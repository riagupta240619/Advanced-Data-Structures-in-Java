package Hashing.Collision;

import java.util.LinkedList;

public class Chaining {

        private final LinkedList<Integer>[] table;
        private final int tableSize;

        @SuppressWarnings("unchecked")
        public Chaining(int size) {
            tableSize = size;

            table = new LinkedList[tableSize];

            for (int i = 0; i < tableSize; i++) {
                table[i] = new LinkedList<>();
            }
        }

        // Hash Function
        private int hashFunction(int key) {
            return key % tableSize;
        }

        // Insert
        public void insert(int key) {
            int index = hashFunction(key);

            if (!table[index].contains(key)) {
                table[index].add(key);
            } else {
                System.out.println(key + " already exists.");
            }
        }

        // Search
        public boolean search(int key) {
            int index = hashFunction(key);

            return table[index].contains(key);
        }

        // Delete
        public void remove(int key) {
            int index = hashFunction(key);

            if (table[index].remove(Integer.valueOf(key))) {
                System.out.println(key + " removed.");
            } else {
                System.out.println(key + " not found.");
            }
        }

        // Display
        public void display() {

            System.out.println("\nHash Table:");

            for (int i = 0; i < tableSize; i++) {

                System.out.print(i + " -> ");

                for (int value : table[i]) {
                    System.out.print(value + " -> ");
                }

                System.out.println("NULL");
            }
        }

        public static void main(String[] args) {

            Chaining hashTable = new Chaining(5);

            hashTable.insert(10);
            hashTable.insert(20);
            hashTable.insert(15);
            hashTable.insert(7);
            hashTable.insert(12);

            hashTable.display();

            System.out.println(
                    "\nSearch 20: " +
                            (hashTable.search(20) ? "Found" : "Not Found")
            );

            hashTable.remove(20);

            hashTable.display();
        }
}
