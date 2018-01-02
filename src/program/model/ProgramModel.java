package program.model;

import utils.conversion.ColorConversion;
import utils.conversion.CoordinateConversion;
import functions.IImageFunction;
import generator.FunctionGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

/**
 * Holds the model associated with the program.
 */
public class ProgramModel {

    private IProgramModel2ViewAdapter m2v;

    private BufferedImage imageToCreate;

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
    public void createRandomImage(int width, int height, int picDepth) {
        // TODO: Add error handling for negative values.

        imageToCreate = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

        IImageFunction imageFunction = FunctionGenerator.FUNCTION_GENERATOR.generateImageFunction(picDepth);

        // TODO: Parallellize this loop if possible.

        int numThreads = 3;
        Thread[] threads = new Thread[numThreads];

        long currTime = System.currentTimeMillis();
        for (int k = 0; k < numThreads; k++) {
            final double iter = k;
            threads[k] = new Thread(() -> {
                for (int i = (int)(iter / numThreads) * width; i < ((iter + 1) / numThreads) * width; i++) {
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
            });
            threads[k].start();
        }

//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                double convertedI = CoordinateConversion.convertXToDouble(i, width);
//                double convertedJ = CoordinateConversion.convertYToDouble(j, height);
//                double[] color = imageFunction.execute(convertedI, convertedJ);
//
//
//                float[] finalColorArray = ColorConversion.getFloatArrayFromDoubles(color);
//                Color finalPixelColor = new Color(finalColorArray[0],
//                        finalColorArray[1], finalColorArray[2], finalColorArray[3]);
//
//                imageToCreate.setRGB(i, j, finalPixelColor.getRGB());
//            }
//        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                System.out.println("Thread " + i + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Threaded Time = " + (System.currentTimeMillis() - currTime));
        System.out.println(imageFunction);
        m2v.displayImage(imageToCreate);
    }
}
