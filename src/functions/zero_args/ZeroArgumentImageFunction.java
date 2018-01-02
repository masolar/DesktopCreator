package functions.zero_args;

import functions.IImageFunction;

/**
 * Represents all image functions that do not need any other functions
 */
public abstract class ZeroArgumentImageFunction implements IImageFunction {

    private String functionName;

    public ZeroArgumentImageFunction(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public abstract double[] execute(double x, double y);

    public String toString() {
        return functionName + "()";
    }
}
