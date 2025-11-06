package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.models.CredencialesInicioSesion;
import co.com.AutoLocal.tasks.AbrirPagina;
import co.com.AutoLocal.tasks.Autenticarse;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AutenticacionStepsDefinitions {

    @Dado("^que el usuario abre la página de login$")
    public void queElUsuarioAbreLaPaginaDeLogin() {
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.lapagina());
    }

    @Cuando("^ingresa las credenciales correctas:$")
    public void ingresaLasCredencialesCorrectas(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                Autenticarse.auto(dataTable.asList(CredencialesInicioSesion.class))
        );
    }


    @Entonces("^debería ver el mensaje Panel de Administración Sox$")
    public void deberiaVerElMesajePanelDeAdministracionSox(){
        // Aquí se validará el mensaje de éxito
    }
}