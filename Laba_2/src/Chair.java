public class Chair extends Furniture{
    private String softness;
    private String back;
    private String varierty;

    Chair()
    {
        back = "Есть спинка";
        varierty = "Мягкая сидушка";
    }
    public Chair(int coutLegs, String material, String color, int price)
    {
        super(coutLegs, material, color, price);
    }
    public Chair(int coutLegs, String material, String color, int price, String softness)
    {
        super(coutLegs, material, color, price);
        this.softness = softness;
    }

    public void Print(int coutLegs, String material, String color, int price, String softness)
    {
        System.out.println("Количество ножек: " + coutLegs + "Материал: " + material +
                "Цвет: " + color + "Цена: " + price + "Мягкость: " + softness);
    }
    @Override
    public void ForWhat()
    {
        System.out.println("На стуле сидят");
    }
    public String getSoftness()
    {
        return softness;
    }
    public void setSoftness(String softness)
    {
        this.softness = softness;
    }
    public String getBack(){return back;}
    public String getVarierty(){return varierty;}
}
