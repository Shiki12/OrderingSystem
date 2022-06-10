package com.shiki.controller;

import com.shiki.entity.Product;
import com.shiki.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String getAll(Model model){
        List<Product> list = productService.getAll();
        for (Product product : list) {
            System.out.println(product);
        }
        model.addAttribute("list",list);
        return "admin/index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {
         log.info("图片大小={}",file.getSize());
        if (!file.isEmpty()){
             //保存到webapp
             file.transferTo(new File("E:\\workspace2022\\OrderingSystem\\src\\main\\webapp" +
                     "\\images\\product\\2.jpg"  ));

         }


        return "ok";
    }




}
