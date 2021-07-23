package test;

public class Orders {
    private String orderName;
    private String orderAdd;

    public Orders(String orderName,String orderAdd){
        this.orderName = orderName;
        this.orderAdd = orderAdd;
    }

    public void Show(){
        String msg = orderName + "::" + orderAdd;
        System.out.println(msg);
    }
}
