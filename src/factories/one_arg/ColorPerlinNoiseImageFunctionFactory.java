package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.one_arg.ColorPerlinNoiseImageFunction;

public class ColorPerlinNoiseImageFunctionFactory extends OneArgImageFunctionFactory {

    public ColorPerlinNoiseImageFunctionFactory(IImageFunctionFactory arg_one) {
        super(arg_one);
    }

    @Override
    public IImageFunction produce() {
        return new ColorPerlinNoiseImageFunction(arg_one.produce());
    }
}
