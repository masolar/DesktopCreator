package program.model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Holds the model associated with the program.
 */
public class ProgramModel {

    IProgramModel2ViewAdapter m2v;

    BufferedImage imageToCreate;

    public ProgramModel(IProgramModel2ViewAdapter m2v) {
        this.m2v = m2v;
    }

    /**
     * Performs all startup tasks associated with the model.
     */
    public void start() {

    }

    /**
     * Creates a random image for the user's background.
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public void createRandomImage(int width, int height) {
        // TODO: Add error handling for negative values.

        imageToCreate = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);


        // TODO: Parallellize this loop if possible.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                imageToCreate.setRGB(i, j, new Color(22, 100, 53).getRGB());
            }
        }
    }
}
