public class BillGeneratorImp implements BillGenerator{
    @Override
    public String getBill(Pizza pizza) {
        // your code goes here
        String var = "";
        var += "Base Price Of The Pizza: " + pizza.getBasePrice() + "\n";
        if(pizza.isCheeseAdded()){
            var += "Extra Cheese Added: " + pizza.getCheesePrice() + "\n";
        }
        if(pizza.isExtraToppings()){
            var += "Extra Toppings Added: " + pizza.getToppingsPrice() + "\n";
        }
        if(pizza.isTakeaway()){
            var += "Paperbag Added: " + pizza.getTakeawayPrice() + "\n";
        }
        var += "Total Price: " + pizza.getPrice() + "\n";
        return var;
    }
}
