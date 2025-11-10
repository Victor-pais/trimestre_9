package co.com.AutoLocal.models;

public class UsuarioData {
    private String nombre_usuario;
    private String nombres;
    private String apellidos;
    private String tipo_documento_id;
    private String numero_documento;
    private String celular;
    private String direccion;
    private String ciudad;
    private String email;
    private String contrasena;
    private String tipo_rol_id;

    // Getters y setters
    public String getNombre_usuario() { return nombre_usuario; }
    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTipo_documento_id() { return tipo_documento_id; }
    public void setTipo_documento_id(String tipo_documento_id) { this.tipo_documento_id = tipo_documento_id; }

    public String getNumero_documento() { return numero_documento; }
    public void setNumero_documento(String numero_documento) { this.numero_documento = numero_documento; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTipo_rol_id() { return tipo_rol_id; }
    public void setTipo_rol_id(String tipo_rol_id) { this.tipo_rol_id = tipo_rol_id; }
}
