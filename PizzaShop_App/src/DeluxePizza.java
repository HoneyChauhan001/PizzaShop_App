public class DeluxePizza extends Pizza {
    public DeluxePizza(Boolean isVeg) {
        super(isVeg);
        super.addExtraCheese();
        super.addExtraToppings();
    }

    public DeluxePizza(Boolean isVeg, BillGenerator billGenerator,CheeseAdder cheeseAdder, ToppingsAdder toppingsAdder){
        super(isVeg,billGenerator,cheeseAdder,toppingsAdder);
        super.addExtraCheese();
        super.addExtraToppings();
        super.basePrice = super.basePrice + super.getCheesePrice() + super.getToppingsPrice();

    }
}
