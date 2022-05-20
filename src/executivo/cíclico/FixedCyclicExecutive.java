package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.logging.Level;
import java.util.logging.Logger;


public class FixedCyclicExecutive {
    private int sum = 0;
    private int loop = 0;
    private boolean keepRunning = false;
    private long cycleTime = 40;
    private long timeUsedInCycle = 0;
    
    public FixedCyclicExecutive () {}
    
    public FixedCyclicExecutive (int cycleTime) {
        this.cycleTime = cycleTime;
    }
    
    public void stop () {
        this.keepRunning = false;
    }
    
    public void run () {
        this.keepRunning = true;
        
        while (this.keepRunning) {
            this.waitNextCycle();
            
            long startTime = System.currentTimeMillis();

            this.updateLoop();
            this.updateSum();
            this.printLoopSum();
            
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
   
    private void updateLoop () {
        this.loop += 1;
        
        try { new Thread().sleep(5); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateSum () {
        this.sum += this.loop;
        
        try { new Thread().sleep(5); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printLoopSum () {
        System.out.println("Fixes Cyclic Executive - Loop " + this.loop + " - Sum " + this.sum);
        
        try { new Thread().sleep(5); //Simulate time spent with tasks
        } catch(InterruptedException ex) {
            Logger.getLogger(FixedCyclicExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
