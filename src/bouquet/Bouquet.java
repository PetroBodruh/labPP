package bouquet;
import bouquet.flower.Flower;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;


public class Bouquet {
    protected double price;
    protected boolean currently=false;
    protected List<Flower> flower =new ArrayList<>();
    protected  List<Accessory> accessory = new ArrayList<>();
    protected String name;
    public Bouquet(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public boolean getCurently(){
        return currently;
    };
    public void setCurrently(boolean currently){
        this.currently=currently;
    }
    public String addFlower(Flower type){
        flower.add(type);
        return "success";
    }
    public void addFlower(String name){
        flower.add(new Flower(name,100,2,10));
    }

    public List<Flower> getFlower() {
        return flower;
    }
   public List<Accessory> getAccessory(){
        return accessory;
   }
   public void addAccessory(String name){
        accessory.add(new Accessory(name,100));
   }


}
