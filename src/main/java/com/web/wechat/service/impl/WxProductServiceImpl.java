package com.web.wechat.service.impl;

import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WxProductServiceImpl implements WxProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public ResponseData getProInfos() {
        try {
            List<Product> productList=productDao.getAll();
            // 使用 Stream 排序  确保category_id较小的在传输的表的上面
            List<Product> newProductList = productList.stream().sorted(Comparator.comparing(Product::getCid))
                    .collect(Collectors.toList());

            return new ResponseData(1,"商品列表",newProductList);
        }catch (Exception e) {
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData getProNum() {
        try {
            List<Integer> productNumber = productDao.getProNum();
            Integer[] products = new Integer[productNumber.size()+1];
            products[0]=1;
            int j=1;
            for (Integer i:productNumber)
            { products[j++]=i; }
            for(int i=0;i<products.length-1;i++)
            products[i+1]+=products[i];
//            for (Integer s:products){
//                System.out.println(s);
//            }
            return new ResponseData(1,"商品分类排序表",products);
        }catch (Exception e) {
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData getProDetail(int id) {
        try {
            Product product=productDao.getOnlineById(id);
            return new ResponseData(1,"商品详细信息",product);
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }


}
