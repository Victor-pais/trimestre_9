package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.questions.ProductoExiste;
import co.com.AutoLocal.tasks.CreacionUsuarios.IniciarSesion;
import co.com.AutoLocal.tasks.CreacionProductos.IrAlModuloProductos;
import co.com.AutoLocal.tasks.EdicionProducto.EditarProducto;
import co.com.AutoLocal.userinterface.Productos.ProductosPage;

import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class EditarProductoStepDefinitions {

    // LOGIN
    @Dado("^que el administrador accede al sistema$")
    public void queElAdministradorAccedeAlSistema() {
        OnStage.theActorCalled("Admin")
                .wasAbleTo(IniciarSesion.conCredenciales("admin", "admin123"));
    }

    // MENÚ
    @Dado("^el administrador está en el menu principal$")
    public void elAdministradorEstaEnElMenuPrincipal() {
    }

    // ACCESO RÁPIDO — SOLO UNA DEFINICIÓN
    @Cuando("^el administrador ingresa al módulo Productos$")
    public void elAdministradorIngresaAlModuloProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlModuloProductos.abrir()
        );
    }

    // EDITAR PRODUCTO
    @Cuando("^edita el producto \"([^\"]*)\" cambiando el nombre a \"([^\"]*)\"$")
    public void editarProducto(String nombreActual, String nuevoNombre) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EditarProducto.cambiarNombre(nombreActual, nuevoNombre)
        );
    }

    // MENSAJE DE ÉXITO
    @Entonces("^el sistema muestra un mensaje de éxito al actualizar el producto$")
    public void validarMensajeExito() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Mensaje de éxito visible",
                        actor -> ProductosPage.MENSAJE_EXITO.resolveFor(actor).isVisible()
                )
        );
    }

    // VALIDAR EN TABLA
    @Entonces("^el producto \"([^\"]*)\" aparece en la tabla$")
    public void productoApareceEnTabla(String nuevoNombre) {
        OnStage.theActorInTheSpotlight().should(
                seeThat("El producto aparece en la tabla",
                        ProductoExiste.conNombre(nuevoNombre),
                        equalTo(true)
                )
        );
    }
}
