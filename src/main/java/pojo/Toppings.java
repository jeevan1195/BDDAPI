package pojo;

import cucumber.api.java.ro.Si;

import java.util.List;

public class Toppings {

    public List<Topping> getTopping() {
        return topping;
    }

    public void setTopping(List<Topping> topping) {
        this.topping = topping;
    }

    private List<Topping> topping;
}
