import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private int frequency;

    public Toy(int id, String name, int quantity, int frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void decreaseQuantity() {
        quantity--;
    }
}

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addNewToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyFrequency(int toyId, int newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    public void playToyLottery() {
        List<Toy> prizeToys = selectPrizeToys();
        if (prizeToys.isEmpty()) {
            System.out.println("No toys available to play the lottery.");
            return;
        }

        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        prizeToy.decreaseQuantity();
        savePrizeToyToFile(prizeToy);

        System.out.println("Congratulations! You won a " + prizeToy.getName() + ".");
    }

    private List<Toy> selectPrizeToys() {
        List<Toy> prizeToys = new ArrayList<>();
        Random random = new Random();

        for (Toy toy : toys) {
            int frequency = toy.getFrequency();
            int randomNumber = random.nextInt(100) + 1;

            if (randomNumber <= frequency && toy.getQuantity() > 0) {
                prizeToys.add(toy);
            }
        }

        return prizeToys;
    }

    private void savePrizeToyToFile(Toy prizeToy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(prizeToy.getName() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the prize toy to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy(1, "Teddy Bear", 5, 20);
        Toy toy2 = new Toy(2, "Doll", 10, 30);
        Toy toy3 = new Toy(3, "Race Car", 8, 15);

        toyStore.addNewToy(toy1);
        toyStore.addNewToy(toy2);
        toyStore.addNewToy(toy3);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Toy Store!");
        System.out.println("1. Play Toy Lottery");
        System.out.println("2. Update Toy Frequency");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            toyStore.playToyLottery();
        } else if (choice == 2) {
            System.out.print("Enter the toy ID: ");
            int toyId = scanner.nextInt();
            System.out.print("Enter the new frequency: ");
            int newFrequency = scanner.nextInt();
            toyStore.updateToyFrequency(toyId, newFrequency);
        } else {
            System.out.println("Invalid choice. Exiting the program.");
        }
    }
}
