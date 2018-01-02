package functions.one_arg;

import functions.IImageFunction;

import java.util.Random;

public class ColorPerlinNoiseImageFunction extends OneArgumentImageFunction {

    private static final Random rand = new Random();
    private int randomColorVal1, randomColorVal2, randomColorVal3;

    //TODO: Make these values part of the constructor to be deterministic
    public ColorPerlinNoiseImageFunction(IImageFunction argOne) {
        super("ColorPerlin", argOne);

        randomColorVal1 = rand.nextInt(100);
        randomColorVal2 = rand.nextInt(100);
        randomColorVal3 = rand.nextInt(100);
    }

    //TODO: Figure out best values to put into perlin
    //TODO: Figure out if there's a reason for color perlin to be one argument.
    @Override
    public double[] execute(double x, double y) {
        double[] perlinSeed = imageFunction.execute(x, y);

        return new double[] {BWPerlinNoiseImageFunction.noise(x, y, randomColorVal1),
                             BWPerlinNoiseImageFunction.noise(x, y, randomColorVal2),
                             BWPerlinNoiseImageFunction.noise(x, y, randomColorVal3),
                             1};
    }
}
