package command;

import flower.Flower;

import java.util.List;

public class FindFlowerByStemLengthCommand implements Command {
    private List<Flower> bouquet;

    public FindFlowerByStemLengthCommand(List<Flower> bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        // Логіка пошуку квітки в букеті за діапазоном довжини стебла
        // Вивід результатів
    }
}