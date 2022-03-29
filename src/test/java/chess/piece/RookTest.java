package chess.piece;

import static org.assertj.core.api.Assertions.assertThat;

import chess.File;
import chess.Player;
import chess.Position;
import chess.Rank;
import chess.board.Board;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RookTest {

    @DisplayName("target 위치로 움직일 수 없으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"SEVEN,D", "ONE,D"})
    void canMove_false(Rank rank, File file) {
        Map<Position, Piece> board = new Board().getBoard();
        Piece rook = new Rook(Player.BLACK, "R");
        boolean actual = rook.canMove_2(Position.of(Rank.FOUR, File.D), Position.of(rank, file), board);

        assertThat(actual).isFalse();
    }

    @DisplayName("target 위치로 움직일 수 있으면 true를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"FOUR,H", "FOUR,A", "SIX,D", "TWO,D"})
    void canMove_true(Rank rank, File file) {
        Map<Position, Piece> board = new Board().getBoard();
        Piece rook = new Rook(Player.BLACK, "R");
        boolean actual = rook.canMove_2(Position.of(Rank.FOUR, File.D), Position.of(rank, file), board);

        assertThat(actual).isTrue();
    }
}
