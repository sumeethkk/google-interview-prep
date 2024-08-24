package com.sumeeth.googleinterview.concepts.ds.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;

//Digital tree to store characters of a string in tree format in order to search string with prefix
public class TRIEExample {

    private static class Node {
        Node[] children = new Node[26];
        int size = 0;
        boolean visited = false;

        public int getCharIndex(Character ch) {
            return ch - 'a'; //to get index  of character relative to 'a'
        }

        public Node getNode(Character ch) {
            return children[getCharIndex(ch)];
        }

        public Node setNode(Character ch, Node node) {
            return children[getCharIndex(ch)] = node;
        }

        public void printTrie(Node node){
            if(node == null || node.visited)
                return;

            LinkedList<Node> q = new LinkedList<Node>();

            node.visited = true;
            q.add(node);

            while (!q.isEmpty())
            {
                Node currentNode = q.removeFirst();
                for(int i = 0 ; i<currentNode.size; i++){
                    System.out.println("Current i: "+ i);
                    if(!currentNode.children[i].visited){
                        System.out.println((char) i);
                        currentNode.children[i].visited=true;
                        q.add(currentNode.children[i]);
                    }
                }
            }
        }


        public void addString(String str) {

            addString(str.toLowerCase(), 0);

        }

        public void addString(String str, int index) {
            if (str.length() == index) return;
            Character ch = str.charAt(index);
            Node child = getNode(ch);
            if (child == null) {
                child = new Node();
                setNode(ch, child);
            }
            size++;
            child.addString(str, index + 1);
        }

        public int findCount(String str, int index) {
            if (str.length() == index) return size;
            Character ch = str.charAt(index);
            Node child = getNode(ch);
            if(child == null) return 0;
            else return child.findCount(str, index+1);
        }


    }

    public static void main(String[] args) {
        Node node = new Node();
        node.addString("Hello");
        node.addString("How");
        node.addString("are");
        node.addString("you");
        node.printTrie(node);
    }

}
