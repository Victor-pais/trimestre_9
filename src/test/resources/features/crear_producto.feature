# language: es

Característica: Crear un nuevo producto en el sistema
  Como administrador del sistema
  Quiero acceder al módulo de productos
  Para registrar nuevos productos correctamente

  Antecedentes:
    Dado que el administrador ingreso al sistema
    Y se encuentra en la pagina principal

  Escenario: Crear un producto exitosamente
    Cuando el administrador accede al modulo Productos
    Y selecciona la opcion Nuevo producto
    Y completa el formulario de producto
      | nombreProducto | proveedor |
      | Producto Test  | Proveedor 1 — Admin Principal |
    Y confirma la creacion del producto
    Entonces el sistema muestra mensaje de producto creado
