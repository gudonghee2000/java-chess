package chess.model.command;

import chess.model.board.Board;
import chess.model.position.Position;
import chess.model.state.Finished;
import chess.model.state.Running;
import chess.model.state.State;
import java.util.List;

public class Move implements Command {

    private final Position source;
    private final Position target;

    public Move(final String command) {
        final List<String> options = List.of(command.split(" "));
        checkOptionsForm(options);
        this.source = createPosition(options.get(1));
        this.target = createPosition(options.get(2));
    }

    private void checkOptionsForm(final List<String> options) {
        if (options.size() != 3) {
            throw new IllegalArgumentException("[ERROR] `move b2 b3` 양식에 맞게 입력 해주세요.");
        }
    }

    private Position createPosition(final String option) {
        return Position.from(option);
    }

    @Override
    public State executeTo(final Board board) {
        final Board movedBoard = board.move(source, target);
        if (board.isKingDead()) {
            return new Finished(Board.of(movedBoard));
        }
        return new Running(Board.of(movedBoard));
    }

    @Override
    public boolean isStart() {
        return false;
    }
}
