package functions.zero_args;

/**
 * An image function that returns the x coordinates for each color value
 */
public class XImageFunction extends ZeroArgumentImageFunction {

    public XImageFunction() {
        super("X");
    }
    @Override
    public double[] execute(double x, double y) {
        return new double[] {x, x, x, 1};
    }
}
