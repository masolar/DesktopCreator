package program.model;

import java.awt.image.BufferedImage;

/**
 * Provides a way for the model to interface with the view.
 */
public interface IProgramModel2ViewAdapter {

    /**
     * Gives the view an image to display to the user.
     * @param createdImage The image for the view to display.
     */
    public void displayImage(BufferedImage createdImage);
}
