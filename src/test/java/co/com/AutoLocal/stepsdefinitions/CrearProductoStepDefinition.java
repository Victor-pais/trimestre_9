package co.com.AutoLocal.stepsdefinitions;

import co.com.AutoLocal.models.ProductoData;
import co.com.AutoLocal.tasks.CreacionProductos.CrearProducto;
import co.com.AutoLocal.tasks.CreacionProductos.ConfirmarCreacionProducto;
import co.com.AutoLocal.tasks.CreacionProductos.IrAlModuloProductos;
import co.com.AutoLocal.tasks.CreacionUsuarios.IniciarSesion;
import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearProductoStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    // ----------------------------
    // ANTECEDENTES
    // ----------------------------

    @Dado("^que el administrador ingreso al sistema$")
    public void queElAdministradorIngresoAlSistema() {
        OnStage.theActorCalled("Admin")
                .wasAbleTo(IniciarSesion.conCredenciales("admin", "admin123"));
    }

    @Dado("^se encuentra en la pagina principal$")
    public void seEncuentraEnLaPaginaPrincipal() {
        // Validación opcional o vacío
    }

    // ----------------------------
    // ESCENARIO: Crear producto
    // ----------------------------

    @Cuando("^el administrador accede al modulo Productos$")
    public void elAdministradorAccedeAlModuloProductos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlModuloProductos.abrir()
        );
    }

    @Cuando("^selecciona la opcion Nuevo producto$")
    public void seleccionaLaOpcionNuevoProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IrAlModuloProductos.clickNuevo()
        );
    }

    @Cuando("^completa el formulario de producto$")
    public void completaElFormularioDeProducto(List<ProductoData> datos) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearProducto.conDatos(datos.get(0))
        );
    }

    @Cuando("^confirma la creacion del producto$")
    public void confirmaLaCreacionDelProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarCreacionProducto.guardar()
        );
    }

    @Entonces("^el sistema muestra mensaje de producto creado$")
    public void elSistemaMuestraMensajeDeProductoCreado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ProductosPage.MENSAJE_EXITO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Ensure.that(ProductosPage.MENSAJE_EXITO).isDisplayed()
        );
        System.out.println(" Producto creado exitosamente.");
    }

}
