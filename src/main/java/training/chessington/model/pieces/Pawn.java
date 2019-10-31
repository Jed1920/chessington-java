package training.chessington.model.pieces;

import com.sun.javafx.logging.jfr.JFRInputEvent;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

    public static final int START_POS_WHITE = 6;
    public static final int START_POSITION_BLACK = 1;
    public static final int ONE_STEP_WHITE = -1;
    public static final int ONE_STEP_BLACK = 1;


    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }


    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        if (colour == PlayerColour.WHITE) {
            if (from.getRow() == 0) {
                return allowedMoves;
            }
            if ((from.getRow() == START_POS_WHITE) && board.get(from.plus(-2, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(-2, 0)));
            }
            if (board.get(from.plus(ONE_STEP_WHITE, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(-1, 0)));
            }
            if (from.getCol() != 7 && board.get(from.plus(-1, 1)) != null) {
                if (board.get(from.plus(-1, 1)).getColour() == PlayerColour.BLACK) {
                    allowedMoves.add(new Move(from, from.plus(-1, 1)));
                }
            }
            if (from.getCol() != 0 && board.get(from.plus(-1, -1)) != null) {
                if (board.get(from.plus(-1, -1)).getColour() == PlayerColour.BLACK) {
                    allowedMoves.add(new Move(from, from.plus(-1, -1)));
                }
            }

        } else {
            if (from.getRow() == 7) {
                return allowedMoves;
            }
            if ((from.getRow() == START_POSITION_BLACK) && board.get(from.plus(2, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(2, 0)));
            }
            if (board.get(from.plus(ONE_STEP_BLACK, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(1, 0)));
            }
            if (from.getCol() != 7 && board.get(from.plus(1, 1)) != null) {
                if (board.get(from.plus(1, 1)).getColour() == PlayerColour.WHITE) {
                    allowedMoves.add(new Move(from, from.plus(1, 1)));
                }
            }
            if (from.getCol() != 0 && board.get(from.plus(1, -1)) != null) {
                if (board.get(from.plus(1, -1)).getColour() == PlayerColour.WHITE) {
                    allowedMoves.add(new Move(from, from.plus(1, -1)));
                }
            }
        }
        return allowedMoves;
    }

}
