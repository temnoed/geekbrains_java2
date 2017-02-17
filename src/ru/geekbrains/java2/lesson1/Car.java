package ru.geekbrains.java2.lesson1;

/**
 * Created by Home-pc on 28.09.2016.
 */
public class Car {
    public static  int count = 0;
    //    public static String name1;
//    protected String name2;
//    String name3; //default
    private String name;
    private String nomer;

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        if (nomer.length() > 3) {
            this.nomer = nomer;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Car)) return false;
        Car car = (Car) obj;
        if (!this.name.equals(car.name)) return false;
        if (!this.nomer.equals(car.nomer)) return false;
        return true;
    }


    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }


    public Car(String name, String nomer) {
        this(name);
        this.nomer = nomer;
    }
}
