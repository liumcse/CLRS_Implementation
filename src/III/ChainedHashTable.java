package III;

import java.util.LinkedList;

public abstract class ChainedHashTable {
    private final int size;
    private LinkedList<Data>[] keyTable;

    // data is stored in a key-value pair
    private class Data {
        final int key;
        final int value;

        Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key() { return this.key; }
        int value() { return this.value; }
    }

    // constructor with size specified
    public ChainedHashTable(int size) {
        this.size = size;
        keyTable = new LinkedList[size];
    }

    // default constructor
    public ChainedHashTable() {
        this(500);
    }

    public void insert(int key, int value) {
        // get hash code
        int code = hash(key);

        // insert key to keyTable
        if (keyTable[code] == null) keyTable[code] = new LinkedList<>();
        keyTable[code].add(new Data(key, value));

    }

    public int search(int key) {
        // get hash code
        int code = hash(key);

        // go to the list at specified index
        LinkedList<Data> l = keyTable[code];

        // start searching
        for (Data data : l) {
            if (data.key() == key) return data.value();
        }

        // failure
        return -1;
    }

    public void delete(int key) {
        // get hash code
        int code = hash(key);

        // go to the list at specified index
        LinkedList<Data> l = keyTable[code];

        // start searching
        for (Data data : l) {
            if (data.key() == key) l.remove(data);
        }
    }


    public abstract int hash(int key);

    public static void main(String[] args) {
        ChainedHashTable ht = new ChainedHashTable(7) {
            @Override
            public int hash(int key) {
                return key % 7;
            }
        };

        ht.insert(24, 153);
        ht.insert(7, 12);
        ht.insert(14, 6);
        ht.insert(1, 339);
        ht.insert(234, 12);

        // successful search
        System.out.println("Search for key == 24: " + ht.search(24));
        System.out.println("Search for key == 7: " + ht.search(7));
        System.out.println("Search for key == 14: " + ht.search(14));
        System.out.println("Search for key == 1: " + ht.search(1));
        System.out.println("Search for key == 234: " + ht.search(234));

        // unsuccessful search
        System.out.println("Search for key == 0: " + ht.search(0));

        // delete then search
        ht.delete(14);
        System.out.println("Search for key == 14: " + ht.search(14));



    }
}
