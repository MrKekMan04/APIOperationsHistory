package ru.netology.vitaliyefimov.entity;

public class Customer {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{ id:" + id + "name: " + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Customer customer = (Customer) o;
        return id == customer.id
                && (name != null && name.equals(customer.getName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int res = 1;
        res = prime * res + id;
        res = prime * res + ((name == null) ? 0 : name.hashCode());
        return res;
    }
}
