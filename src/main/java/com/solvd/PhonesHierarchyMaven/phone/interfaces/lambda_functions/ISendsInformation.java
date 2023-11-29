package main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions;

@FunctionalInterface
public interface ISendsInformation<T> {
    void sendInformation(T data);
}
