package UMLmain;

import java.awt.*;

class compositionline extends originline {
    public compositionline(int x1,int x2,int y1,int y2){
        super(x1,x2,y1,y2);
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        if( x1 > x2 && y1 < y2){
            g.drawLine(Math.abs(x1-x2), 0, 0, Math.abs(y1-y2));
            g.fillRect(0, Math.abs((y1-y2))-10, 10, 10);
            //System.out.println("右上左下");
        }
        else if (x1 < x2 && y1 < y2){
            g.drawLine(0, 0,Math.abs(x1-x2) , Math.abs(y1-y2));
            g.fillRect(Math.abs(x1-x2)-10, Math.abs(y1-y2)-10, 10, 10);
            //System.out.println("左上右下");
        }
        else if(x1 < x2 && y1 >y2){
            g.drawLine(0, Math.abs(y1-y2), Math.abs(x1-x2),0 );
            g.fillRect(Math.abs(x1-x2)-10, 0, 10, 10);
            //System.out.println("左下右上");
        }
        else{
            g.drawLine(Math.abs(x1-x2) , Math.abs(y1-y2),0, 0);
            g.fillRect(0, 0, 10, 10);
            //System.out.println("右下左上");
        }
        //System.out.println(x1+" "+x2+" "+y1+" "+y2);
    }
}