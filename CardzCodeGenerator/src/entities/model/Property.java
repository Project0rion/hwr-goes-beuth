package entities.model;

/**
 * Created by Project0rion on 20.01.2017.
 */
public class Property {

    private String type;
    private String name;
    private boolean isIterable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIterable() {
        return isIterable;
    }

    public void setIterable(boolean iterable) {
        isIterable = iterable;
    }
}
