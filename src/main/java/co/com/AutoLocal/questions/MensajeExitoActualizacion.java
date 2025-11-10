package co.com.AutoLocal.questions;

import co.com.AutoLocal.userinterface.CreacionUsuarios.UsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeExitoActualizacion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Obtiene el texto del mensaje de éxito
        return Text.of(UsuariosPage.MENSAJE_EXITO)
                .viewedBy(actor)
                .asString();
    }

    public static MensajeExitoActualizacion visible() {
        return new MensajeExitoActualizacion();
    }
}
