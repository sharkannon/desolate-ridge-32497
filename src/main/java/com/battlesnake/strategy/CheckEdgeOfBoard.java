package com.battlesnake.strategy;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.Snake;

public class CheckEdgeOfBoard implements BasicStrategy {
    public List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves) {
        List<Move> nextPossibleSnakeMoves = new ArrayList<>();

        Snake us = SnakeUtils.findSnakeByUUID(request.getYou(), request.getSnakes());
        int boardSize = request.getHeight();

        for (Move snakeMove : possibleSnakeMoves) {
            int[] possbileMoveCoord = SnakeUtils.getPossibleMoveCoord(us.getCoords()[0], snakeMove);
            if (!(possbileMoveCoord[0] < 0 || possbileMoveCoord[0] == boardSize ||
                    possbileMoveCoord[1] < 0 || possbileMoveCoord[1] == boardSize)) {
                nextPossibleSnakeMoves.add(snakeMove);
            }
        }

        System.out.println("CheckEdgeOfBoard: " + nextPossibleSnakeMoves.toString());
        return nextPossibleSnakeMoves;
    }


}
