package factories.three_args;

import factories.IImageFunctionFactory;
import functions.IImageFunction;
import functions.three_args.LerpImageFunction;
import functions.two_args.SubtractImageFunction;

public class LerpImageFunctionFactory extends ThreeArgImageFunctionFactory {
    public LerpImageFunctionFactory(IImageFunctionFactory arg_one, IImageFunctionFactory arg_two, IImageFunctionFactory arg_three) {
        super(arg_one, arg_two, arg_three);
    }

    @Override
    public IImageFunction produce() {
        return new LerpImageFunction(arg_one.produce(), arg_two.produce(), arg_three.produce());
    }
}
