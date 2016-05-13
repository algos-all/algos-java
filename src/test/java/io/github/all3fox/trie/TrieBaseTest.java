package io.github.all3fox.trie;

import org.junit.Test;

public class TrieBaseTest extends TrieCheck {
    @Test public void testEmpty0() {checkEmpty0(new TrieBase());}
    @Test public void testEmpty1() {checkEmpty1(new TrieBase());}
    @Test public void testEmpty2() {checkEmpty2(new TrieBase());}
    @Test public void testSingleLeters() {checkSingleLetters(new TrieBase<Integer>());}
    @Test public void testSimpleChain() {checkSimpleChain(new TrieBase<Integer>(), 10);}
}