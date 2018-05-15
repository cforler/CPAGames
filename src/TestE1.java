public class TestE1 {
    
    public static void main(String args[]) {
        
        CPAGame cpa = new CPAGame(new E1Adversary(), new E1());
        cpa.run();
        cpa.printResult();
        
        System.out.println("");
    }
}
