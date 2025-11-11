package co.com.AutoLocal.tasks.CreacionUsuarios;

import co.com.AutoLocal.models.UsuarioData;
import co.com.AutoLocal.userinterface.Usuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearUsuario implements Task {

    private final UsuarioData usuarioData;

    public CrearUsuario(UsuarioData usuarioData) {
        this.usuarioData = usuarioData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.BOTON_NUEVO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.BOTON_NUEVO),

                WaitUntil.the(UsuariosPage.MODAL_NUEVO_USUARIO, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue(usuarioData.getNombre_usuario()).into(UsuariosPage.CAMPO_NOMBRE_USUARIO),
                Enter.theValue(usuarioData.getNombres()).into(UsuariosPage.CAMPO_NOMBRES),
                Enter.theValue(usuarioData.getApellidos()).into(UsuariosPage.CAMPO_APELLIDOS),

                WaitUntil.the(UsuariosPage.SELECT_TIPO_DOCUMENTO, isClickable()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(usuarioData.getTipo_documento_id()).from(UsuariosPage.SELECT_TIPO_DOCUMENTO),

                Enter.theValue(usuarioData.getNumero_documento()).into(UsuariosPage.CAMPO_DOCUMENTO),
                Enter.theValue(usuarioData.getCelular()).into(UsuariosPage.CAMPO_CELULAR),
                Enter.theValue(usuarioData.getDireccion()).into(UsuariosPage.CAMPO_DIRECCION),
                Enter.theValue(usuarioData.getCiudad()).into(UsuariosPage.CAMPO_CIUDAD),
                Enter.theValue(usuarioData.getEmail()).into(UsuariosPage.CAMPO_CORREO),
                Enter.theValue(usuarioData.getContrasena()).into(UsuariosPage.CAMPO_CONTRASENA),

                WaitUntil.the(UsuariosPage.SELECT_ROL, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.SELECT_ROL),
                Click.on(UsuariosPage.OPCION_ROL.of(usuarioData.getTipo_rol_id()))
        );
    }

    public static CrearUsuario conDatos(UsuarioData usuarioData) {
        return Tasks.instrumented(CrearUsuario.class, usuarioData);
    }
}
