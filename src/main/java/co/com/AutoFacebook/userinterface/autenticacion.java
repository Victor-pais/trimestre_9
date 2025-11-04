package co.com.AutoFacebook.userinterface;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class autenticacion extends PageObject {

    public static final Target INPUT_USUARIO = Target.the("Ingreso del Usuario")
            .located(By.id("username"));

    public static final Target INPUT_CLAVE = Target.the("Ingreso del Password")
            .located(By.id("password"));

    public static final Target BTN_INICIOSESION = Target.the("Click Boton inicio sesion")
            .located(By.id("submit"));

    public static final Target MENSAJE_LOGIN = Target.the("Mensaje de login exitoso")
            .located(By.xpath("//h1[contains(text(),'Logged In Successfully')]"));
}

