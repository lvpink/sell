
package com.imooc.sell.repository;

import com.imooc.sell.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        //1,
        ProductCategory productCategory = repository.findById(1).orElse(null);
        if(productCategory !=null){
            System.out.println(productCategory.toString());
        }
//        //2,
//        Optional<ProductCategory> productCategory1 = repository.findById(1);
//        if(productCategory1.isPresent()){
//            ProductCategory category = productCategory1.get();
//            System.out.println(category.toString());
//        }
//        //3,
//        repository.findById(1).ifPresent(category1 -> System.out.println(category1.toString()));
//        //4,
//        repository.findById(1).orElseThrow(() -> new ClassCastException("category dose not exit!"));
    }
    @Test
    @Transactional//执行完回滚
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱1", 5);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }
    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(1,2,3);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        Assert.assertNotNull(byCategoryTypeIn);
    }

}