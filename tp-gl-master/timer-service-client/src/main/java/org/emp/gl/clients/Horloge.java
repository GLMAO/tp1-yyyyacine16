package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    private String name;
    private TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialisée !");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(SECONDE_PROP)) {
            System.out.println(name + " → " +
                timerService.getHeures() + ":" +
                timerService.getMinutes() + ":" +
                timerService.getSecondes());
        }
    }
}
