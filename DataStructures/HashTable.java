package DataStructures;

public class HashTable {

    private LinkedList[] data;

    HashTable(int size) {
        this.data = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.data[i] = new LinkedList();
        }
    }

    public void insert(String value) {
        int index = Math.abs(hashFunction(value)) % data.length;
        this.data[index].insert(value);
    }

    public boolean delete(String value) {
        int index = Math.abs(hashFunction(value)) % data.length;
        return data[index].delete(value);
    }

    public boolean search(String value) {
        int index = Math.abs(hashFunction(value)) % data.length;
        return data[index].search(value);
    }

    private int hashFunction(String value) {
        int hash = 7;
        for (char c : value.toCharArray()) {
            hash = hash * 31 + c;
        }

        return hash;
    }

    private int jenkinsHash(String value) {
        int hash = 0;

        for (char c : value.toCharArray()) {
            hash += (c & 0xFF);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);

        return hash;
    }
}
