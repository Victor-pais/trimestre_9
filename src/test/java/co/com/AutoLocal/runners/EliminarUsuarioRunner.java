package co.com.AutoLocal.runners;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/eliminar_usuario.feature"},
        glue = {"co.com.AutoLocal.stepsdefinitions"},
        tags = {"@EliminarUsuario"},
        plugin = {"pretty"}
)
public class EliminarUsuarioRunner {

    @Test
    public void run() {
        // Método vacío para que Gradle reconozca el test
    }
}
