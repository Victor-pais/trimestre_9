# language: es

Característica: Eliminar producto del sistema

  Antecedentes:
    Dado que el administrador ingreso al sistema
    Y se encuentra en la pagina principal

  Escenario: Eliminar un producto existente
    Cuando el administrador accede al modulo Productos
    Y elimina el producto "Producto Test"
    Entonces el sistema confirma que el producto "Producto Test" ya no está en la tabla
