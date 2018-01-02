package functions.zero_args;

/**
 * An image function that returns a constant color.
 */
// TODO: Figure out how to handle alpha value.
public class ConstantImageFunction extends ZeroArgumentImageFunction {

    public double constant;

    public ConstantImageFunction(double constant) {
        super("Constant");
        this.constant = constant;
    }


    @Override
    public double[] execute(double x, double y) {
        return new double[] {constant, constant, constant, 1};
    }
}
