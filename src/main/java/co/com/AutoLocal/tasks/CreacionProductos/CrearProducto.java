package co.com.AutoLocal.tasks.CreacionProductos;

import co.com.AutoLocal.models.ProductoData;
import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearProducto implements Task {

    private final ProductoData data;

    public CrearProducto(ProductoData data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ProductosPage.INPUT_NOMBRE, isVisible())
                        .forNoMoreThan(8).seconds(),

                Enter.theValue(data.getNombreProducto())
                        .into(ProductosPage.INPUT_NOMBRE),

                SelectFromOptions.byVisibleText(data.getProveedor())
                        .from(ProductosPage.SELECT_PROVEEDOR)
        );
    }

    public static CrearProducto conDatos(ProductoData data) {
        return instrumented(CrearProducto.class, data);
    }
}
