import command.AssembleBouquetCommand;
import command.Command;
import command.FindFlowerByStemLengthCommand;
import command.SortFlowersCommand;
import flower.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Flower> flowers = new ArrayList<>();

        // Ініціалізація об'єктів-квітів
        flowers.add(new Flower("Rose", 10.0, 5, 20.0));
        flowers.add(new Flower("Tulip", 8.0, 4, 15.0));
        // Додаткові об'єкти-квіти

        List<Command> commands = new ArrayList<>();
        commands.add(new AssembleBouquetCommand(flowers));
        commands.add(new SortFlowersCommand(flowers));
        commands.add(new FindFlowerByStemLengthCommand(flowers));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Вивід меню
            System.out.println("1. Зібрати букет");
            System.out.println("2. Сортувати квіти у букеті");
            System.out.println("3. Знайти квітку за діапазоном довжини стебла");
            System.out.println("0. Вихід");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= commands.size()) {
                commands.get(choice - 1).execute();
            } else {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }}