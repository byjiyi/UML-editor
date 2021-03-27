package UMLmain;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class UMLeditor_main extends JFrame{
    canvas panel = new canvas();
    public UMLeditor_main() {

        menubar menubar = new menubar(panel);
        sidebar sidebar = new sidebar(panel);
        sidebar.setLayout(new GridLayout(6 , 1, 2, 2));
        sidebar.setBackground(new Color(215, 161, 165));

        getContentPane().setLayout(new BorderLayout());
        setJMenuBar(menubar);
        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().setBackground(Color.PINK);
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        UMLeditor_main mainWindow = new UMLeditor_main();
        mainWindow.setTitle("UML Editor");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1200, 700);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}