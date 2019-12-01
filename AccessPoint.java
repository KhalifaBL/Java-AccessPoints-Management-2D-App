

public class AccessPoint {
    int x , y; // les coordonnées
    int Rc ; // numéro du point d'accès
    
    AccessPoint( int x, int y, int Rc)
    { this.x=x; this.y=y; this.Rc=Rc ;}
    public int getX() {
        // TODO Auto-generated method stub
        return this.x;
    }

    public int getY() {
        // TODO Auto-generated method stub
        return this.y ;
    }
    public int getRc() {
        // TODO Auto-generated method stub
        return this.Rc;
    }
    public void setX(int x) {
        this.x=x ;

    }
    public void setY(int y) {
        this.y=y ;

    }
    public void setRc(int Rc) {
        this.Rc=Rc ;

    }


}