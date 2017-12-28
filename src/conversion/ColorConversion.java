package conversion;

/**
 * Contains a few handy methods for converting between colors and color spaces.
 */
public class ColorConversion {

    /**
     * Returns a float array given a double array
     * @param dArray The double array to be converted
     * @return A float array with the same values
     */
    public static float[] getFloatArrayFromDoubles(double[] dArray) {
        return new float[] {wrapFloatVal((float)dArray[0]),
                            wrapFloatVal((float)dArray[1]),
                            wrapFloatVal((float)dArray[2]),
                            wrapFloatVal((float)dArray[3])};
    }

    /**
     * Wraps floats so that they stay within a [0.0, 1.0] range
     * @param val The value of the float to wrap
     * @return A wrapped float
     */
    private static float wrapFloatVal(float val) {
        float valToCheck = val;

        if (valToCheck < 0.0F)
            return 0.0F;
        if (valToCheck > 1.0F)
            return 1.0F;
        return val;
    }
}
