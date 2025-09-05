package com.hokago_memories.chapter_6;

// 트웃의 위치를 저장
public class Position {
    // 최근 확인한 트웃의 위치
    public static final Position INITIAL_POSITION = new Position(-1);
    public final int value;

    public Position(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final Position position = (Position) obj;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public Position next() {
        return new Position(value + 1);
    }
}
