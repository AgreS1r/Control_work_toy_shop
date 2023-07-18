// Абстрактный класс, представляющий горячий напиток
abstract class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    // Абстрактный метод, который должен быть реализован в подклассах
    public abstract void drink();
}

// Класс, представляющий горячий напиток с температурой
class HotDrinkWithTemperature extends HotDrink {
    private int temperature;

    public HotDrinkWithTemperature(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void drink() {
        System.out.println("Drinking " + getName() + " at " + getTemperature() + " degrees Celsius");
    }
}

// Интерфейс, представляющий торговый автомат
interface VendingMachine {
    HotDrink getProduct(String name, int volume);
}

// Класс, представляющий горячих напитков автомат
class HotDrinkVendingMachine implements VendingMachine {
    private List<HotDrinkWithTemperature> drinks;

    public HotDrinkVendingMachine() {
        drinks = new ArrayList<>();
        drinks.add(new HotDrinkWithTemperature("Tea", 250, 80));
        drinks.add(new HotDrinkWithTemperature("Coffee", 200, 90));
        drinks.add(new HotDrinkWithTemperature("Cocoa", 300, 70));
    }

    // Метод, который выдает продукт по имени, объему и температуре
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrinkWithTemperature drink : drinks) {
            if (drink.getName().equals(name) && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null;
    }
}

// Основной класс программы
public class Main {
    public static void main(String[] args) {
        HotDrinkWithTemperature tea = new HotDrinkWithTemperature("Tea", 250, 80);
        HotDrinkWithTemperature coffee = new HotDrinkWithTemperature("Coffee", 200, 90);
        
        tea.drink();
        coffee.drink();
        
        HotDrinkVendingMachine vendingMachine = new HotDrinkVendingMachine();
        HotDrinkWithTemperature hotCocoa = (HotDrinkWithTemperature) vendingMachine.getProduct("Cocoa", 300, 70);
        hotCocoa.drink();
    }
}
