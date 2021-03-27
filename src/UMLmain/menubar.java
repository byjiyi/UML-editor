package UMLmain;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class menubar extends JMenuBar {
    public menubar(canvas panel){
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenuItem item1 = new JMenuItem("Change object name");
        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String classname = JOptionPane.showInputDialog("Input object name");
                panel.selectedObj.objectName = classname;
                System.out.println(classname);
                panel.repaint();
            }
        });
        JMenuItem item2 = new JMenuItem("Group");
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                panel.grouping();
                panel.repaint();
            }
        });
        JMenuItem item3 = new JMenuItem("Ungroup");
        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                panel.ungrouping();
                panel.repaint();
            }
        });
        JMenuItem item4 = new JMenuItem("Save Image");
        item4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                BufferedImage im = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
                panel.paint(im.getGraphics());
                try {
                    ImageIO.write(im, "PNG", new File("shot.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JMenuItem item5 = new JMenuItem("Clear");
        item5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                panel.removeAll();
                panel.repaint();
            }
        });
        menu1.add(item4);menu1.add(item5);
        menu2.add(item1);menu2.add(item2);menu2.add(item3);
        add(menu1);
        add(menu2);
    }
}
