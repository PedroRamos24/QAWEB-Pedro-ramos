package com.nttdata.steps;

import com.nttdata.page.InicioSesionPage;
import com.nttdata.page.StorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductStoreStep {
    private WebDriver driver;

    public ProductStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPaginaDeLaTienda() {
        driver.get("https://qalab.bensg.com/store");
    }

    public void clickIniciarSesion() {
        driver.findElement(StorePage.btniniciarSesion).click();
    }

    public void loguearUsuario(String user, String password) {
        driver.findElement(InicioSesionPage.txtemail).sendKeys(user);
        driver.findElement(InicioSesionPage.txtpassword).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(InicioSesionPage.btnLogin))
                .click();
    }

    public String getNombre() {
        return driver.findElement(StorePage.txtNombre).getText();
    }

    public void navegarCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver.findElement(StorePage.getbtnCategoriaLocator(categoria)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSubcategoria = wait.until(ExpectedConditions.elementToBeClickable(StorePage.getbtnSubCategoriaLocator(subcategoria)));
        btnSubcategoria.click();
    }

    public void agregarProductoAlCarrito(int unidades) {
        driver.findElement(StorePage.firstProduct).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnSubcategoria = wait.until(ExpectedConditions.elementToBeClickable(StorePage.btnAnadiUnidades));
        for (int i = 1; i < unidades; i++) {
            btnSubcategoria.click();
        }
        driver.findElement(StorePage.btnAnadirCarrito).click();
    }

    public String validarPopupConfirmacion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.txtTitulo));
        wait.until(ExpectedConditions.textToBePresentInElement(popup, "Producto añadido correctamente a su carrito de compra"));
        return popup.getText();
    }

    public boolean validarMontoTotalPopup() {
        double precioUnidad = convertirPrecio(driver.findElement(StorePage.txtPrecioUnidad).getText());
        double cantidad = convertirPrecio(driver.findElement(StorePage.txtCantidad).getText());
        double precioTotal = convertirPrecio(driver.findElement(StorePage.txtPrecioTotal).getText());
        return Math.abs(precioUnidad * cantidad - precioTotal) < 0.01;
    }

    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnFinCompra = wait.until(ExpectedConditions.elementToBeClickable(StorePage.btnFinalizarCompra));
        btnFinCompra.click();
    }

    public String getTituloCarrito() {
        return driver.findElement(StorePage.txtTitleCarrito).getText();
    }

    public boolean validarMontoTotalCarrito() {
        double precioUnidad = convertirPrecio(driver.findElement(StorePage.txtPrecioUnidad2).getText());
        double cantidad = convertirPrecio(driver.findElement(StorePage.txtCantidad2).getText());
        double precioTotal = convertirPrecio(driver.findElement(StorePage.txtPrecioTotal2).getText());
        return Math.abs(precioUnidad * cantidad - precioTotal) < 0.01;
    }

    private double convertirPrecio(String precio) {
        precio = precio.replaceAll("[^0-9.,]", "").replace(",", ".");
        return Math.round(Double.parseDouble(precio) * 100.0) / 100.0;
    }


}
