package chess.model.piece;

import chess.model.Team;
import chess.model.direction.Direction;
import chess.model.direction.strategy.MoveStrategy;
import chess.model.direction.strategy.SingleMove;
import chess.model.position.Position;
import java.util.List;
import java.util.Map;

public class Knight extends Piece {

    private static final double SCORE = 2.5;

    private final MoveStrategy moveStrategy;

    public Knight(final Team team) {
        super(team);
        this.moveStrategy = new SingleMove(team, Direction.knightDirection());
    }

    @Override
    public boolean canMove(Position source, Position target, Map<Position, Piece> board) {
        List<Position> positions = moveStrategy.searchMovablePositions(source, board);
        return positions.contains(target);
    }

    @Override
    public double addTo(final double score) {
        return score + SCORE;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
