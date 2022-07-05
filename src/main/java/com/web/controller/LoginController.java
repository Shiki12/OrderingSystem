package com.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.dao.AdministratorDao;
import com.web.entity.Administrator;
import com.web.entity.Customer;
import com.web.entity.Product;
import com.web.entity.po.VerCode;
import com.web.service.CustomerService;
import com.web.service.ProductService;
import com.web.utils.Utils;
import com.web.wechat.dataUtil.ResponseData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    AdministratorDao administratorDao;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;


    JavaMailSender javaMailSender;//注入
    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RequestMapping("/") //
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/session")
    public  String tosession(){
        return "cus/session";
    }


    @RequestMapping("") //
    public String toUserLogin(){
        return "cus/login";
    }

    @RequestMapping ("/admin")  //管理员登录功能
    public String login(
            @RequestParam("username")String username,
            @RequestParam("password")String password, Model model, HttpSession session,

            @RequestParam(defaultValue = "1",value = "pageNum")int pageNum
            ){

        //得到subject对象
        Subject subject = SecurityUtils.getSubject();
        //得到token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            //执行登录完了之后存放session
            session.setAttribute("loginUser",username);

            Administrator administrator = administratorDao.selectByName(username);
            String lastLoginTime="";
            if (administrator!= null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //得到上次登陆的时间
                Date time = administrator.getLasttime();
                //上次时间
                lastLoginTime = sdf.format(time);
                //当前时间
                String format = sdf.format(new Date());
                //string转date  不处理时间格式会不理想
                ParsePosition pos = new ParsePosition(0);
                Date strtodate = sdf.parse(format, pos);
                administrator.setLasttime(strtodate);
                administratorDao.update(administrator);

                //设置页面大小
                PageHelper.startPage(pageNum,10);
                List<Product> list = productService.getAll();
                //pageHelper 包装之后的代码
                PageInfo<Product> pageInfo = new PageInfo<>(list);
                model.addAttribute("pageInfo",pageInfo);

                return "admin/index";
            }

        }catch (Exception e){
            model.addAttribute("msg","程序异常");
            return "";
        };
        return "";

    }
    @RequestMapping("/customer")
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,HttpSession session,Model model){

        Customer customer = customerService.getByName(username);
        if (customer!=null){
            if (password.equals(customer.getPassword())){
              session.setAttribute("customer",customer);
              model.addAttribute("msg","登录成功");
              return "success";
            }
            else {
                model.addAttribute("msg","账号或密码错误");
                return "cus/login";
            }
        }
        else {
            return "cus/login";
        }

    }

    @RequestMapping("/check") //查看用户名是否存在
    @ResponseBody
    public ResponseData check(String name){

        Customer customer = customerService.getByName(name);
        if (customer !=null){
            return new ResponseData(0,"用户名已存在");
        }
        else {
          return new ResponseData(1,"用户名可行");
        }
    }

    @RequestMapping("/register") //查看用户名是否存在
    @ResponseBody
    public ResponseData register(HttpSession session,String resuser,
                                 String respass,String resmail,String vcode){
        VerCode vercode =(VerCode) session.getAttribute("vercode");

        Customer customer = new Customer();
        customer.setName(resuser);
        customer.setPassword(respass);
        customer.setMail(resmail); ;
        customer.setName(resuser);
        Date date = new Date();

        if (vcode.equals(vercode.getCode())){
            int i = Utils.compare(vercode.getDate(), date);
            if (i>2){
                return new ResponseData(0,"验证码已过期");
            }
            else {
                customerService.addCustomer(customer);
                return new ResponseData(1,"注册成功");
            }

        }
        return new ResponseData(0,"验证码错误");
    }

    @Async
    @RequestMapping(value = "/mail",method = RequestMethod.GET)
    @ResponseBody
    //发送邮件
    public  String mail(String mail,HttpSession session) throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("941728409@qq.com");

        mimeMessageHelper.setTo(mail);

        mimeMessageHelper.setSubject("OrderingSystem");
        StringBuffer sb = new StringBuffer();

        //存放将验证码类存放session中。
        int randomNumber = Utils.getRandomNumber();
        Integer integer = new Integer(randomNumber);
        VerCode verCode = new VerCode(integer.toString(), new Date());
        //将验证码放在session中
        session.setAttribute("vercode",verCode);


        sb.append("尊敬的用户,您好:\n"
                + "\n本次请求的邮件验证码为:" + randomNumber + ",本验证码5分钟内有效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）");

        mimeMessageHelper.setText(sb.toString());

        javaMailSender.send(mimeMessage);

        return "发送成功";

    }




}
