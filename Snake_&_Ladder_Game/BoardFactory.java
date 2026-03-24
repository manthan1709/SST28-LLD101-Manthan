import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BoardFactory {
    public static Board createBoard(int size, Difficulty difficulty){
        int snakes = size;
        int ladders = size;



        Map<Integer, Jump> jumps = new HashMap<>();
        Random random = new Random();
        int end = size * size;

        while (snakes > 0) {
            int start = getRandom(2, end - 1, random);
            int endPos = getRandom(1, start - 1, random);

            if (isValid(start, endPos, size, end, jumps)) {
                jumps.put(start, new Snake(start, endPos));
                snakes--;
            }
        }

        while (ladders > 0) {
            int start = getRandom(1, end - 1, random);
            int endPos = getRandom(start + 1, end, random);

            if (isValid(start, endPos, size, end, jumps)) {
                jumps.put(start, new Ladder(start, endPos));
                ladders--;
            }
        }


        return new Board(size, jumps);


    }
       private static int getRandom(int min, int max, Random random) {
        return random.nextInt(max - min + 1) + min;
    }

    private static boolean isValid(int start, int end, int size, int boardEnd, Map<Integer, Jump> jumps) {

        if (start == boardEnd) return false;
        if (jumps.containsKey(start)) return false;

        int rowStart = (start - 1) / size;
        int rowEnd = (end - 1) / size;

        return Math.abs(rowStart - rowEnd) >= 1;
    }

}
