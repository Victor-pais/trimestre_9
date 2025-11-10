package co.com.AutoLocal.tasks.EliminacionUsuario;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;

public class AceptarAlerta implements Task {

    public static AceptarAlerta ahora() {
        return Tasks.instrumented(AceptarAlerta.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Accede al WebDriver del actor
        Alert alerta = BrowseTheWeb.as(actor).getDriver().switchTo().alert();
        // Acepta la alerta
        alerta.accept();
    }
}



