import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class P2 extends BlockCipher {
    private RandomFunction f1;
    private RandomFunction f2;


    public P2() {
	f1 = new RandomFunction();
	f2 = new RandomFunction();
    }

    public P2(long key) {
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
    }

    public long encrypt(long plaintext) {
	int L = (int) ((plaintext >>> 32) & 0xFFFFFFFFL);
	int R = (int) (plaintext & 0xFFFFFFFFL);

	int X = L ^ f1.get(R);
	int Y = R ^ f2.get(X);

	return Misc.toLong(X,Y);
    }

    public long decrypt(long ciphertext) {
	int X = (int) ((ciphertext >>> 32) & 0xFFFFFFFFL);
	int Y = (int) (ciphertext & 0x0FFFFFFFFL);

	int R = Y ^ f2.get(X);
	int L = X ^ f1.get(R);

	return  Misc.toLong(L,R);
    }
}
