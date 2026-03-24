public class Main {

    public static void main(String[] args) {

        Pen pen = PenFactory.createPen(PenType.BALL, "Blue", false);

        pen.open();
        pen.write("Hello World");
        pen.close();

        pen.refill();
    }
}