public class Player {
    private int id;
    private int position = 0;

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

}
