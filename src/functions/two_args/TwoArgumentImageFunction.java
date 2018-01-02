package functions.two_args;

import functions.IImageFunction;

/**
 * An image function that takes two image functions as input.
 */
public abstract class TwoArgumentImageFunction implements IImageFunction {

    private String functionName;

    protected IImageFunction imageFunction1;
    protected IImageFunction imageFunction2;

    public TwoArgumentImageFunction(String functionName, IImageFunction imageFunction1, IImageFunction imageFunction2) {
        this.functionName = functionName;

        this.imageFunction1 = imageFunction1;
        this.imageFunction2 = imageFunction2;
    }

    @Override
    public abstract double[] execute(double x, double y);

    public String toString() {
        return functionName + "(" + imageFunction1.toString() + ", " + imageFunction2.toString() + ")";
    }
}
