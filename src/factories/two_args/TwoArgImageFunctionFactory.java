package factories.two_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;

public abstract class TwoArgImageFunctionFactory implements IImageFunctionFactory {

    protected IImageFunctionFactory arg_one, arg_two;

    public TwoArgImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two) {
        this.arg_one = arg_one;
        this.arg_two = arg_two;
    }
    public abstract IImageFunction produce();
}
