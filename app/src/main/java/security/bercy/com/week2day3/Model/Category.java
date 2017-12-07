package security.bercy.com.week2day3.Model;

/**
 * Created by Bercy on 12/6/17.
 */

public class Category {
    String type;
    String bodyType;

    @Override
    public String toString() {
        return type +"              " + bodyType;

    }

    public Category(String type, String bodyType) {
        this.type = type;
        this.bodyType = bodyType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
