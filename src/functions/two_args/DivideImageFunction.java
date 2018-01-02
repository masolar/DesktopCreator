package functions.two_args;

import functions.IImageFunction;

/**
 * A function that divides the results of two functions together.
 */
public class DivideImageFunction extends TwoArgumentImageFunction {

    public DivideImageFunction(IImageFunction imageFunction1, IImageFunction imageFunction2) {
        super("Divide", imageFunction1, imageFunction2);
    }

    @Override
    public double[] execute(double x, double y) {

        double[] result1 = imageFunction1.execute(x, y);
        double[] result2 = imageFunction2.execute(x, y);

        double[] finalResult = new double[4];

        for (int i = 0; i < 4; i++) {
            if (result2[i] == 0) {
                finalResult[i] = 0;
            } else
                finalResult[i] = result1[i] / result2[i];
        }

        return finalResult;
    }
}
