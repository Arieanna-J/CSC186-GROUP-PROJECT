public class Item {
    private int itemID;
    private String itemName;
    private double itemPrice;
    private int quantityStock;
    private int discount;
    
    public Item(){}
    public Item(int ID, String name, double price, int quantity){
        this.itemID = ID;
        this.itemName = name;
        this.itemPrice = price;
        this.quantityStock = quantity;
    }
    
    public void setItem(int ID, String name, double price, int quantity){
        this.itemID = ID;
        this.itemName = name;
        this.itemPrice = price;
        this.quantityStock = quantity;
    }
    public void setQuantity(int quantity){
        this.quantityStock = quantity;
    }
    public int getItemID(){
        return itemID;
    }
    public String getItemName(){
        return itemName;
    }
    
    public double getPrice(){
        return itemPrice;
    }
    public int getQuantity(){
        return quantityStock;
    }

    public double calcPrice(int value){
        double totalPrice;
        totalPrice = itemPrice * value;
        return totalPrice;
    }
    
    
    public String toString(){
        return ("Item ID: " + itemID + "\nItem Name: " + itemName + "\nPrice: RM" + itemPrice);
    }
}