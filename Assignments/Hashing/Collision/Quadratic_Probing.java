package Hashing.Collision;

public class Quadratic_Probing {

    private int[] table;
    private int tableSize;

    public Quadratic_Probing(int size) {

        tableSize = size;
        table = new int[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = -1;
        }
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    // Insert
    public void insert(int key) {

        int index = hashFunction(key);

        for (int i = 0; i < tableSize; i++) {

            int newIndex =
                    (index + i * i) % tableSize;

            if (table[newIndex] == -1) {

                table[newIndex] = key;
                return;
            }

            if (table[newIndex] == key) {
                System.out.println("Duplicate key.");
                return;
            }
        }

        System.out.println("Hash Table is full.");
    }

    // Search
    public boolean search(int key) {

        int index = hashFunction(key);

        for (int i = 0; i < tableSize; i++) {

            int newIndex =
                    (index + i * i) % tableSize;

            if (table[newIndex] == key) {
                return true;
            }

            if (table[newIndex] == -1) {
                return false;
            }
        }

        return false;
    }

    // Display
    public void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < tableSize; i++) {

            System.out.print(i + " -> ");

            if (table[i] == -1)
                System.out.println("EMPTY");
            else
                System.out.println(table[i]);
        }
    }

    public static void main(String[] args) {

        Quadratic_Probing hashTable =
                new Quadratic_Probing(7);

        hashTable.insert(10);
        hashTable.insert(17);
        hashTable.insert(24);

        hashTable.display();

        System.out.println(
                "\nSearch 17: " +
                        (hashTable.search(17)
                                ? "Found"
                                : "Not Found")
        );
    }
}