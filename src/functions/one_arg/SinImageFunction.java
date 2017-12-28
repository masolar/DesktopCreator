package functions.one_arg;

import functions.IImageFunction;

/**
 * A function that gets the cos of a number.
 */
public class SinImageFunction extends OneArgumentImageFunction {

    public SinImageFunction(IImageFunction imageFunction) {
        super(imageFunction);
    }

    @Override
    public double[] execute(double x, double y) {
        double[] color = imageFunction.execute(x, y);

        return new double[] {Math.sin(color[0]), Math.sin(color[1]), Math.sin(color[2]), Math.sin(color[3])};
    }
}
