package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.HorlogeUI;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {

    public static void main(String[] args) {

    TimerService timerService = new DummyTimeServiceImpl();

    new Horloge("H1", timerService);
    new Horloge("H2", timerService);

    new CompteARebours("C1", 5, timerService);

    for (int i = 1; i <= 10; i++) {
        int start = 10 + (int)(Math.random() * 11);
        new CompteARebours("C" + i, start, timerService);
    }

   
    new HorlogeUI("Horloge Graphique", timerService);
}

    }

