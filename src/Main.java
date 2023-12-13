import bouquet.Bouquet;
import command.*;
import bouquet.flower.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Flower> flowerList = new ArrayList<>();
        List<Bouquet> bouquetsList = new ArrayList<>();
        Executor executor = new Executor();
        executor.addCommand(new FindFlowerByStemLengthCommand(bouquetsList));
        executor.addCommand(new SortFlowersCommand(bouquetsList));
        executor.addCommand(new HelpCommand(executor));
        executor.addCommand(new SetBouquetCommand(bouquetsList));
        executor.addCommand(new ShowCommand(flowerList, bouquetsList));
        executor.addCommand(new AddAccessoryComand(bouquetsList));
        executor.addCommand(new AddFlowerCommand(bouquetsList));
        executor.addCommand(new RemoveAccessoryComand(bouquetsList));
        executor.addCommand(new RemoveFlowerCommand(bouquetsList));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            int firstSpaceIndex = input.indexOf(' ');
            String firstElement;
            String param;

            if (firstSpaceIndex != -1) {
                firstElement = input.substring(0, firstSpaceIndex);
                param = input.substring(firstSpaceIndex + 1).trim();
            } else {
                firstElement = input;
                param = "";
            }
            if (!firstElement.isEmpty()) {
                if (!Objects.equals(firstElement, "exit")) {
                    executor.executeCommand(firstElement, param);
                } else {
                    break;
                }
            }

        }


    }
}