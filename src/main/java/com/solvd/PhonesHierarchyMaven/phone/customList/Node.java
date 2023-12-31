package main.java.com.solvd.PhonesHierarchyMaven.phone.customList;

import java.util.Objects;

public class Node <T>{
    public T data;
    public Node<T> next;
    public Node(T data){
        this.data = data;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
