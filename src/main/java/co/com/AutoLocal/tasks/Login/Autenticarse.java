package co.com.AutoLocal.tasks.Login;

import co.com.AutoLocal.models.CredencialesInicioSesion;
import co.com.AutoLocal.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

import static co.com.AutoLocal.userinterface.Usuarios.LoginPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Autenticarse implements Task {

    private final List<CredencialesInicioSesion> credenciales;

    public Autenticarse(List<CredencialesInicioSesion> credenciales) {
        this.credenciales = credenciales;
    }

    public static Autenticarse auto(List<CredencialesInicioSesion> credenciales){
        return Instrumented.instanceOf(Autenticarse.class)
                .withProperties(credenciales);
    }

    String Numero = RandomStringUtils.random(2,false,true);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INPUT_USUARIO),
                Enter.theValue(credenciales.get(0).getUsuario()).into(INPUT_USUARIO),
                Click.on(INPUT_CLAVE),
                Enter.theValue(credenciales.get(0).getClave()).into(INPUT_CLAVE),
                Click.on(BTN_INICIOSESION)
        );

        theActorInTheSpotlight().remember(SesionVariable.usuario.toString(),
                credenciales.get(0).getUsuario());
    }
}
