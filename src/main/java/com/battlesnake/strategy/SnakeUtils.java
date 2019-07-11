package com.battlesnake.strategy;

import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.Snake;

public class SnakeUtils {

    public static Snake findSnakeByUUID(String uuid, List<Snake> snakes) {
        for (Snake snake: snakes) {
            if (uuid.equals(snake.getId())) {
                return snake;
            }
        }
        return null;
    }

    public static int[] getPossibleMoveCoord(int[] head, Move possibleSnakeMove) {
        int[] possibleCoord = new int[2];
        switch (possibleSnakeMove) {
            case UP:
                possibleCoord = new int[]{head[0], head[1] - 1};
                break;
            case LEFT:
                possibleCoord = new int[]{head[0] - 1, head[1]};
                break;
            case DOWN:
                possibleCoord = new int[]{head[0], head[1] + 1};
                break;
            case RIGHT:
                possibleCoord = new int[]{head[0] + 1, head[1]};
                break;
        }

        return possibleCoord;
    }

    public static boolean sameCoords(int i[], int j[]) {
        if (i[0] == j[0] && i[1] == j[1]) {
            return true;
        }
        return false;
    }
}
