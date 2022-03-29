package chess.model.state;

import chess.model.board.Board;
import chess.model.Team;

import java.util.Map;

public class End extends Finished {

    protected End(Board board) {
        super(board);
    }

    @Override
    public State proceed(String command) {
        if (command.equals("status")) {
            return new Status(board);
        }
        throw new IllegalArgumentException("[ERROR] 올바른 명령을 입력해주세요.");
    }

    @Override
    public boolean isStatus() {
        return false;
    }

    @Override
    public Map<Team, Double> calculateScore() {
        throw new RuntimeException("[ERROR] 점수를 계산 할 수 없습니다.");
    }
}
