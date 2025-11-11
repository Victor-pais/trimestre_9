package co.com.AutoLocal.tasks.CreacionProductos;

import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmarCreacionProducto implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Paso 1: Esperar a que el botón crear esté visible y listo
        actor.attemptsTo(
                WaitUntil.the(ProductosPage.BTN_CREAR, isVisible()).forNoMoreThan(10).seconds()
        );

        System.out.println("🖱️ Click en Crear producto.");
        actor.attemptsTo(Click.on(ProductosPage.BTN_CREAR));

        // Paso 2: Manejar alerta nativa del navegador
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            // Pausa breve para dejar aparecer la alerta
            Thread.sleep(500);

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(" Alerta encontrada: " + alert.getText());
            alert.accept();
            System.out.println(" Alerta aceptada correctamente.");

        } catch (NoAlertPresentException e) {
            System.out.println(" No apareció alerta en el tiempo esperado.");
        } catch (Exception e) {
            System.out.println(" Error al manejar alerta: " + e.getMessage());
        }

        // Paso 3: Validar mensaje de éxito en la página
        actor.attemptsTo(
                WaitUntil.the(ProductosPage.MENSAJE_EXITO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(ProductosPage.MENSAJE_EXITO).isDisplayed()
        );

        System.out.println(" Producto registrado con éxito.");
    }

    public static ConfirmarCreacionProducto guardar() {
        return instrumented(ConfirmarCreacionProducto.class);
    }
}
