public class PenFactory {
    public static Pen createPen(PenType type, String color, boolean withCap){
        OpenCloseStrategy openStrategy;
        RefillStrategy refillStrategy;

        if (withCap) {
            openStrategy = new CapOpenClose();
        } else {
            openStrategy = new ClickOpenClose();
        }

        switch (type) {

            case BALL:
                refillStrategy = new ReplaceRefill();
                return new BallPen(openStrategy, refillStrategy, color);

            case GEL:
                refillStrategy = new ReplaceRefill();
                return new GelPen(openStrategy, refillStrategy, color);

            case FOUNTAIN:
                refillStrategy = new InkFillRefill();
                return new FountainPen(openStrategy, refillStrategy, color);

            default:
                throw new IllegalArgumentException("Invalid Pen Type");
        }
    }
}
