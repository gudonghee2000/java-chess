package chess.model.command;

import chess.model.board.Board;
import chess.model.state.Finished;
import chess.model.state.State;

public class End implements Command {

    @Override
    public State executeTo(final Board board) {
        return new Finished(Board.of(board));
    }

    @Override
    public boolean isStart() {
        return false;
    }
}
