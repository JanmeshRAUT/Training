package Interface;

public class App {
    public static void main(String[] args) {
        RestrauntService service = new Dominoz("Pizza");
        service.acceptOrder("John");
        service.PrepareFood();
        service.DeliverFood();
        System.out.println(service);
    }
}
