package command;

import bouquet.Accessory;
import bouquet.Bouquet;
import bouquet.flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command {
    List<Flower> flowers = new ArrayList<>();
    List<Accessory> accessorys = new ArrayList<>();
    List<Bouquet> bouquets =new ArrayList<>();
    public ShowCommand(List<Flower> flowers, List<Bouquet> bouquet){
        this.flowers=flowers;
        this.bouquets=bouquet;
    }
    @Override
    public void execute(String params) {
        if (params.equals("bocs")) {
            if (!bouquets.isEmpty()) {
                for (int i = 0; i < bouquets.size(); i++) {
                    System.out.println(bouquets.get(i).getName());
                }
            }

        }
        else if (params.equals("bocF")){
            if(isBuetCurrent()!=-1){
                flowers=bouquets.get(isBuetCurrent()).getFlower();
                for (Flower flower : flowers) {
                    System.out.println(flower.getName());
                }
            }}

       else if (params.equals("flowers")){
            if(!flowers.isEmpty()){
                for (int i = 0; i < flowers.size(); i++) {
                    System.out.println(flowers.get(i).getName());
                } }
        }
       else if (params.equals("bocA")){
            if(isBuetCurrent()!=-1){
                accessorys=bouquets.get(isBuetCurrent()).getAccessory();
                for (Accessory accessory : accessorys) {
                    System.out.println(accessory.getName());
                }
            }}
        else if (params.equals("price")){
            System.out.println("not now");
            /*
            if(isBuetCurrent()!=-1){
                accessorys=bouquets.get(isBuetCurrent()).getAccessory();
                for (Accessory accessory : accessorys) {
                    System.out.println(accessory.getName());
                }
            }*/}
       else {
            System.out.println("no parametr");
        }


    }

    @Override
    public String getCommandName() {
        return "show";
    }
    public int isBuetCurrent(){
        for (int i = 0; i <bouquets.size() ; i++) {
            if (bouquets.get(i).getCurently()){
                return i;
            }
        }
        return -1;
    }
}
