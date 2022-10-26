import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Board board = new Board();
    int nop; // Number Of Players ..
    int nor; // Number of Rounds ..
    Players[] players;

    String[] pawn_shapes = {"battleship", "top hat", "penguin", "cat", "sack of money", "iron", "train", "cannon"}; // 8
    Integer[] taken_shapes = {0, 0, 0, 0, 0, 0, 0, 0};
    int hm_pawns = 8;

    String[] colours = {"blue", "red", "green", "yellow", "purple", "black", "white", "pink"}; // 8
    Integer[] taken_colours = {0, 0, 0, 0, 0, 0, 0, 0};
    int hm_colours = 8;

    public Game(String[] args) {
        nop = Integer.parseInt(args[0]);
        nor = Integer.parseInt(args[1]);
        players = new Players[nop];

        System.out.println("Player' Selection! \n");
        for (int i=0; i<nop; i++) {

            System.out.print("Player " + i + " name: ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();

            int choice = 0;
            String colour = null;

            while (choice == 0) {
                System.out.print("Choose your colour from the list (");
                for (int j=0; j<hm_colours; j++)
                    if (taken_colours[j] == 0)
                        System.out.print(colours[j] + ", ");
                System.out.print("): ");
                colour = in.nextLine().toLowerCase();

                if (Arrays.asList(colours).contains(colour) && taken_colours[Arrays.asList(colours).indexOf(colour)]==0) {
                    choice = 1;
                    taken_colours[Arrays.asList(colours).indexOf(colour)] = 1;
                }
                else {
                    System.out.println("This colour is not available or non-existent");
                }
            }



            String pawn_shape = null;
            choice = 0;

            while (choice == 0) {
                System.out.print("Choose your shape from the list (");
                for (int j=0; j<hm_pawns; j++)
                    if (taken_shapes[j] == 0)
                        System.out.print(pawn_shapes[j] + ", ");

                System.out.print("): ");
                pawn_shape = in.nextLine().toLowerCase();

                if (Arrays.asList(pawn_shapes).contains(pawn_shape) && taken_shapes[Arrays.asList(pawn_shapes).indexOf(pawn_shape)]==0) {
                    choice = 1;
                    taken_shapes[Arrays.asList(pawn_shapes).indexOf(pawn_shape)] = 1;
                }
                else {
                    System.out.println("This shape is not available or non-existent");
                }
            }
            players[i] = new Players(name, colour, pawn_shape);
        }

        // TESTING THAT PLAYERS ARE ADDED CORRECTLY
        // for (int i=0; i<nop; i++)
        //     System.out.println(players[i].name + ", " + players[i].colour + ", " + players[i].pawn_shape + ", $" + players[i].cash);
    }

    public void play() {
        System.out.println();
        for (int round = 0; round < nor; round++) {
            for (int player = 0; player < nop; player++) {
                int dice = board.throwDice();
                players[player].board_position+=dice;
                if (players[player].board_position>40) {
                    players[player].cash+=200;
                    players[player].board_position-=40;
                    System.out.println(players[player].name + " moved to position " + players[player].board_position + " after rolling a " + dice + " and won 200$ for passing through the Start");
                } else {
                    System.out.println(players[player].name + " moved to position " + players[player].board_position + " after rolling a " + dice);
                }
            }
        }

        int winner = 0;
        for (int i=1; i<nop; i++) {
            if (players[winner].cash < players[i].cash) {
                winner = i;
            } else if (players[winner].cash == players[i].cash) {
                if (players[winner].board_position < players[i].board_position) {
                    winner = i;
                }
            }
        }

        int laps = players[winner].cash/200;
        System.out.println("\n"+ players[winner].name + " has won the game with $" + players[winner].cash + " and on position " + players[winner].board_position + " after " + laps + " laps.");
        System.out.println("Other players results: ");
        for (int i=0; i<nop; i++) {
            if (i!=winner) {
                laps = players[i].cash/200;
                System.out.println(players[i].name + " has $" + players[i].cash + " and is on position " + players[i].board_position + " after " + laps + " laps.");
            }
        }
    }
}
