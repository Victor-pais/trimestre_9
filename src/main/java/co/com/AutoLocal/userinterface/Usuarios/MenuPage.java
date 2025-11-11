package co.com.AutoLocal.userinterface.Usuarios;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class MenuPage {

    public static final Target BTN_USUARIOS = Target.the("Botón de usuarios")
            .located(By.xpath("//button[contains(.,'Usuarios')]"));
}

