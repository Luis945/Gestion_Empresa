package sample.objetos;

public class Usuario {

    int id;
    String Nombre,email,password;

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        Nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }

    public Usuario(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
