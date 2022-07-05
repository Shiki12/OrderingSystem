package com.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.entity.Product;
import com.web.service.ProductService;
import com.web.wechat.dataUtil.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/getAll")
    //得到所有的数据
    public String getAll(Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum")int pageNum) {
        //设置页面大小
        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "admin/index";
    }
    //添加商品
    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file,Product product,Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum")int pageNum) throws IOException {

        String originalFilename = file.getOriginalFilename();

        //图片完整的地址  System.getProperty("user.dir")表示当前项目的路径
        String path= System.getProperty("user.dir")+"\\src\\main\\webapp\\images" +
                "\\product\\"+originalFilename;
        //图片存入数据库的相对地址

        product.setImageUrl("images/product/"+originalFilename);

        log.info("存入数据库的商品地址={}",product.getImageUrl());

        product.setBid(1); //这个是商品种类id

        product.setCid(1); //这个是前端传过来管理员的id

        product.setStatus(1); //默认状态是有存货
        productService.addProduct(product);

        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);

        if (!file.isEmpty()){
            //保存到webapp
            file.transferTo(new File(path));
            return "admin/index";
        }
        return "admin/index";

    }




    //去更新页面
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id,Model model){

        Product product = productService.getById(id);

        model.addAttribute("pro",product);

        return "admin/update";
    }

    //更新页面操作
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(Model model,Product product,
                          @RequestParam(defaultValue = "1",value = "pageNum")int pageNum
            ,@RequestPart("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        //图片完整的地址  System.getProperty("user.dir")表示当前项目的路径
        String path= System.getProperty("user.dir")+"\\src\\main\\webapp\\images" +
                "\\product\\"+filename;

        product.setBid(1);
        product.setCid(1);
        //判断当前文件是否存在
        //文件不存在的情况
        if (file.isEmpty()){
            //通过传过来的id找到商品
            Product product1 = productService.getById(product.getId());
            String imageUrl = product1.getImageUrl();
            //将之前的图片地址赋值给现在的这个
            product.setImageUrl(imageUrl);
        }
        else {
            product.setImageUrl("images/product/"+filename);
            file.transferTo(new File(path));  //保存图片
        }
        productService.update(product);

        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/index";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id,Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){
        productService.deleteById(id);
        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/index";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public ResponseData getOne(int id){

        Product product = productService.getById(id);
        if (product!=null){
            return  new ResponseData(1,"请求成功",product);
        }
        return null;

    }



}
