import java.util.Random;

public class AIPlayer extends Player{
    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {

        // AI making winning move on board
        for (int col = 1; col < board.getNumCols() + 1; col++) {
            if (board.validMove(col)) {
                // add move and check if it contains win
                board.addMove(col,symbol);

                if (board.containsWin()) {
                    return;
                }
                else {
                    board.undoMove(col);
                }
            }
        }

        // AI blocking opponents winning move

        // get opponent's symbol
        char oppSymbol = board.oppSymbol(symbol);

        if (oppSymbol != ' ') {
            for (int col = 1; col < board.getNumCols() + 1; col++) {
                if (board.validMove(col)) {
                    // add move and check if it contains win
                    board.addMove(col,oppSymbol);

                    if (board.containsWin()) {
                        //remove oppSymbol and add current AI symbol to block opponent win possibility
                        board.undoMove(col);
                        board.addMove(col,symbol);
                        return;
                    }
                    else {
                        board.undoMove(col);
                    }
                }
            }
        }

        // IF AI cannot make a winning move or a blocking move, add a random move
        Random rand = new Random();
        int input = rand.nextInt(1,8);
        while (!board.validMove(input)) {
            input = rand.nextInt(1,8);
        }
        board.addMove(input, symbol);
    }
}
