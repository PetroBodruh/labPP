package command;

import bouquet.Bouquet;
import bouquet.flower.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortFlowersCommand implements Command {
    protected List<Bouquet> bouquet = new ArrayList<>();
    protected List<Flower> flower = new ArrayList<>();
    protected List<Flower> sortflower = new ArrayList<>();

    public SortFlowersCommand(List<Bouquet> bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute(String params) {
        int ind = 0;
        int max = 0;
        System.out.println("executed sort");
        int currB = isBuetCurrent();
        if (currB == -1) {
            System.out.println("Виберіть букет");
        } else {
            flower = bouquet.get(currB).getFlower();
            for (int i = 0; i < flower.size(); i++) {
                if (flower.get(i).getFreshnessLevel() > max) {
                    max = flower.get(i).getFreshnessLevel();
                    ind = i;
                }

            }
            sortflower.add(flower.get(ind));
            System.out.println("sorted max" + sortflower.get(ind).getName() + " " + sortflower.get(ind).getStemLength());
            flower.sort(Comparator.comparingInt(Flower::getFreshnessLevel));
            flower.forEach(System.out::println);
        }
    }

    @Override
    public String getCommandName() {
        return "sort";
    }

    public int isBuetCurrent() {
        for (int i = 0; i < bouquet.size(); i++) {
            if (bouquet.get(i).getCurently()) {
                return i;
            }
        }
        return -1;
    }
    public String getDesc(){
        return "sort // sorting  bouquet by fresh ";
    }
}