package baseball.computer.hint;

public enum Hint {

    BALL("볼"),

    STRIKE("스트라이크"),

    NOTHING("낫싱");

    private final String name;

    Hint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrintableString(int count) {
        if (this == NOTHING) {
            return this.name;
        }

        return String.format("%d%s", count, this.name);
    }

}
