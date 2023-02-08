// dev branch for Y.Practicum
import java.lang.invoke.ConstantCallSite;
import java.util.Scanner;

class Dish {
    String name;
    double price;

    Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Bill {
    int numberOfPersons;
    String listOfDishes;
    double totalSum;

    Bill(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
        this.listOfDishes = "";
        this.totalSum = 0;
    }

    public void addDish(Dish dish) {
        this.listOfDishes = this.listOfDishes + '\n' + dish.name;
        this.totalSum += dish.price;
        System.out.println("Блюдо " + dish.name + " добавлено в чек");
    }

    public void print() {
        System.out.println("Добавленные товары:");
        System.out.println(listOfDishes);
    }
}

class Calculator {
    Bill bill;

    Calculator(Bill bill) {
        this.bill = bill;
    }
    public double payment() {
        return bill.totalSum/bill.numberOfPersons;
    }

    public String formattedOutPut() {
        double payment = this.payment();
        return String.format("%.2f " + this.rubbleProperCase(payment), payment);
    }

    private String rubbleProperCase(Double sum) {
        int intSum = (int)Math.floor(sum);

        if (intSum%10==1) {
            return "рубль";
        }
        else if (intSum%10==2 && intSum!=12) {
            return "рубля";
        }
        else if (intSum%10==3 && intSum!=13) {
            return "рубля";
        }
        else if (intSum%10==4 && intSum!=14) {
            return "рубля";
        }
        else {
            return "рублей";
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Bill bill;

        Scanner scanner = new Scanner(System.in);

        //Получаем количество гостей
        while (true) {
            System.out.print("На сколько гостей разбить чек? ");
            int numberOfPersons = scanner.nextInt();
            if (numberOfPersons>1) {
                bill = new Bill(numberOfPersons);
                break;
            }
            System.out.println("Неверное значение. Количество гостей должно быть больше 1. Попробуйте еще раз.");
        }
        scanner.nextLine();//Вынужденная мера для обхода ошибки https://stackoverflow.com/questions/23450524/java-scanner-doesnt-wait-for-user-input
        while (true) {
            System.out.print("Введите название блюда или команду Завершить: ");
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("завершить")) {
                break;
            }

            System.out.print("Введите цену блюда: ");
            double inputPrice = scanner.nextDouble();
            Dish dish = new Dish(inputString, inputPrice);
            bill.addDish(dish);

            scanner.nextLine();//аналогично, комментарию выше
        }

        bill.print();//выводим счет на экран
        Calculator calc = new Calculator(bill);
        System.out.println(calc.formattedOutPut());//выводим итог расчета
        scanner.close();
    }
}

