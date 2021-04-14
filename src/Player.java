import java.util.Random;

public class Player {
    private Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(int height, int width, Obstacle[] obstacles) {
        Random random1 = new Random();
        boolean empty = true;
        do {
            int path = random1.nextInt(4);
            if (path == 0) { //kuzey
                if (position.getI() != 0) { //en yukarıda değilse
                    if (!Main.ObstacleTile(position.getI() - 1, position.getJ(), obstacles)) {
                        // kuzey pozisyonuna gider eğer obstacle yoksa
                        position.decreaseI();
                    }
                    empty = false;
                }
            } else if (path == 1) { //güney
                if (position.getI() != height - 1) { //en aşağıda değilse
                    if (!Main.ObstacleTile(position.getI() + 1, position.getJ(), obstacles)) {
                        // obstacle yoksa güney pozisyonuna gider
                        position.increaseI();

                    }
                    empty = false;
                }
            }else if (path == 2) { //batı
                if (position.getJ() != width - 1) { //en sağda değilse
                    if (!Main.ObstacleTile(position.getI(), position.getJ() + 1, obstacles)) {
                        //obstacle yoksa doğu pozisyonna gider
                        position.increaseJ();
                    }
                }

                empty = false;
            } else if (path == 3) { //doğu
                if (position.getJ() != 0) { //en solda değilse
                    if (!Main.ObstacleTile(position.getI(), position.getJ() - 1, obstacles)) {
                        //obstacle yoksa batı pozisyonuna gider
                        position.decreaseJ();
                    }
                }
                empty = false;
            }
        } while (empty);
    }
}


