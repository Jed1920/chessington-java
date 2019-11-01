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
                i = -from.getRow();
            }
        }
        for (int i = 1; i <= 7- from.getRow(); i++) {
            if (board.get(from.plus(i, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(i, 0)));
            } else {
                i = 7- from.getRow();
            }
        }
        for (int i = -1; i >= -from.getCol(); i--) {
            if (board.get(from.plus(0, i)) == null) {
                allowedMoves.add(new Move(from, from.plus(0, i)));
            } else {
                i = -from.getCol();
            }
        }
        for (int i = 1; i <= 7- from.getCol(); i++) {
            if (board.get(from.plus(0, i)) == null) {
                allowedMoves.add(new Move(from, from.plus(0, i)));
            } else {
                i = 7- from.getCol();
            }
        }

        return allowedMoves;
    }
}
