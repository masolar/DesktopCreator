package factories.one_arg;

import factories.IImageFunctionFactory;
import functions.IImageFunction;

public abstract class OneArgImageFunctionFactory implements IImageFunctionFactory {

    protected IImageFunctionFactory arg_one;

    public OneArgImageFunctionFactory(IImageFunctionFactory arg_one) {
        this.arg_one = arg_one;
    }

    public abstract IImageFunction produce();
}
