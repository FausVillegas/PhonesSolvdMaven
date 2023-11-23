package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import java.util.Objects;

public class Connectivity {
    private String chargeConnectivity;

    public Connectivity(String chargeConnectivity) {
        this.chargeConnectivity = chargeConnectivity;
    }

    public String getChargeConnectivity() {
        return chargeConnectivity;
    }

    public void setChargeConnectivity(String chargeConnectivity) {
        this.chargeConnectivity = chargeConnectivity;
    }

    @Override
    public String toString() {
        return "Connectivity{" +
                "chargeConnectivity='" + chargeConnectivity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connectivity that = (Connectivity) o;
        return Objects.equals(chargeConnectivity, that.chargeConnectivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chargeConnectivity);
    }
}
