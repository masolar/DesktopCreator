package functions.one_arg;

import functions.IImageFunction;

/**
 * A function that gets the cos of a number.
 */
public class CosImageFunction extends OneArgumentImageFunction {

    public CosImageFunction(IImageFunction imageFunction) {
        super(imageFunction);
    }

    @Override
    public double[] execute(double x, double y) {
        double[] color = imageFunction.execute(x, y);

        return new double[] {Math.cos(color[0]), Math.cos(color[1]), Math.cos(color[2]), Math.cos(color[3])};
    }
}
