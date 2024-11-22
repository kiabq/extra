

public class Cookie {
    int numCookies;
    final int DEFAULT_NUM_COOKIES = 48;
    double cupsSugar, cupsButter, cupsFlour, cupsChocolateChips;


    public Cookie() {
        this.numCookies = DEFAULT_NUM_COOKIES;
        calculateIngredients();
    }

    // Constructor with argument for number of cookies
    public Cookie(int numCookies) {
        this.numCookies = numCookies;
        calculateIngredients();
    }

    public void setNumCookies(int numCookies) {
        this.numCookies = numCookies;
    }
    public int getNumCookies() {
        return this.numCookies;
    }

    public void setCupsSugar(double cupsSugar) {
        this.cupsSugar = cupsSugar;
    }
    public double getCupsSugar() {
        return this.cupsSugar;
    }

    public void setCupsButter(double cupsButter) {
        this.cupsButter = cupsButter;
    }
    public double getCupsButter() {
        return this.cupsButter;
    }

    public void setCupsFlour(double cupsFlour) {
        this.cupsFlour = cupsFlour;
    }
    public double getCupsFlour() {
        return this.cupsFlour;
    }

    public void setCupsChocolateChips(double cupsChocolateChips) {
        this.cupsChocolateChips = cupsChocolateChips;
    }
    public double getCupsChocolateChips() {
        return this.cupsChocolateChips;
    }

    public void calculateIngredients() {
        final int COOKIE_BASE = 48;
        this.cupsSugar = numCookies * (1.5 / COOKIE_BASE);
        this.cupsButter = numCookies * (1.0 / COOKIE_BASE);
        this.cupsFlour = numCookies * (2.75 / COOKIE_BASE);
        this.cupsChocolateChips = numCookies * (3.9 / COOKIE_BASE);
    }

    public String toString() {
        return String.format("Ingredients needed for Batch:\n\tNumber of Cookies: %d\n\tCups of Sugar: %.2f\n\tCups of Butter: %.2f\n\tCups of Flour: %.2f\n\tCups of Chocolate Chips: %.2f\n", 
            numCookies, cupsSugar, cupsButter, cupsFlour, cupsChocolateChips);
    }
}
