package chap03.p9.menu;

import java.time.LocalDateTime;

public class Sandwich extends Menu {

    private String ingredients;
    private LocalDateTime expirationDate;

    public Sandwich(String name, int price, String ingredients, LocalDateTime expirationDate) {
        super(name, price);
        this.ingredients = ingredients;
        this.expirationDate = expirationDate;
    }

    @Override
    public String displayInfo() {
        return this.name + ": " + this.price +"원 " + "(재료 : " + this.ingredients +", 만료일 : " + this.expirationDate + ")";
    }

    public String getIngredients() {
        return ingredients;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
