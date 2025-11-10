package co.com.AutoLocal.userinterface.CreacionUsuarios;


import net.serenitybdd.screenplay.targets.Target;




import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_USUARIO = Target.the("campo usuario")
            .located(By.name("login"));

    public static final Target INPUT_CLAVE = Target.the("campo contraseña")
            .located(By.name("contrasena"));

    public static final Target BTN_INICIOSESION = Target.the("botón iniciar sesión")
            .located(By.xpath("//button[contains(text(),'Ingresar')]"));
}


