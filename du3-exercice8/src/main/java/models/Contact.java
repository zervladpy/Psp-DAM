package models;

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact(name=" + name + ", phone=" + phone +")";
    }

    public String getName() {
        return name;
    }


}
