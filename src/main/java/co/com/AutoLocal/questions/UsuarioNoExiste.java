package co.com.AutoLocal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsuarioNoExiste implements Question<Boolean> {

    private final String nombre;

    public UsuarioNoExiste(String nombre) {
        this.nombre = nombre;
    }

    public static UsuarioNoExiste conNombre(String nombre) {
        return new UsuarioNoExiste(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        By filaUsuario = By.xpath("//td[contains(text(),'" + nombre + "')]");

        // Esperar con el constructor compatible
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(filaUsuario));

        return driver.findElements(filaUsuario).isEmpty();
    }

}
