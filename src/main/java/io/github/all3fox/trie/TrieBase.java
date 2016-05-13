package io.github.all3fox.trie;

import java.util.HashMap;
import java.lang.String;

class TrieBase<V> implements Trie<V> {
    private class NodeWithParent {
        Node node; Node parent; Integer n;

        NodeWithParent(Node node, Node parent, Integer n) {
            this.node = node; this.parent = parent; this.n = n;
        }
    }

    private class Node {
        V val = null;
        HashMap<Character, Node> edges = new HashMap<>();

        void put(String key, V val, Integer i) {
            Node self = this;
            for (int n = i; n < key.length(); ++n) {
                if (!self.edges.containsKey(key.charAt(n)))
                    self.edges.put(key.charAt(n), new Node());

                self = self.edges.get(key.charAt(n));
            }

            self.val = val;
        }

        NodeWithParent getNodeWithParent(String key) {
            Node self = this; Node parent = null;

            for (int i = 0; i < key.length(); ++i) {
                if (!self.edges.containsKey(key.charAt(i))) {
                    return new NodeWithParent(self, parent, i);
                }

                parent = self;
                self = self.edges.get(key.charAt(i));
            }

            return new NodeWithParent(self, parent, key.length());
        }

        V get(String key) {
            NodeWithParent nwp = getNodeWithParent(key);
            return key.length() == nwp.n ? nwp.node.val : null;
        }
    }

    private Node root = null;

    private NodeWithParent getNodeWithParent(String key) {
        if (this.root == null) {return new NodeWithParent(null, null, 0);}
        return root.getNodeWithParent(key);
    }

    public V get(String key) {
        if (this.root == null) {return null;}
        return root.get(key);
    }

    public void put(String key, V val) {
        NodeWithParent nwp = getNodeWithParent(key);

        if (nwp.node == null && nwp.parent == null) {
            this.root = new Node();
            nwp.node = this.root;
        }

        nwp.node.put(key, val, nwp.n);
    }
}
