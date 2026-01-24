package tic_tac_toe_v2_guided.enums;

public enum Symbol {

    X('X'),
    O('O'),
    EMPTY('_');

    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    Symbol(char symbol) {
        this.symbol = symbol;
    }
}
