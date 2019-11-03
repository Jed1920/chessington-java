package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        int x;
        List<Move> allowedMoves = new ArrayList<>();
        // top left
        for (x = 1; x <= 8; x++) {
            if (board.squareIsOnBoard(from.plus(-x, -x))) {
                if (checkSquareEmpty(board, from, -x, -x)) {
                    allowedMoves.add(new Move(from, from.plus(-x, -x)));
                } else {
                    if (checkPieceOppositeColour(board, from, -x, -x)) {
                        allowedMoves.add(new Move(from, from.plus(-x, -x)));
                        break;
                    }
                    break;
                }
            } else {
                break;
            }
        }
        //bottom right
        for (x = 1; x <= 8; x++) {
            if (board.squareIsOnBoard(from.plus(x, x))) {
                if (checkSquareEmpty(board, from, x, x)) {
                    allowedMoves.add(new Move(from, from.plus(x, x)));
                } else {
                    if (checkPieceOppositeColour(board, from, x, x)) {
                        allowedMoves.add(new Move(from, from.plus(x, x)));
                        break;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        for (x = 1; x <= 8; x++) {
            if (board.squareIsOnBoard(from.plus(x, -x))) {
                if (checkSquareEmpty(board, from, x, -x)) {
                    allowedMoves.add(new Move(from, from.plus(x, -x)));
                } else {
                    if (checkPieceOppositeColour(board, from, x, -x)) {
                        allowedMoves.add(new Move(from, from.plus(x, -x)));
                        break;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        for (x = 1; x <= 8; x++) {
            if (board.squareIsOnBoard(from.plus(-x, x))) {
                if (checkSquareEmpty(board, from, -x, x)) {
                    allowedMoves.add(new Move(from, from.plus(-x, x)));
                } else {
                    if (checkPieceOppositeColour(board, from, -x, x)) {
                        allowedMoves.add(new Move(from, from.plus(-x, x)));
                        break;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        return allowedMoves;
    }

    private boolean checkSquareEmpty(Board board, Coordinates from, int x, int y) {
        return (board.get(from.plus(x, y)) == null);
    }

    private boolean checkPieceOppositeColour(Board board, Coordinates from, int x, int y) {
        return (board.get(from.plus(x, y)).getColour() != colour);
    }
}
