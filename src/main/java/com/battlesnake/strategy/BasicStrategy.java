package com.battlesnake.strategy;

import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;

public interface BasicStrategy {
    List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves);
}
