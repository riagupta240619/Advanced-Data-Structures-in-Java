package Hashing.Collision;

public class Double_Hashing {

    private int[] table;
    private int tableSize;

    public Double_Hashing(int size) {

        tableSize = size;
        table = new int[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = -1;
        }
    }

    // First Hash Function
    private int hash1(int key) {

        return key % tableSize;
    }

    // Second Hash Function
    private int hash2(int key) {

        return 7 - (key % 7);
    }

    // Insert
    public void insert(int key) {

        for (int i = 0; i < tableSize; i++) {

            int index =
                    (hash1(key) +
                            i * hash2(key))
                            % tableSize;

            if (table[index] == -1) {

                table[index] = key;
                return;
            }

            if (table[index] == key) {
                System.out.println("Duplicate key.");
                return;
            }
        }

        System.out.println("Hash Table is full.");
    }

    // Search
    public boolean search(int key) {

        for (int i = 0; i < tableSize; i++) {

            int index =
                    (hash1(key) +
                            i * hash2(key))
                            % tableSize;

            if (table[index] == key) {
                return true;
            }

            if (table[index] == -1) {
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

        Double_Hashing hashTable =
                new Double_Hashing(11);

        hashTable.insert(10);
        hashTable.insert(21);
        hashTable.insert(32);

        hashTable.display();

        System.out.println(
                "\nSearch 21: " +
                        (hashTable.search(21)
                                ? "Found"
                                : "Not Found")
        );
    }
}