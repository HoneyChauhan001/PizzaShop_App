public class Pizza {
    private int price;
    protected int basePrice;
    private Boolean isVeg;
    private String bill;
    private int vegBasePrice = 300;
    private int nonVegBasePrices = 400;
    private boolean isCheeseAdded;
    private boolean isExtraToppings;
    private boolean isTakeaway;
    private BillGenerator billGenerator;
    private CheeseAdder cheeseAdder;
    private ToppingsAdder toppingsAdder;
    private int cheesePrice;
    private int takeawayPrice = 20;
    private int toppingsPrice;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        basePrice = getBasePrice();
        price = basePrice;
        isCheeseAdded = false;
        isExtraToppings = false;
        isTakeaway = false;
        this.billGenerator = new BillGeneratorImp();
        this.cheeseAdder = new CheeseAdderImp();
        this.toppingsAdder = new ToppingsAdderImp();
    }
    public Pizza(Boolean isVeg, BillGenerator billGenerator, CheeseAdder cheeseAdder, ToppingsAdder toppingsAdder){//dependency Inversion/injection principle
        this.isVeg = isVeg;
        basePrice = getBasePrice();
        price = basePrice;
        isCheeseAdded = false;
        isExtraToppings = false;
        isTakeaway = false;
        this.billGenerator = billGenerator;
        this.cheeseAdder  = cheeseAdder;
        this.toppingsAdder = toppingsAdder;
    }

    public int getBasePrice(){
        return isVeg ? vegBasePrice : nonVegBasePrices;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        int  priceOfCheese= cheeseAdder.addCheese(isCheeseAdded);
        cheesePrice += priceOfCheese;
        price += priceOfCheese;
        isCheeseAdded = true;
    }

    public void addExtraToppings(){//apply SOLID for addExtraToppings
        int priceOfToppings = toppingsAdder.addTopping(isExtraToppings,isVeg);
        toppingsPrice += priceOfToppings;
        price += priceOfToppings;
        isExtraToppings = true;
    }

    public void addTakeaway(){
        if(!isTakeaway){
            isTakeaway = true;
            price += takeawayPrice;
        }
    }

    public Boolean getVeg() {
        return isVeg;
    }

    public int getVegBasePrice() {
        return vegBasePrice;
    }

    public int getNonVegBasePrices() {
        return nonVegBasePrices;
    }

    public boolean isCheeseAdded() {
        return isCheeseAdded;
    }

    public int getCheesePrice() {
        return cheesePrice;
    }

    public boolean isExtraToppings() {
        return isExtraToppings;
    }

    public boolean isTakeaway() {
        return isTakeaway;
    }

    public int getTakeawayPrice() {
        return takeawayPrice;
    }

    public int getToppingsPrice() {
        return toppingsPrice;
    }

    public String getBill(){
        // your code goes here
        String bill = billGenerator.getBill(this);//Single responsibility Principle
        this.bill = bill;
        return this.bill;
    }
}
