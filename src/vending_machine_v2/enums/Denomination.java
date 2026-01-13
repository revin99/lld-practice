package vending_machine_v2.enums;

public enum Denomination {

    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private int value;

    Denomination(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
