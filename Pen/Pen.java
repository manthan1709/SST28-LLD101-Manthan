public abstract class Pen {
    protected OpenCloseStrategy openCloseStrategy;
    protected RefillStrategy refillStrategy;
    protected String color;

    protected int inkQuantity;
    protected static final int MAX_CAPACITY = 200;

    public Pen(OpenCloseStrategy o,RefillStrategy r, String color){
        this.openCloseStrategy=o;
        this.refillStrategy=r;
        this.color= color;
        this.inkQuantity= MAX_CAPACITY;
    }

    public void open(){
        openCloseStrategy.open();
    }

    public void close(){
        openCloseStrategy.close();
    }
    public void refill(){
        refillStrategy.refill();
        this.inkQuantity= MAX_CAPACITY;
        System.out.println("Ink refilled to " + MAX_CAPACITY);
    }

    protected boolean hasInk(int required) {
        return inkQuantity >= required;
    }

    protected void useInk(int amount) {
        inkQuantity -= amount;
    }
    
    public abstract void write(String text);

}
