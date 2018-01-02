package factories.zero_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;

public abstract class ZeroArgImageFunctionFactory implements IImageFunctionFactory {

    public abstract IImageFunction produce();
}
