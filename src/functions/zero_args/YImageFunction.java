package functions.zero_args;

/**
 * An image function that returns the y coordinates for each color value
 */
public class YImageFunction extends ZeroArgumentImageFunction {

    public YImageFunction() {
        super("Y");
    }
    @Override
    public double[] execute(double x, double y) {
        return new double[] {y, y, y, 1};
    }
}
