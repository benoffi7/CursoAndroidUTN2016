package gonzalo.ejemploutn.objetos;

/**
 * Created by Gonzalo on 01/11/2016.
 */

public class Casa
{
    int cantidadHabitaciones;
    String calle;
    double precio;
    boolean departamento;
    boolean favorito;

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public boolean isDepartamento() {
        return departamento;
    }

    public void setDepartamento(boolean departamento) {
        this.departamento = departamento;
    }

    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
