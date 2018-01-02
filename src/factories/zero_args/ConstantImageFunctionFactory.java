package factories.zero_args;

import functions.IImageFunction;
import functions.zero_args.ConstantImageFunction;

public class ConstantImageFunctionFactory extends ZeroArgImageFunctionFactory {

    @Override
    public IImageFunction produce() {
        return new ConstantImageFunction(Math.random());
    }
}
