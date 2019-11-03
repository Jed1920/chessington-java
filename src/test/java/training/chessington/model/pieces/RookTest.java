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
    public void rookCannotMoveOverPieceVertically() {
        Board board = Board.empty();

        Piece whiteRook = new Rook(PlayerColour.BLACK);
        Coordinates whiteRookCoords = new Coordinates(4, 4);
        board.placePiece(whiteRookCoords,whiteRook);

        Piece whitePawn1 = new Pawn(PlayerColour.BLACK);
        Coordinates whitePawnCoords1 = new Coordinates(6, 4);
        board.placePiece(whitePawnCoords1, whitePawn1);

        Piece whitePawn2 = new Pawn(PlayerColour.BLACK);
        Coordinates whitePawnCoords2 = new Coordinates(1, 4);
        board.placePiece(whitePawnCoords2, whitePawn2);

        // Act
        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);

        // Assert
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(3, 0)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(-4, 0)));
    }
    @Test
    public void rookCanMoveRight() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, 3)));
    }

    @Test
    public void rookCanMoveLeft() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(4, 3);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(0, -3)));
    }

    @Test
    public void rookCannotMoveOverPieceHorizontally() {
        Board board = Board.empty();

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteRookCoords = new Coordinates(4, 4);
        board.placePiece(whiteRookCoords,whiteRook);

        Piece whitePawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords1 = new Coordinates(4, 6);
        board.placePiece(whitePawnCoords1, whitePawn1);

        Piece whitePawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords2 = new Coordinates(4, 1);
        board.placePiece(whitePawnCoords2, whitePawn2);

        // Act
        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);

        // Assert
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, 3)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, -4)));
    }

    @Test
    public void whiteRookCanCaptureBlackPiece(){
        Board board = Board.empty();

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteRookCoords = new Coordinates(4, 4);
        board.placePiece(whiteRookCoords,whiteRook);

        Piece blackPawn = new Pawn(PlayerColour.BLACK);
        Coordinates blackPawnCoords = new Coordinates(4, 6);
        board.placePiece(blackPawnCoords, blackPawn);

        // Act
        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);

        // Assert
        assertThat(whiteRookMoves).contains(new Move(whiteRookCoords, whiteRookCoords.plus(0, 2)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, 3)));
    }

    @Test
    public void blackRookCanCaptureWhitePiece(){
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackRookCoords = new Coordinates(4, 4);
        board.placePiece(blackRookCoords,blackRook);

        Piece whitePawn = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords = new Coordinates(4, 6);
        board.placePiece(whitePawnCoords, whitePawn);

        // Act
        List<Move> blackRookMoves = blackRook.getAllowedMoves(blackRookCoords, board);

        // Assert
        assertThat(blackRookMoves).contains(new Move(blackRookCoords, blackRookCoords.plus(0, 2)));
        assertThat(blackRookMoves).doesNotContain(new Move(blackRookCoords, blackRookCoords.plus(0, 3)));
    }

}
