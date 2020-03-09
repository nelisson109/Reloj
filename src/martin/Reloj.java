package martin;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Reloj extends Label {

    private int horas;
    private int minutos;
    private int segundos;
    //private boolean formatoHoras = true;
    private BooleanProperty formatoHs = new SimpleBooleanProperty(true);
    List<Tarea> listaTareas = Collections.synchronizedList(new ArrayList<Tarea>());
    //ArrayList<Accion> listaAcciones = new ArrayList<Accion>();
    private Accion accion;

    public Reloj() {
       // iniciar();
    }

    public void comenzar(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//falta pasar el formato
                        Calendar calendar = new GregorianCalendar();
                        horas = calendar.get(Calendar.HOUR_OF_DAY);
                        minutos = calendar.get(Calendar.MINUTE);
                        segundos = calendar.get(Calendar.SECOND);
                        Date date = new Date();
                        String fecha = formato.format(date);
                        if(formatoHs.get() == true){
                            //System.out.println(horas + ":" + minutos + ":" + segundos);
                            setText(horas + ":" + minutos + ":" + segundos);
                        }
                        else{
                            horas = calendar.get(Calendar.HOUR);
                            //System.out.println(horas + ":" + minutos + ":" + segundos);
                            setText(horas + ":" + minutos + ":" + segundos);
                        }

                        if (listaTareas != null){
                            for (int i=0; i<listaTareas.size(); i++){
                                if(listaTareas.get(i).getFecha().equals(fecha) &&
                                listaTareas.get(i).getHoras()==horas && listaTareas.get(i).getMinutos()==minutos &&
                                listaTareas.get(i).getSegundos()==segundos){
                                   /* for (int j=0; j<listaAcciones.size(); j++){
                                        listaAcciones.get(j).ejecuta(listaTareas.get(i));
                                    }*/
                                   accion.ejecuta(listaTareas.get(i));
                                }
                            }
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    public void registrarTarea(Tarea tarea){
        listaTareas.add(tarea);
        //alarma?
    }

    public void borrarTarea(Tarea tarea){
        listaTareas.remove(tarea);
    }

    public void añadirAccion(Accion accion){
        this.accion = accion;
    }

    public boolean isFormatoHs() {
        return formatoHs.get();
    }

    public BooleanProperty formatoHsProperty() {
        return formatoHs;
    }

    public void setFormatoHs(boolean formatoHs) {
        this.formatoHs.set(formatoHs);
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
}
