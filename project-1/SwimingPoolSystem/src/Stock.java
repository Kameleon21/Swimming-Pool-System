public class Stock {
    /* private variables */
    private String itemName;
    private int itemQuantity;

    /* constructor method */
    public Stock(String itemName,int itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    /* Getters and Setters */
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /* https://www.tutorialspoint.com/java/util/formatter_tostring.htm */
    /* to String */
    public String toString() {
       return "itemName: %s,itemQuantity: %d %n".formatted(itemName, itemQuantity);
    }
}
