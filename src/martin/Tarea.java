package martin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarea {
    private int horas;
    private int minutos;
    private int segundos;
    private Date fecha;
    private String texto;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public Tarea(int horas, int minutos, int segundos, Date fecha, String texto) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.fecha = fecha;
        this.texto = texto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String getFecha() {
        return formato.format(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
