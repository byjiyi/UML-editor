package UMLmain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

abstract class originlabel extends JLabel implements MouseMotionListener {
    protected String objectName = "Object Name";
    protected int isselected = 0;
    int parentcounter = 0;
    public abstract void paint(Graphics g);
    public java.util.List<originline> lines_in_up = new ArrayList<originline>();
    public java.util.List<originline> lines_out_up = new ArrayList<originline>();
    public java.util.List<originline> lines_in_down = new ArrayList<originline>();
    public java.util.List<originline> lines_out_down = new ArrayList<originline>();
    public java.util.List<originline> lines_in_right = new ArrayList<originline>();
    public java.util.List<originline> lines_out_right = new ArrayList<originline>();
    public java.util.List<originline> lines_in_left = new ArrayList<originline>();
    public java.util.List<originline> lines_out_left = new ArrayList<originline>();
    public java.util.List<originlabel> groupobjs = new ArrayList<originlabel>();

    public originlabel(int x, int y) {
        setLocation(x-20, y-60);
        addMouseMotionListener(this);
    }

    public void changelocation(int changeX, int changeY){
        if (isselected == 1) {
            setLocation((int) (getLocation().getX() + changeX) - 10,
                    (int) (getLocation().getY() + changeY) - 10);
            for (int i = lines_in_up.size() - 1; i >= 0; i--) {
                originline linemove = lines_in_up.get(i);
                linemove.x2 = (int) (getLocation().getX() + changeX + 50);
                linemove.y2 = (int) (getLocation().getY() + changeY);
                linemove.setline();
            }
            for (int i = lines_out_up.size() - 1; i >= 0; i--) {
                originline linemove = lines_out_up.get(i);
                linemove.x1 = (int) (getLocation().getX() + changeX + 50);
                linemove.y1 = (int) (getLocation().getY() + changeY);
                linemove.setline();
            }
            for (int i = lines_in_down.size() - 1; i >= 0; i--) {
                originline linemove = lines_in_down.get(i);
                linemove.x2 = (int) (getLocation().getX() + changeX + 50);
                linemove.y2 = (int) (getLocation().getY() + changeY + getHeight()-20);
                linemove.setline();
            }
            for (int i = lines_out_down.size() - 1; i >= 0; i--) {
                originline linemove = lines_out_down.get(i);
                linemove.x1 = (int) (getLocation().getX() + changeX + 50);
                linemove.y1 = (int) (getLocation().getY() + changeY + getHeight()-20);
                linemove.setline();
            }
            for (int i = lines_in_right.size() - 1; i >= 0; i--) {
                originline linemove = lines_in_right.get(i);
                linemove.x2 = (int) (getLocation().getX() + changeX + 100);
                linemove.y2 = (int) (getLocation().getY() + changeY + (getHeight()-20)/2);
                linemove.setline();
            }
            for (int i = lines_out_right.size() - 1; i >= 0; i--) {
                originline linemove = lines_out_right.get(i);
                linemove.x1 = (int) (getLocation().getX() + changeX + 100);
                linemove.y1 = (int) (getLocation().getY() + changeY + (getHeight()-20)/2);
                linemove.setline();
            }
            for (int i = lines_in_left.size() - 1; i >= 0; i--) {
                originline linemove = lines_in_left.get(i);
                linemove.x2 = (int) (getLocation().getX() + changeX);
                linemove.y2 = (int) (getLocation().getY() + changeY + (getHeight()-20)/2);
                linemove.setline();
            }
            for (int i = lines_out_left.size() - 1; i >= 0; i--) {
                originline linemove = lines_out_left.get(i);
                linemove.x1 = (int) (getLocation().getX() + changeX);
                linemove.y1 = (int) (getLocation().getY() + changeY + (getHeight()-20)/2);
                linemove.setline();
            }

        }
    }

    public void mouseDragged(MouseEvent e) {
        // 改變自已的位置
        changelocation(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {}
    public abstract void setgroupsize(int width, int height);
    public abstract void setselect(int s);
    public abstract void findobj(originlabel obj);
    public abstract void moving(List<originlabel> add);
}
