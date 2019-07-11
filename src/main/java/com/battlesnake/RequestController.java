/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.battlesnake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.battlesnake.data.HeadType;
import com.battlesnake.data.Move;
import com.battlesnake.data.MoveRequest;
import com.battlesnake.data.MoveResponse;
import com.battlesnake.data.StartRequest;
import com.battlesnake.data.StartResponse;
import com.battlesnake.data.TailType;
import com.battlesnake.strategy.CheckEdgeOfBoard;
import com.battlesnake.strategy.CheckSnakeTail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping(value="/start", method=RequestMethod.POST, produces="application/json")
    public StartResponse start(@RequestBody StartRequest request) {
        return new StartResponse()
                .setName("Tron")
                .setColor("#FF0000")
                .setHeadUrl("http://www.supertouchart.com/wp-content/uploads/2016/07/539954915798600d2009de7b1f09530b.png")
                .setHeadType(HeadType.FANG)
                .setTailType(TailType.PIXEL)
                .setTaunt("Trongggggalong!");
    }

    @RequestMapping(value="/move", method=RequestMethod.POST, produces = "application/json")
    public MoveResponse move(@RequestBody MoveRequest request) {
        CheckEdgeOfBoard checkEdgeOfBoard = new CheckEdgeOfBoard();
        CheckSnakeTail checkTail = new CheckSnakeTail();

        List<Move> possibleMoves = new ArrayList<>();
        possibleMoves.add(Move.RIGHT);
        possibleMoves.add(Move.DOWN);
        possibleMoves.add(Move.LEFT);
        possibleMoves.add(Move.UP);

        possibleMoves = checkTail.makeAMove(request, possibleMoves);
        possibleMoves = checkEdgeOfBoard.makeAMove(request, possibleMoves);

        Move move = possibleMoves.get(0);
        if (move == null) {
            move = Move.RIGHT;
        }

        return new MoveResponse()
                .setMove(move)
                .setTaunt("Going Down!");
    }

    @RequestMapping(value="/end", method=RequestMethod.POST)
    public Object end() {
        // No response required
        Map<String, Object> responseObject = new HashMap<String, Object>();
        return responseObject;
    }

}
