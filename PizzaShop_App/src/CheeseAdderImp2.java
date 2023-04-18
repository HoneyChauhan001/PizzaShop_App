public class CheeseAdderImp2 implements CheeseAdder{
    private int cheesePrice = 80;
    private int secondCheesePrice = 60;
    @Override
    public int addCheese(Boolean isCheeseAdded) {
        if(!isCheeseAdded){
            return cheesePrice;
        }
        return secondCheesePrice;
    }
}
