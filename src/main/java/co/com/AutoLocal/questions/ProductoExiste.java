package co.com.AutoLocal.questions;


import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductoExiste implements Question<Boolean> {

    private final String nombre;

    public ProductoExiste(String nombre) {
        this.nombre = nombre;
    }

    public static ProductoExiste conNombre(String nombre) {
        return new ProductoExiste(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return ProductosPage.botonEditarDelProducto(nombre)
                    .resolveFor(actor)
                    .isVisible();
        } catch (Exception e) {
            return false;
        }
    }
}
