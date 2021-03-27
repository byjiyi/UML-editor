package UMLmain;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.List;

class usecaselabel extends originlabel implements MouseMotionListener {
    public usecaselabel(int x, int y) {
        super(x, y);
        setSize(120,70);
    }

    public void paint(Graphics g) {
        g.drawOval(10, 10, 100, 50);
        int stringWidth = g.getFontMetrics().stringWidth(objectName);
        double empty = (120 - stringWidth)/2;
        g.drawString(objectName, (int)empty, 40);
        if (isselected ==1) {
            g.fillRect(55, 0, 10, 10);
            g.fillRect(55, 60, 10, 10);
            g.fillRect(110, 32, 10, 10);
            g.fillRect(0, 32, 10, 10);
        }
    }
    public void setgroupsize(int width, int height) {}
    public void setselect(int s){}
    public void findobj(originlabel obj){}
    public void moving(List<originlabel> add){}
}