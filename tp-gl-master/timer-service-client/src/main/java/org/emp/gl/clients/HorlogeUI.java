package org.emp.gl.clients;


import java.awt.Font;
import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeUI extends JFrame implements TimerChangeListener {

    private JLabel label;
    private TimerService timerService;

    public HorlogeUI(String title, TimerService timerService) {

        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        // Configuration fenêtre
        setTitle(title);
        setSize(300, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Zone d’affichage
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        add(label);

        // Afficher fenêtre
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(SECONDE_PROP)) {
            label.setText(
                timerService.getHeures() + " : " +
                timerService.getMinutes() + " : " +
                timerService.getSecondes()
            );
        }
    }
}
