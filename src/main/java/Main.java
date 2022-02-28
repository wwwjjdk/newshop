import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Shop.getShop()
                .getCreateHashMap()
                .getCheckMap()
                .filter();
         offer();
    }

    public static void offer() {
        int cost = 0;
        while (true) {
            System.out.println("купить(да/нет)");
            String answer = scanner.nextLine();
            if (answer.equals("да") || answer.equals("yes")) {
                System.out.println("название товара и кол-во(через пробел)");
                String answer1 = scanner.nextLine();
                String[] x = answer1.split(" ");
                cost += pay(x);
            } else {
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("note.txt", true))){
                    bufferedWriter.write(":::::::::::::::::::::::::::::::::::::::::::\nВсего куплено на: " + Integer.toString(cost));
                }catch (IOException e){
                    System.err.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static int pay(String[] x) {
        int number = Integer.parseInt(x[SECOND]);
        String item = x[FIRST];
        int prise = number * Shop.getShop().map.get(item);
        last(prise, number, item);
        return prise;
    }

    public static void last(int prise, int number, String item) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("note.txt", true))) {
            stringBuilder.append("Продукт: " + item);
            stringBuilder.append("| Кол-во: " + number);
            stringBuilder.append("| Куплено на: " + prise + "\n");
            bufferedWriter.write(String.valueOf(stringBuilder));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
