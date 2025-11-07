package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private int valeur;
    private String name;
    private TimerService timerService;

    public CompteARebours(String name, int valeur, TimerService timerService) {
        this.name = name;
        this.valeur = valeur;
        this.timerService = timerService;

        timerService.addTimeChangeListener(this);
        System.out.println(name + " : Début du compte à rebours → " + valeur);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(SECONDE_PROP)) {
            valeur--;
            System.out.println(name + " → " + valeur);

            if (valeur <= 0) {
                timerService.removeTimeChangeListener(this);
                System.out.println(name + " terminé → " + valeur);
            }
        }
    }
}
