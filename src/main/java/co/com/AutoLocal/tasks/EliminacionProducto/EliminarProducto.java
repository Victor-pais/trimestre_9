package co.com.AutoLocal.tasks.EliminacionProducto;


import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarProducto implements Task {

    private final String nombre;

    public EliminarProducto(String nombre) {
        this.nombre = nombre;
    }

    public static EliminarProducto conNombre(String nombre) {
        return instrumented(EliminarProducto.class, nombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println(" Eliminando producto: " + nombre);

        actor.attemptsTo(
                Click.on(ProductosPage.botonEliminarDelProducto(nombre)),
                AceptarAlertaProducto.ahora()
        );
    }
}

