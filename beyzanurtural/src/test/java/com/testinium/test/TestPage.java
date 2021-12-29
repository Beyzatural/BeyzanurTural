package com.testinium.test;

import com.testinium.base.BaseTest;
import com.testinium.page.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPage extends BaseTest {

    HomePage homePage;

    @Before
    public void before() {
        homePage = new HomePage(getWebDriver());
    }

    @Test
    public void test() {
        try{
            homePage
                   .account("beyzaturaal@gmail.com", "deneme123.")
                    .favControl()
                    .checkCart()
                    .searchProduct("pantolon")
                    .scrolleDown()
                    .productList()
                    .shopping();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        //down();
    }
}
