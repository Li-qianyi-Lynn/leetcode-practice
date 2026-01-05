class MyHashMap {

    /** Initialize your data structure here. */
    Integer[] map;
    public MyHashMap() {
        this.map = new Integer[1000001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (this.map[key] == null)
            return -1;
        return this.map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.map[key] = null;
    }
}