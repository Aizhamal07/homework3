package Homeworks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class Drones implements MilitaryWeapons {
    private static final Logger logger = LogManager.getLogger(Drones.class);
    private String name;
    private double cost;
    private int quantity;
    private String functional;

    public Drones(String name, double cost, int quantity, String functional) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.functional = functional;

    }

    @Override
    public String getName() {
        logger.info("Equipment name: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getCost() {
        logger.info(name + " costs " + cost);
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;

    }

    @Override
    public int getQuantity() {
        logger.info("There are " + quantity + " " + name);
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFunctional(String functional) {
        this.functional = functional;
    }

    public String getFunctional() {
        return functional;
    }

    @Override
    public boolean isFunctional() throws DronesException {
        if (functional.equalsIgnoreCase("yes")) {
            logger.info("Great!Still functional...");
            return true;

        } else if (functional.equalsIgnoreCase("no")) {
            logger.info("No problem!We will fix it");
            throw new DronesException("Drone is not functional");
        } else {
            throw new DronesException("Functional status is not valid");
        }
    }

    @Override
    public String toString() {
        return "Drones {" +
                "cost=" + cost +
                ", quantity=" + quantity +
                ", functional=" + functional +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((functional == null) ? 0 : functional.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Drones drones = (Drones) obj;
        return Double.compare(drones.cost, cost) == 0 &&
                quantity == drones.quantity &&
                Objects.equals(functional, drones.functional) &&
                Objects.equals(name, drones.name);
    }
}
