package co.com.AutoFacebook.models;

public class CredencialesInicioSesion {
    private String usuario;

    private String clave;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuarios(String usuarios) {
        this.usuario = usuarios;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public CredencialesInicioSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
}
