package factories.two_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.two_args.SubtractImageFunction;

public class SubtractImageFunctionFactory extends TwoArgImageFunctionFactory {

    public SubtractImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two) {
        super(arg_one, arg_two);
    }

    @Override
    public IImageFunction produce() {
        return new SubtractImageFunction(arg_one.produce(), arg_two.produce());
    }
}