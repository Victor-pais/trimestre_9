package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.tasks.CreacionUsuarios.ConfirmarCreacionUsuario;
import co.com.AutoLocal.tasks.CreacionUsuarios.CrearUsuario;
import co.com.AutoLocal.tasks.CreacionUsuarios.IrAlModuloUsuarios;
import co.com.AutoLocal.tasks.CreacionUsuarios.IniciarSesion;
import co.com.AutoLocal.userinterface.CreacionUsuarios.UsuariosPage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearUsuarioStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    // ----------------------------
    // ANTECEDENTES
    // ----------------------------

    @Dado("^que el administrador ha iniciado sesion en el sistema$")
    public void queElAdministradorHaIniciadoSesionEnElSistema() {
        OnStage.theActorCalled("Admin")
                .wasAbleTo(IniciarSesion.conCredenciales("admin", "admin123"));
    }

    @Dado("^se encuentra en la pagina del menu principal$")
    public void seEncuentraEnLaPaginaDelMenuPrincipal() {
        // Aquí podrías agregar una validación de URL o simplemente dejarlo vacío
    }

    // ----------------------------
    // ESCENARIO: Crear un nuevo usuario exitosamente
    // ----------------------------

    @Cuando("^el administrador hace clic en el acceso rapido \\\"(.*)\\\"$")
    public void elAdministradorHaceClicEnElAccesoRapido(String modulo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlModuloUsuarios.enElMenu(modulo)
        );
    }

    @Cuando("^hace clic en el boton \\\"(.*)\\\"$")
    public void haceClicEnElBoton(String boton) {
        System.out.println("El administrador hace clic en el botón: " + boton);
        // Si el botón es "Nuevo", ya lo maneja CrearUsuario
    }

    @Cuando("^completa el formulario con los datos del usuario$")
    public void completaElFormularioConLosDatosDelUsuario(List<Map<String, String>> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearUsuario.conLosDatos(datos.get(0))
        );
    }

    @Cuando("^confirma la creacion del usuario$")
    public void confirmaLaCreacionDelUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarCreacionUsuario.confirmar()
        );
    }

    @Entonces("^el sistema muestra un mensaje de confirmacion$")
    public void elSistemaMuestraUnMensajeDeConfirmacion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(UsuariosPage.MENSAJE_EXITO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(UsuariosPage.MENSAJE_EXITO).isDisplayed()
        );
        System.out.println("✅ El sistema muestra un mensaje de confirmación exitosamente.");
    }
}
