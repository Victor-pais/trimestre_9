# language: es
@EditarProducto
Característica: Editar producto existente

  Antecedentes:
    Dado que el administrador accede al sistema
    Y el administrador está en el menu principal

  Escenario: Editar un producto existente exitosamente
    Cuando el administrador ingresa al módulo Productos
    Y edita el producto "Producto Test" cambiando el nombre a "Producto Editado"
    Entonces el sistema muestra un mensaje de éxito al actualizar el producto
    Y el producto "Producto Editado" aparece en la tabla
