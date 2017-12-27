package program.controller;

import program.model.IProgramModel2ViewAdapter;
import program.model.ProgramModel;
import program.view.IProgramView2ModelAdapter;
import program.view.ProgramView;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Handles all communication between the model and the view.
 */
public class ProgramController {

    private ProgramModel model;
    private ProgramView view;

    public static void main (String[] args) {
        EventQueue.invokeLater(() ->
            new ProgramController().start()
        );
    }

    public ProgramController() {
        model = new ProgramModel(new IProgramModel2ViewAdapter() {
            @Override
            public void displayImage(BufferedImage createdImage) {
                view.displayImage(createdImage);
                System.out.println("Here");
            }
        });

        view = new ProgramView(new IProgramView2ModelAdapter() {

            @Override
            public void createImage(int width, int height) {
                model.createRandomImage(width, height);
            }
        });
    }

    private void start() {
        model.start();
        view.start();
    }
}
