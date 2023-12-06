package main.java.com.solvd.PhonesHierarchyMaven.threads;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "CallableThread";
    }
}
