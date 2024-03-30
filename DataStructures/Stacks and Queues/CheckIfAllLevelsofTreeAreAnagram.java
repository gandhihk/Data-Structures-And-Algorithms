package ds.stacksAndQueues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheckIfAllLevelsofTreeAreAnagram {
    static class Node {
        Node left, right;
        int data;

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    public static Node newNode(int data)
    {
        Node temp = new Node(data);
        return temp;
    }

    public static void main(String args[])
    {
        // Constructing both the trees.
        Node root1 = newNode(1);
        root1.left = newNode(3);
        root1.right = newNode(2);
        root1.right.left = newNode(5);
        root1.right.right = newNode(4);

        Node root2 = newNode(1);
        root2.left = newNode(2);
        root2.right = newNode(3);
        root2.left.left = newNode(4);
        root2.left.right = newNode(5);

        if (areAnagrams(root1, root2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static boolean areAnagrams(Node root1, Node root2){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        // Hashmap to store the elements that occur in each level.
        Map<Integer, Integer> map = new HashMap<>();

        while(!q1.isEmpty() && !q2.isEmpty()){
            int n1 = q1.size();             // n1 indicates number of Nodes at current level in first tree
            int n2 = q2.size();             // n2 indicates number of nodes in current level of second tree.

            if(n1!=n2)
                return false;

            //traverse all nodes of current level and add all child nodes of next level to queue
            while(n1-- >0){
                Node node1 = q1.poll();
                //insert q1 element of current level to hashmap
                map.put(node1.data, map.getOrDefault(node1.data, 0)+1);

                if(node1.left!=null)
                    q1.add(node1.left);
                if(node1.right!=null)
                    q1.add(node1.right);
            }

            while(n2-- >0){
                Node node2 = q2.poll();

                // if element from second tree isn't present in the first tree of same level then it can't be an anagram.
                if(!map.containsKey(node2.data))
                    return false;

                //reduce frequency of this element from hashmap, for repeated elements
                map.put(node2.data, map.get(node2.data)-1);
                if(map.get(node2.data)==0)
                    map.remove(node2.data);

                if(node2.left!=null)
                    q2.add(node2.left);
                if(node2.right!=null)
                    q2.add(node2.right);
            }

            // If nodes of current levels are anagrams the hashmap wouldn't contain any elements.
            if (!map.isEmpty())
                return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
