package generator;

import factories.IImageFunctionFactory;
import factories.one_arg.*;
import factories.three_args.LerpImageFunctionFactory;
import factories.two_args.AddImageFunctionFactory;
import factories.two_args.DivideImageFunctionFactory;
import factories.two_args.MultiplyImageFunctionFactory;
import factories.two_args.SubtractImageFunctionFactory;
import factories.zero_args.ConstantImageFunctionFactory;
import factories.zero_args.XImageFunctionFactory;
import factories.zero_args.YImageFunctionFactory;
import factories.zero_args.ZeroArgImageFunctionFactory;
import functions.IImageFunction;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiFunction;

public class FunctionGenerator {

    public static final FunctionGenerator FUNCTION_GENERATOR = new FunctionGenerator();

    private static final Random rand = new Random();

    private ArrayList<IImageFunctionFactory> zeroArgFactories;
    private ArrayList<BiFunction<Integer, Integer, IImageFunctionFactory>> otherFactories;

    private FunctionGenerator() {
        zeroArgFactories = new ArrayList<IImageFunctionFactory>();
        otherFactories = new ArrayList<BiFunction<Integer, Integer, IImageFunctionFactory>>();

        zeroArgFactories.add(new ConstantImageFunctionFactory());
        zeroArgFactories.add(new XImageFunctionFactory());
        zeroArgFactories.add(new YImageFunctionFactory());

        otherFactories.add((maxDepth, currentDepth) -> {
            return new ConstantImageFunctionFactory();
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new XImageFunctionFactory();
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new YImageFunctionFactory();
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new SinImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new CosImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new ArcTanImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new BWPerlinNoiseImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new ColorPerlinNoiseImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new AddImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1), generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new MultiplyImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1), generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new DivideImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1), generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new SubtractImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1), generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
        otherFactories.add((maxDepth, currentDepth) -> {
            return new LerpImageFunctionFactory(generateRandomFunctionFactory(maxDepth, currentDepth + 1),
                                                generateRandomFunctionFactory(maxDepth, currentDepth + 1),
                                                generateRandomFunctionFactory(maxDepth, currentDepth + 1));
        });
    }

    public IImageFunction generateImageFunction(int maxDepth) {
        return generateRandomFunctionFactory(maxDepth, 0).produce();
    }

    private IImageFunctionFactory generateRandomFunctionFactory(int maxDepth, int currentDepth) {
        if (maxDepth == currentDepth) {
            return zeroArgFactories.get(rand.nextInt(zeroArgFactories.size()));
        }

        return otherFactories.get(rand.nextInt(otherFactories.size())).apply(maxDepth, currentDepth);
    }
}
