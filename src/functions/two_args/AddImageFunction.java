package functions.two_args;

import functions.IImageFunction;

/**
 * A function that adds the results of two functions together.
 */
public class AddImageFunction extends TwoArgumentImageFunction {

    public AddImageFunction(IImageFunction imageFunction1, IImageFunction imageFunction2) {
        super("Add", imageFunction1, imageFunction2);
    }

    @Override
    public double[] execute(double x, double y) {

        double[] result1 = imageFunction1.execute(x, y);
        double[] result2 = imageFunction2.execute(x, y);

        return new double[] {result1[0] + result2[0], result1[1] + result2[1], result1[2] + result2[2], result1[3] + result2[3]};
    }
}
