
public class Misc {

    public static long toLong(int up, int low)
    {
	return (((long) up & 0xFFFFFFFFL) << 32) | ((long) low & 0xFFFFFFFFL);
    }

}

