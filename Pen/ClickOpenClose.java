public class ClickOpenClose implements OpenCloseStrategy{
    @Override
    public void open(){
        System.out.println("Click: Tip out");
    }
    @Override
    public void close(){
        System.out.println("Click: Tip in");
    }
}
