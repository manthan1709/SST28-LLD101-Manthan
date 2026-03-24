import java.util.Queue;

public class Game {

    private Queue<Player> players;
    private Board board;
    private MoveStrategy strategy;

    public Game(Board board,Queue<Player> players,MoveStrategy strategy){
        this.board=board;
        this.players=players;
        this.strategy= strategy;
    }

    public Player makeMove() {

        Player player = players.poll();

        strategy.makeMove(player, board);

        if (isWinner(player)) {
            return player;
        }

        System.out.println("Player " + player.getId() + " at " + player.getPosition());

        players.offer(player);
        return null;
    }
    private boolean isWinner(Player player) {
        return player.getPosition() == board.getLastCell();
    }
}
