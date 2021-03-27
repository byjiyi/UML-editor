package UMLmain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class sidebar extends JToolBar {
    List<toolbutton> btn = new ArrayList<toolbutton>();
    public sidebar(canvas panel){
        toolbutton select = new toolbutton(panel, "UMLmain/image/select.png", 1, this);
        toolbutton association = new toolbutton(panel, "UMLmain/image/association.png", 2, this);
        toolbutton generalization = new toolbutton(panel, "UMLmain/image/generalization.png", 3, this);
        toolbutton composition = new toolbutton(panel, "UMLmain/image/composition.png", 4, this);
        toolbutton classes = new toolbutton(panel, "UMLmain/image/class.png", 5, this);
        toolbutton usecase = new toolbutton(panel, "UMLmain/image/usecase.png", 6, this);

        add(select);btn.add(select);
        add(association);btn.add(association);
        add(generalization);btn.add(generalization);
        add(composition);btn.add(composition);
        add(classes);btn.add(classes);
        add(usecase);btn.add(usecase);
    }

    public void refresh(int mode){
        mode = mode - 1;
        for (int i = 0; i < btn.size(); i++) {
            if(i != mode){
                btn.get(i).selected = 0;
                btn.get(i).setBackground(Color.WHITE);
            }
        }
    }
}
