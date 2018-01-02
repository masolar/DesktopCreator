package functions.one_arg;

import functions.IImageFunction;

/**
 * An image function that uses another image function as its input.
 */
public abstract class OneArgumentImageFunction implements IImageFunction {

    private String functionName;
    protected IImageFunction imageFunction;


    public OneArgumentImageFunction(String functionName, IImageFunction imageFunction) {

        this.functionName = functionName;

        this.imageFunction = imageFunction;
    }

    @Override
    public abstract double[] execute(double x, double y);

    public String toString() {
        return functionName + "(" + imageFunction.toString() + ")";
    }
}
