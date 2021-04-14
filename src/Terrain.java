import java.util.Random;

public class Terrain {

    Tile[][] map;
    Config config;
    Random random1;
    Player[] playerList;
    Obstacle[] obstacleList;
    Tile finishPoint;


    public Terrain(Config config){
        this.config=config;
        random1=new Random();
        playerList=new Player[config.numberOfPeople];
        obstacleList=new Obstacle[config.numberOfObstacle];
    }

    public Player[] getPlayerList(){
        return playerList;
    }

    public Tile[][] getMap() {
        return map;
    }

    public boolean createMap(){



        //creating map
        map =new Tile[config.height][config.width];
        for(int i=0;i<config.height;i++){
            for(int j=0;j<config.width;j++){
                map[i][j]= new Tile(new Position(i,j),false,false,this.config);
            }
        }


        //creating obstacles
        for(int i=0;i<config.numberOfObstacle;i++){
            int x=random1.nextInt(config.height-1);
            int y=random1.nextInt(config.width-1);
            if(!map[x][y].isObstacle()){
                //o pozisyonda obstacle yoksa yarat
                (map[x][y]).setObstacle(true);
                obstacleList[i]=new Obstacle(new Position(x,y));
            }else{
                i--;
            }
        }

        //creting players
        for(int i=0;i<config.numberOfPeople;i++){
            Position position=Main.createPosition(config.height-1,config.width-1,obstacleList);
            Player player=new Player(position);
            playerList[i]=player;
            (map[position.getI()][position.getJ()]).setPlayer(true);
           (map[position.getI()][position.getJ()]).addPlayer(player,playerList);
        }
        //creating finish point

        boolean  isEmpty=false;
        while(!isEmpty) {
            int finishX = random1.nextInt(config.height - 1);
            int finishY = random1.nextInt(config.width - 1);
            //boşşsa finishi oluştur
            if (!map[finishX][finishY].isObstacle() && !map[finishX][finishY].isPlayer()) {
                (map[finishX][finishY]).setFinish(true);
                finishPoint = new Tile(new Position(finishX, finishY), false, false, config);
                isEmpty =true;
            }
        }

        return true;
    }

    public void performMove(){
        for(int i=0;i<playerList.length;i++){
            Player player =playerList[i];
            player.move(config.height,config.width,obstacleList);
        }
        updateTile();
    }


    public boolean gameOver(){
        for(int i=0;i<getPlayerList().length;i++){
            if(playerList[i].getPosition().getI()==finishPoint.getPosition().getI() && playerList[i].getPosition().getJ()==finishPoint.getPosition().getJ()){
                System.out.println("Oyuncu finish noktasına ulaştı. Oyun Bitti");
                return true;
            }
        }
        return false;
    }
    public boolean encounter(){
        for(int i=0;i<playerList.length;i++){
            for(int j=1;j<playerList.length;j++){
                if(playerList[i].getPosition().getI()==playerList[j].getPosition().getI() && playerList[i].getPosition().getJ()==playerList[j].getPosition().getJ() ){
                    //eğer iki playerin pozisyonu aynıysa true
                    return true;
                }
            }
        }return false;
    }

    public void updateTile() {
        for (int k = 0; k < config.height; k++) {
            for (int l = 0; l < config.width; l++) {
                if ((map[k][l]).isFinish()) {
                    (map[k][l]).setFinish(true);
                }
                (map[k][l]).clear();
                for (int i = 0; i < obstacleList.length; i++) {
                    Obstacle obs = obstacleList[i];
                    if (obs.getPosition().equal(k, l)) {
                        (map[k][l]).setObstacle(true);
                        //hw3 için eklendi
                        System.out.println("("+map[k][l].getPosition().getI()+ " " +map[k][l].getPosition().getJ()+")");

                    }
                }
                if (!(map[k][l]).isObstacle()) {
                    for (int a = 0;a< playerList.length;a++) {
                        if (playerList[a].getPosition().equal(k, l)) {
                            (map[playerList[a].getPosition().getI()][playerList[a].getPosition().getJ()]).setPlayer(true);
                            (map[k][l]).getCurrentPlayers()[a]=playerList[a];
                            System.out.println("("+map[k][l].getPosition().getI()+ " " +map[k][l].getPosition().getJ()+")");

                        }
                    }
                }
            }
        }

    }
}
