# language: es

@EditarUsuario
Característica: Editar usuario existente

  Antecedentes:
    Dado que el administrador ha iniciado sesion en el sistema
    Y se encuentra en la pagina del menu principal

  Escenario: Editar un usuario existente exitosamente
    Cuando el administrador hace clic en el acceso rapido "Usuarios"
    Y edita el usuario "rafa" cambiando el nombre a "rafael" y el correo a "rafael@example.com"
    Entonces el sistema muestra un mensaje de éxito al actualizar el usuario
