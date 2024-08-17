# **Objects Identification:**

Just like real world, try to identify what can be the objects

1. **PlayingPiece** : Default are X,0 but we are allowing user to choose from more options
2. **Board** : n*n board
3. **Player** : Player with name and playing piece
4. **Game** : The game that will be played.

We create an enum PieceType with multiple options for player to choose from.
Then we create a PlayerPiece class which will set the PieceType it gets in constructor.
No we create subtantial piece i.e PieceX and PieceO which will extend PlayerPiece.

Now coming to board.Firstly board will have a size n*n. 
Secondly the board will have 2D matrix of PlayingPiece. Since each block will be either X or 0 so the type will be 
PlayingPiece. So Board and PlayingPiece will have has a r/s. Board has PlayingPieces.

Now coming to Player class. It will have name and PlayingPiece. PlayingPiece can be X or O or any one of his choice.
So Player class also has a piece. It is has a r/s. See image2

Now coming to Game class. Game will have List<Player>. Game has Players. It also required Board. So Game has Board.
See image3. For maintaining list of players we use Deque, as we need to remove from start whose turn it is and put it
at back


