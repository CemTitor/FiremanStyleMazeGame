public class Tile {
    Config config1;
    private Position position;
    private boolean obstacle;
    private boolean player;
    private boolean finish;
    private Player[] currentPlayers;
    private Obstacle[] currentObstacles;


    public Tile(Position position, boolean isObstacle, boolean isPlayer, Config config1) {
        this.position = position;
        this.obstacle = isObstacle;
        this.player = isPlayer;
        this.config1 = config1;
        currentPlayers = new Player[config1.numberOfPeople];
        currentObstacles = new Obstacle[config1.numberOfObstacle];
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Obstacle[] getCurrentObstacles() {
        return currentObstacles;
    }

    public void setCurrentObstacles(Obstacle[] currentObstacles) {
        this.currentObstacles = currentObstacles;

    }

    public Player[] getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(Player[] currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public void addPlayer(Player player, Player[] currentPlayers) {
        for (int i = 0; i < currentPlayers.length; i++) {
            player = currentPlayers[i];
        }
    }
    public void clear() {
        currentPlayers = new Player[config1.numberOfPeople];
        player= false;
    }
//    public boolean encounter(){
//        for(int i=0;i<currentPlayers.length;i++){
//            for(int j=1;j<currentPlayers.length;j++){
//                if(currentPlayers[i].getPosition().getI()==currentPlayers[j].getPosition().getI() && currentPlayers[i].getPosition().getJ()==currentPlayers[j].getPosition().getJ() ){
//                    return true;
//                }
//            }
//        }return false;
//    }
}






