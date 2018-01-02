package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.one_arg.CosImageFunction;

public class CosImageFunctionFactory extends OneArgImageFunctionFactory {

    public CosImageFunctionFactory(IImageFunctionFactory arg_one) {
        super(arg_one);
    }

    @Override
    public IImageFunction produce() {
        return new CosImageFunction(arg_one.produce());
    }
}
