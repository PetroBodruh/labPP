package command;

import bouquet.Bouquet;
import bouquet.flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class FindFlowerByStemLengthCommand implements Command {
    protected List<Bouquet> bouquet =new ArrayList<>();
    protected List<Flower> flower =new ArrayList<>();
    protected List<Flower> stFlower =new ArrayList<>();

    public FindFlowerByStemLengthCommand(List<Bouquet> bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute(String params) {
        int firstSpaceIndex = params.indexOf(' ');
        String min;
        String max;

        if (firstSpaceIndex != -1) {
            min = params.substring(0, firstSpaceIndex);
            max = params.substring(firstSpaceIndex + 1).trim();
        System.out.println("executed find");
        int currB=isBuetCurrent();
        if(currB==-1){
            System.out.println("Виберіть букет");
        }
        else {
            flower = bouquet.get(currB).getFlower();
            for (int i = 0; i < flower.size(); i++) {
                if (flower.get(i).getStemLength() < Double.parseDouble(max) && flower.get(i).getStemLength() > Double.parseDouble(min)) {
                    stFlower.add(flower.get(i));
                }
            }
        }
            System.out.println("Квіти у заданому діапазоні стеблел");
            for (int i = 0; i < stFlower.size(); i++) {
                System.out.println("-"+stFlower.get(i).getName()+" "+stFlower.get(i).getStemLength());
            }} else{
        System.out.println("помилка вводу");
    }}
    @Override
    public String getCommandName() {
        return "find";
    }
    public int isBuetCurrent(){
            for (int i = 0; i <bouquet.size() ; i++) {
                if (bouquet.get(i).getCurently()){
                    return i;
                }
            }
            return -1;
        }
}