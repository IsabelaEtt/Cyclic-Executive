package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FixedCyclicExecutive {
    private final long cycleTime = 40;
    private long timeUsedInCycle = 0;
    private List<Task> tasks = new ArrayList<>();
    
    public FixedCyclicExecutive () {}
    
    public void run () {
        while (true) {
            this.waitNextCycle();

            for (Task task: tasks) {
                task.run();
                
                this.timeUsedInCycle += task.getDuration();
            }
        }
    }
    
    synchronized private void waitNextCycle () {
        System.out.println("\nUsed " + this.timeUsedInCycle + " ms, cycle should have " + this.cycleTime + " ms");
        
        long timeToWait = this.cycleTime - this.timeUsedInCycle;
        this.timeUsedInCycle = 0;
        
        if (timeToWait <= 0) {
            System.out.println("Doesn't need to wait...");
            return;
        }
        
        System.out.println("Will wait " + timeToWait + " ms...");
        
        try { new Thread().sleep(timeToWait);
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void addTask (Task newTask) {
       this.tasks.add(newTask);
    }
}