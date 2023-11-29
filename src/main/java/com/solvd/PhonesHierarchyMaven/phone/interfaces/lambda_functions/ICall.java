package main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions;

@FunctionalInterface
public interface ICall<T> {
    void callTo(T contact);
}

