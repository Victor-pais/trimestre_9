package co.com.AutoLocal.tasks.CreacionUsuarios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IrAlModuloUsuarios implements Task {

    private final String modulo;

    public IrAlModuloUsuarios(String modulo) {
        this.modulo = modulo;
    }

    public static IrAlModuloUsuarios enElMenu(String modulo) {
        return Tasks.instrumented(IrAlModuloUsuarios.class, modulo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        Target ACCESO_RAPIDO = Target.the("acceso rápido del módulo " + modulo)
                .locatedBy("//div[@routerlink='/usuarios']");

        actor.attemptsTo(
                WaitUntil.the(ACCESO_RAPIDO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(ACCESO_RAPIDO)
        );
    }
}