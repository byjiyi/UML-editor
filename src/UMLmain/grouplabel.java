package UMLmain;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.List;

class grouplabel extends originlabel implements MouseMotionListener {
    public int groupwidth, groupheight = 0;
    public grouplabel(int x, int y) {
        super(x, y);
    }
    public void setgroupsize(int width, int height){
        groupwidth = width;
        groupheight = height;
    }
    public void paint(Graphics g) {}
    public void setselect(int s){
        for (int i = groupobjs.size() - 1; i >= 0; i--) {
            groupobjs.get(i).isselected = s;
            groupobjs.get(i).setselect(s);
        }
    }

    public void findobj(originlabel obj){
        for (int i = groupobjs.size() - 1; i >= 0; i--) {
            if(groupobjs.get(i).isselected == 1){
                isselected = 1;
                setselect(1);
            }
            groupobjs.get(i).findobj(obj);
        }
    }
    public void moving(List<originlabel> add){
        add.add(this);
        for (int i = groupobjs.size() - 1; i >= 0; i--) {
            if(groupobjs.get(i).isselected == 1){
                add.add(groupobjs.get(i));
            }
            groupobjs.get(i).moving(add);
        }
    }
}