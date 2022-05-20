package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.logging.Level;
import java.util.logging.Logger;

public class VariableCyclicExecutive {
    private int loop = 0;
    private boolean keepRunning = false;
    private long minorCycleTime = 20;
    private long timeUsedInMinorCycle = 0;
    
    public VariableCyclicExecutive () {}
    
    public void stop () {
        this.keepRunning = false;
    }
    
    public void run () {
        this.keepRunning = true;
        
        while (this.keepRunning) {
            // First minor cycle
            this.waitNextMinorCycle();
            
            long startTime = System.currentTimeMillis();

            this.task1();
            this.task2();
            this.task3();
            
            this.timeUsedInMinorCycle = this.timeUsedInMinorCycle + (System.currentTimeMillis() - startTime);
            
            
            // Second minor cycle
            this.waitNextMinorCycle();
            
            startTime = System.currentTimeMillis();

            this.task1();
            this.task2();
            this.task4();
            this.task5();
            
            this.timeUsedInMinorCycle = this.timeUsedInMinorCycle + (System.currentTimeMillis() - startTime);
            
            
            // Third minor cycle
            this.waitNextMinorCycle();
            
            startTime = System.currentTimeMillis();

            this.task1();
            this.task2();
            this.task3();
            
            this.timeUsedInMinorCycle = this.timeUsedInMinorCycle + (System.currentTimeMillis() - startTime);
            
            
            // Fourth minor cycle
            this.waitNextMinorCycle();
            
            startTime = System.currentTimeMillis();

            this.task1();
            this.task2();
            this.task4();
            
            this.timeUsedInMinorCycle = this.timeUsedInMinorCycle + (System.currentTimeMillis() - startTime);
        }
    }
    
    synchronized private void waitNextMinorCycle () {
        System.out.println("\nUsed " + this.timeUsedInMinorCycle + " ms, minor cycle should have " + this.minorCycleTime + " ms");
        
        long timeToWait = this.minorCycleTime - this.timeUsedInMinorCycle;
        this.timeUsedInMinorCycle = 0;
        
        if (timeToWait <= 0) {
            this.timeUsedInMinorCycle = timeToWait * -1;
            System.out.println("Doesn't need to wait... Overrun..." + this.timeUsedInMinorCycle);
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
