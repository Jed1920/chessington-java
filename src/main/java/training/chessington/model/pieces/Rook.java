package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();
        for (int i = -1; i >= -from.getRow(); i--) {
            if (board.get(from.plus(i, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(i, 0)));
            } else {
                return allowedMoves;
            }
        }
        for (int i = 1; i <= 7- from.getRow(); i++) {
            if (board.get(from.plus(i, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(i, 0)));
            } else {
                return allowedMoves;
            }
        }
        return allowedMoves;
    }
}
