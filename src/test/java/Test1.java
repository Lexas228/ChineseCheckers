import ru.vsu.checkers.components.BotMoveGetter;
import ru.vsu.checkers.components.MoveGetter;
import ru.vsu.checkers.model.logic.Bot;
import ru.vsu.checkers.model.logic.Color;
import ru.vsu.checkers.model.logic.Game;
import ru.vsu.checkers.model.logic.Player;
import ru.vsu.checkers.services.*;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args){
        Map<Player, Color> playerColorMap = new HashMap<>();
        for(Color c : Color.values()){
            playerColorMap.put(new Bot(), c);
        }
        Map<Player, MoveGetter> playerMoveGetterMap = new HashMap<>();
        for(Player s : playerColorMap.keySet()){
            playerMoveGetterMap.put(s, new BotMoveGetter());
        }
        PrintService pr = new PrintServiceImp();
        GameService gs = new GameServiceImp();
        Game game = gs.createGame(playerColorMap);
        gs.startGame(playerMoveGetterMap, 20, pr::print, game);

    }
}
