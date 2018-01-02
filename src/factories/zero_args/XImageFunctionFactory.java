package factories.zero_args;

import functions.IImageFunction;
import functions.zero_args.XImageFunction;

public class XImageFunctionFactory extends ZeroArgImageFunctionFactory {

    @Override
    public IImageFunction produce() {
        return new XImageFunction();
    }
}
