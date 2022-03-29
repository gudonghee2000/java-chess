package chess.piece;

import chess.Player;
import chess.Position;
import chess.direction.route.Route;
import chess.direction.strategy.RoyaltyRouteFinder;
import chess.direction.strategy.RouteStrategy;

public class King extends Piece {

    private static final double SCORE = 0;

    private final RouteStrategy routeStrategy;

    public King(Player player, String symbol) {
        super(player, symbol);
        this.routeStrategy = new RoyaltyRouteFinder();
    }

    public Route findRoute(Position source, Position target) {
        return routeStrategy.findRoute(source, target);
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public double addTo(double score) {
        return score + SCORE;
    }
}
