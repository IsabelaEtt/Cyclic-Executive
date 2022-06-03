package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // runFixedCyclicExecutive();
        runVariableCyclicExecutive();
    }
    
    static void runFixedCyclicExecutive () {
        FixedCyclicExecutive fce = new FixedCyclicExecutive();
        fce.addTask(new Task("Task 1", 1, 5));
        fce.addTask(new Task("Task 2", 2, 4));
        fce.addTask(new Task("Task 3", 3, 3));
        fce.addTask(new Task("Task 4", 4, 2));
        fce.addTask(new Task("Task 5", 5, 1));
        fce.run();
    }
    
    static void runVariableCyclicExecutive () {
        VariableCyclicExecutive vce = new VariableCyclicExecutive();
        Task task1 = new Task("Task 1", 4, 8);
        Task task2 = new Task("Task 2", 3, 6);
        Task task3 = new Task("Task 3", 1, 3);
        Task task4 = new Task("Task 4", 2, 3);
        Task task5 = new Task("Task 5", 1, 2);
        
        List<Task> minorCycle1 = new ArrayList<>();
        minorCycle1.add(task1);
        minorCycle1.add(task2);
        minorCycle1.add(task3);
        
        List<Task> minorCycle2 = new ArrayList<>();
        minorCycle2.add(task1);
        minorCycle2.add(task2);
        minorCycle2.add(task4);
        minorCycle2.add(task5);
        
        List<Task> minorCycle3 = new ArrayList<>();
        minorCycle3.add(task1);
        minorCycle3.add(task2);
        minorCycle3.add(task3);
        
        List<Task> minorCycle4 = new ArrayList<>();
        minorCycle4.add(task1);
        minorCycle4.add(task2);
        minorCycle4.add(task4);
        
        vce.addMinorCycle(minorCycle1);
        vce.addMinorCycle(minorCycle2);
        vce.addMinorCycle(minorCycle3);
        vce.addMinorCycle(minorCycle4);
        
        vce.run();
    }
}