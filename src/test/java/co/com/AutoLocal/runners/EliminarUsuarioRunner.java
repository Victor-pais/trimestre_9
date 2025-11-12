package co.com.AutoLocal.runners;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/eliminar_usuario.feature"},
        glue = {"co.com.AutoLocal.stepsdefinitions"},
        tags = {"@EliminarUsuario"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class EliminarUsuarioRunner {
}
