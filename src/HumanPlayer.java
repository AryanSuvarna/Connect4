import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        Scanner scan = new Scanner(System.in);

        // check if the input is valid to add to the list (column is not full)
        while(true) {
            System.out.print(name + ", please input your move: ");
            int input = scan.nextInt();

            if (board.validMove(input)) {
                board.addMove(input, symbol);
                break;
            }
            else {
                System.out.println("Invalid move! Try again");
            }
        }
    }
}
