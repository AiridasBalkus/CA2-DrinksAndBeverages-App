package Model;

// A generic HashTable implementation with key-value pairs
public class HashTable<K, V> {
    private final int TABLE_SIZE = 10; // Fixed table size for simplicity
    private HashNode<K, V>[] table;   // Array to hold hash nodes

    // Constructor to initialize the hash table
    HashTable() {
        table = new HashNode[TABLE_SIZE]; // Initialize array of hash nodes
    }

    // Hash function to calculate the index based on the key
    private int hash(K key) {
        int hash = 0;
        String keyString = key.toString(); // Convert key to string
        for (char c : keyString.toCharArray()) {
            hash = (31 * hash + c) % TABLE_SIZE; // Compute hash value
        }
        return hash; // Return hash index within the table size
    }

    // Method to add or update a key-value pair in the hash table
    public void put(K key, V value) {
        int index = hash(key); // Compute index for the key
        HashNode<K, V> newNode = new HashNode<>(key, value); // Create a new node

        if (table[index] == null) {
            table[index] = newNode; // If no collision, insert node at index
        } else {
            // Handle collision using chaining (linked list)
            HashNode<K, V> current = table[index];
            while (current.next != null && !current.key.equals(key)) {
                current = current.next; // Traverse to find end of chain or matching key
            }
            if (current.key.equals(key)) {
                current.value = value; // Update value if key already exists
            } else {
                current.next = newNode; // Add new node to the end of the chain
            }
        }
    }

    // Method to retrieve a value by its key
    public V get(K key) {
        int index = hash(key); // Compute index for the key
        HashNode<K, V> current = table[index]; // Get the chain head at index
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value; // Return value if key is found
            }
            current = current.next; // Move to the next node in the chain
        }
        return null; // Return null if key is not found
    }

    // Method to remove a key-value pair from the hash table
    public void remove(K key) {
        int index = hash(key); // Compute index for the key
        HashNode<K, V> current = table[index]; // Get the chain head at index
        HashNode<K, V> prev = null; // Pointer to track previous node

        while (current != null && !current.key.equals(key)) {
            prev = current; // Move to next node, tracking the previous node
            current = current.next;
        }

        if (current != null) { // If the key is found
            if (prev == null) {
                table[index] = current.next; // Remove the head node
            } else {
                prev.next = current.next; // Remove the node in the chain
            }
        }
    }

    // Inner static class to represent a node in the hash table
    private static class HashNode<K, V> {
        K key; // Key of the node
        V value; // Value associated with the key
        HashNode<K, V> next; // Pointer to the next node in the chain

        // Constructor to initialize a node with key-value pair
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null; // Initially, no next node
        }
    }
}


