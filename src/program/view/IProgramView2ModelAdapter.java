package program.view;

/**
 * Provides a way for the view to interface with the model.
 */
public interface IProgramView2ModelAdapter {

    /**
     * Asks the view to create an image of a given size.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public void createImage(int width, int height);
}
