package program.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Holds the main view for the program
 */
public class ProgramView extends JFrame {

    private IProgramView2ModelAdapter v2m;
    private JPanel pnlMain;
    private JPanel pnlControls;
    private JTextField txtWidth;
    private JTextField txtHeight;
    private JLabel lblDimensions;
    private JLabel lblX;
    private JButton btnCreateImage;
    private JLabel lblImage;

    public ProgramView(IProgramView2ModelAdapter v2m) {
        this.v2m = v2m;

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initGui();
    }

    /**
     * Perfroms all start up tasks associated with the view.
     */
    public void start() {

        this.add(pnlMain);

        this.setVisible(true);
        this.pack();
    }

    /**
     * Displays the completed image for the user to see
     *
     * @param image The image for the user to view
     */
    public void displayImage(BufferedImage image) {
        lblImage.setIcon(new ImageIcon(image.getScaledInstance((int)(image.getWidth() * .5), -1, Image.SCALE_SMOOTH)));

        this.pack();
    }

    /**
     * Performs all gui component initializations.
     */
    private void initGui() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(0, 0));
        pnlMain.setBackground(new Color(-3748656));
        pnlControls = new JPanel();
        pnlControls.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlMain.add(pnlControls, BorderLayout.SOUTH);
        lblDimensions = new JLabel();
        lblDimensions.setText("Dimensions:");
        pnlControls.add(lblDimensions);
        txtWidth = new JTextField();
        txtWidth.setToolTipText("Choose the width of your background");
        txtWidth.setColumns(10);
        pnlControls.add(txtWidth);
        lblX = new JLabel();
        lblX.setText("X");
        pnlControls.add(lblX);
        txtHeight = new JTextField();
        txtHeight.setToolTipText("Choose the height of your background");
        txtHeight.setColumns(10);
        pnlControls.add(txtHeight);
        btnCreateImage = new JButton();
        btnCreateImage.setText("Create");
        btnCreateImage.setToolTipText("Create a random image of the given size");
        btnCreateImage.addActionListener((e) -> v2m.createImage(Integer.parseInt(txtWidth.getText()),
                                                                Integer.parseInt(txtHeight.getText())));

        pnlControls.add(btnCreateImage);
        lblImage = new JLabel();
        lblImage.setText("");
        pnlMain.add(lblImage, BorderLayout.CENTER);
    }
}
