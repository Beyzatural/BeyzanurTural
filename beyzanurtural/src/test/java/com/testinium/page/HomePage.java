package com.testinium.page;

import com.testinium.base.BasePage;
import com.testinium.constants.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class HomePage extends BasePage {

    Logger logger = Logger.getLogger("com.testinium.page.HomePage");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage account(String email, String password) throws InterruptedException {
        logger.info("Hesabım sayfası kontrol edildi.");
        findElement(Constants.ACC).click();
        findElement(Constants.EMAİL).sendKeys(email);
        findElement(Constants.PASSWORD).sendKeys(password);
        findElement(Constants.BTN_LOGIN).click();
        Thread.sleep(3000);

        return this;
    }

    public HomePage favControl() throws InterruptedException {
        logger.info("Favorilerim sayfası kontrol edildi.");
        WebElement fav = findElement(Constants.FAV);
        fav.click();
        WebElement favNum = findElement(Constants.FAVNUM);
        String vals3 = favNum.getText().split(" Ürün")[0].split("\\(")[1];
        System.out.println("Favori listesindeki ürün sayısı " + vals3 + " adettir.");
        Thread.sleep(3000);
        return this;
    }

    public HomePage checkCart() {
        logger.info("Sepetim sayfası kontrol edildi.");
        WebElement check = findElement(Constants.CHECK);
        check.click();
        WebElement isCheckNull = findElement(Constants.CHECKBASKET);
        String vals2 = isCheckNull.getText().split("Birbirinden")[0];
        System.out.println(vals2);
        findElement(Constants.BTN_HOME).click();
        return this;
    }

    public HomePage searchProduct(String product) throws InterruptedException {
        logger.info("Home sayfası search işlemi başlatıldı.");
        findElement(Constants.SEARCH).sendKeys(product);
        findElement(Constants.SEARCH).sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        return this;
    }

    public HomePage scrolleDown() throws InterruptedException {
        logger.info("Ürün sayfası scroll işlemi başlatıldı.");
        scroll();
        return this;
    }

    public HomePage productList() {
        logger.info("Ürün listeleme işlemi başlatıldı.");
        List<WebElement> productList = findElements(Constants.PRODUCT_LIST);
        Random r = new Random();
        logger.info("Ürün detayları sayfası başlatıldı.");
        productList.get(r.nextInt(productList.size())).click();

        return this;
    }
    public void waitMe(long val) throws InterruptedException {
        Thread.sleep(val);
    }

    public void selectValue(WebElement element, String val){
        logger.info("Sepete eklenen ürün sayısı belirtildi.");
        Select select = new Select(element);
        select.selectByValue(val);
    }

    public HomePage shopping() throws InterruptedException {
        logger.info("Ürün listeleme işlemi başlatıldı.");
        List<WebElement> sizelist = findElements(Constants.SIZE_LIST);
        int temp = 0;
        if(sizelist.size() != 0){
            for(int i = 0; i<sizelist.size(); i++){
                if(sizelist.get(i).getText().equals("34")) {
                    temp = 1;
                    String className = sizelist.get(i).getAttribute("class");

                    String[] vals = className.split(" ");

                    if(vals.length>1){
                        if(vals[1].equals("-disabled")) {
                            logger.info(Constants.NOT_AVAILABLE);
                            break;
                        }
                    } else {
                        logger.info("Belirtilen beden varsa seçme işlemi başlatıldı.");
                        sizelist.get(i).click();
                        logger.info("Sepete ekleme işlemi başlatıldı.");
                        findElement(Constants.ADD_BASKET).click();

                        // TODO: Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması
                        String oldpay = findElement(Constants.PRODUCT_PRICE).getText();
                        logger.info("Sepet sayfası başlatıldı.");
                        findElement(Constants.CART).click();
                        String newpay = findElement(Constants.BASKET_PRICE).getText();
                        if (oldpay.equals(newpay)) {
                            System.out.println(Constants.PRICE_EQUALS);
                        }
                        // TODO: Spettteki ürün adetinin 2 yapılması
                        selectValue(findElement(Constants.SELECT), "2");
                        waitMe(2500);
                        logger.info("Sepetteki ürün silme işlemi başlatıldı.");
                        findElement(Constants.DELETE_PRODUCT).click();
                    }
                }
            }
            if (temp == 0){
                System.out.println(Constants.NOT_AVAILABLE);
            }
        }
        return this;
    }

}
