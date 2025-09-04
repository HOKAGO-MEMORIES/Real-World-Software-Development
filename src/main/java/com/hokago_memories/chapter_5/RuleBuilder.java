package com.hokago_memories.chapter_5;

public class RuleBuilder {
    private final Condition condition;
    /* 개선 전 코드
    이렇게 사용하면 빈 RuleBuilder의 인스턴스화와 createRule() 메서드 호출이라는 문제가 있다.
    private Action action;

    public RuleBuilder when (final Condition condition) {
        this.condition = condition;
        return this;
    }

    public RuleBuilder then (final Action action) {
        this.action = action;
        return this;
    }

    public Rule createRule() {
        return new Rule(condition, action);
    }
    */

    // 사용자가 직접 생성자를 호출하지 못하도로고 함
    // 따라서 다른 진입점을 만듦
    private RuleBuilder(final Condition condition) {
        this.condition = condition;
    }

    // 정적 메서드로 만들어 이 메서드를 직접 호출하면 예전 생성자를 호출하도록 함
    public static RuleBuilder when (final Condition condition) {
        return new RuleBuilder(condition);
    }

    // Rule 객체의 최종 생성을 책임짐
    public Rule then (final Action action) {
        return new Rule(condition, action);
    }
}
