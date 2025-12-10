package co.com.AutoLocal.runners.SuiteUsuarios;

import co.com.AutoLocal.runners.CrearUsuarioRunner;
import co.com.AutoLocal.runners.EditarUsuarioRunner;
import co.com.AutoLocal.runners.EliminarUsuarioRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CrearUsuarioRunner.class,
        EditarUsuarioRunner.class,
        EliminarUsuarioRunner.class

})

public class SuiteUsurios {
}
