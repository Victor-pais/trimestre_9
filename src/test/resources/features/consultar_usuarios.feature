# language: es

Característica: Consulta de usuarios
  Como usuario autenticado
  Quiero consultar la lista de usuarios del sistema
  Para poder verificar que la información sea correcta

  @consulta
  Escenario: Verificar la visualización de la lista de usuarios
    Dado que el usuario ha iniciado sesión correctamente
    Cuando navega a la sección de "Usuarios"
    Entonces debería ver una lista de usuarios registrados en el sistema
