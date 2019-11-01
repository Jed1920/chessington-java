package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class RookTest {

    @Test
    public void rookCanMoveUp() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-5, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(-6, 0)));
    }

    @Test
    public void rookCanMoveDown() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 0)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 0)));
    }

    @Test
    public void whiteRookCannotMoveOverWhitePiece() {
        Board board = Board.empty();

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteRookCoords = new Coordinates(7, 4);
        board.placePiece(whiteRookCoords,whiteRook);

        Piece whitePawn = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords = new Coordinates(4, 4);
        board.placePiece(whitePawnCoords, whitePawn);

        // Act
        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);

        // Assert
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(-5, 0)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(-6, 0)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(-7, 0)));
    }

}
