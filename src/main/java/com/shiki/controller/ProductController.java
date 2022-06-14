package com.shiki.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiki.entity.Product;
import com.shiki.service.ProductService;
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
        model.addAttribute("list",pageInfo);
        return "admin/index";
    }




    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file,Product product,Model model,
    @RequestParam(defaultValue = "1",value = "pageNum")int pageNum) throws IOException {
  //         log.info("图片大小={}",file.getSize());
//
//         log.info("商品名称={},商品价格={},商品数量={},商品详情={}",product.getName(),product.getPrice(),
//                 product.getNumber(),product.getMiaoshu());

        String originalFilename = file.getOriginalFilename();

        //图片完整的地址  System.getProperty("user.dir")表示当前项目的路径
       String path= System.getProperty("user.dir")+"\\src\\main\\webapp\\images" +
               "\\product\\"+originalFilename;
       //图片存入数据库的相对地址

       product.setImageUrl("images/product/"+originalFilename);

        log.info("存入数据库的商品地址={}",product.getImageUrl());
        product.setBid(1);
        product.setCid(1);
        productService.addProduct(product);

        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("list",pageInfo);

        if (!file.isEmpty()){
             //保存到webapp
             file.transferTo(new File(path));
            return "admin/index";
         }
         return "admin/index";

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  update(Model model,Product product,
                          @RequestParam(defaultValue = "1",value = "pageNum")int pageNum
    ,@RequestPart("file") MultipartFile file){






        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("list",pageInfo);
      return "admin/index";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(int id,Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum")int pageNum){



        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("list",pageInfo);
        return "admin/index";
    }


}
