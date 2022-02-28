import java.util.*;

public class Shop {
    private static Shop shop;
    protected Map<String, Integer> map = new HashMap<>();


    public static Shop getShop() {
        if (shop == null) {
            shop = new Shop();

        }
        return shop;
    }

    public Shop getCreateHashMap() {
        map.put("клубника", 2);
        map.put("вода", 13);
        map.put("кола", 3);
        map.put("водка", 15);
        map.put("хлеб", 4);
        map.put("гетик", 1);
        return this;
    }

    public Shop filter() {

        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()/*.reversed()*/).forEach(System.out::println);
        return this;
    }

    public Shop getCheckMap() {
        System.out.printf("Всего товаров: %s \n", map.size());
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("|Продукт: %s | Стоимость: %s \n", item.getKey(), item.getValue());
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        return this;
    }
}
