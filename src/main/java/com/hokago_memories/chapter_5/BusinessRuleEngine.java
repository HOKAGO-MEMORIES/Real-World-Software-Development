package com.hokago_memories.chapter_5;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    // private final List<Action> actions;
    private final List<Rule> rules;
    private final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        this.facts = facts;
        this.rules = new ArrayList<>();
        // this.actions = new ArrayList<>();

    }

    /* 이전 코드
    public void addAction(final Action action) {
        this.actions.add(action);
    }

    public int count() {
        return this.actions.size();
    }

    public void run() {
        this.actions.forEach(action -> action.perform(facts));
    }
    */

    // 비즈니스 규칙 엔진이 액션 대신 규칙을 지원하도록 리팩토링

    public void addRule(final Rule rule) {
        this.rules.add(rule);
    }

    public void run() {
        this.rules.forEach(rule -> rule.perform(facts));
    }
}
