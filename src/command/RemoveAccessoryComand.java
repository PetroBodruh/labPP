package command;

import bouquet.Accessory;
import bouquet.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class RemoveAccessoryComand implements Command{
    protected List<Bouquet> bouquet =new ArrayList<>();
    protected  List<Accessory> accessory = new ArrayList<>();
    public RemoveAccessoryComand(List<Bouquet> bouquet){
        this.bouquet=bouquet;
    }
    @Override
    public void execute(String params) {
        int currB=isBuetCurrent();
        if(currB==-1){
            System.out.println("Виберіть букет");
        }
        else {accessory=bouquet.get(currB).getAccessory();
            for (int i = 0; i < accessory.size(); i++) {
                if(accessory.get(i).getName().equals(params)){
                    accessory.remove(i);
                    break;
                }
            }
        }

    }

    @Override
    public String getCommandName() {
        return "removeA";
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
        return "remove 'accessory name'// remove accessory from selected bouquet";
    }
}
