package co.com.AutoLocal.tasks.CreacionUsuarios;


import co.com.AutoLocal.userinterface.Usuarios.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Task {

    private final String usuario;
    private final String clave;

    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Abre la página de login
                Open.url("http://localhost:4200/login"),

                // Ingresa credenciales
                Enter.theValue(usuario).into(LoginPage.INPUT_USUARIO),
                Enter.theValue(clave).into(LoginPage.INPUT_CLAVE),
                Click.on(LoginPage.BTN_INICIOSESION)
        );
    }

    public static IniciarSesion conCredenciales(String usuario, String clave) {
        return instrumented(IniciarSesion.class, usuario, clave);
    }
}

