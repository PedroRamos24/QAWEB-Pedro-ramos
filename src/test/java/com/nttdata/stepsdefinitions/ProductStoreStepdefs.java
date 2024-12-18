package com.nttdata.stepsdefinitions;
import com.nttdata.steps.ProductStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static com.nttdata.page.StorePage.*;

public class ProductStoreStepdefs {

    private WebDriver driver;
    private ProductStoreStep productStoreStep;

    @Given("dado que estoy en la página de la tienda")
    public void dadoQueEstoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        productStoreStep = new ProductStoreStep(driver); // Inicializa ProductStoreStep
        productStoreStep.abrirPaginaDeLaTienda();
        screenShot();
    }

    @And("doy click en Iniciar Sesion")
    public void doyClickEnIniciarSesion() {
        productStoreStep.clickIniciarSesion();
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        productStoreStep.loguearUsuario(user, password);
        screenShot();
    }

    @And("verifico que salga el nombre {string}")
    public void verificoQueSalgaElNombre(String name) {
        String nombre = productStoreStep.getNombre();
        Assertions.assertEquals(name, nombre, "ERROR: El texto no coincide con la palabra esperada.");
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        productStoreStep.navegarCategoriaYSubcategoria(categoria, subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        productStoreStep.agregarProductoAlCarrito(unidades);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String titulo = productStoreStep.validarPopupConfirmacion();
        Assertions.assertTrue(titulo.contains("correctamente a su"), "ERROR: El texto no contiene la parte esperada del mensaje.");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        boolean esCorrecto = productStoreStep.validarMontoTotalPopup();
        Assertions.assertTrue(esCorrecto, "ERROR: El monto total calculado no coincide con el precio total en el popup.");
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        productStoreStep.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String titulo = productStoreStep.getTituloCarrito();
        Assertions.assertEquals("CARRITO", titulo, "ERROR: El titulo no coincide con la palabra esperada.");
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        boolean esCorrecto = productStoreStep.validarMontoTotalCarrito();
        Assertions.assertTrue(esCorrecto, "ERROR: El monto total calculado no coincide con el precio total en el carrito.");
        screenShot();
    }
}
