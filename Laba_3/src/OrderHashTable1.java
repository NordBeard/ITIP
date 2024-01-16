import java.util.LinkedList;
import java.util.List;
class Order{
    //Поля или значения для класса order
    private String orderNumber;
    private String orderDate;
    private List<String> products;
    private String orderStatus;
    //Конструктор
    public Order(String orderNumber, String orderDate, List<String> products, String orderStatus) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.products = products;
        this.orderStatus = orderStatus;
    }
    //Геттеры и Сеттеры
    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<String> getProducts() {
        return products;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    //Перезапись

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", products=" + products +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}


public class OrderHashTable1 {
    // Создание таблицы
    private static final int DEFAULT_CAPACITY = 16;

    private LinkedList<Order>[] table;

    private static int size;
    // Конструкторы
    public OrderHashTable1() {
        this(DEFAULT_CAPACITY);
    }

    public OrderHashTable1(int capacity) {
        table = new LinkedList[capacity];
    }
    //Вычисление хэша
    private int hash(String orderNumber) {
        return Math.abs(orderNumber.hashCode() % table.length);
    }
    //Коллизия

    public void insertOrder(Order order) {
        int index = hash(order.getOrderNumber());
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        table[index].add(order);
    }
    //Поиск по номеру
    public Order findOrder(String orderNumber) {
        int index = hash(orderNumber);
        LinkedList<Order> orders = table[index];
        if (orders != null) {
            for (Order order : orders) {
                if (order.getOrderNumber().equals(orderNumber)) {
                    return order;
                }
            }
        }
        return null;
    }
    // Удаления заказа
    public void removeOrder(String orderNumber) {
        int index = hash(orderNumber);
        LinkedList<Order> orders = table[index];
        if (orders != null) {
            orders.removeIf(order -> order.getOrderNumber().equals(orderNumber));
        }
    }
    //Изменения статуса
    public void changeOrderStatus(String orderNumber, String newStatus) {
        Order order = findOrder(orderNumber);
        if (order != null) {
            order.setOrderStatus(newStatus);
        }
    }


    public static void main(String[] args) {
        OrderHashTable1 orderTable = new OrderHashTable1();

        Order order1 = new Order("2201", "2023-01-01", List.of("Монитор1", "Монитор2"), "Ожидается");
        Order order2 = new Order("2202", "2023-01-02", List.of("Процессор1", "Процессор2"), "Отпралено");
        Order order3 = new Order("2203", "2023-01-03", List.of("Куллер1", "Куллер2"), "Обработка");
        Order order4 = new Order("2204", "2023-01-04", List.of("Клавиатура1", "Клавиатура2"), "Доставлено");
        Order order5 = new Order("2204", "2023-01-05", List.of("ЖесткийДиск1", "ЖесткийДиск2"), "Доставлено");

        orderTable.insertOrder(order1);
        orderTable.insertOrder(order2);
        orderTable.insertOrder(order3);
        orderTable.insertOrder(order4);
        orderTable.insertOrder(order5);



        System.out.println("Заказ с номером 2201: " + orderTable.findOrder("2201"));
        System.out.println("Заказ с номером 2203: " + orderTable.findOrder("2203"));

        orderTable.removeOrder("2202");
        System.out.println("После удаления заказа с номером 2202: " + orderTable.findOrder("2202"));

        orderTable.changeOrderStatus("2201", "Завершен");
        System.out.println("После изменения статуса для заказа 2201: " + orderTable.findOrder("2201"));

        System.out.println("Заказ с номером 2204 (до изменений): " + orderTable.findOrder("2204"));

        // Меняем статус для заказа с номером "2204"
        orderTable.changeOrderStatus("2204", "В обработке");
        Order order6 = new Order("2204", "2023-01-06", List.of("ЖесткийДиск1", "ЖисткийДиск2"), "В обработке");
        orderTable.insertOrder(order6);
        System.out.println("Заказ с номером 2204 (после изменений): " + orderTable.findOrder("2204"));



    }
}
