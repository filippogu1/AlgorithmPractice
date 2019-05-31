package AlgorithmPractice;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args)
    {
        // Creating an empty TreeSet
        TreeSet<Integer> tree_set = new TreeSet<Integer>();

        // Adding the elements using add()
        tree_set.add(1);
        tree_set.add(2);
        tree_set.add(3);
        tree_set.add(4);
        tree_set.add(5);
        tree_set.add(10);
        tree_set.add(20);
        tree_set.add(30);
        tree_set.add(40);
        tree_set.add(50);

        // Creating the tailSet tree
        // NOTE - head_set for the limit value, is EXCLUSIVE!!
        TreeSet<Integer> tail_set = (TreeSet<Integer>)tree_set.tailSet(10);
        TreeSet<Integer> head_set = (TreeSet<Integer>)tree_set.headSet(10);

        // Creating an Iterator
        Iterator<Integer> iter = tail_set.iterator();

        // Displaying the tail set data
        System.out.println("The resultant values from the tail: ");
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }

        iter = head_set.iterator();

        // Displaying the tail set data
        System.out.println("The resultant values from the head: ");
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }
}
