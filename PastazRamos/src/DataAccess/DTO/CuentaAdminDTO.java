package DataAccess.DTO;

public class CuentaAdminDTO {
    private String correo;
    private String password;

    // Constructor vacío
    public CuentaAdminDTO() {}

    // Constructor con parámetros
    public CuentaAdminDTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString
    @Override
    public String toString() {
        return "CuentaAdminDTO{" +
               "correo='" + correo + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
