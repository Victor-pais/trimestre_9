package co.com.AutoLocal.tasks.CreacionUsuarios;

import co.com.AutoLocal.userinterface.Usuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmarCreacionUsuario implements Task {

    public static ConfirmarCreacionUsuario confirmar() {
        return Tasks.instrumented(ConfirmarCreacionUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Paso 1: Hacer clic en el botón GUARDAR / CREAR
        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.BOTON_GUARDAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(UsuariosPage.BOTON_GUARDAR)
        );

        System.out.println(" Se hizo clic en el botón Guardar/Crear usuario.");

        // Paso 2: Manejar la alerta del navegador
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5); //  Compatible con Selenium 3

        try {
            // Pausa breve para dejar que aparezca la alerta
            Thread.sleep(500);

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(" Alerta detectada: " + alert.getText());
            alert.accept();
            System.out.println(" Alerta aceptada correctamente.");

        } catch (NoAlertPresentException e) {
            System.out.println(" No se encontró alerta en el tiempo esperado.");
        } catch (Exception e) {
            System.out.println(" Error al manejar la alerta: " + e.getMessage());
        }

        // Paso 3: Verificar que el mensaje de éxito aparezca en el HTML
        actor.attemptsTo(
                WaitUntil.the(UsuariosPage.MENSAJE_EXITO, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(UsuariosPage.MENSAJE_EXITO).isDisplayed()
        );

        System.out.println(" Mensaje de éxito verificado correctamente en la página.");
    }
}

