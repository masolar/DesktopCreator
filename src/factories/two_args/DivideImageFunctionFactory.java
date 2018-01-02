package factories.two_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.two_args.DivideImageFunction;

public class DivideImageFunctionFactory extends TwoArgImageFunctionFactory {

    public DivideImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two) {
        super(arg_one, arg_two);
    }

    @Override
    public IImageFunction produce() {
        return new DivideImageFunction(arg_one.produce(), arg_two.produce());
    }
}