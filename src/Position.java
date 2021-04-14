public class Position {

private int i,j;

    public Position(int i,int j){
        this.i=i;
        this.j=j;
    }

    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }
    public void setI(int i){
        this.i=i;
    }
    public void setJ(int j){
        this.j=j;
    }
    public void increaseI(){
        this.i+=1;
    }
    public void increaseJ(){
        this.j+=1;
    }
    public void decreaseI(){
        this.i-=1;
    }
    public void decreaseJ(){
        this.j-=1;
    }
//pozisyon aynıysa true
    public boolean equal(int k, int l) {
        boolean isEqual = false;
        if (i == k && j == l) {
            isEqual = true;
        }
        return isEqual;
    }
 //kullanılmayabiilir
    public boolean equal(Position position) {
        boolean isEqual = false;
        if (i == position.getI() && j == position.getJ()) {
            isEqual = true;
        }
        return isEqual;
    }

}
