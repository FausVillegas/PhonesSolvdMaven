package com.solvd.PhonesHierarchyMaven.phone.customList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CustomLinkedList<T> implements Iterable<T>{
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private Node<T> head;

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAt(int index, T data){
        if(index==0){
            addFirst(data);
        }else{
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            int i = 0;
            while(i<index-1 && current.next!=null){
                current = current.next;
                i++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteFirst(){
        if(head==null){
            LOGGER.debug("The liked list is empty");
        }else{
            head = head.next;
        }
    }

    public void deleteLast(){
        if(head==null){
            LOGGER.debug("The liked list is empty");
        }else{
            if(head.next==null){
                head = null;
            }else {
                Node<T> current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
        }
    }

    public void deleteAt(int index){
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public int length() {
        if (head == null) {
            return 0;
        } else {
            Node<T> currentNode = head;
            int length = 0;
            while (currentNode != null) {
                length++;
                currentNode = currentNode.next;
            }
            return length;
        }
    }

    public void show() {
        if (head == null) {
            LOGGER.debug("The liked list is empty");
        } else {
            Node<T> current = head;
            while (current != null) {
                LOGGER.debug(current.data);
                current = current.next;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }

        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLinkedList<?> that = (CustomLinkedList<?>) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}
