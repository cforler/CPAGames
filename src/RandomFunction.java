import java.util.HashMap;
import java.security.SecureRandom;

/* Random 32-bit  function */
public class RandomFunction {
    HashMap<Integer,Integer> B = new HashMap<Integer,Integer>();
    SecureRandom random;

    public RandomFunction() {
	random = new SecureRandom();
    }

    public RandomFunction(byte[] b) {
	random = new SecureRandom(b);
    }


    public void Rekey() {
	B.clear();
    }

    public int get(int x) {
	if( B.containsKey(x) == false )
	    B.put(x, random.nextInt());
	return B.get(x);
    }
}