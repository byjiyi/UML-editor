package UMLmain;

import java.awt.event.MouseEvent;

public class selectmode extends Mode{
    public void mousePressed(MouseEvent e) {
        modepanel.recentgroup = null;


        for (int i = modepanel.objects.size() - 1; i >= 0; i--) {
            originlabel objreset = modepanel.objects.get(i);
            objreset.isselected = 0;
            objreset.setselect(0);
        }
        modepanel.selectedObj = null;
        modepanel.repaint();
        modepanel.groupstartx = e.getX();
        modepanel.groupstarty = e.getY();
        grouplabel group = new grouplabel(modepanel.groupstartx, modepanel.groupstarty);
        modepanel.recentgroup = group;

    }

    public void mouseReleased(MouseEvent e) {
            int groupwidth, groupheight;
            groupwidth = Math.abs(modepanel.groupstartx - e.getX());
            groupheight = Math.abs(modepanel.groupstarty - e.getY());
            modepanel.recentgroup.setgroupsize(groupwidth, groupheight);
            int groupendx,groupendy;
            groupendx = Math.max(modepanel.groupstartx, e.getX());
            groupendy = Math.max(modepanel.groupstarty, e.getY());
            modepanel.groupstartx = Math.min(modepanel.groupstartx, e.getX());
            modepanel.groupstarty = Math.min(modepanel.groupstarty, e.getY());
            for (int i = modepanel.objects.size() - 1; i >= 0; i--) {
                originlabel objgroup = modepanel.objects.get(i);
                if ((objgroup.getLocation().getX() > modepanel.groupstartx) && ((objgroup.getLocation().getX() + objgroup.getWidth()) < (groupendx))){
                    if ((objgroup.getLocation().getY() > modepanel.groupstarty) && ((objgroup.getLocation().getY() + objgroup.getHeight()) < (groupendy))){
                        modepanel.groupinglabel.add(objgroup);
                        objgroup.isselected = 1;
                        objgroup.setselect(1);
                    }
                }
            }
            modepanel.repaint();
    }
}
