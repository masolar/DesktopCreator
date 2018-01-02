package factories.two_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.two_args.MultiplyImageFunction;

public class MultiplyImageFunctionFactory extends TwoArgImageFunctionFactory {

    public MultiplyImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two) {
        super(arg_one, arg_two);
    }

    @Override
    public IImageFunction produce() {
        return new MultiplyImageFunction(arg_one.produce(), arg_two.produce());
    }
}