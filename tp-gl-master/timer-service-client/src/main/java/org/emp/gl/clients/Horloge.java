package org.emp.gl.clients;

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
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        // On affiche l’heure seulement quand les secondes changent
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            afficherHeure();
        }
    }

    public void afficherHeure() {
        System.out.println(name + " → " +
                timerService.getHeures() + ":" +
                timerService.getMinutes() + ":" +
                timerService.getSecondes());
    }
}
