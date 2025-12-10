package co.com.AutoLocal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductoNoExiste implements Question<Boolean> {

    private final String nombre;

    public ProductoNoExiste(String nombre) {
        this.nombre = nombre;
    }

    public static ProductoNoExiste conNombre(String nombre) {
        return new ProductoNoExiste(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String xpath = "//td[contains(text(),'" + nombre + "')]";

        WebDriverWait wait = new WebDriverWait(driver, 15);


        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), 0));

        return driver.findElements(By.xpath(xpath)).isEmpty();
    }

}