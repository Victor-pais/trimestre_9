# language: es

Característica: Autenticación en mi página local
  Como usuario registrado
  Quiero iniciar sesión en mi aplicación local
  Para acceder al sistema.

  @autenticacion
  Escenario: Inicio de sesión exitoso
    Dado que el usuario abre la página de login
    Cuando ingresa las credenciales correctas:
      | usuario | clave    |
      | admin   | admin123 |
    Entonces debería ver el mensaje Panel de Administración Sox