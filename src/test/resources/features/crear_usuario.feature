# language: es

Característica: Crear un nuevo usuario en el sistema
  Como administrador del sistema
  Quiero acceder al módulo de usuarios
  Para registrar nuevos usuarios correctamente

  Antecedentes:
    Dado que el administrador ha iniciado sesion en el sistema
    Y se encuentra en la pagina del menu principal

  Escenario: Crear un nuevo usuario exitosamente
    Cuando el administrador hace clic en el acceso rapido "Usuarios"
    Y hace clic en el boton "Nuevo"
    Y completa el formulario con los datos del usuario
      | nombre_usuario | nombres | apellidos | tipo_documento_id | numero_documento | celular | direccion | ciudad | email | contrasena | tipo_rol_id |
      | rafa           | Rafael  | López     | Cédula de Ciudadanía | 10473483456 | 3222222235 | carrera 94 m # 91 a 61 | Bogotá D.C. | juantgaga@gmail.com | juan12343 | Administrador |

    Y confirma la creacion del usuario
    Entonces el sistema muestra un mensaje de confirmacion

