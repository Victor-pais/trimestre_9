# language: es

Característica: Autenticación en la página de Practice Test Automation
  Como usuario del sitio de pruebas
  Quiero autenticarme en el portal de Practice Test Automation
  Para poder acceder al contenido y funcionalidades disponibles en mi cuenta.

  @autenticacion
  Escenario: Verificar la autenticación exitosa en la pagina de Practice Test Automation
    Dado que el usuario se encuentre en la pagina de inicio de sesion de Practice Test Automation
    Cuando ingrese las credenciales correctas:
      | usuario | clave       |
      | student | Password123 |
    Entonces se debe verificar que el usuario haya sido autenticado correctamente y redirigido a su perfil
