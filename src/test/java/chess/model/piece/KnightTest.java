package chess.model.piece;

import static chess.model.position.File.A;
import static chess.model.position.File.B;
import static chess.model.position.File.C;
import static chess.model.position.File.D;
import static chess.model.Team.BLACK;
import static chess.model.position.Rank.FIVE;
import static chess.model.position.Rank.FOUR;
import static chess.model.position.Rank.SEVEN;
import static chess.model.position.Rank.SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import chess.model.position.File;
import chess.model.position.Position;
import chess.model.position.Rank;
import chess.model.direction.route.Route;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnightTest {

    @DisplayName("target 값이 이동법위를 벗어나면 예외를 발생한다.")
    @ParameterizedTest()
    @CsvSource(value = {"SIX,A", "SEVEN,E"})
    void findRoute_exception(Rank rank, File file) {
        Piece knight = new Knight(BLACK, "N");
        assertThatThrownBy(() -> knight.findRoute(Position.of(FIVE, B), Position.of(rank, file)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 현재 기물을 이동 할 수 없는 위치가 입력됬습니다.");
    }

    @DisplayName("SSE 위치로 움직일 수 있으면 SSE 방향의 Route를 반환한다.")
    @Test
    void findRoute_sse() {
        Piece knight = new Knight(BLACK, "N");
        Route route = knight.findRoute(Position.of(FIVE, B), Position.of(SEVEN, C));

        assertThat(route).isEqualTo(new Route(-2, 1));
    }


    @DisplayName("SSW 위치로 움직일 수 있으면 SSW 방향의 Route를 반환한다.")
    @Test
    void findRoute_ssw() {
        Piece knight = new Knight(BLACK, "N");
        Route route = knight.findRoute(Position.of(FIVE, B), Position.of(SEVEN, A));

        assertThat(route).isEqualTo(new Route(-2, -1));
    }


    @DisplayName("EES 위치로 움직일 수 있으면 EES 방향의 Route를 반환한다.")
    @Test
    void findRoute_ees() {
        Piece knight = new Knight(BLACK, "N");
        Route route = knight.findRoute(Position.of(FIVE, B), Position.of(FOUR, D));

        assertThat(route).isEqualTo(new Route(1, 2));
    }


    @DisplayName("EEN 위치로 움직일 수 있으면 EEN 방향의 Route를 반환한다.")
    @Test
    void findRoute_een() {
        Piece knight = new Knight(BLACK, "N");
        Route route = knight.findRoute(Position.of(FIVE, B), Position.of(SIX, D));

        assertThat(route).isEqualTo(new Route(-1, 2));
    }
}