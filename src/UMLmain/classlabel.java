package UMLmain;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.List;

class classlabel extends originlabel implements MouseMotionListener {
    public classlabel(int x, int y) {
        super(x, y);
        setSize(120,120);
    }

    public void paint(Graphics g) {
        g.drawRect(10, 10, 100, 100);
        int portion = 100 / 3;
        g.drawLine(10, portion+10, 110, portion+10);
        g.drawLine(10, portion * 2+10, 110, portion * 2+10);
        int stringWidth = g.getFontMetrics().stringWidth(objectName);
        double empty = (120 - stringWidth)/2;
        g.drawString(objectName, (int)empty, 30);
        if (isselected == 1) {
            g.fillRect(55, 0, 10, 10);
            g.fillRect(55, 110, 10, 10);
            g.fillRect(110, 55, 10, 10);
            g.fillRect(0, 55, 10, 10);
        }
    }
    public void setgroupsize(int width, int height){}
    public void setselect(int s){};
    public void findobj(originlabel obj){}
    public void moving(List<originlabel> add){}
}
