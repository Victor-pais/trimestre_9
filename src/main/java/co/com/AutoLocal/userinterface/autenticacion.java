package co.com.AutoLocal.userinterface;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class autenticacion extends PageObject {

    public static final Target INPUT_USUARIO = Target.the("campo usuario")
            .located(By.name("login"));

    public static final Target INPUT_CLAVE = Target.the("campo contraseña")
            .located(By.name("contrasena"));

    public static final Target BTN_INICIOSESION = Target.the("botón iniciar sesión")
            .located(By.xpath("//button[contains(text(),'Ingresar')]"));

    public static final Target MENSAJE_BIENVENIDA = Target.the("mensaje de bienvenida")
            .located(By.xpath("//h1[contains(text(),'Panel de Administración Sox')]"));


}

