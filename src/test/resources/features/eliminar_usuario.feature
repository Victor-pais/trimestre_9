# language: es

@EliminarUsuario
Característica: Eliminar usuario del sistema

  Antecedentes:
    Dado que el administrador ha iniciado sesion en el sistema
    Y se encuentra en la pagina del menu principal

  Escenario: Eliminar un usuario existente
    Cuando el administrador hace clic en el acceso rapido "Usuarios"
    Y elimina el usuario "rafa"
    Entonces el sistema confirma que el usuario "rafa" ya no está en la tabla
