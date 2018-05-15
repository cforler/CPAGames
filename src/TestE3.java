public class TestE3 {
    
    public static void main(String args[]) {
        
        CPAGame cpa = new CPAGame(new E3Adversary(), new E3(),
                                  new RandomPermutation4());
        cpa.run();
        cpa.printResult();
        
        System.out.println("");
    }
}
