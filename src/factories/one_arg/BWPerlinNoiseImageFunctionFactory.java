package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.one_arg.BWPerlinNoiseImageFunction;

public class BWPerlinNoiseImageFunctionFactory extends OneArgImageFunctionFactory {

    public BWPerlinNoiseImageFunctionFactory(IImageFunctionFactory arg_one) {
        super(arg_one);
    }

    @Override
    public IImageFunction produce() {
        return new BWPerlinNoiseImageFunction(arg_one.produce());
    }
}
