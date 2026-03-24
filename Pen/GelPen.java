public class GelPen extends Pen {

    public GelPen(OpenCloseStrategy o, RefillStrategy r, String color) {
        super(o, r, color);
    }

    @Override
    public void write(String text) {
        if (!hasInk(text.length())) {
            System.out.println("Not enough ink!");
            return;
        }

        useInk(text.length());

        System.out.println(color + " GelPen writing: " + text);
        System.out.println("Remaining ink: " + inkQuantity);
    }
}