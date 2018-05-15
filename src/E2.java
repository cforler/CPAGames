import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class E2 extends BlockCipher {
       
    public E2() {
        rekey(new SecureRandom().nextLong());
    }
    
    public void rekey(long key) {
         this.key = key;
    }


    public long encrypt(long plaintext) {
        return plaintext + key;
    }

    public long decrypt(long ciphertext) {
        return ciphertext - key;
    }
}
