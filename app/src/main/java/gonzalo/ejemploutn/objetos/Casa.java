package gonzalo.ejemploutn.objetos;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gonzalo on 01/11/2016.
 */
@Table(name = "Casa")
public class Casa extends Model
{
    @Column (name = "cantidadHabitaciones")
    int cantidadHabitaciones;
    @Column (name = "calle")
    String calle;
    @Column (name = "precio")
    double precio;
    @Column (name = "departamento")
    boolean departamento;
    @Column (name = "favorito")
    boolean favorito;

    public Casa() {
    }

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
