package christmas.domain.entity;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", "애피타이저", 6000),
    TAPAS("타파스", "애피타이저", 5500),
    CAESAR_SALAD("시저샐러드", "애피타이저", 8000),
    T_BONE_STEAK("티본스테이크", "메인", 55000),
    BBQ_RIBS("바비큐립", "메인", 54000),
    SEAFOOD_PASTA("해산물파스타", "메인", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25000),
    CHOCOLATE_CAKE("초코케이크", "디저트", 15000),
    ICE_CREAM("아이스크림", "디저트", 5000),
    ZERO_COLA("제로콜라", "음료", 3000),
    RED_WINE("레드와인", "음료", 60000),
    CHAMPAGNE("샴페인", "음료", 25000);

    private final String name;
    private final String section;
    private final int price;
    Menu(String name, String section, int price) {
        this.name = name;
        this.section = section;
        this.price = price;
    }

    public int getTotalPrice(int quantity) {
        return price * quantity;
    }

    public String getSection() {
        return section;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
