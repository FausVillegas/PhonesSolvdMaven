package main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambdafunctions;

@FunctionalInterface
public interface ISendsInformation<T> {
    void sendInformation(T data);
}
