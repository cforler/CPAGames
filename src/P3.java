import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class P3 extends BlockCipher {
    private RandomFunction f1;
    private RandomFunction f2;
    private RandomFunction f3;


    public P3() {
	f1 = new RandomFunction();
	f2 = new RandomFunction();
	f3 = new RandomFunction();
    }

    public P3(long key) {
	rekey(key);
    }

    public void rekey(long key) {
	this.key = key;
	byte[] seed = ByteBuffer.allocate(8).putLong(key).array();
	SecureRandom g = new SecureRandom(seed);
	g.nextBytes(seed);
	f1 = new RandomFunction(seed);
	g.nextBytes(seed);
	f2 = new RandomFunction(seed);
	g.nextBytes(seed);
	f3 = new RandomFunction(seed);
    }


    public long encrypt(long plaintext) {
	int L = (int) ((plaintext >>> 32) & 0xFFFFFFFFL);
	int R = (int) (plaintext & 0xFFFFFFFFL);

	int S = L ^ f1.get(R);
	int Y = R ^ f2.get(S);
	int X = S ^ f3.get(Y);

	return Misc.toLong(X,Y);
    }

    public long decrypt(long ciphertext) {
	int X = (int) ((ciphertext >>> 32) & 0x00000000FFFFFFFFL);
	int Y = (int) (ciphertext & 0x00000000FFFFFFFFL);

	int S = X ^ f3.get(Y);
	int R = Y ^ f2.get(S);
	int L = S ^ f1.get(R);


	return  Misc.toLong(L,R);
    }
}
