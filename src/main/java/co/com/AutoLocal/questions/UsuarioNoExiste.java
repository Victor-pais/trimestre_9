package co.com.AutoLocal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

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
        return BrowseTheWeb.as(actor).getDriver()
                .findElements(By.xpath("//td[contains(text(),'" + nombre + "')]"))
                .isEmpty();
    }
}
