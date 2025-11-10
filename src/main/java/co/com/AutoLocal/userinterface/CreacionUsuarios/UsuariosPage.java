package co.com.AutoLocal.userinterface.CreacionUsuarios;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class UsuariosPage {

    // Botón que abre el modal
    public static final Target BOTON_NUEVO =
            Target.the("botón nuevo usuario")
                    .located(By.id("btnNuevoUsuario"));

    // Modal completo que contiene el formulario
    public static final Target MODAL_NUEVO_USUARIO = Target.the("modal nuevo usuario")
            .locatedBy("//div[contains(@class,'modal-content')]");

    // Campos del formulario dentro del modal
    public static final Target CAMPO_NOMBRE_USUARIO = Target.the("campo nombre de usuario")
            .locatedBy("//input[@placeholder='Nombre de usuario']");

    public static final Target CAMPO_NOMBRES = Target.the("campo nombres")
            .locatedBy("//input[@placeholder='Nombres']");

    public static final Target CAMPO_APELLIDOS = Target.the("campo apellidos")
            .locatedBy("//input[@placeholder='Apellidos']");

    public static final Target SELECT_TIPO_DOCUMENTO = Target.the("selector tipo documento")
            .located(By.id("selectTipoDocumento"));

    public static final Target CAMPO_DOCUMENTO =
            Target.the("campo número de documento")
                    .located(By.id("inputDocumento"));
    public static final Target CAMPO_CELULAR = Target.the("campo celular")
            .locatedBy("//input[contains(@placeholder,'Celular')]");

    public static final Target CAMPO_DIRECCION = Target.the("campo dirección")
            .locatedBy("//input[contains(@placeholder,'Dirección')]");

    public static final Target CAMPO_CIUDAD = Target.the("campo ciudad")
            .locatedBy("//input[contains(@placeholder,'Ciudad')]");
    public static final Target CAMPO_CORREO = Target.the("campo correo electrónico")
            .locatedBy("//input[@placeholder='Email' or @type='email']");

    public static final Target CAMPO_CONTRASENA = Target.the("campo contraseña")
            .locatedBy("//input[@type='password']");

    public static final Target SELECT_ROL =
            Target.the("selector rol del usuario")
                    .located(By.id("selectRol"));

    public static final Target OPCION_ROL =
            Target.the("opción del rol")
                    .locatedBy("//select[@id='selectRol']/option[normalize-space(text())='{0}']");
    public static final Target BOTON_GUARDAR = Target.the("botón guardar usuario")
            .locatedBy("//button[contains(@class,'btn-guardar') or contains(text(),'Crear')]");

    // Ajusta este ID cuando veamos el HTML completo del mensaje de éxito
    public static final Target MENSAJE_EXITO = Target.the("mensaje de éxito al crear usuario")
            .locatedBy("//*[contains(text(),'Usuario registrado') or contains(text(),'creado') or contains(text(),'éxito')]");

}
