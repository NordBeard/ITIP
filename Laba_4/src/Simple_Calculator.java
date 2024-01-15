public class Simple_Calculator {
    private double a;
    private double b;
    private String operation;
    public Simple_Calculator(double a, double b, String operation)
    {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }
    public double Addition()
    {
        return a + b;
    }
    public double Subtraction()
    {
        return a - b;
    }
    public double Multiplication()
    {
        return a * b;
    }
    public double Divide()
    {
        if(b == 0d)
        {
            return 0d;
        }
        return a / b;
    }
    public String getOperation()
    {
        return operation;
    }
}
