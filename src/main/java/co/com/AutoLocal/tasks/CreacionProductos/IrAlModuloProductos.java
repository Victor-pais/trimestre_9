package co.com.AutoLocal.tasks.CreacionProductos;

import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IrAlModuloProductos implements Task {


        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Click.on(ProductosPage.MODULO_PRODUCTOS)
            );
        }

        public static IrAlModuloProductos abrir() {
            return instrumented(IrAlModuloProductos.class);
        }

        public static Task clickNuevo() {
            return Task.where(
                    "{0} hace clic en Nuevo producto",
                    Click.on(ProductosPage.BTN_NUEVO)
            );
        }
    }
