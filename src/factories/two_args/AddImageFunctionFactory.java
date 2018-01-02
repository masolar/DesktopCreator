package factories.two_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.two_args.AddImageFunction;

public class AddImageFunctionFactory extends TwoArgImageFunctionFactory {

    public AddImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two) {
        super(arg_one, arg_two);
    }

    @Override
    public IImageFunction produce() {
        return new AddImageFunction(arg_one.produce(), arg_two.produce());
    }
}
