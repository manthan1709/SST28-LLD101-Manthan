public class EasyMoveStrategy  implements MoveStrategy{
    private Dice dice = new Dice();

    public void makeMove(Player player, Board board){
        while (true) {
            int roll = dice.roll();
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
