public class Table extends Furniture {
    private int width;
    private int height;
    private int depth;
    private boolean transformer;
    private boolean patterns;
    Table()
    {
        transformer = true;
        patterns = true;
    }
    public Table(int coutLegs, String material, String color, int price)
    {
        super(coutLegs, material, color, price);
    }
    public Table(int coutLegs, String material, String color, int price, int width, int depth, int height)
    {
        super(coutLegs, material, color, price);
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public void Print(int coutLegs, String material, String color, int price, int width, int depth, int height)
    {
        System.out.println("Количество ножек: " + coutLegs + "Материал: " + material +
                "Цвет: " + color + "Цена: " + price + "Ширина: " + width + "Длина: " + depth + "Высота: " + height);
    }
    @Override
    public void ForWhat()
    {
        System.out.println("За столом едят");
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public int getDepth()
    {
        return depth;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setDepth(int depth)
    {
        this.depth = depth;
    }
    public boolean getTransformer(){return transformer;}
    public boolean getPatterns(){return patterns;}
}
