package org.pg4200.datastructure.base.list;

import org.pg4200.datastructure.base.StringContainerWithIndex;

/**
 * Created by arcuri82 on 15-Aug-17.
 */
public class NaiveListStringContainer implements StringContainerWithIndex{

    /*
        For each "value" in the container, we create a TreeNode object to contain it.
        Each node object will have a pointer to the next one in the list, apart
        from the last one (which will have "null")
     */
    private class ListNode{
        String value;
        ListNode next;
    }

    /**
     * The first element in the list
     */
    private ListNode head;


    @Override
    public String get(int index) {

        if(head == null){
            return null;
        }

        //need to traverse all the nodes until the "index"th one.

        ListNode current = head;
        int counter = 0;

        while(current != null){

            if(counter == index){
                //found it
                return current.value;
            }

            //go to the next element
            current = current.next;
            counter++;
        }

        return null;
    }

    @Override
    public void add(String value) {

        ListNode node = new ListNode();
        node.value = value;

        if(head == null){
            //empty container
            head = node;
            return;
        }

        //go to the last element
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = node;
    }

    @Override
    public int size() {

        if(head == null){
            return 0;
        }

        int size = 1;

        //go to the last element
        ListNode current = head;
        while(current.next != null){
            current = current.next;
            size++;
        }

        return size;
    }

    /*
        Why did I call this implementation "naive"?
        Because it is very inefficient: each operation "might" need to traverse
        the entire list.
        So, if you have 1 million elements, it will take much longer than just
        using a backing array.
        However, one advantage here is that we can add as many elements as we want,
        as long as there is enough RAM for it.
     */
}
