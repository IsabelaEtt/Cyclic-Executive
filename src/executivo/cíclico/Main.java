package executivo.cíclico;

// @author Isabela Canelas Ett - RA00303107

public class Main {
    public static void main(String[] args) {
        FixedCyclicExecutive fce = new FixedCyclicExecutive();
        
        fce.run();

        try { new Thread().sleep(4000);
        } catch(InterruptedException ex) {
            System.out.println("Erro");
        }
        
        fce.stop();
    }
}
