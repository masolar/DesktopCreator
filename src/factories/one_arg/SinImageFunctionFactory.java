package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.one_arg.SinImageFunction;

public class SinImageFunctionFactory extends OneArgImageFunctionFactory {

    public SinImageFunctionFactory(IImageFunctionFactory arg_one) {
        super(arg_one);
    }

    @Override
    public IImageFunction produce() {
        return new SinImageFunction(arg_one.produce());
    }
}
