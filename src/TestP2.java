
public class TestP2 {

    public static void main(String args[])
    {
	CPAGame cpa = new CPAGame(new NaiveAdversary(), new P2());
	cpa.run();
	cpa.printResult();

	System.out.println("");

	cpa = new CPAGame(new P2Adversary(), new P2());
	cpa.run();
	cpa.printResult();

    }
}
