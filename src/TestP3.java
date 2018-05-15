
public class TestP3 {

    public static void main(String args[])
    {
	CPAGame cpa = new CPAGame(new NaiveAdversary(), new P3());
	cpa.run();
	cpa.printResult();

	System.out.println("");

	cpa = new CPAGame(new P3Adversary(), new P3());
	cpa.run();
	cpa.printResult();

    }
}
