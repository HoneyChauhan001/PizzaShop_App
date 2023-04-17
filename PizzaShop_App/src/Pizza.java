public class Pizza {
    private int price;
    private int basePrice;
    private Boolean isVeg;
    private String bill;
    private int vegBasePrice = 300;
    private int nonVegBasePrices = 400;
    private boolean isCheeseAdded;
    private boolean isExtraToppings;
    private boolean isTakeaway;
    private BillGenerator billGenerator;
    private int cheesePrice = 80;
    private int vegExtraToppingsPrices = 70;
    private int nonVegExtraToppingsPrices = 120;
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
    }
    public Pizza(Boolean isVeg, BillGenerator billGenerator){//dependency Inversion/injection principle
        this.isVeg = isVeg;
        basePrice = getBasePrice();
        price = basePrice;
        isCheeseAdded = false;
        isExtraToppings = false;
        isTakeaway = false;
        this.billGenerator = billGenerator;
    }

    public int getBasePrice(){
        return isVeg ? vegBasePrice : nonVegBasePrices;
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(!isCheeseAdded){
            isCheeseAdded = true;
            price += cheesePrice;
        }
    }

    public void addExtraToppings(){
        if(!isExtraToppings){
            isExtraToppings = true;
            toppingsPrice = isVeg ? vegExtraToppingsPrices : nonVegExtraToppingsPrices;
            price += toppingsPrice;
        }
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

    public int getVegExtraToppingsPrices() {
        return vegExtraToppingsPrices;
    }

    public int getNonVegExtraToppingsPrices() {
        return nonVegExtraToppingsPrices;
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
