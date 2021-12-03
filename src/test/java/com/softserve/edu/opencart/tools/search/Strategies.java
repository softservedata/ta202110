package com.softserve.edu.opencart.tools.search;

//
// Factory Method Pattern
//

interface Strategy {
    Search getStrategy();
}

class ImplicitStrategy implements Strategy {
    public Search getStrategy() {
        return new SearchImplicit();
    }
}

class ExplicitStrategyVisible implements Strategy {
    public Search getStrategy() {
        return new SearchExplicitVisible();
    }
}

public enum Strategies {
    DEFAULT_STRATEGY(new ImplicitStrategy()),
    IMPLICIT_STRATEGY(new ImplicitStrategy()),
    EXPLICIT_STRATEGY_VISIBLE(new ExplicitStrategyVisible());

    private Strategy strategy;

    private Strategies(Strategy searchStrategy) {
        this.strategy = searchStrategy;
    }

    public Search getStrategy() {
        return strategy.getStrategy();
    }

}
