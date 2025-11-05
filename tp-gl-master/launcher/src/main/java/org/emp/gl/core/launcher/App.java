package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {

    public static void main(String[] args) {

        // 1) Instancier le TimerService (SUJET)
        TimerService timerService = new DummyTimeServiceImpl();

        // 2) Injecter dans Horloge (OBSERVATEURS)
        Horloge h1 = new Horloge("Horloge 1", timerService);
        

        
    }
}
