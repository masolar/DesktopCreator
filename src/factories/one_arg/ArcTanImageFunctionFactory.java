package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.one_arg.ArcTanImageFunction;

public class ArcTanImageFunctionFactory extends OneArgImageFunctionFactory {

    public ArcTanImageFunctionFactory(IImageFunctionFactory arg_one) {
        super(arg_one);
    }

    @Override
    public IImageFunction produce() {
        return new ArcTanImageFunction(arg_one.produce());
    }
}