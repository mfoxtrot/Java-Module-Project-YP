// dev branch for Y.Practicum

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
    public double calculate() {
        return bill.totalSum/bill.numberOfPersons;
    }
}
public class Main {

    public static void main(String[] args) {
    }
}
