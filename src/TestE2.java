public class TestE2 {
    
    public static void main(String args[]) {
        
        CPAGame cpa = new CPAGame(new E2Adversary(), new E2());
        cpa.run();
        cpa.printResult();
        
        System.out.println("");
    }
}
