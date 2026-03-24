public class Main {
    public static void main(String[] args) {

        Game game = GameFactory.create(10, 2, Difficulty.HARD);

        while (true) {
            Player winner = game.makeMove();

            if (winner != null) {
                System.out.println("Winner: Player " + winner.getId());
                break;
            }
        }
    }
}