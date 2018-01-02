package functions.one_arg;

import functions.IImageFunction;

/**
 * A function that gets the cos of a number.
 */
public class ArcTanImageFunction extends OneArgumentImageFunction {

    public ArcTanImageFunction(IImageFunction imageFunction) {
        super("ArcTan", imageFunction);
    }

    @Override
    public double[] execute(double x, double y) {
        double[] color = imageFunction.execute(x, y);

        return new double[] {Math.atan(color[0]), Math.atan(color[1]), Math.atan(color[2]), Math.atan(color[3])};
    }
}
