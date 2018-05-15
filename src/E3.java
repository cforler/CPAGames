import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class E3 extends BlockCipher {
    int[][] t;
    
    
    public E3() {
        rekey(new SecureRandom().nextLong());
        initT();
    }

    public E3(long key) {
	rekey(key);
        initT();
    }

    private void initT() {
           t = new int[][] { {2,0,1,3}, {3,2,1,0}, {0,1,2,3}, {2,1,0,3},
                             {0,1,2,3}, {2,3,1,0}, {0,2,3,1}, {1,2,3,0} };
    }

    public void rekey(long key) {
        key %= 8;
        this.key = (key+8)%8;
    }


    public long encrypt(long plaintext) {
        int p = (int) (plaintext%4)+4;
        p %= 4;
        return t[(int) key][p];
    }

    public long decrypt(long ciphertext) {
        int c = (int) (ciphertext%4)+4;
        c%=4;
        for(int i=0;i<4;i++)
            if(t[(int)key][i] == c) return i;
        return -1;
    }
}
