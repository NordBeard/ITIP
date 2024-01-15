public class Bed extends Furniture{
    private String matras;
    private String sostav;
    private int pillow_count;
    public static int counter;
    Bed()
    {
        pillow_count = 3;
        sostav = "На пружине";
        matras = "Мягкая";
        counter++;
    }
    public Bed(int coutLegs, String material, String color, int price)
    {
        super(coutLegs, material, color, price);
    }
    public Bed(int coutLegs, String material, String color, int price, String matras)
    {
        super(coutLegs, material, color, price);
        this.matras = matras;
    }

    public void Println(int coutLegs, String material, String color, int price, String variety)
    {
        System.out.println("Количество ножек: " + coutLegs + "Материал: " + material +
                "Цвет: " + color + "Цена: " + price + "Мягкость: " + variety);
    }
    @Override
    public void ForWhat()
    {
        System.out.println("На кровати спят");
    }
    public String getMatras()
    {
        return matras;
    }
    public static int getCounter()
    {
        return counter;
    }
    public void setMatras(String matras)
    {
        this.matras = matras;
    }
    public String getSostav(){return sostav;}
    public int getPillow_count(){return pillow_count;}

}
