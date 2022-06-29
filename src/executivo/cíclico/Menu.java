package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    boolean runningInitialMenu = true;
    boolean runningFixedMenu = false;
    boolean runningVariableMenu = false;
    Scanner scanner = new Scanner(System.in);
    FixedCyclicExecutive fce = new FixedCyclicExecutive();
    VariableCyclicExecutive vce = new VariableCyclicExecutive();
    
    private void showFixedCyclicExecutiveOptions () {
        System.out.println("Selecione o que deseja fazer com o executivo cíclico de tempo fixo:");
        System.out.println("1 - Rodar");
        System.out.println("2 - Pausar");
        System.out.println("3 - Reotmar");
        System.out.println("4 - Parar");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("6 - Sair");
        
        while (runningFixedMenu) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1: 
                    this.createFixedCyclicExecutiveTasks();
                    this.runFixedCyclicExecutive();
                    continue;
                case 2: 
                    fce.stopCycle();
                    this.showFixedCyclicExecutiveOptions();
                    break;
                case 3:
                    this.runFixedCyclicExecutive();
                    continue;
                case 4: 
                    fce.removeAllTasks();
                    fce.stopCycle();
                    this.showFixedCyclicExecutiveOptions();
                    break;
                case 5:
                    fce.removeAllTasks();
                    fce.stopCycle();
                    this.runningInitialMenu = true;
                    this.runningFixedMenu = false;
                    this.showInitialMenu();
                    break;
                case 6:
                    fce.removeAllTasks();
                    fce.stopCycle();
                    this.runningFixedMenu = false;
                    break;
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
    }
    
    private void showVariableCyclicExecutiveOptions () {
        System.out.println("Selecione o que deseja fazer com o executivo cíclico de tempo variável:");
        System.out.println("1 - Rodar");
        System.out.println("2 - Pausar");
        System.out.println("3 - Reotmar");
        System.out.println("4 - Parar");
        System.out.println("5 - Voltar ao menu principal");
        System.out.println("6 - Sair");
        
        while (runningVariableMenu) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1: 
                    this.createVariableCyclicExecutiveTasks();
                    this.runVariableCyclicExecutive();
                    continue;
                case 2: 
                    vce.stopCycle();
                    this.showVariableCyclicExecutiveOptions();
                    break;
                case 3:
                    this.runVariableCyclicExecutive();
                    continue;
                case 4: 
                    vce.removeAllTasks();
                    vce.stopCycle();
                    this.showVariableCyclicExecutiveOptions();
                    break;
                case 5:
                    vce.removeAllTasks();
                    vce.stopCycle();
                    this.runningInitialMenu = true;
                    this.runningVariableMenu = false;
                    this.showInitialMenu();
                    break;
                case 6:
                    vce.removeAllTasks();
                    vce.stopCycle();
                    this.runningVariableMenu = false;
                    break;
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
    }
    
    public void showInitialMenu () {
        System.out.println("Bem vindo! Selecione qual executive cíclico você deseja rodar:");
        System.out.println("1 - Executivo cíclico de tempo fixo");
        System.out.println("2 - Executivo cíclico de tempo variável");
        System.out.println("3 - Sair");
        
        while (runningInitialMenu) {
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1: 
                    this.runningInitialMenu = false;
                    this.runningFixedMenu = true;
                    this.showFixedCyclicExecutiveOptions();
                    break;
                case 2:
                    this.runningInitialMenu = false;
                    this.runningVariableMenu = true;
                    this.showVariableCyclicExecutiveOptions();
                    break;
                case 3:
                    this.runningInitialMenu = false;
                    break;
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
    }
    
    private void createFixedCyclicExecutiveTasks () {
        fce.addTask(new Task("Task 1", 1, 5));
        fce.addTask(new Task("Task 2", 2, 4));
        fce.addTask(new Task("Task 3", 3, 3));
        fce.addTask(new Task("Task 4", 4, 2));
        fce.addTask(new Task("Task 5", 5, 1));
    }
    
    private void runFixedCyclicExecutive () {
        if (!fce.hasTasks()) {
            System.out.println("É necessário rodar antes de retomar");
            return;
        }
        
        new Thread(new FixedRunnable()).start();
    }
    
    private void createVariableCyclicExecutiveTasks () {
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
    }
    
    private void runVariableCyclicExecutive () {
       if (!vce.hasTasks()) {
            System.out.println("É necessário rodar antes de retomar");
            return;
        }
        
        new Thread(new VariableRunnable()).start();
    }
    
    
  
    private class FixedRunnable implements Runnable {
        public void run() {
            fce.run();
        }
    }
    
    private class VariableRunnable implements Runnable {
        public void run() {
            vce.run();
        }
    }
}

