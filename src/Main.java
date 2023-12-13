import Droid.Droid;
import Droid.attackDroid.AttackDr;
import Droid.defendDroid.DefendDr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        //List<Droid> droids = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список створених дроїдів");
            System.out.println("3. Запустити бій 1 на 1");
            System.out.println("4. Запустити бій команда на команду");
            System.out.println("5. Записати проведений бій у файл");
            System.out.println("6. Відтворити проведений бій зі збереженого файлу");
            System.out.println("7. Вийти з програми");
            System.out.print("Введіть номер команди: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистити буфер введення

            switch (choice) {
                case 1 -> createDroid();
                case 2 -> showDroids();
                case 3 -> startOneOnOneBattle();
                case 4 -> startTeamBattle();
                case 5 -> saveBattleToFile();
                case 6 -> loadBattleFromFile();
                case 7 -> exit = true;
                default -> System.out.println("Невірний вибір команди.");
            }
        }

    }

    public static void createDroid() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();
        System.out.println("Ведіть тип дроїда");
        System.out.println("можливі типи дроїдів : Attack , Defend");
        String type = scanner.nextLine();
        switch (type) {
            case "Attack" -> {
                Droid droid = new AttackDr(name);
                droids.add(droid);
            }
            case "Defend" -> {
                Droid droid = new DefendDr(name);
                droids.add(droid);
            }
            default -> System.out.println("Невірний вибір типу.");
        }
    }

    private static void showDroids() {
        System.out.println("Список створених дроїдів:");
        for (Droid droid : droids) {
            System.out.println(droid);
        }
    }

    private static void startOneOnOneBattle() {

        System.out.println("Виберіть першого дроїда для бою:");
        Droid droid1 = selectDroid();
        int droid1Helth = droid1.getHealth();

        System.out.println("Виберіть другого дроїда для бою:");
        Droid droid2 = selectDroid();
        int droid2Health = droid2.getHealth();

        // Проведення бою 1 на 1
        battleOneOnOne(droid1, droid2);
        droid1.setHealth(droid1Helth);
        droid2.setHealth(droid2Health);
    }

    private static Droid selectDroid() {
        Scanner scanner = new Scanner(System.in);
        showDroids();
        System.out.print("Виберіть номер дроїда: ");
        int choice = scanner.nextInt();
        //  scanner.nextLine();
        return droids.get(choice - 1);
    }

    private static void battleOneOnOne(Droid droid1, Droid droid2) {
        while (droid1.getHealth() > 0 && droid2.getHealth() > 0) {
            int damage1 = droid1.getDamage();
            int damage2 = droid2.getDamage();

            droid2.takeDamage(damage1);
            droid1.takeDamage(damage2);

            System.out.println(droid1.getName() + " атакує " + droid2.getName() + " і завдає " + damage1 + " пошкодження.d1: " + droid1.getHealth());
            System.out.println(droid2.getName() + " атакує " + droid1.getName() + " і завдає " + damage2 + " пошкодження.d2: " + droid2.getHealth());
        }

        if (droid1.getHealth() <= 0) {
            System.out.println(droid2.getName() + " переміг!");
            droid2.setWin(true);
            droid1.setWin(false);
        } else {
            System.out.println(droid1.getName() + " переміг!");
            droid1.setWin(true);
            droid2.setWin(false);
        }
    }

    private static void saveBattleToFile() {
        String fileName = "game.txt";
        try (FileWriter writer = new FileWriter(fileName)) {

            for (Droid droid : droids) {
                writer.write("Ім'я дроїда: " + droid.getName() + ", Тип дроїда : " + droid.getType() + ", Здоров'я дроїда: " + droid.getHealth() + ", Чи переміг : " + droid.isWin() + "\n");
            }
            System.out.println("Бій збережено у файл " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл.");
        }
    }

    private static void loadBattleFromFile() {
        String fileName = "game.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }

    }

    public static void startTeamBattle() {
        Droid[] droidTeam1 = new Droid[2];
        Droid[] droidTeam2 = new Droid[2];

        System.out.println("Виберіть дроїда 1 першої команди");
        droidTeam1[0] = selectDroid();
        System.out.println("Виберіть дроїда 2 першої команди");
        droidTeam1[1] = selectDroid();
        System.out.println("Виберіть дроїда 1 другої команди");
        droidTeam2[0] = selectDroid();
        System.out.println("Виберіть дроїда 2 другої команди");
        droidTeam2[1] = selectDroid();

        while ((isAlive(droidTeam1) && isAlive(droidTeam2))) {
            Scanner scanner = new Scanner(System.in);

            // Хід 1 команди
            System.out.println("Хід 1 команди");
            System.out.println("Виберіть дроїда 1 команди, який буде атакувати");
            int choice1=getChoice(droidTeam1);

            System.out.println("Виберіть, кого атакувати з другої команди");
            int choice2=getChoice(droidTeam2);

            // Перевірка, чи обраний дроїд існує
            if (droidTeam2[choice2 - 1] != null) {
                // Приймання шкоди дроїдом з другої команди
                droidTeam2[choice2 - 1].takeDamage(droidTeam1[choice1 - 1].getDamage());

                System.out.println("Здоров'я дроїда на ім'я" + droidTeam2[choice2 - 1].getName() + ": " + droidTeam2[choice2 - 1].getHealth());

                if (droidTeam2[choice2 - 1].getHealth() <= 0) {
                    System.out.println(droidTeam2[choice2 - 1].getName() + " знешкоджений");
                    droidTeam2[choice2 - 1] = null;// Встановлюємо null для знешкодженого дроїда
                    if (droidTeam2[choice2 - 1] != null) {
                        droidTeam2[choice2 - 1].setWin(false);
                    }
                    if (droidTeam2[choice1 - 1] != null) {
                        droidTeam1[choice1 - 1].setWin(true);
                    }
                }

            }
            MakePerfectMove(droidTeam2, droidTeam1);
        }
    }

    // Допоміжна функція для перевірки, чи є хоча б один дроїд живим
    private static boolean isAlive(Droid[] droids) {
        for (Droid droid : droids) {
            if (droid != null && droid.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void MakePerfectMove(Droid[] droidTeam2, Droid[] droidTeam1) {
        if (droidTeam1[inxH(droidTeam1)] != null) {
            int droidDamage = droidTeam2[inxD(droidTeam2)].getDamage();
            // Приймання шкоди дроїдом з перешої команди
            droidTeam1[inxH(droidTeam1)].takeDamage(droidDamage);

            System.out.println("Здоров'я взято за " + droidDamage + "допомогю фугкціїmake perfect move " + droidTeam1[inxH(droidTeam1)].getName() + ": " + droidTeam1[inxH(droidTeam1)].getHealth());

            if (droidTeam1[inxH(droidTeam1)].getHealth() <= 0) {
                System.out.println(droidTeam1[inxH(droidTeam1)].getName() + " знешкоджений");
                droidTeam1[inxH(droidTeam1)] = null; // Встановлюємо null для знешкодженого дроїда
                droidTeam2[inxD(droidTeam2)].setWin(true);
            }
        }

    }

    public static int inxD(Droid[] droidTeam2) {
        int maxDamage = 0;
        int j = -1;
        for (int i = 0; i < droidTeam2.length; i++) {
            if (droidTeam2[i] != null) {
                if (droidTeam2[i].getDamage() > maxDamage) {
                    maxDamage = droidTeam2[i].getDamage();
                    j = i;
                }
            }

        }
        return j;
    }

    public static int inxH(Droid[] droidTeam1) {
        int lowHealth = Integer.MAX_VALUE;
        int j = -1;
        for (int i = 0; i < droidTeam1.length; i++) {
            if (droidTeam1[i] != null) {
                if (droidTeam1[i].getHealth() < lowHealth) {
                    lowHealth = droidTeam1[i].getHealth();
                    j = i;
                }
            }
        }
        return j;
    }
    public static int getChoice(Droid[] droidTeam){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список дроїдів 2 команди:");
        for (int i = 0; i < droidTeam.length; i++) {
            if (droidTeam[i] != null) {
                System.out.println((i + 1) + ". " + droidTeam[i].getName());
            }
        }
        return scanner.nextInt();
    }
}