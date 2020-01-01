
package EDD;

public class NodoUsuarioRechazo {
    private String Nombre;
    private String Apellido;
    private String Carnet;
    private String Password;
    private String Razon;

    public NodoUsuarioRechazo() {
    }

    public NodoUsuarioRechazo(String Nombre, String Apellido, String Carnet, String Password, String Razon) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carnet = Carnet;
        this.Password = Password;
        this.Razon = Razon;
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

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String Razon) {
        this.Razon = Razon;
    }
    
    
 
}
