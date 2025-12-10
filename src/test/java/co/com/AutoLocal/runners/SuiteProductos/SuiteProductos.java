package co.com.AutoLocal.runners.SuiteProductos;


import co.com.AutoLocal.runners.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CrearProductoRunner.class,
        EditarProductoRunner.class,
        EliminarProductoRunner.class

})
public class SuiteProductos {
}
