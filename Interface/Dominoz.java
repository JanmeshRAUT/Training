package Interface;

public class Dominoz implements RestrauntService{
    String fooditem;
    Dominoz(String foodItem){
        this.fooditem=foodItem;
    }

    @Override
    public void acceptOrder(String custName){
        System.out.println("Hello"+ custName+"Aceept the order!!!");
    }

    @Override
    public void PrepareFood(){
        System.out.println("Preparing the food item: "+ fooditem);
    }
    @Override
    public void DeliverFood(){
        System.out.println("Delivering the food item: "+ fooditem);
    }
    @Override
    public String toString(){
        return "Dominoz [fooditem=" + fooditem + "]";
    }
}
