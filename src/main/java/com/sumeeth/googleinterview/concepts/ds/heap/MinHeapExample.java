package com.sumeeth.googleinterview.concepts.ds.heap;

import java.util.Arrays;

//Min Heap Example
public class MinHeapExample {

    private Integer[] heap;
    private Integer size; //this represent current size
    private Integer capacity;


    public MinHeapExample() {
        size = 0;
        capacity = 10;
        heap = new Integer[capacity];
    }

    //double the capacity if exceeds tht limit
    private void adjustCapacity() {
        if (size == capacity) {
            capacity = capacity * 2;
            heap = Arrays.copyOf(heap, capacity);
            size++;
        }
    }

    public static void main(String[] args) {
        // Display message
        System.out.println("The Min Heap is ");

        // Creating object opf class in main() methodn
        MinHeapExample minHeap = new MinHeapExample();

        // Inserting element to minHeap
        // using insert() method

        // Custom input entries
        minHeap.addElement(5);
        minHeap.addElement(3);
        minHeap.addElement(17);
        minHeap.addElement(10);
        minHeap.addElement(84);
        minHeap.addElement(19);
        minHeap.addElement(6);
        minHeap.addElement(22);
        minHeap.addElement(9);

        // Print all elements of the heap
        minHeap.print();

        // Removing minimum value from above heap
        // and printing it
        System.out.println("The Min val is "
                + minHeap.remove());

        minHeap.print();

        System.out.println("The Min val is "
                + minHeap.remove());

    }



    //utilityMethods to access heap elements
    public boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    public Integer getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public Integer getParent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    public boolean hasLeftChild(int currentIdx) {
        int leftChildIndex = getLeftChildIndex(currentIdx);
        return leftChildIndex >= 0 && leftChildIndex < size;
    }

    public boolean hasRightChild(int currentIdx) {
        int rightChildIndex = getRightChildIndex(currentIdx);
        return rightChildIndex >= 0 && rightChildIndex < size;
    }

    public Integer getLeftChildIndex(int currentIndex) {
        return (2 * currentIndex) + 1;
    }

    public Integer getRightChildIndex(int currentIndex) {
        return (2 * currentIndex) + 2;
    }

    public Integer getLeftChild(int currentIndex) {
        return heap[getLeftChildIndex(currentIndex)];
    }

    public Integer getRightChild(int currentIndex) {
        return heap[getRightChildIndex(currentIndex)];
    }

    public Integer getMin() {
        return heap[0];
    }
    private boolean isLeaf(int pos)
    {
        return !hasLeftChild(pos);
    }
    public void print()
    {
        for (int i = 0; i < size / 2 && hasLeftChild(i); i++) {

            // Printing the parent and both childrens
            System.out.println(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + getLeftChild(i)
                            + " RIGHT CHILD :" + getRightChild(i));
        }
    }


    public void addElement(Integer newElement) {
        //add element at the end
        //heapyfyUp till new element find its correct position
        adjustCapacity();
        int newElementIdx = size;
        heap[newElementIdx] = newElement;
        heapifyUp(newElementIdx);
        size++;
    }

    private void heapifyUp(Integer newElementIdx) {
        if (hasParent(newElementIdx) && getParent(newElementIdx) > heap[newElementIdx]) {
            swap(getParentIndex(newElementIdx), newElementIdx);
            heapifyUp(getParentIndex(newElementIdx));
        }
    }

    /**
     * this always removes the root element and then find new root
     */
    public Integer remove() {
        //add element at the end
        //heapyfyUp till new element find its correct position
        adjustCapacity();
        Integer removedElement = heap[0];
        heap[0] = heap[size - 1];
        heapifyDown(0);
        size--;
        return removedElement;
    }

    private void heapifyDown(int rootIndex) {
        //root is swapped with last index value
        //now find the right position of new value by swapping it with smaller element
        if(!isLeaf(rootIndex)) {
            int swapPos = !hasRightChild(rootIndex)? getLeftChildIndex(rootIndex):
                                    getLeftChild(rootIndex) < getRightChild(rootIndex) ? getLeftChildIndex(rootIndex)
                                                                                        : getRightChildIndex(rootIndex);
            if (getLeftChild(rootIndex) < heap[rootIndex] || (hasRightChild(rootIndex) && getRightChild(rootIndex) < heap[rootIndex])) {
                swap(swapPos, rootIndex);
                heapifyDown(swapPos);
            }
        }

    }

    public void swap(int index1, int index2) {
        Integer tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }


}
