package factories.zero_args;

import functions.IImageFunction;
import functions.zero_args.YImageFunction;

public class YImageFunctionFactory extends ZeroArgImageFunctionFactory {

    @Override
    public IImageFunction produce() {
        return new YImageFunction();
    }
}
