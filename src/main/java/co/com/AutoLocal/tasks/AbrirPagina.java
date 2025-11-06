package co.com.AutoLocal.tasks;

import co.com.AutoLocal.userinterface.InicioLocal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPagina implements Task {

    InicioLocal inicioLocal;

    public static AbrirPagina lapagina(){return Tasks.instrumented(AbrirPagina.class);}

    @Override
    public <T extends Actor> void performAs(T actor) { actor.attemptsTo(Open.browserOn(inicioLocal));

    }
}
