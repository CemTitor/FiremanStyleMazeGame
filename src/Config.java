import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Config {
    public int height;
    public int width;
    int numberOfPeople;
    int numberOfObstacle;

    public Config() throws IOException {
        readConfig();
    }
    private void readConfig() throws IOException {
        FileReader fileReader1=new FileReader("var.cfg");
        BufferedReader oku1=new BufferedReader(fileReader1);
        String satir=oku1.readLine();

        height =Integer.parseInt(satir.split(" : ")[1]);
        //split -->stringi boşluklarına göre ayırır ve arraya çevirir [1]de arrayin 1.indexini alır
        satir=oku1.readLine();
        width=Integer.parseInt(satir.split(" : ")[1]);
        satir=oku1.readLine();
        numberOfPeople=Integer.parseInt(satir.split(" : ")[1]);
        satir=oku1.readLine();
        numberOfObstacle=Integer.parseInt(satir.split(" : ")[1]);
    }
}
