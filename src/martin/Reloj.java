package martin;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj extends Label {
    private Label relojDigital;
    private int horas;
    private int minutos;
    private int segundos;
    private boolean formatoHoras = true;
    private BooleanProperty formatoHs = new SimpleBooleanProperty(true);

    public Reloj() {
       // iniciar();
    }

    public void comenzar(){
        Timer clock = new Timer();
        clock.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(formatoHoras == true){
                            DateFormat formato = new SimpleDateFormat("HH:mm:ss");//falta pasar el formato
                            Calendar calendar = Calendar.getInstance();
                            horas = calendar.get(Calendar.HOUR);
                            minutos = calendar.get(Calendar.MINUTE);
                            segundos = calendar.get(Calendar.SECOND);
                            relojDigital = new Label();
                            //System.out.println(formato.format(horas) + ":" + formato.format(minutos) + ":" + formato.format(segundos));
                            //relojDigital.setText(formato.format(horas) + ":" + formato.format(minutos) + ":" + formato.format(segundos));
                            //relojDigital.setText(horas + ":" + minutos + ":" + segundos);
                            System.out.println(horas + ":" + minutos + ":" + segundos);
                        }
                        else{

                        }

                    }
                });
            }
        }, 1000, 1000);

      /*  Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            time.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();*/
    }

    public boolean isFormatoHoras() {
        return formatoHoras;
    }

    public void setFormatoHoras(boolean formatoHoras) {
        this.formatoHoras = formatoHoras;
    }

    public void iniciar(){//esto sobra ahora mismo

        Thread reloj = new Thread(){
            public void run(){
                while(true) {
                    DateFormat formato = new SimpleDateFormat("HH:mm:ss");
                    Calendar calendar = Calendar.getInstance();
                    horas = calendar.get(Calendar.HOUR);
                    minutos = calendar.get(Calendar.MINUTE);
                    segundos = calendar.get(Calendar.SECOND);
                    System.out.println(horas + ":" + minutos + ":" + segundos);

                    try{
                        sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        reloj.start();
    }
}
