# FiremanStyleMazeGame
Game in which players try to reach the endpoint


Reading all variables from config file, called ”var.cfg”.
Recording the status of the terrain for each turn so that it can show the whole game step by step. 

If you press 1, it comes to the end of the game
If you press a number other than 1, it goes step by step

The Rules of the Game
1. All players can move one step at a turn.
2. All movements must be in random direction (north, south, east or west).
3. Any obstacles are not permitted to move.
4. If a player moves to the obstacle, it remains inactive in its place for the same turn.
5. All players and obstacles occupy one tile space.
6. There can be any number of players in one tile. There must be only one obstacle in any tile.
7. If any player reaches to the finish point, the game is over and the player wins.

• P - refers to player
• + - refers to obstacle
• 0 - refers to free space
• F - refers to finish point
