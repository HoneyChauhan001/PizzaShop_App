public class ToppingsAdderImp implements ToppingsAdder{
    private int vegExtraToppingsPrices = 70;
    private int nonVegExtraToppingsPrices = 120;
    @Override
    public int addTopping(Boolean isExtraTopping, Boolean isVeg) {
        if(!isExtraTopping){
            return isVeg ? vegExtraToppingsPrices : nonVegExtraToppingsPrices;
        }
        else return 0;
    }
}
