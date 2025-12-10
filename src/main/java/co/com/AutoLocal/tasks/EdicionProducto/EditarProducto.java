package co.com.AutoLocal.tasks.EdicionProducto;

import co.com.AutoLocal.userinterface.Productos.ProductosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditarProducto implements Task {

    private final String nombreActual;
    private final String nuevoNombre;

    public EditarProducto(String nombreActual, String nuevoNombre) {
        this.nombreActual = nombreActual;
        this.nuevoNombre = nuevoNombre;
    }

    public static EditarProducto cambiarNombre(String nombreActual, String nuevoNombre) {
        return instrumented(EditarProducto.class, nombreActual, nuevoNombre);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ProductosPage.botonEditarDelProducto(nombreActual)),
                Clear.field(ProductosPage.INPUT_NOMBRE),
                Enter.theValue(nuevoNombre).into(ProductosPage.INPUT_NOMBRE),
                Click.on(ProductosPage.BTN_CREAR)
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            Thread.sleep(500);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No apareció alerta.");
        } catch (Exception e) {
            System.out.println("Error manejando alerta: " + e.getMessage());
        }
    }
}
