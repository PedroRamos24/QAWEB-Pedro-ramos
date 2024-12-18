package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {
    public static By btniniciarSesion = By.xpath("//div[@class=\"user-info\"]/a");
    public static By txtNombre = By.xpath("//span[@class='hidden-sm-down']");

    public static By getbtnCategoriaLocator(String categoria) {
        String respuesta="";
        if(categoria.equals("Clothes")){
            respuesta = "//*[@id=\"category-3\"]/a";
        }
        if(categoria.equals("Accesorios")){
            respuesta = "//*[@id=\"category-6\"]/a";
        }
        if(categoria.equals("Art")){
            respuesta = "//*[@id=\"category-9\"]/a";
        }

        return By.xpath(respuesta);
    }

    public static By getbtnSubCategoriaLocator(String subcategoria){

        String respuesta2="";

        if (subcategoria.equals("Men")){
            respuesta2="//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a";
        }
        if (subcategoria.equals("Women")){
            respuesta2="//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a";
        }

        return By.xpath(respuesta2);
    }


    public static By firstProduct= By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");

    public static By btnAnadiUnidades = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");

    public static By btnAnadirCarrito = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");

    public static By txtTitulo = By.xpath("//*[@id=\"myModalLabel\"]");


    public static By txtPrecioUnidad = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");

    public static By txtCantidad = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");

    public static By txtPrecioTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    public static By btnFinalizarCompra = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");


    public static By txtTitleCarrito = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");


    public static By txtPrecioUnidad2 = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");

    public static By txtCantidad2 = By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");

    public static By txtPrecioTotal2 = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");



}
