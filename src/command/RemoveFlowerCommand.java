package command;

import bouquet.Bouquet;
import bouquet.flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class RemoveFlowerCommand implements Command{
    protected List<Bouquet> bouquet =new ArrayList<>();
    protected List<Flower> flower =new ArrayList<>();
    public RemoveFlowerCommand(List<Bouquet> bouquet){
        this.bouquet=bouquet;
    }
    @Override
    public void execute(String params) {
        int currB=isBuetCurrent();
        if(currB==-1){
            System.out.println("Виберіть букет");
        }
        else {flower=bouquet.get(currB).getFlower();
            for (int i = 0; i < flower.size(); i++) {
                if(flower.get(i).getName().equals(params)){
                    flower.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public String getCommandName() {
        return "removeF";
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
        return "remove 'flower name'// remove flower from selected bouquet";
    }
}
