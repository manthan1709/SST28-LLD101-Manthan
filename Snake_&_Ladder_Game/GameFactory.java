import java.util.LinkedList;
import java.util.Queue;

public class GameFactory {
    public static Game create(int size, int playerCount, Difficulty difficulty) {
        Board board = BoardFactory.createBoard(size, difficulty);

        Queue<Player> players = new LinkedList<>();
        for (int i = 1; i <= playerCount; i++) {
            players.add(new Player(i));
        }

        MoveStrategy strategy = (difficulty == Difficulty.HARD)
                ? new HardMoveStrategy()
                : new EasyMoveStrategy();

        return new Game(board, players, strategy);

    }
}
