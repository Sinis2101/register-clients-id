package model;

import exceptions.IDParityException;
import exceptions.IDTypeException;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    private int accessAttempts;
    private List<Person> accessors;
    int currentDay;

    public Marketplace(int currentDay) {
        accessAttempts = 0;
        accessors = new ArrayList<>();
        this.currentDay = currentDay;
    }

    public void attemptAccess(Person person) throws IDParityException, IDTypeException {

        accessAttempts++;

        if(person.getIdType()==IDType.TI) {
            throw new IDTypeException(person.getId());
        } else if(dayIsEven()==person.isEven()) {
            throw new IDParityException(person.getId(), currentDay);
        } else {
            accessors.add(person);
        }

    }

    public int getAccessAttempts() {
        return accessAttempts;
    }

    public List<Person> getAccessors() {
        return accessors;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public boolean dayIsEven() {
        return currentDay%2 == 0;
    }

}
