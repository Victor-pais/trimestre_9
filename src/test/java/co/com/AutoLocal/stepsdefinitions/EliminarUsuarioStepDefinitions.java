package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.tasks.EliminacionUsuario.EliminarUsuario;
import co.com.AutoLocal.questions.UsuarioNoExiste;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EliminarUsuarioStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^elimina el usuario \"([^\"]*)\"$")
    public void eliminaElUsuario(String nombreUsuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarUsuario.conNombre(nombreUsuario)
        );
    }

    @Entonces("^el sistema confirma que el usuario \"(.*)\" ya no está en la tabla$")
    public void validarEliminacion(String nombreUsuario) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(UsuarioNoExiste.conNombre(nombreUsuario), is(true))
        );
    }
}
