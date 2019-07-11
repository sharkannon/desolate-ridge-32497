package com.battlesnake.strategy;

import java.util.ArrayList;
import java.util.List;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;

public class CheckOtherSnakes implements BasicStrategy {

    public List<Move> makeAMove(MoveRequest request, List<Move> possibleSnakeMoves) {
        return new ArrayList<>();
    }
}
