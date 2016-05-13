package io.github.all3fox.trie;

public interface Trie<V> {
    /**
     * Put key-value pair into trie
     * @param key not empty or null
     * @param val not null
     */
    public void put(String key, V val);

    /**
     * Get value based on key
     * @param key not empty or null
     * @return value or null
     */
    public V get(String key);
}
