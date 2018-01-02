package factories.three_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;

public abstract class ThreeArgImageFunctionFactory implements IImageFunctionFactory {

    protected IImageFunctionFactory arg_one, arg_two, arg_three;

    public ThreeArgImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two, IImageFunctionFactory arg_three) {
        this.arg_one = arg_one;
        this.arg_two = arg_two;
        this.arg_three = arg_three;
    }
    public abstract IImageFunction produce();
}
