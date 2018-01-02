package functions;

/**
 * An interface representing a compositional function that is applied to a pixel.
 */
public interface IImageFunction {
    /**
     * Performs whatever steps this function needs.
     * @param x The x coordinate to act upon.
     * @param y The y coordinate to act upon.
     * @return A double array for rgba values.
     */
    double[] execute(double x, double y);
}
