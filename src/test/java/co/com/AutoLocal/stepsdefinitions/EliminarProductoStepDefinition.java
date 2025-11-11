package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.tasks.EliminacionProducto.EliminarProducto;
import co.com.AutoLocal.questions.ProductoNoExiste;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class EliminarProductoStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^elimina el producto \"([^\"]*)\"$")
    public void eliminaElProducto(String nombre) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarProducto.conNombre(nombre)
        );
    }

    @Entonces("^el sistema confirma que el producto \"(.*)\" ya no está en la tabla$")
    public void validarEliminacion(String nombre) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ProductoNoExiste.conNombre(nombre), is(true))
        );
    }
}
