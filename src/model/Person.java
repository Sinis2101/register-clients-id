package model;

public class Person {

    private IDType idType;
    private String id;

    public Person(IDType idType, String id) {
        this.idType = idType;
        this.id = id;
    }

    public IDType getIdType() {
        return idType;
    }

    public String getId() {
        return id;
    }
}
