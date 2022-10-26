public class Players {
    String name;
    String colour;
    String pawn_shape;
    int cash;
    int board_position;

    public Players(String _name, String _colour, String _pawn_shape) {
        name = _name;
        colour = _colour;
        pawn_shape = _pawn_shape;
        cash = 0;
        board_position = 1;
    }
}
