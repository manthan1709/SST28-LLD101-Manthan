public class HardMoveStrategy implements MoveStrategy{
    private Dice dice = new Dice();

    public void makeMove(Player player, Board board){
        int sixCount = 0;
        while (true) {
            int roll = dice.roll();
            if (roll == 6) sixCount++;

            if (sixCount == 3) {
                System.out.println("Turn skipped!");
                return;
            }
            int next = player.getPosition() + roll;
    
            if(next<=board.getLastCell()){
                if (board.hasJump(next)) {
                    next= board.getJump(next).getEnd();
                }
                player.setPosition(next);
            }
            if (roll != 6) break;
        }

    }
}
