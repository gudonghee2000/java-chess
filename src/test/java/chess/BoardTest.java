package chess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.model.board.Board;
import chess.model.position.File;
import chess.model.position.Position;
import chess.model.position.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @DisplayName("8x8의 보드판이 생성되는지 확인한다.")
    @Test
    void construct_board() {
        Board board = Board.init();

        assertThat(board.getBoard().size()).isEqualTo(64);
    }

    @DisplayName("선택한 위치에 기물이 없으면 예외를 발생 시킨다.")
    @Test
    void move_none_exception() {
        Board board = Board.init();

        assertThatThrownBy(() -> board.move(Position.of(Rank.THREE, File.D), Position.of(Rank.FOUR, File.D)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 선택한 위치에 기물이 없습니다.");
    }

    @DisplayName("선택한 위치에 기물이 상대방 기물이면 예외를 발생 시킨다.")
    @Test
    void move_opposite_exception() {
        Board board = Board.init();

        assertThatThrownBy(() -> board.move(Position.of(Rank.SEVEN, File.D), Position.of(Rank.FIVE, File.D)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 상대편 기물은 움직일 수 없습니다.");
    }
}
