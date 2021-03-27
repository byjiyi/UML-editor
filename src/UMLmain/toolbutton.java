package UMLmain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class toolbutton extends JButton {
    int selected;
    int btnmode ;
    public toolbutton(canvas panel, String image, int mode, sidebar sidebar){
        setBackground(Color.WHITE);
        ImageIcon selectIcon = new ImageIcon(ClassLoader.getSystemResource(image));
        setIcon(selectIcon);
        btnmode = mode;
        addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                panel.mode = mode;
                panel.setMode();
                selected = 1;
                setBackground(Color.BLACK);
                sidebar.refresh(btnmode);
            }
        });
    }
}
