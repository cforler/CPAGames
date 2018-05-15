
/* Abstract 64-bit Blockcipher with k=64 */

public abstract class BlockCipher {
    protected long key;

    public abstract void rekey(long key);
    public abstract long encrypt(long plaintext);
    public abstract long decrypt(long ciphertext);

}