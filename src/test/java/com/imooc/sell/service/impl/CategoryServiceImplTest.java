package com.imooc.sell.service.impl;

import com.imooc.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;
    @Test
    public void findById() {
        ProductCategory category = categoryServiceImpl.findById(2);
//        Assert.assertNotEquals(null,category);
        Assert.assertNotNull(category);
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryServiceImpl.findAll();
        Assert.assertNotNull(categoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1,2,3,6,7);
        List<ProductCategory> byCategoryTypeIn = categoryServiceImpl.findByCategoryTypeIn(list);
        Assert.assertNotNull(byCategoryTypeIn.size());
    }

    @Test
    public void save() {
        ProductCategory category = categoryServiceImpl.save(new ProductCategory("我们的", 5));
        Assert.assertNotNull(category);
    }
}