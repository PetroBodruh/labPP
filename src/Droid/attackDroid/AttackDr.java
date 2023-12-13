package Droid.attackDroid;

import Droid.Droid;

public class AttackDr extends Droid {
    protected String type = "Attack";

    public AttackDr(String name) {
        super(name, 15, 5, 10, 20);
    }

    @Override
    public String toString() {
        return "Droid:" +
                "type='" + type + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", speed=" + speed +
                ", name='" + name + '\'';
    }

    @Override
    public String getType() {
        return type;
    }
}
