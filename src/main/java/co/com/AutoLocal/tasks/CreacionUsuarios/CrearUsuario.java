package co.com.AutoLocal.tasks.CreacionUsuarios;

import co.com.AutoLocal.userinterface.CreacionUsuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearUsuario implements Task {

    private final Map<String, String> datos;

    public CrearUsuario(Map<String, String> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.BOTON_NUEVO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.BOTON_NUEVO),

                WaitUntil.the(UsuariosPage.MODAL_NUEVO_USUARIO, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(datos.get("usuario")).into(UsuariosPage.CAMPO_NOMBRE_USUARIO),
                Enter.theValue(datos.get("nombre")).into(UsuariosPage.CAMPO_NOMBRES),
                Enter.theValue(datos.get("apellido")).into(UsuariosPage.CAMPO_APELLIDOS),

                WaitUntil.the(UsuariosPage.SELECT_TIPO_DOCUMENTO, isClickable()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(datos.get("tipo_documento")).from(UsuariosPage.SELECT_TIPO_DOCUMENTO),

                Enter.theValue(datos.get("documento")).into(UsuariosPage.CAMPO_DOCUMENTO),
                Enter.theValue(datos.get("celular")).into(UsuariosPage.CAMPO_CELULAR),
                Enter.theValue(datos.get("direccion")).into(UsuariosPage.CAMPO_DIRECCION),
                Enter.theValue(datos.get("ciudad")).into(UsuariosPage.CAMPO_CIUDAD),
                Enter.theValue(datos.get("correo")).into(UsuariosPage.CAMPO_CORREO),
                Enter.theValue(datos.get("contraseña")).into(UsuariosPage.CAMPO_CONTRASENA),

                WaitUntil.the(UsuariosPage.SELECT_ROL, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.SELECT_ROL),
                Click.on(UsuariosPage.OPCION_ROL.of(datos.get("rol")))
        );
    }

    public static CrearUsuario conLosDatos(Map<String, String> datos) {
        return Tasks.instrumented(CrearUsuario.class, datos);
    }
}
