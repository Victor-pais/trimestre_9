package co.com.AutoLocal.tasks.EliminacionProducto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;

public class AceptarAlertaProducto implements Task {

    public static AceptarAlertaProducto ahora() {
        return Tasks.instrumented(AceptarAlertaProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Alert alerta = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        System.out.println(" Alerta mostrada: " + alerta.getText());
        alerta.accept();
        System.out.println("Alerta aceptada.");
    }
}

