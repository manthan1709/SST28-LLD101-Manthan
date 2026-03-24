import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Jump> jumps;

    public Board(int size, Map<Integer, Jump> jumps) {
        this.size = size;
        this.jumps = jumps;
    }

    public int getLastCell() {
        return size * size;
    }

    public boolean hasJump(int pos) {
        return jumps.containsKey(pos);
    }

    public Jump getJump(int pos) {
        return jumps.get(pos);
    }
}
