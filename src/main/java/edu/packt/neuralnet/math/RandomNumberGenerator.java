package edu.packt.neuralnet.math;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    public static long seed;

    public static double GenerateNext() {
        ThreadLocalRandom.current().setSeed(seed);

        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }
}
