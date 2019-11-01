package training.chessington.model.pieces;

import com.sun.javafx.logging.jfr.JFRInputEvent;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

    public static final int RIGHT_BOARD_EDGE = 7;
    public static final int LEFT_BOARD_EDGE = 0;

    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> allowedMoves = new ArrayList<>();

        if (checkPieceEndBoard(from, colour)) {

            if (checkPieceInFront(from, board, colour)) {
                allowedMoves.add(new Move(from, from.plus(forward(colour, 1), 0)));
            }
            if (checkPieceTwoInFront(from, board, colour)) {
                allowedMoves.add(new Move(from, from.plus(forward(colour, 2), 0)));
            }
            if (diagonalTakeRight(from, board, colour)) {
                allowedMoves.add(new Move(from, from.plus(forward(colour, 1), 1)));
            }
            if (diagonalTakeLeft(from, board, colour)) {
                allowedMoves.add(new Move(from, from.plus(forward(colour, 1), -1)));
            }

        }
        return allowedMoves;
    }

    private Integer forward(PlayerColour colour, int i) {
        if (colour == PlayerColour.WHITE) { i *= -1; }
        return i;
    }

    private Integer startPosition(PlayerColour colour) {
        int start;
        if (colour == PlayerColour.WHITE) { start = 6; }
        else { start = 1; }
        return start;
    }
    private Integer endBoardPosition(PlayerColour colour){
        int end;
        if (colour == PlayerColour.WHITE) { end = 0; }
        else { end = 7; }
        return end;
    }

    private Boolean checkPieceEndBoard(Coordinates from, PlayerColour colour) {
        return (from.getRow() != endBoardPosition(colour));
    }

    private Boolean checkPieceInFront(Coordinates from, Board board, PlayerColour colour) {
        return (board.get(from.plus(forward(colour, 1), 0)) == null);

    }

    private Boolean checkPieceTwoInFront(Coordinates from, Board board, PlayerColour colour) {
        return (from.getRow() == startPosition(colour) && (board.get(from.plus(forward(colour, 2), 0)) == null));
    }

    private Boolean diagonalTakeRight(Coordinates from, Board board, PlayerColour colour) {
        boolean b = false;
        if (from.getCol() != RIGHT_BOARD_EDGE && board.get(from.plus(forward(colour, 1), 1)) != null) {
            b = (board.get(from.plus(forward(colour, 1), 1)).getColour() != colour);
        }
        return b;
    }

    private Boolean diagonalTakeLeft(Coordinates from, Board board, PlayerColour colour) {
        boolean b = false;
        if (from.getCol() != LEFT_BOARD_EDGE && board.get(from.plus(forward(colour, 1), -1)) != null) {
            b = (board.get(from.plus(forward(colour, 1), -1)).getColour() != colour);
        }
        return b;
    }

}
