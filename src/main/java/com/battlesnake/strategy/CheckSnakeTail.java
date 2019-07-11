package com.battlesnake.strategy;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class CheckSnakeTail implements BasicStrategy {

    @Override public List<Move> makeAMove(MoveRequest request, List<Move> moves) {
        Snake me = SnakeUtils.findSnakeByUUID(request.getYou(),request.getSnakes());

        List<Move> remainingMoves = new ArrayList<>();
        if(me != null) {
            int[][] coords = me.getCoords();
            int[] head = coords[0];
            int[] upCoords = SnakeUtils.getPossibleMoveCoord(head, Move.UP);
            int[] downCoords = SnakeUtils.getPossibleMoveCoord(head, Move.DOWN);
            int[] leftCoords = SnakeUtils.getPossibleMoveCoord(head, Move.LEFT);
            int[] rightCoords = SnakeUtils.getPossibleMoveCoord(head, Move.RIGHT);

            for(int i=1; i<coords.length; i++) {
                if (SnakeUtils.sameCoords(upCoords, coords[i])) {
                    moves.remove(Move.UP);
                }

                if (SnakeUtils.sameCoords(downCoords, coords[i])) {
                    moves.remove(Move.DOWN);
                }

                if (SnakeUtils.sameCoords(leftCoords, coords[i])) {
                    moves.remove(Move.LEFT);
                }

                if (SnakeUtils.sameCoords(rightCoords, coords[i])) {
                    moves.remove(Move.RIGHT);
                }
            }
        }
        return moves;
    }
}
