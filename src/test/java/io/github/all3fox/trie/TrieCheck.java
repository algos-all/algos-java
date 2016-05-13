package io.github.all3fox.trie;

import static org.junit.Assert.assertEquals;

class TrieCheck {

    private static String ascii_letters = "abcdefghijklmnopqrstuvwxyz";

    void checkEmpty0(Trie tr) {
        assertEquals(tr.get(""), null);
    }

    void checkEmpty1(Trie tr) {
        assertEquals(null, tr.get(null));
    }

    void checkEmpty2(Trie tr) {
        tr.put("whatever", 42);
        assertEquals(tr.get(""), null);
    }

    void checkSingleLetters(Trie<Integer> tr) {
        for (Integer i = 0; i < ascii_letters.length(); ++i) {
            tr.put("" + ascii_letters.charAt(i), i);
        }

        for (Integer i = 0; i < ascii_letters.length(); ++i) {
            assertEquals(tr.get("" + ascii_letters.charAt(i)), i);
        }
    }

    void checkSimpleChain(Trie<Integer> tr, Integer n) {
        String s = "i";
        for (Integer i = 0; i < n; ++i, s += "i") {
            tr.put(s, i);
        }

        String t = "i";
        for (Integer i = 0; i < n; ++i, t += "i") {
            assertEquals(t, i, tr.get(t));
        }
    }
}
