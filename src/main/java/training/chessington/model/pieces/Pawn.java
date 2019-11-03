package training.chessington.model.pieces;

import com.sun.javafx.logging.jfr.JFRInputEvent;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        if (checkPieceEndBoard(from)) {

            if (checkPieceInFront(from, board)) {
                allowedMoves.add(new Move(from, from.plus(forward(1), 0)));
            }
            if (checkStartPosandPieceTwoInFront(from, board)) {
                allowedMoves.add(new Move(from, from.plus(forward(2), 0)));
            }
            if (diagonalTakeRight(from, board)) {
                allowedMoves.add(new Move(from, from.plus(forward(1), 1)));
            }
            if (diagonalTakeLeft(from, board)) {
                allowedMoves.add(new Move(from, from.plus(forward(1), -1)));
            }

        }
        return allowedMoves;
    }

    private Integer forward(int i) {
        if (colour == PlayerColour.WHITE) { i *= -1; }
        return i;
    }

    private Integer startPosition() {
        int start;
        if (colour == PlayerColour.WHITE) { start = 6; }
        else { start = 1; }
        return start;
    }
    private Integer endBoardPosition(){
        int end;
        if (colour == PlayerColour.WHITE) { end = 0; }
        else { end = 7; }
        return end;
    }

    private Boolean checkPieceEndBoard(Coordinates from) {
        return (from.getRow() != endBoardPosition());
    }

    private Boolean checkPieceInFront(Coordinates from, Board board) {
        return (board.get(from.plus(forward(1), 0)) == null);
    }

    private Boolean checkStartPosandPieceTwoInFront(Coordinates from, Board board) {
        return (from.getRow() == startPosition() && (board.get(from.plus(forward(2), 0)) == null));
    }

    private Boolean diagonalTakeRight(Coordinates from, Board board) {
        Coordinates square = from.plus(forward(1), 1);
        if (board.squareIsOnBoard(square) && board.get(square) != null) {
            return (board.get(square).getColour() != colour);
        }
        return false;
    }

    private Boolean diagonalTakeLeft(Coordinates from, Board board) {
        Coordinates square = from.plus(forward(1), -1);
        if (board.squareIsOnBoard(square) && board.get(square) != null) {
            return (board.get(square).getColour() != colour);
        }
        return false;
    }

}
