package enumtype;

public enum Fruit {
    APPLE,
    BANANA,
    ORANGE;

    // 만약 바나나나 사라지거나 오렌지와 바나나의 순서를 바꾼다면?
    public int getIndexOfFruit() {
        return this.ordinal();
    }
}
