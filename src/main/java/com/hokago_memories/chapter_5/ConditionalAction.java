package com.hokago_memories.chapter_5;

public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
