import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static final int CONTINUE = 0;
    public static final int DRAW = 1;
    public static final int PLAYER_WIN = 2;
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE = "\033[0;35m";  // PURPLE

    public static int turnNumber;
    public static int gameStatus;
public static Position position;
    public static Terrain terrain;

    public static int height;
    public static int width;

    public Main() {
    }

    public static void main(String args[]) throws IOException {
//        File file1 = null;
//        FileWriter fileWr1;
//        BufferedWriter bufferedWr1 = null;
//
//        file1 = new File("output_.txt");
//        fileWr1 = new FileWriter(file1, false);
//        bufferedWr1 = new BufferedWriter(fileWr1);



        Config config = new Config();
        turnNumber = 0;
        gameStatus = CONTINUE;
        Scanner sc1 = new Scanner(System.in);


        terrain = new Terrain(config);
        if (!terrain.createMap()) {
            System.out.println("Config file is incorrect. Playground could not be created.");
        }

        height = config.height;
        width = config.width;
        //haritayı oluşturma
        System.out.println("1) Press 1 if you want to end the game immediately");
        System.out.println("2) If you want to continue the game step by step, press any number except 1.");
        if (sc1.nextInt() == 1) {

            while (!terrain.gameOver()) {


//            file1=new File("output_"+turnNumber+".txt");
//            fileWr1 = new FileWriter(file1,false);
//            bufferedWr1 = new BufferedWriter(fileWr1);
                File file = new File("output_" + turnNumber + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, false);
                BufferedWriter bufferedWr1 = new BufferedWriter(fileWriter);

                System.out.println(("Turn number: " + ++turnNumber));
                bufferedWr1.write("Turn number: " + turnNumber+"\n");
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if ((terrain.getMap()[i][j]).isObstacle()) {
                            System.out.print(YELLOW + " + " + RESET);
                            bufferedWr1.write(" + ");
                        } else if ((terrain.getMap()[i][j]).isPlayer()) {
                                System.out.print(RED + " P " + RESET);
                                bufferedWr1.write(" P ");

                        } else if (terrain.getMap()[i][j].isFinish()) {
                            System.out.print(BLUE_BOLD + " F " + RESET);
                            bufferedWr1.write(" F ");
                        } else {
                            System.out.print(" 0 ");
                            bufferedWr1.write(" 0 ");
                        }
                    }
                    System.out.println();
                    bufferedWr1.newLine();
                }
                bufferedWr1.newLine();
                bufferedWr1.close();
                terrain.performMove();
            }

        } else {
            while (!terrain.gameOver()) {
                System.out.println("Press any number for next turn");
                sc1.nextInt();

//            file1=new File("output_"+turnNumber+".txt");
//            fileWr1 = new FileWriter(file1,false);
//            bufferedWr1 = new BufferedWriter(fileWr1);
                    File file = new File("output_" + turnNumber + ".txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, false);
                    BufferedWriter bufferedWr1 = new BufferedWriter(fileWriter);

                    System.out.println(("Turn number: " + ++turnNumber));
                    bufferedWr1.write("Turn number: " + turnNumber+ "\n");
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if ((terrain.getMap()[i][j]).isObstacle()) {
                                System.out.print(YELLOW + " + " + RESET);
                                bufferedWr1.write(" + ");
                            } else if ((terrain.getMap()[i][j]).isPlayer()) {
                                    System.out.print(RED + " P " + RESET);
                                    bufferedWr1.write(" P ");

                            } else if (terrain.getMap()[i][j].isFinish()) {
                                System.out.print(BLUE_BOLD + " F " + RESET);
                                bufferedWr1.write(" F ");
                            } else {
                                System.out.print(" 0 ");
                                bufferedWr1.write(" 0 ");
                            }
                        }
                        System.out.println();
                        bufferedWr1.newLine();
                    }
                    bufferedWr1.newLine();
                    bufferedWr1.close();
                    terrain.performMove();

            }

        }
    }





    public static Position createPosition(int maxHeight, int maxWidth, Obstacle[] obstacles) {
        Random random1 = new Random();
        int height, width;
        height = random1.nextInt(maxHeight-1);
        width = random1.nextInt(maxWidth-1);
        while (ObstacleTile(height, width, obstacles)) {
            //
            height = random1.nextInt(maxHeight-1);
            width = random1.nextInt(maxWidth-1);
        }

        return new Position(height, width);

    }

    // o pozisyonda obstacle varsa true
    public static boolean ObstacleTile(int height, int width, Obstacle[] obstacles) {
        boolean notEmpty = false;
        for (int i = 0; i < obstacles.length; i++) {
            if (height == obstacles[i].getPosition().getI() && width == obstacles[i].getPosition().getJ()) {
                //pozisyonda obstacle varsa if e girer
                notEmpty = true;
                break;
            }
        }
        return notEmpty;
    }


}
