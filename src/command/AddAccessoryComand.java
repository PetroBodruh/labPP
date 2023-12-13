package command;

import bouquet.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class AddAccessoryComand implements Command{
    protected List<Bouquet> bouquet =new ArrayList<>();
    public AddAccessoryComand(List<Bouquet> bouquet){
        this.bouquet=bouquet;
    }
    @Override
    public void execute(String params) {
        if(isBuetCurrent()==-1){
            System.out.println("Виберіть букет");
        }
        else {bouquet.get(isBuetCurrent()).addAccessory(params);}
    }

    @Override
    public String getCommandName() {
        return "addA";
    }
    public int isBuetCurrent(){
        for (int i = 0; i <bouquet.size() ; i++) {
            if (bouquet.get(i).getCurently()){
                return i;
            }
        }
        return -1;
    }
    public String getDesc(){
        return "add 'accessory name'// add accesory to selected bouquet";
    }
}
