package Lib;

public abstract class Toy {
    protected String category;
    protected int minAge;

    public Toy(String category, int minAge) {
        this.category = category;
        this.minAge = minAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public abstract void play();
}
