package co.com.AutoLocal.tasks.EliminacionUsuario;



import co.com.AutoLocal.userinterface.CreacionUsuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuario implements Task {

    private final String nombre;

    public EliminarUsuario(String nombre) {
        this.nombre = nombre;
    }

    public static EliminarUsuario conNombre(String nombre) {
        return instrumented(EliminarUsuario.class, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(UsuariosPage.botonEliminarDelUsuario(nombre)),
                AceptarAlerta.ahora()
        );
    }
}

