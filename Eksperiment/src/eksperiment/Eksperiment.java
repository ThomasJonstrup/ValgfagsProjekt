/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eksperiment;

/**
 *
 * @author Thomas
 */
public class Eksperiment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int number = 0;
        int timeNumber = 7000;
        long t1 = (long) System.currentTimeMillis();
        
        for (int i = 0; i < timeNumber; i++) {
            number = number + 1;
            System.out.println("" + number);
        }
        long t2 = (long) System.currentTimeMillis();
        
        System.out.println("Iterativ: " + (t2 - t1) + " millisekunder");
        
        t1 = (long) System.currentTimeMillis();
        
        rekursivMetode(timeNumber);
        
        t2 = (long) System.currentTimeMillis();
        System.out.println("Rekursiv: " + (t2 - t1) + " millisekunder");
        
    }
    
    private static void rekursivMetode(int timeNumber)
    {
        if (timeNumber >= 1) {
            rekursivMetode(timeNumber -1 );
            System.out.println(" " + timeNumber);
        }
        
    }
    
    
}
