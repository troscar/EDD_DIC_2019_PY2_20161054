
package EDD;

public class NodoUsuario {
    private String Nombre;
    private String Apellido;
    private Integer Carnet;
    private Integer Password;

    public NodoUsuario() {
    }
    

    public NodoUsuario(String Nombre, String Apellido, Integer Carnet, Integer Password) {
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

    public Integer getCarnet() {
        return Carnet;
    }

    public void setCarnet(Integer Carnet) {
        this.Carnet = Carnet;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer Password) {
        this.Password = Password;
    }
    
    

}
