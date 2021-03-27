package UMLmain;

import javax.swing.*;

abstract class originline extends JLabel {
    public int x1, y1, x2, y2;
    public originline(int x11,int x21,int y11,int y21){
        x1 = x11;
        x2 = x21;
        y1 = y11;
        y2 = y21;
        /*int x, y;
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        setSize(Math.abs(x1-x2),Math.abs(y1-y2));
        setLocation(x, y);*/
    }

    public void setline(){
        int x, y;
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        setSize(Math.abs(x1-x2),Math.abs(y1-y2));
        setLocation(x, y);
    }

}
