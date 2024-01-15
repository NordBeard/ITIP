abstract public class Furniture {
    private int countLegs;
    private String material;
    private String color;
    private int price;
    private int counter;
    public Furniture(int countLegs, String material, String color, int price)
    {
        this.countLegs = countLegs;
        this.material = material;
        this.color = color;
        this.price = price;
    }
    Furniture()
    {

    }
    public abstract void ForWhat();

}
