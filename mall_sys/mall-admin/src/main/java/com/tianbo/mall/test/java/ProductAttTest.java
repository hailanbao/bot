package com.tianbo.mall.test.java;
import com.tianbo.mall.StartApp;
import com.tianbo.mall.modules.product.mapper.PmsProductAttributeCategoryMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductAttTest {
    @Autowired
    PmsProductAttributeCategoryMapper mapper;

    @Test
    public void test01(){
        System.out.println(mapper.getListWithAttr());
    }
}
