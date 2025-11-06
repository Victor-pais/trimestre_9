package co.com.AutoLocal.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/autenticacion_local.feature",
        glue = {"co.com.AutoLocal.stepsdefinitions", "co.com.AutoLocal.utils.hooks"},
        snippets = SnippetType.CAMELCASE)

public class AutenticacionRunner {
}