package co.com.AutoLocal.questions;

import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.NoSuchElementException;

public class ProductoNoExiste implements Question<Boolean> {

    private final String nombre;

    public ProductoNoExiste(String nombre) {
        this.nombre = nombre;
    }

    public static ProductoNoExiste conNombre(String nombre) {
        return new ProductoNoExiste(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {

            for (int i = 0; i < 10; i++) {
                boolean existe = ProductosPage.botonEliminarDelProducto(nombre)
                        .resolveFor(actor)
                        .isPresent();
                if (!existe) {
                    return true;
                }
                Thread.sleep(500);
            }
            return false;
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
