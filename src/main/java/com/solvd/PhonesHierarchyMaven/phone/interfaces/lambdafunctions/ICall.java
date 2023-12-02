package main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambdafunctions;

@FunctionalInterface
public interface ICall<T> {
    void callTo(T contact);
}

