package Customer;


public class Customer {
    protected int customerId;
    protected String lastname;
    protected String firstname;
    protected String patronymic;
    protected String adress;
    protected long cardNum;
    protected int amount;

    public Customer(int customerId, String lastname, String firstname, String patronymic, String adress, long cardNum, int amount) {
        this.customerId = customerId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.adress = adress;
        this.cardNum = cardNum;
        this.amount = amount;
    }

    public class RungeKuttaSolver {

        public static void main(String[] args) {
            // Задані параметри
            double x0 = 0;  // Початкова точка x
            double y0 = -3;  // Початкове значення y
            double h = 0.001;  // Крок

            // Вивід заголовка
            System.out.println("Step\t x\t\t y\t\t k1\t\t k2\t\t k3\t\t k4");

            // Виклик функції для розв'язання рівняння
            rungeKutta(x0, y0, h);
        }

        // Функція, що описує диференціальне рівняння
        public static double f(double x, double y) {
            return x * y - Math.cos(Math.pow(x, 2) + 2 * y);
        }

        // Метод Рунге-Кутта четвертого порядку
        public static void rungeKutta(double x0, double y0, double h) {
            double x = x0;
            double y = y0;

            System.out.printf("%d\t %.4f\t %.4f", 0, x, y);

            for (int i = 1; x < 1; i++) {
                double k1 = h * f(x, y);
                double k2 = h * f(x + h / 2, y + k1 / 2);
                double k3 = h * f(x + h / 2, y + k2 / 2);
                double k4 = h * f(x + h, y + k3);

                y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
                x = x + h;

                // Вивід значень
                System.out.printf("\n%d\t %.4f\t %.4f\t %.4f\t %.4f\t %.4f\t %.4f", i, x, y, k1, k2, k3, k4);
            }
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAdress() {
        return adress;
    }

    public long getCardNum() {
        return cardNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customerId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", adress='" + adress + '\'' +
                ", cardNum=" + cardNum +
                ", amount=" + amount +
                '}';
    }
}

