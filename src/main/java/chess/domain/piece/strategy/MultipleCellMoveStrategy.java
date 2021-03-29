package chess.domain.piece.strategy;

import chess.domain.piece.Piece;
import chess.domain.piece.Pieces;
import chess.domain.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static chess.domain.piece.Direction.*;

public abstract class MultipleCellMoveStrategy implements MoveStrategy {
    protected final List<Position> positions = new ArrayList<>();

    protected List<Position> makeUpRoutes(final Pieces basePieces, final Pieces targetPieces,
                                          final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        for (int index = position.getRankValue(); index < range; index++) {
            Position nextPosition = position.findNextPositionByRank(UP, index);
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeDownRoutes(final Pieces basePieces, final Pieces targetPieces,
                                            final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        for (int index = position.getRankValue(); index > range; index--) {
            Position nextPosition = position.findNextPositionByRank(DOWN, index);
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeLeftRoutes(final Pieces basePieces, final Pieces targetPieces,
                                            final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        for (int index = position.getFileValue(); index > range; index--) {
            Position nextPosition = position.findNextPositionByFile(LEFT, index);
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeLeftUpRoutes(final Pieces basePieces, final Pieces targetPieces,
                                              final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        int rank = position.getRankValue();
        int file = position.getFileValue();
        for (int index = rank; index < range; index++) {
            Position nextPosition = findNextPosition(index + LEFT_UP.getRow(),
                    file-- + LEFT_UP.getColumn());
            if (file < 1) {
                break;
            }
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeLeftDownRoutes(final Pieces basePieces, final Pieces targetPieces,
                                                final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        int rank = position.getRankValue();
        int file = position.getFileValue();
        for (int index = rank; index > range; index--) {
            Position nextPosition = findNextPosition(index + LEFT_DOWN.getRow(),
                    file-- + LEFT_DOWN.getColumn());
            if (file < 1) {
                break;
            }
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeRightRoutes(final Pieces basePieces, final Pieces targetPieces,
                                             final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        for (int index = position.getFileValue(); index < range; index++) {
            Position nextPosition = position.findNextPositionByFile(RIGHT, index);
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeRightUpRoutes(final Pieces basePieces, final Pieces targetPieces,
                                               final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        int rank = position.getRankValue();
        int file = position.getFileValue();
        for (int index = rank; index < range; index++) {
            Position nextPosition = findNextPosition(index + RIGHT_UP.getRow(),
                    file++ + RIGHT_UP.getColumn());
            if (file > 7) {
                break;
            }
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    protected List<Position> makeRightDownRoutes(final Pieces basePieces, final Pieces targetPieces,
                                                 final Position position, final int range) {
        List<Position> positions = new ArrayList<>();
        int rank = position.getRankValue();
        int file = position.getFileValue();
        for (int index = rank; index > range; index--) {
            Position nextPosition = findNextPosition(index + RIGHT_DOWN.getRow(),
                    file++ + RIGHT_DOWN.getColumn());
            if (file > 7) {
                break;
            }
            Optional<Piece> basePiece = findPiece(basePieces, nextPosition);
            Optional<Piece> targetPiece = findPiece(targetPieces, nextPosition);
            if (targetPiece.isPresent()) {
                positions.add(nextPosition);
                break;
            }
            if (!basePiece.isPresent()) {
                positions.add(nextPosition);
                continue;
            }
            break;
        }
        return positions;
    }

    abstract public List<Position> makeLinearRoutes(final Pieces basePieces, final Pieces targetPieces,
                                                    final Position position, final int range);

    abstract public List<Position> makeDiagonalRoutes(final Pieces basePieces, final Pieces targetPieces,
                                                      final Position position, final int range);
}