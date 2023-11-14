package command;

import flower.Flower;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFlowersCommand implements Command {
    private List<Flower> bouquet;

    public SortFlowersCommand(List<Flower> bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        // Логіка сортування квітів у букеті за рівнем свіжості
        //Collections.sort(bouquet, Comparator.comparingInt(Flower::getFreshnessLevel));
    }
}