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
            int[] upupCoords = SnakeUtils.getPossibleMoveCoord(upCoords, Move.UP);

            int[] downCoords = SnakeUtils.getPossibleMoveCoord(head, Move.DOWN);
            int[] downdownCoords = SnakeUtils.getPossibleMoveCoord(downCoords, Move.DOWN);

            int[] leftCoords = SnakeUtils.getPossibleMoveCoord(head, Move.LEFT);
            int[] leftleftCoords = SnakeUtils.getPossibleMoveCoord(leftCoords, Move.LEFT);

            int[] rightCoords = SnakeUtils.getPossibleMoveCoord(head, Move.RIGHT);
            int[] rightrightCoords = SnakeUtils.getPossibleMoveCoord(rightCoords, Move.RIGHT);

            int[][] coords = snake.getCoords();
            for (int i = 0; i < coords.length; i++) {
                if (SnakeUtils.sameCoords(upCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.UP);
                }

                if (SnakeUtils.sameCoords(upupCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.UP);
                } else if (possibleSnakeMoves.contains(Move.UP)){
                    possibleSnakeMoves.remove(Move.UP);
                    possibleSnakeMoves.add(0, Move.UP);
                }

                if (SnakeUtils.sameCoords(downCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.DOWN);
                }

                if (SnakeUtils.sameCoords(downdownCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.DOWN);
                } else if (possibleSnakeMoves.contains(Move.DOWN)) {
                    possibleSnakeMoves.remove(Move.DOWN);
                    possibleSnakeMoves.add(0, Move.DOWN);
                }

                if (SnakeUtils.sameCoords(leftCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.LEFT);
                }

                if (SnakeUtils.sameCoords(leftleftCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.LEFT);
                } else if (possibleSnakeMoves.contains(Move.LEFT)) {
                    possibleSnakeMoves.remove(Move.LEFT);
                    possibleSnakeMoves.add(0, Move.LEFT);
                }

                if (SnakeUtils.sameCoords(rightCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.RIGHT);
                }

                if (SnakeUtils.sameCoords(rightrightCoords, coords[i])) {
                    possibleSnakeMoves.remove(Move.RIGHT);
                } else if (possibleSnakeMoves.contains(Move.RIGHT)) {
                    possibleSnakeMoves.remove(Move.RIGHT);
                    possibleSnakeMoves.add(0, Move.RIGHT);
                }
            }
        }
        System.out.println("AvoidOthers: " + possibleSnakeMoves.toString());
        return possibleSnakeMoves;
    }
}
