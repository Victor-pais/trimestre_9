package co.com.AutoLocal.tasks.CreacionUsuarios;

import co.com.AutoLocal.userinterface.Usuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirFormularioUsuario implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(UsuariosPage.BOTON_NUEVO));
    }

    public static AbrirFormularioUsuario nuevo() {
        return instrumented(AbrirFormularioUsuario.class);
    }
}

