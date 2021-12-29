package com.testinium.constants;

import org.openqa.selenium.By;

public class Constants {

    public static final By SEARCH = By.className("o-header__search--input");
    public static final By PRODUCT_LIST = By.className("o-productList__itemWrapper");
    public static final By SIZE_LIST = By.className("m-variation__item");
    public static final By PRODUCT_PRICE = By.className("m-price__new");
    public static final By CART = By.className("m-notification__button");
    public static final By BASKET_PRICE = By.className("m-productPrice__salePrice");
    public static final By SELECT = By.id("quantitySelect0");
    public static final By DELETE_PRODUCT = By.id("removeCartItemBtn0");
    public static final By ADD_BASKET = By.id("addBasket");
    public static final By ACC = By.className("bwi-account-o");
    public static final By FAV = By.className("bwi-favorite-o");
    public static final By FAVNUM = By.id("favoriteProductList");
    public static final By CHECK = By.className("bwi-cart-o");
    public static final By CHECKBASKET = By.id("emtyCart");
    public static final By EMAİL = By.id("email");
    public static final By PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("loginBtn");
    public static final By BTN_HOME = By.className("m-empty__messageBtn");


    public static final String NOT_AVAILABLE = "Seçtiğiniz beden stokda mevcut değil.";
    public static final String PRICE_EQUALS = "Ürün ve sepetteki fiyat birine eşit.";
    public static final String NOT_PRICE_EQUALS = "Ürün ve sepetteki fiyat birine eşit değil.";

}
