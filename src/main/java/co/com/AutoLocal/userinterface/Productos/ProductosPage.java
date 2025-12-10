package co.com.AutoLocal.userinterface.Productos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductosPage {

    // Acceso al módulo Productos
    public static final Target MODULO_PRODUCTOS = Target.the("Acceso rápido Productos")
            .located(By.cssSelector("div.card[routerlink='/productos']"));

    // Botón Nuevo
    public static final Target BTN_NUEVO =
            Target.the("botón nuevo producto")
                    .located(By.id("btn-nuevo-producto"));

    // Campo Nombre
    public static final Target INPUT_NOMBRE =
            Target.the("input nombre producto")
                    .located(By.id("input-nombre-producto"));

    // Select proveedor
    public static final Target SELECT_PROVEEDOR =
            Target.the("select proveedor")
                    .located(By.id("select-proveedor"));

    // Botón Crear / Actualizar (sirve para ambos)
    public static final Target BTN_CREAR =
            Target.the("botón crear o actualizar producto")
                    .located(By.id("btn-crear-producto"));

    // Mensaje de éxito (crear o actualizar)
    public static final Target MENSAJE_EXITO =
            Target.the("alerta éxito")
                    .located(By.xpath("//div[contains(@class,'alerta') and contains(@class,'exito')]"));

    // Botón Eliminar dinámico
    public static Target botonEliminarDelProducto(String nombreProducto) {
        return Target.the("botón eliminar del producto " + nombreProducto)
                .locatedBy("//tr[td[contains(text(),'{0}')]]//button[contains(@class,'eliminar')]")
                .of(nombreProducto);
    }

    // Botón Editar dinámico
    public static Target botonEditarDelProducto(String nombreProducto) {
        return Target.the("botón editar del producto " + nombreProducto)
                .locatedBy("//tr[td[contains(text(),'{0}')]]//button[contains(@class,'editar')]")
                .of(nombreProducto);
    }
}
