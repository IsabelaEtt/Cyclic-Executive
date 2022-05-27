package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task {
    long startTime;
    long finishTime;
    long duration;
    long mediumDuration;
    int tolerance;
    String name;
    Random rand = new Random();

    Task(String name, long mediumDuration, int tolerance) {
        this.name = name;
        this.mediumDuration = mediumDuration;
        this.tolerance = tolerance;
    }
    
    public long getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public void run() {
        this.startTime = System.currentTimeMillis();
        this.duration = this.mediumDuration + this.rand.nextInt(this.tolerance);
        
        try { new Thread().sleep(this.duration);
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.finishTime = System.currentTimeMillis();
    }
}