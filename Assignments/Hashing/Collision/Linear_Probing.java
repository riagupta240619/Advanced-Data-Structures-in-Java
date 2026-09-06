package Hashing.Collision;

public class Linear_Probing {

    private int[] table;
    private int tableSize;

    public Linear_Probing(int size) {
        tableSize = size;
        table = new int[tableSize];

        // -1 means EMPTY
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
        int startIndex = index;

        while (table[index] != -1) {

            if (table[index] == key) {
                System.out.println("Duplicate key.");
                return;
            }

            index = (index + 1) % tableSize;

            if (index == startIndex) {
                System.out.println("Hash Table is full.");
                return;
            }
        }

        table[index] = key;
    }

    // Search
    public boolean search(int key) {

        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != -1) {

            if (table[index] == key) {
                return true;
            }

            index = (index + 1) % tableSize;

            if (index == startIndex) {
                break;
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

        Linear_Probing hashTable =
                new Linear_Probing(7);

        hashTable.insert(10);
        hashTable.insert(17);
        hashTable.insert(24);

        hashTable.display();

        System.out.println(
                "\nSearch 17: " +
                        (hashTable.search(17) ? "Found" : "Not Found")
        );
    }
}