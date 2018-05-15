import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class E1 extends BlockCipher {
       
    public E1() {
        rekey(new SecureRandom().nextLong());
    }
    
    public void rekey(long key) {
         this.key = key;
    }


    public long encrypt(long plaintext) {
        return plaintext ^ key;
    }

    public long decrypt(long ciphertext) {
        return ciphertext ^ key;
    }
}
