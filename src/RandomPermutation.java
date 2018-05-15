import java.util.HashMap;
import java.util.Map;
import java.security.SecureRandom;

public class RandomPermutation extends BlockCipher {
    HashMap<Long,Long> B = new HashMap<Long,Long>();
    SecureRandom random  = new SecureRandom();

    public void rekey(long key) {
	B.clear();
    }

    /******************************************************/

    public long encrypt(long plaintext) {
	if( B.containsKey(plaintext) )
	    return B.get(plaintext);
	else
	    return getFreshCiphertext(plaintext);
    }

    /******************************************************/

    public long decrypt(long ciphertext) {
	if( B.containsValue(ciphertext) )
	    {
	    for (Map.Entry<Long, Long> entry : B.entrySet())
		if (entry.getValue().equals(ciphertext))
		    return entry.getKey();
	    }
	return getFreshPlaintext(ciphertext);
    }

    /******************************************************/


    private long getFreshCiphertext(long p) {
	long c = random.nextLong();
	while( B.containsValue(c) )
	    c = random.nextLong();
	B.put(p,c);
	return c;
    }

    private long getFreshPlaintext(long c) {
	long p = random.nextLong();
	while( B.containsKey(p) )
	    p = random.nextLong();
	B.put(p,c);
	return p;
    }
}
