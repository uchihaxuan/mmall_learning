package com.mmall.service.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by geely
 */
public class ProductServiceTest extends TestBase {

    @Autowired
    private IProductService iProductService;

    @Test
    public void testIProductService(){
        ServerResponse<PageInfo> result =  iProductService.getProductByKeywordCategory("iphone",2,1,5,"price_desc");
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<String> images = Lists.newArrayList();
        images.add("com/mmall/aa.jpg");
        images.add("com/mmall/bb.jpg");
        images.add("com/mmall/cc.jpg");
        images.add("com/mmall/dd.jpg");
        images.add("com/mmall/ee.jpg");
//        ["mmall/aa.jpg","mmall/bb.jpg","mmall/cc.jpg","mmall/dd.jpg","mmall/ee.jpg"]
    }
}
