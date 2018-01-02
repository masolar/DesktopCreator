package program.model;

import utils.conversion.ColorConversion;
import utils.conversion.CoordinateConversion;
import functions.IImageFunction;
import generator.FunctionGenerator;

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

        IImageFunction imageFunction = FunctionGenerator.FUNCTION_GENERATOR.generateImageFunction(5);

        // TODO: Parallellize this loop if possible.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double convertedI = CoordinateConversion.convertXToDouble(i, width);
                double convertedJ = CoordinateConversion.convertYToDouble(j, height);
                double[] color = imageFunction.execute(convertedI, convertedJ);


                float[] finalColorArray = ColorConversion.getFloatArrayFromDoubles(color);
                Color finalPixelColor = new Color(finalColorArray[0],
                        finalColorArray[1], finalColorArray[2], finalColorArray[3]);

                imageToCreate.setRGB(i, j, finalPixelColor.getRGB());
            }
        }
        System.out.println(imageFunction);
        m2v.displayImage(imageToCreate);
    }
}
