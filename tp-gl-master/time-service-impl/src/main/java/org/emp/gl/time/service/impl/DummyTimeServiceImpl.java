package org.emp.gl.time.service.impl;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.beans.PropertyChangeSupport;

import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class DummyTimeServiceImpl implements TimerService {

    private int dixieme;
    private int secondes;
    private int minutes;
    private int heures;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public DummyTimeServiceImpl() {
        majHeureSysteme();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                majHeureSysteme();
            }
        }, 100, 100);
    }

    private void majHeureSysteme() {
        LocalTime now = LocalTime.now();

        setDixieme(now.getNano() / 100000000);
        setSecondes(now.getSecond());
        setMinutes(now.getMinute());
        setHeures(now.getHour());
    }

    private void setDixieme(int newValue) {
        int old = dixieme;
        dixieme = newValue;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, old, newValue);
    }

    private void setSecondes(int newValue) {
        int old = secondes;
        secondes = newValue;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, old, newValue);
    }

    private void setMinutes(int newValue) {
        int old = minutes;
        minutes = newValue;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, old, newValue);
    }

    private void setHeures(int newValue) {
        int old = heures;
        heures = newValue;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, old, newValue);
    }

    @Override public void addTimeChangeListener(TimerChangeListener pl) {
        pcs.addPropertyChangeListener(pl);
    }

    @Override public void removeTimeChangeListener(TimerChangeListener pl) {
        pcs.removePropertyChangeListener(pl);
    }

    @Override public int getMinutes() { return minutes; }
    @Override public int getHeures() { return heures; }
    @Override public int getSecondes() { return secondes; }
    @Override public int getDixiemeDeSeconde() { return dixieme; }
}
