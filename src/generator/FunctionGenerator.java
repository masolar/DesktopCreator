package generator;

import factories.IImageFunctionFactory;
import factories.one_arg.CosImageFunctionFactory;
import factories.one_arg.SinImageFunctionFactory;
import factories.two_args.AddImageFunctionFactory;
import factories.zero_args.ConstantImageFunctionFactory;
import factories.zero_args.XImageFunctionFactory;
import factories.zero_args.YImageFunctionFactory;
import factories.zero_args.ZeroArgImageFunctionFactory;
import functions.IImageFunction;

import java.util.ArrayList;
import java.util.Random;

public class FunctionGenerator {

    public static final FunctionGenerator FUNCTION_GENERATOR = new FunctionGenerator();

    private static final Random rand = new Random();

    //TODO: Fix this ghetto class code using a visitor.

    private FunctionGenerator() {
    }

    public IImageFunction generateImageFunction(int maxDepth) {
        return generateRandomFunctionFactory(maxDepth, 0).produce();
    }

    //TODO: Clean up this awful builder code. This was done to prototype.
    private IImageFunctionFactory generateRandomFunctionFactory(int maxDepth, int currentDepth) {
        if (maxDepth == currentDepth) {
            int randNum = rand.nextInt(3);

            switch (randNum) {
                case 0:
                    return new ConstantImageFunctionFactory();
                case 1:
                    return new XImageFunctionFactory();
                case 2:
                    return new YImageFunctionFactory();
            }
        }

        int randNum = rand.nextInt(3);

        switch (randNum) {
            case 0:
                return new SinImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
            case 1:
                return new CosImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
            case 2:
                return new AddImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1), generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        }

        return null;
    }
}
