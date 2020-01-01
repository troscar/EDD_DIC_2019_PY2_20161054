
package EDD;

public class NodoUsuario {
    private String Nombre;
    private String Apellido;
    private String Carnet;
    private String Password;

    public NodoUsuario() {
    }

    public NodoUsuario(String Nombre, String Apellido, String Carnet, String Password) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carnet = Carnet;
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCarnet() {
        return Carnet;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
 
}
