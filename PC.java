
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PC {
    private int x ;
    private int y ;
    private int numPA=0;
    public PC(int x, int y,int numPA){
        this.x = x ;
        this.y=y ;
        this.numPA = numPA ;
    }

    public int getnumPA(){
        return this.numPA ;
    }
    public void setnumPA(int x){
        this.numPA=x ;
    }
    public int getX(){
        return this.x ;
    }
    public int getY(){
        return this.y ;
    }
    public void setX(int x){ this.x = x ; }

    public void setY(int y){ this.y = y ; }

    public void DrawPC(Graphics2D g , int x , int y){
        // This will represent a PC as a square of a=30 and placed at the x,y passed as parameters for this function 
        Shape square = new Rectangle2D.Double(x,y,30,30) ;
        
        //The Double class defines a rectangle specified in double type coordinates.
        
        g.setPaint(Color.BLUE); //Choosing the color
        g.fill(square) ; } //  Fills the interior of a Shape using the settings of the Graphics2D context.


    public void ConnectPc(Graphics2D ga , int num){

        this.setnumPA(num) ;
    }
    public void DisconnectPC(Graphics2D ga){
        setnumPA(0) ;
    }


}



