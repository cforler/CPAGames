
public abstract class Adversary {

    /* Returns true:  Adversary thinks bc is a real block cipher
     * Returns false: Adversary thinks bc is a random permutation */

    public abstract boolean runAndGuess(BlockCipher bc);

}