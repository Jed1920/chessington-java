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

        int x;
        int y = 0;
        List<Move> allowedMoves = new ArrayList<>();

        for (x = -1; x >= -from.getRow(); x--) {
            if (checkSquareEmpty(board,from,x,y)) {
                allowedMoves.add(new Move(from, from.plus(x, y)));
            } else {
                if (checkPieceOppositeColour(board,from,x,y)) {
                    allowedMoves.add(new Move(from, from.plus(x, y)));
                    break;
                }
                break;
            }
        }

        for (x = 1; x <= 7 - from.getRow(); x++) {
            if (checkSquareEmpty(board,from,x,y)) {
                allowedMoves.add(new Move(from, from.plus(x, y)));
            } else {
                if (checkPieceOppositeColour(board,from,x,y))  {
                    allowedMoves.add(new Move(from, from.plus(x, y)));
                    break;
                }
                break;
            }
        }

        x = 0;
        for (y = -1; y >= -from.getCol(); y--) {
            if (checkSquareEmpty(board,from,x,y)) {
                allowedMoves.add(new Move(from, from.plus(x, y)));
            } else {
                if (checkPieceOppositeColour(board,from,x,y))  {
                    allowedMoves.add(new Move(from, from.plus(x, y)));
                    break;
                }
                break;
            }
        }

        for (y = 1; y <= 7 - from.getCol(); y++) {
            if (checkSquareEmpty(board,from,x,y)) {
                allowedMoves.add(new Move(from, from.plus(x, y)));
            } else {
                if (checkPieceOppositeColour(board,from,x,y)) {
                    allowedMoves.add(new Move(from, from.plus(x, y)));
                    break;
                }
                break;
            }
        }

        return allowedMoves;
    }

    private boolean checkSquareEmpty(Board board, Coordinates from, int x, int y){
        return (board.get(from.plus(x, y)) == null);
    }

    private boolean checkPieceOppositeColour(Board board, Coordinates from, int x, int y){
        return (board.get(from.plus(x, y)).getColour() != colour);
    }

}

