package Droid.defendDroid;

import Droid.Droid;

public class DefendDr extends Droid{
    //private final int size=40;
    protected  String type="Defend";

        public DefendDr(String name){
            super(name,60,3,4,40);
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
    public String getType(){return type;}


}
