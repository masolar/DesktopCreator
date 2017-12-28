package functions.one_arg;

import functions.IImageFunction;

/**
 * An image function that uses another image function as its input.
 */
public abstract class OneArgumentImageFunction implements IImageFunction {

    protected IImageFunction imageFunction;

    public OneArgumentImageFunction(IImageFunction imageFunction) {
        this.imageFunction = imageFunction;
    }

    @Override
    public abstract double[] execute(double x, double y);
}
