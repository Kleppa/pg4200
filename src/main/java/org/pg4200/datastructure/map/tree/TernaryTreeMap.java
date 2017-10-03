package org.pg4200.datastructure.map.tree;

import org.pg4200.datastructure.map.tree.MyTreeBasedMap;

/**
 * Created by Kleppa on 03/10/2017.
 */
public class TernaryTreeMap<K extends Comparable<K>, V> implements MyTreeBasedMap<K, V> {
    protected int size;

    public class TreeNode {

        TreeNode left;
        TreeNode middle;
        TreeNode right;

        private K firstKey;
        private K secondKey;

        private V firstValue;
        private V secondValue;
    }

    protected TreeNode root;

    public void put(K key, V value) {
        root = put(key, value, root);
    }

    @Override
    public TreeNode put(Comparable key, Object value, TreeNode node) {
        if (node == null) {
            node.firstKey = (K) key;
            node.firstValue = (V) value;
            size++;
            return node;

        }
        if (node.secondKey==null){
            node.secondKey = (K) key;
            node.secondValue = (V) value;
            return node;
        }
        int cmp1 = key.compareTo(node.firstKey);
        int cmp2 = key.compareTo(node.secondKey);

        if ((cmp1 ==0)||cmp2==0){
            node.middle=put(key, value, node);
        }
        return node;

    }

    @Override
    public void delete(Comparable key) {

    }

    @Override
    public Object get(Comparable key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }
}
