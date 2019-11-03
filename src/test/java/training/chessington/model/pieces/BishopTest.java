package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void bishopCanMoveDiagTopRight() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 3)));
    }
    @Test
    public void bishopCanMoveDiagTopLeft() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-4, -4)));
    }
    @Test
    public void bishopCanMoveDiagBotRight() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
    }
    @Test
    public void bishopCanMoveDiagBotLeft() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(4, -4)));
    }

    @Test
    public void rookCannotMoveOverPiece() {
        Board board = Board.empty();

        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates whiteBishopCoords = new Coordinates(4, 4);
        board.placePiece(whiteBishopCoords,whiteBishop);

        Piece whitePawn1 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords1 = new Coordinates(6, 6);
        board.placePiece(whitePawnCoords1, whitePawn1);

        Piece whitePawn2 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords2 = new Coordinates(6, 2);
        board.placePiece(whitePawnCoords2, whitePawn2);

        Piece whitePawn3 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords3 = new Coordinates(2, 2);
        board.placePiece(whitePawnCoords3, whitePawn3);

        Piece whitePawn4 = new Pawn(PlayerColour.WHITE);
        Coordinates whitePawnCoords4 = new Coordinates(2, 6);
        board.placePiece(whitePawnCoords4, whitePawn4);

        // Act
        List<Move> whiteRookMoves = whiteBishop.getAllowedMoves(whiteBishopCoords, board);

        // Assert
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteBishopCoords, whiteBishopCoords.plus(6, 6)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteBishopCoords, whiteBishopCoords.plus(6, 2)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteBishopCoords, whiteBishopCoords.plus(2, 2)));
        assertThat(whiteRookMoves).doesNotContain(new Move(whiteBishopCoords, whiteBishopCoords.plus(2, 6)));
    }

//
//    @Test
//    public void rookCannotMoveOverPieceHorizontally() {
//        Board board = Board.empty();
//
//        Piece whiteRook = new Rook(PlayerColour.WHITE);
//        Coordinates whiteRookCoords = new Coordinates(4, 4);
//        board.placePiece(whiteRookCoords,whiteRook);
//
//        Piece whitePawn1 = new Pawn(PlayerColour.WHITE);
//        Coordinates whitePawnCoords1 = new Coordinates(4, 6);
//        board.placePiece(whitePawnCoords1, whitePawn1);
//
//        Piece whitePawn2 = new Pawn(PlayerColour.WHITE);
//        Coordinates whitePawnCoords2 = new Coordinates(4, 1);
//        board.placePiece(whitePawnCoords2, whitePawn2);
//
//        // Act
//        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);
//
//        // Assert
//        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, 3)));
//        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, -4)));
//    }
//
//    @Test
//    public void whiteRookCanCaptureBlackPiece(){
//        Board board = Board.empty();
//
//        Piece whiteRook = new Rook(PlayerColour.WHITE);
//        Coordinates whiteRookCoords = new Coordinates(4, 4);
//        board.placePiece(whiteRookCoords,whiteRook);
//
//        Piece blackPawn = new Pawn(PlayerColour.BLACK);
//        Coordinates blackPawnCoords = new Coordinates(4, 6);
//        board.placePiece(blackPawnCoords, blackPawn);
//
//        // Act
//        List<Move> whiteRookMoves = whiteRook.getAllowedMoves(whiteRookCoords, board);
//
//        // Assert
//        assertThat(whiteRookMoves).contains(new Move(whiteRookCoords, whiteRookCoords.plus(0, 2)));
//        assertThat(whiteRookMoves).doesNotContain(new Move(whiteRookCoords, whiteRookCoords.plus(0, 3)));
//    }
//
//    @Test
//    public void blackRookCanCaptureWhitePiece(){
//        Board board = Board.empty();
//
//        Piece blackRook = new Rook(PlayerColour.BLACK);
//        Coordinates blackRookCoords = new Coordinates(4, 4);
//        board.placePiece(blackRookCoords,blackRook);
//
//        Piece whitePawn = new Pawn(PlayerColour.WHITE);
//        Coordinates whitePawnCoords = new Coordinates(4, 6);
//        board.placePiece(whitePawnCoords, whitePawn);
//
//        // Act
//        List<Move> blackRookMoves = blackRook.getAllowedMoves(blackRookCoords, board);
//
//        // Assert
//        assertThat(blackRookMoves).contains(new Move(blackRookCoords, blackRookCoords.plus(0, 2)));
//        assertThat(blackRookMoves).doesNotContain(new Move(blackRookCoords, blackRookCoords.plus(0, 3)));
//    }
}
