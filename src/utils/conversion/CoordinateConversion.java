package utils.conversion;

/**
 * Contains helpful conversion methods for going between coordinate spaces.
 */
public class CoordinateConversion {

    /**
     * Converts an x coord from the awt system to a double from [-1.0, 1.0]
     * @param x The x coord to map
     * @param width The width of the image
     * @return A double from [-1.0, 1.0]
     */
    public static double convertXToDouble(int x, int width) {
        int half = width / 2;

        return (x - half) / ((double)half);
    }

    /**
     * Converts an y coord from the awt system to a double from [-1.0, 1.0]
     * @param y The y coord to map
     * @param height The height of the image
     * @return A double from [-1.0, 1.0]
     */
    public static double convertYToDouble(int y, int height) {
        int half = height / 2;

        return (half - y) / ((double)half);
    }
}
