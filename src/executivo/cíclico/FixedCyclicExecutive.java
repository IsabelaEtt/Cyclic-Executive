package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.logging.Level;
import java.util.logging.Logger;


public class FixedCyclicExecutive {
    private boolean keepRunning = false;
    private long cycleTime = 40;
    private long timeUsedInCycle = 0;
    
    public FixedCyclicExecutive () {}
    
    public void stop () {
        this.keepRunning = false;
    }
    
    public void run () {
        this.keepRunning = true;
        
        while (this.keepRunning) {
            this.waitNextCycle();
            
            long startTime = System.currentTimeMillis();

            this.task1();
            this.task2();
            this.task3();
            this.task4();
            this.task5();
            
            this.timeUsedInCycle = System.currentTimeMillis() - startTime;
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
   
    private void task1 () {
        try { new Thread().sleep(8); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void task2 () {
        try { new Thread().sleep(6); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void task3 () {
        try { new Thread().sleep(3); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    private void task4 () {
        try { new Thread().sleep(2); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void task5 () {
        try { new Thread().sleep(1); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
