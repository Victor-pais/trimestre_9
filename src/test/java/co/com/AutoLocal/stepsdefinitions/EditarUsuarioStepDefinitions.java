package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.tasks.EdicionUsuario.EditarUsuario;
import co.com.AutoLocal.questions.MensajeExitoActualizacion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class EditarUsuarioStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^edita el usuario \"([^\"]*)\" cambiando el nombre a \"([^\"]*)\" y el correo a \"([^\"]*)\"$")
    public void editarUsuario(String nombreActual, String nuevoNombre, String nuevoCorreo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EditarUsuario.conDatos(nombreActual, nuevoNombre, nuevoCorreo)
        );
    }

    @Entonces("^el sistema muestra un mensaje de éxito al actualizar el usuario$")
    public void validarMensajeExito() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Mensaje de éxito visible",
                        MensajeExitoActualizacion.visible(),
                        containsString("actualizado"))
        );
    }
}
