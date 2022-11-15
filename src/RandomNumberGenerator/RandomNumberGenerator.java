package RandomNumberGenerator;

import java.lang.Math;

public class RandomNumberGenerator {
    private int seed;
    private final int a = 1103515245;
    private final int c = 12345;
    private final int m = (int) Math.pow(2, 12);
    

    public void generateRandomNumber(int firstSeed) {
        this.seed = firstSeed;
    }

    public void generatePosition(int firstSeed) {
        this.seed = firstSeed;
        this.nextPosition();
    }

    public int nextPosition() {
        this.seed = (seed * a + c) % m;
        if (this.seed > 0 && this.seed < 21) {
            return seed;
        }
        return this.nextPosition();

    }

    public int next() {
        this.seed = (seed * a + c) % m;
        if (this.seed < 0) {
            return this.next();
        }
        return seed;
    }

    public int getSeed() {
        return this.seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}