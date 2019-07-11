package com.battlesnake.strategy;

import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class AvoidOthers implements BasicStrategy {

    public List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves) {
        Snake me = SnakeUtils.findSnakeByUUID(request.getYou(), request.getSnakes());
        int[][] myCoords = me.getCoords();

        List<Snake> snakes = request.getSnakes();

        for (Snake snake : snakes) {

            int[] head = myCoords[0];
            int[] upCoords = SnakeUtils.getPossibleMoveCoord(head, Move.UP);
            int[] downCoords = SnakeUtils.getPossibleMoveCoord(head, Move.DOWN);
            int[] leftCoords = SnakeUtils.getPossibleMoveCoord(head, Move.LEFT);
            int[] rightCoords = SnakeUtils.getPossibleMoveCoord(head, Move.RIGHT);

            int[][] coords = snake.getCoords();
            for(int i = 1; i< coords.length; i++) {
                if (SnakeUtils.sameCoords(upCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.UP);
                }

                if (SnakeUtils.sameCoords(downCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.DOWN);
                }

                if (SnakeUtils.sameCoords(leftCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.LEFT);
                }

                if (SnakeUtils.sameCoords(rightCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.RIGHT);
                }
            }
        }
        return possibleSnakeMoves;
    }
}
