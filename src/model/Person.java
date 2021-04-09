package model;

public class Person {

    private IDType idType;
    private String id;

    public Person(int idType, String id) {
        this.idType = IDType.values()[idType-1];
        this.id = id;
    }

    public IDType getIdType() {
        return idType;
    }

    public String getId() {
        return id;
    }

    public boolean isEven() {

        int idLastNumber = Integer.parseInt(String.valueOf(id.charAt((id.length()-2))));

        return idLastNumber%2 == 0;

    }

}
