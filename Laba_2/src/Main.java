import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bed b = new Bed();
        Bed b2 = new Bed();
        System.out.println(Bed.getCounter());
        System.out.println(Bed.getCounter());
        System.out.println(b2.getMatras());
        System.out.println(b2.getPillow_count());
        System.out.println(b2.getSostav());
        Table t = new Table();
        System.out.println(t.getTransformer());
        System.out.println(t.getPatterns());
        Chair ch = new Chair();
        System.out.println(ch.getSoftness());
        System.out.println(ch.getBack());
        System.out.println(ch.getVarierty());





        //Ввод с клавиатуры
        Scanner sc = new Scanner(System.in);
        System.out.println("Материал мебели: ");
        String material = sc.next();
        System.out.println("Цвет мебели: ");
        String color = sc.next();
        System.out.println("Цена мебели: ");
        int price = sc.nextInt();
        System.out.println("Введите ширину, длину и высоту: ");
        int width = sc.nextInt();
        int depth = sc.nextInt();
        int height = sc.nextInt();

        Table t2 = new Table(4,material,color,price,width,depth,height);
        t2.Print(4,material,color,price,width,depth,height);
        Chair ch1 = new Chair(4,"Береза", "Белый", 8000, "Твердый");
        System.out.println(ch1.getSoftness());



    }
}