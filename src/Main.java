//Train: Пункт призначення, Номер поїзду, Час відправки, Число
//
//місць (загальних, купе, плацкарт, люкс).
//Скласти масив об'єктів. Вивести:
//a) список поїздів, які прямують до заданого пункту призначення;
//b) список поїздів, які прямують до заданого пункту призначення та
//відправляються після заданої години;
//c) список поїздів, які відправляються до заданого пункту
//призначення та мають загальні місця.
import Train.Train;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    static List <Train> trains = new ArrayList<>();
    public static void creationOfList(){
        trains.add(new Train("Київ", 1244, "9:40", 100, 50, 20, 20));
        trains.add(new Train("Львів", 1023, "20:12", 80, 40, 15, 25));
        trains.add(new Train("Одеса", 2900, "15:35", 55, 55, 30, 10));
        trains.add(new Train("Волинь", 1000, "7:20", 78, 44, 14, 55));
        trains.add(new Train("Вінниця", 1220, "4:10", 0, 78, 44, 19));
        trains.add(new Train("Тернопіль", 5552, "19:55", 90, 56, 30, 15));
        trains.add(new Train("Чернігів", 7823, "22:40", 150, 64, 15, 20));
    }
    public static void main(String[] args) {
        Main.creationOfList();
        int userChoice = 0;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        String userDestination;
        String userTime;
        while(cont){
            menu();
            userChoice = sc.nextInt();
            sc.nextLine();
            switch (userChoice){
                case 1:
                    System.out.println("Введіть пункт призначення: ");
                    userDestination = sc.nextLine();
                    toUserDestination(trains, userDestination);
                    break;
                case 2:
                    System.out.println("Введіть пункт призначення: ");
                    userDestination = sc.nextLine();
                    System.out.println("Введіть час (приклад: hh:mm): ");
                    userTime = sc.nextLine();
                    toDesAfterShTime(trains, userDestination, userTime);
                    break;
                case 3:
                    System.out.println("Введіть пункт призначення: ");
                    userDestination = sc.nextLine();
                    toDesAndIsGenSeat(trains, userDestination);
                    break;
                case 4:
                    cont = false;
                    break;
                default:
                    System.out.println("Некоректно введені дані. Спробуйте ще раз");
            }
        }
        sc.close();
    }

    public static void menu(){
        System.out.println("\nЩо ви хочете дізнатися:" +
                "\n1. Поїзди, які прямують до заданого місця призначення;" +
                "\n2. Поїзди, які прямують до заданого місця призначення та відправляються після заданої години;" +
                "\n3. Поїзди, які  які відправляються до заданого пункту призначення та мають загальні місця;" +
                "\n4. Вихід з програми" +
                "\nВаш вибір: ");
    }
    public static int toMinute(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    public static void toUserDestination(List<Train> trains, String des){
        System.out.println("Поїзда, які прямують до " + des + ": ");
        for (Train t : trains){
            if(t.getDestination().equalsIgnoreCase(des)){
                System.out.println("Поїзд\n" + t);
            }
        }
    }
    public static void toDesAfterShTime(List<Train> trains, String des, String time){
        System.out.println("Поїзда, які прямують до " + des + " та відправляються після" + time + ": ");
        for (Train t : trains){
            if(t.getDestination().equalsIgnoreCase(des) && toMinute(t.getShippingTime()) > toMinute(time) ){
                System.out.println("Поїзд\n" + t);
            }
        }
    }
    public static void toDesAndIsGenSeat(List<Train> trains, String des){
        System.out.println("Поїзда, які прямують до " + des + " та мають загальні місця: ");
        for (Train t : trains){
            if(t.getDestination().equalsIgnoreCase(des) && t.getGenSeat() > 0){
                System.out.println("Поїзд\n"+ t);
            }
        }
    }

}


