package functions.three_args;

import functions.IImageFunction;

/**
 * An image function that takes two image functions as input.
 */
public abstract class ThreeArgumentImageFunction implements IImageFunction {

    private String functionName;

    protected IImageFunction imageFunction1;
    protected IImageFunction imageFunction2;
    protected IImageFunction imageFunction3;

    public ThreeArgumentImageFunction(String functionName, IImageFunction imageFunction1, IImageFunction imageFunction2, IImageFunction imageFunction3) {
        this.functionName = functionName;

        this.imageFunction1 = imageFunction1;
        this.imageFunction2 = imageFunction2;
        this.imageFunction3 = imageFunction3;
    }

    @Override
    public abstract double[] execute(double x, double y);

    public String toString() {
        return functionName + "(" + imageFunction1.toString() + ", " + imageFunction2.toString() + ", " + imageFunction3.toString() + ")";
    }
}
