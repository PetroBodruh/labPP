package command;

import bouquet.Bouquet;

import java.util.ArrayList;
import java.util.List;

public class SetBouquetCommand implements Command  {
    protected List<Bouquet> bouquet =new ArrayList<>();
    public SetBouquetCommand(List<Bouquet> bouquet){
        this.bouquet=bouquet;
    }

    @Override
    public void execute(String params) {
        setAllCZ();//currants zero
        System.out.println("set bouquet");
        if(bouquet.isEmpty()){
            Bouquet curreatBucet =new Bouquet(params);
            bouquet.add(curreatBucet);
            curreatBucet.setCurrently(true);}
        else {if(isInArray(params)==-1){
            Bouquet curreatBucet =new Bouquet(params);
            bouquet.add(curreatBucet);
            curreatBucet.setCurrently(true);
        }
        else{
            bouquet.get(isInArray(params)).setCurrently(true);
        }}
    }

    @Override
    public  String getCommandName() {
        return "setB";
    }

    public int isInArray(String params){
        for (int i = 0; i <bouquet.size() ; i++) {
            if (bouquet.get(i).getName().equals(params)){
                return i;
            }
        }
        return -1;
    }
    public void setAllCZ(){
        for (int i = 0; i < bouquet.size(); i++) {
            bouquet.get(i).setCurrently(false);

        }
    }
    public String getDesc(){
        return "set 'bouquet name'// set bouquet from list. If it doesn't exist, create new";
    }
}
