public class CheeseAdderImp implements CheeseAdder{

    private int cheesePrice = 80;
    @Override
    public int addCheese(Boolean isCheeseAdded) {
        if(!isCheeseAdded){
            return cheesePrice;
        }
        return 0;
    }
}
