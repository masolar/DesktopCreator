package functions.three_args;

import functions.IImageFunction;

public class LerpImageFunction extends ThreeArgumentImageFunction {

    public LerpImageFunction(IImageFunction imageFunction1, IImageFunction imageFunction2, IImageFunction imageFunction3) {
        super("Lerp", imageFunction1, imageFunction2, imageFunction3);
    }

    @Override
    public double[] execute(double x, double y) {
        double[] v1 = imageFunction1.execute(x, y);
        double[] v2 = imageFunction2.execute(x, y);
        double[] t = imageFunction3.execute(x, y);

        double[] result = new double[4];
        result[3] = 1;

        for (int i = 0; i < 3; i++) {
            result[i] = (1 - t[i]) * v1[i] + t[i] + v2[i];
        }

        return result;
    }
}
