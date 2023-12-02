package main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambdafunctions;

@FunctionalInterface
public interface IReceivesInformation<T> {
    void receivesInformation(T data);
}
