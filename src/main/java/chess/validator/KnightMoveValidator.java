package chess.validator;

import chess.Board;
import chess.position.Position;

import java.util.Collections;
import java.util.List;

public class KnightMoveValidator extends MoveValidator {
    @Override
    protected boolean isNotPermittedMovement(Board board, Position source, Position target) {
        return source.isNotMultiplicationOfDifferenceBetweenFileAndRankIsTwo(target);
    }

    @Override
    protected List<Position> movePathExceptSourceAndTarget(Position source, Position target) {
        return Collections.emptyList();
    }

    @Override
    protected boolean isKingKilledIfMoves(Board board, Position source, Position target) {
        return board.isKingKilledIfMoves(source, target);
    }
}