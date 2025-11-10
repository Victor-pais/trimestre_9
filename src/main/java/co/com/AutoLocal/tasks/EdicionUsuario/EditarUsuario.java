package co.com.AutoLocal.tasks.EdicionUsuario;

import co.com.AutoLocal.tasks.EliminacionUsuario.AceptarAlerta;
import co.com.AutoLocal.userinterface.CreacionUsuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarUsuario implements Task {

    private final String nombreActual;
    private final String nuevoNombre;
    private final String nuevoCorreo;

    public EditarUsuario(String nombreActual, String nuevoNombre, String nuevoCorreo) {
        this.nombreActual = nombreActual;
        this.nuevoNombre = nuevoNombre;
        this.nuevoCorreo = nuevoCorreo;
    }

    public static EditarUsuario conDatos(String nombreActual, String nuevoNombre, String nuevoCorreo) {
        return instrumented(EditarUsuario.class, nombreActual, nuevoNombre, nuevoCorreo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 🔎 Esperar que el botón editar esté visible y hacer clic
        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.botonEditarDelUsuario(nombreActual), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.botonEditarDelUsuario(nombreActual))
        );

        // ✏️ Esperar el modal y editar los campos
        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.MODAL_NUEVO_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(UsuariosPage.CAMPO_NOMBRE_USUARIO),
                Enter.theValue(nuevoNombre).into(UsuariosPage.CAMPO_NOMBRE_USUARIO),
                Clear.field(UsuariosPage.CAMPO_CORREO),
                Enter.theValue(nuevoCorreo).into(UsuariosPage.CAMPO_CORREO)
        );

        // 💾 Guardar los cambios
        actor.attemptsTo(
                Click.on(UsuariosPage.BOTON_GUARDAR),
                AceptarAlerta.ahora()
        );
    }

    public static EditarUsuario ahora() {
        return Tasks.instrumented(EditarUsuario.class);

    }
}
