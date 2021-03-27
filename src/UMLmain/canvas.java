package UMLmain;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class canvas extends JPanel {
    public int mode;
    public originlabel selectedObj = null;
    public originlabel startobj, endobj = null;
    public List<originlabel> objects = new ArrayList<originlabel>();
    public originline l = null;
    int startx, starty, endx, endy = 0;
    int outport = 0; //上:1,下:2, 左:3 ,右:4
    int inport = 0; //上:1,下:2, 左:3 ,右:4
    int groupstartx, groupstarty = 0;
    public grouplabel recentgroup = null;
    public List<originlabel> groupinglabel = new ArrayList<originlabel>();
    public canvas(){
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if (mode == 5 || mode == 6) {
                    originlabel c1 = null;
                    if(mode == 5){
                        c1 = new classlabel(e.getX(),e.getY());
                    }
                    else if(mode == 6){
                        c1 = new usecaselabel(e.getX(),e.getY());
                    }
                    originlabel finalC = c1;
                    c1.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            if(selectedObj != null && selectedObj != finalC){
                                for (int i = objects.size() - 1; i >= 0; i--) {
                                    originlabel objreset = objects.get(i);
                                    objreset.isselected = 0;
                                    objreset.setselect(0);
                                }
                            }
                            selectedObj = finalC;
                            finalC.isselected = 1;
                            finalC.setselect(1);
                            int temp = 0;
                            for(int i = objects.size() - 1; i >= 0; i--){
                                objects.get(i).findobj(finalC);
                                temp = Math.max(temp,objects.get(i).parentcounter);
                            }
                            System.out.println("parent:"+temp);
                            while(temp > 0){
                                for(int i = objects.size() - 1; i >= 0; i--){
                                    objects.get(i).findobj(finalC);
                                }
                                temp--;
                            }
                            repaint();
                        }
                    });
                    originlabel finalC1 = c1;
                    c1.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {
                            if(mode == 2 || mode == 3 || mode == 4){
                                startx = (int) finalC1.getLocation().getX() + e.getX();
                                starty = (int) finalC1.getLocation().getY() + e.getY();
                                startobj = finalC1;
                                int centerx,centery;
                                centerx = finalC1.getWidth()/2;
                                centery = finalC1.getHeight()/2;
                                if(Math.abs((e.getY()-centery)/(e.getX()-centerx)) > 1 && e.getY() < centery){
                                    System.out.println("上");
                                    startx = (int) finalC1.getLocation().getX() + centerx;
                                    starty = (int) finalC1.getLocation().getY() + 10;
                                    outport = 1;
                                }
                                else if(Math.abs((e.getY()-centery)/(e.getX()-centerx)) > 1 && e.getY() > centery){
                                    System.out.println("下");
                                    startx = (int) finalC1.getLocation().getX() + centerx;
                                    starty = (int) finalC1.getLocation().getY() + centery*2 - 10;
                                    outport = 2;
                                }
                                else if(Math.abs((e.getY()-centery)/(e.getX()-centerx)) < 1 && e.getX() < centerx){
                                    System.out.println("左");
                                    startx = (int) finalC1.getLocation().getX() + 10;
                                    starty = (int) finalC1.getLocation().getY() + centery;
                                    outport = 3;
                                }
                                else if(Math.abs((e.getY()-centery)/(e.getX()-centerx)) < 1 && e.getX() > centerx){
                                    System.out.println("右");
                                    startx = (int) finalC1.getLocation().getX() + centerx*2 - 10;
                                    starty = (int) finalC1.getLocation().getY() + centery;
                                    outport = 4;
                                }
                                repaint();
                            }
                        }
                    });
                    originlabel finalC2 = c1;
                    c1.addMouseListener(new MouseAdapter() {
                        public void mouseReleased(MouseEvent e) {
                            if(mode == 2 || mode == 3 || mode == 4){
                                endx = (int) finalC2.getLocation().getX() + e.getX();
                                endy = (int) finalC2.getLocation().getY() + e.getY();

                                if (startobj != null){
                                    for (int i = objects.size() - 1; i >= 0; i--) {
                                        originlabel objfind = objects.get(i);
                                        if (startobj != objfind) {
                                            if (endx > objfind.getLocation().getX() && endx < (objfind.getLocation().getX() + objfind.getWidth())) {
                                                if (endy > objfind.getLocation().getY() && endy < (objfind.getLocation().getY() + objfind.getHeight())) {
                                                    int centerx, centery;
                                                    centerx = objfind.getWidth() / 2;
                                                    centery = objfind.getHeight() / 2;
                                                    int getendx, getendy = 0;
                                                    getendx = (int) (endx - objfind.getLocation().getX());
                                                    getendy = (int) (endy - objfind.getLocation().getY());
                                                    System.out.println(getendx + " " + getendy);
                                                    Boolean Slope = true;
                                                    if (Math.abs((getendy - centery) / (getendx - centerx)) > 1) {
                                                        Slope = true;
                                                    } else {
                                                        Slope = false;
                                                    }
                                                    if (Slope == true && getendy < centery) {
                                                        System.out.println("上");
                                                        endx = (int) objfind.getLocation().getX() + centerx;
                                                        endy = (int) objfind.getLocation().getY() + 10;
                                                        inport = 1;
                                                    } else if (Slope == true && getendy > centery) {
                                                        System.out.println("下");
                                                        endx = (int) objfind.getLocation().getX() + centerx;
                                                        endy = (int) objfind.getLocation().getY() + centery * 2 - 10;
                                                        inport = 2;
                                                    } else if (Slope != true && getendx < centerx) {
                                                        System.out.println("左");
                                                        endx = (int) objfind.getLocation().getX() + 10;
                                                        endy = (int) objfind.getLocation().getY() + centery;
                                                        inport = 3;
                                                    } else if (Slope != true && getendx > centerx) {
                                                        System.out.println("右");
                                                        endx = (int) objfind.getLocation().getX() + centerx * 2 - 10;
                                                        endy = (int) objfind.getLocation().getY() + centery;
                                                        inport = 4;
                                                    }
                                                    originline line = null;
                                                    if(mode == 2){
                                                        line = new associationline(startx, endx, starty, endy);
                                                    }
                                                    else if (mode == 3){
                                                        line = new generalizationline(startx, endx, starty, endy);
                                                    }
                                                    else if (mode == 4){
                                                        line = new compositionline(startx, endx, starty, endy);
                                                    }
                                                    line.setline();
                                                    repaint();
                                                    l = line;
                                                    add(l);
                                                    endobj = objfind;
                                                        if (inport == 1) {
                                                            endobj.lines_in_up.add(l);
                                                        } else if (inport == 2) {
                                                            endobj.lines_in_down.add(l);
                                                        } else if (inport == 3) {
                                                            endobj.lines_in_left.add(l);
                                                        } else if (inport == 4) {
                                                            endobj.lines_in_right.add(l);
                                                        }
                                                        if (outport == 1) {
                                                            startobj.lines_out_up.add(l);
                                                        } else if (outport == 2) {
                                                            startobj.lines_out_down.add(l);
                                                        } else if (outport == 3) {
                                                            startobj.lines_out_left.add(l);
                                                        } else if (outport == 4) {
                                                            startobj.lines_out_right.add(l);
                                                        }
                                                    repaint();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    });
                    originlabel finalC3 = c1;
                    c1.addMouseMotionListener(new MouseAdapter() {
                        public void mouseDragged(MouseEvent e) {
                            List<originlabel> move = new ArrayList<originlabel>();
                            for(int i = objects.size() - 1; i >= 0; i--){
                                objects.get(i).moving(move);
                            }
                            for(int i = move.size() - 1; i >= 0; i--){
                                if(move.get(i) != finalC3){
                                    move.get(i).changelocation(e.getX(),e.getY());
                                    repaint();
                                }
                            }
                        }});
                    objects.add(c1);
                    add(c1);
                    repaint();
                }
            }
        });
    }

    public void setMode(){
        if(mode == 1){
            addMouseMotionListener(new selectmode());
            addMouseListener(new selectmode());
            selectmode.modepanel = this;
        }
    }

    public void grouping(){
        int tempx1 = 0,tempy1 = 0, tempx2 = 0, tempy2 = 0, maxparent = 0;
        for (int i = 0; i < objects.size(); i++) {
            if(objects.get(i).isselected == 1){
                objects.get(i).isselected = 0;
                objects.get(i).setselect(0);
                objects.remove(i);
                i--;
            }
        }
        for (int i = groupinglabel.size() - 1; i >= 0; i--){
            originlabel temp = groupinglabel.get(i);
            recentgroup.groupobjs.add(temp);
            if(i == groupinglabel.size()-1){
                tempx1 = temp.getX();
                tempy1 = temp.getY();
                tempx2 = temp.getX() + temp.getWidth();
                tempy2 = temp.getY() + temp.getHeight();
            }
            else{
                tempx1 = Math.min(tempx1, temp.getX());
                tempy1 = Math.min(tempy1, temp.getY());
                tempx2 = Math.max(tempx2, temp.getX() + temp.getWidth());
                tempy2 = Math.max(tempy2, temp.getY() + temp.getHeight());
            }
            maxparent = Math.max(maxparent, temp.parentcounter);
        }
        recentgroup.setgroupsize((tempx2 - tempx1), (tempy2 - tempy1));
        recentgroup.setLocation(tempx1 , tempy1);
        recentgroup.parentcounter = maxparent + 1;
        objects.add(recentgroup);
        recentgroup = null;
        groupinglabel.clear();
    }
    public void ungrouping(){
        int ungrouptemp = 0;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).isselected == 1){
                ungrouptemp = Math.max(ungrouptemp, objects.get(i).parentcounter);
            }
        }
        int index = 0;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).parentcounter == ungrouptemp){
                index = i;
                break;
            }
        }
        for (int i = 0; i < objects.get(index).groupobjs.size(); i++) {
            objects.add(objects.get(index).groupobjs.get(i));
        }
        objects.remove(objects.get(index));
    }
}