package co.com.AutoFacebook.stepsdefinitions;

import co.com.AutoFacebook.models.CredencialesInicioSesion;
import co.com.AutoFacebook.tasks.AbrirPagina;
import co.com.AutoFacebook.tasks.Autenticarse;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AutenticacionStepsDefinitions {

    @Dado("^que el usuario se encuentre en la pagina de inicio de sesion de Practice Test Automation$")
    public void queElUsuarioSeEncuentreEnLaPaginaDeInicioDeSesionDePracticeTestAutomation() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }

    @Cuando("^ingrese las credenciales correctas:$")
    public void ingreseLasCredencialesCorrectas(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Autenticarse.auto(dataTable.asList(CredencialesInicioSesion.class))
        );
    }
    @Entonces("^se debe verificar que el usuario haya sido autenticado correctamente y redirigido a su perfil$")
    public void seDebeVerificarQueElUsuarioHayaSidoAutenticadoCorrectamenteYRedirigidoASuPerfil() {
        // Aquí se validará el mensaje de éxito
    }
}

