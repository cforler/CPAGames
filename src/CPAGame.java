import java.security.SecureRandom;

public class CPAGame {
    private final int NUMBER_OF_ROUNDS = 1000;
    private final int THRESHOLD = 650;

    private SecureRandom random = new SecureRandom();
    private Adversary adversary;
    private BlockCipher bc;
    private BlockCipher p;
    private int result;

    
    public CPAGame(Adversary a, BlockCipher bc) {
	adversary = a;
	this.bc = bc;
        this.p = new RandomPermutation();
    }
    
    
    public CPAGame(Adversary a, BlockCipher bc, BlockCipher randomPermutation) {
        this.p = randomPermutation;
	adversary = a;
	this.bc = bc;
    }

    public void run()
    {
	result = 0;
	for(int i=0;i< NUMBER_OF_ROUNDS;i++)
	    {
		boolean guess;
		boolean real = random.nextBoolean();
		if(real) {
			bc.rekey(random.nextLong());
			guess = adversary.runAndGuess(bc);
		    }
		else
		   guess = adversary.runAndGuess(p);

		if(guess == real) result+=1;
	    }
    }

    public boolean hasWon() {
	return (result > THRESHOLD);
    }


    public void printResult() {
	System.out.print("The score of your adversary is " + result + "/" + NUMBER_OF_ROUNDS+". ");
	if(hasWon())
	    System.out.println("Congratulations! You won!\nYour adversary was able to distinguish the given block cipher from a random permutation. :-)");
	else
	    System.out.println("You lose!\nYour adversary was NOT able to distinguish the given block cipher from a random permutation. :-(");
    }
}
