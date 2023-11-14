package command;

import flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class AssembleBouquetCommand implements Command {
    private List<Flower> flowers;
    private List<Flower> bouquet;

    public AssembleBouquetCommand(List<Flower> flowers) {
        this.flowers = flowers;
        this.bouquet = new ArrayList<>();
    }

    @Override
    public void execute() {
        // Логіка збору букету
        // Додавання квітів, використання аксесуарів і т. д.
    }
}