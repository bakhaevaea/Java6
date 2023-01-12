package src.main.java.org.example;

public class Computer {
    /* наименование */
    private String name;

    /* фирма производитель */
    private String brand;

    /* Диагональ экрана в дюймах */
    private double diagonal;

    /* Процессор,частота, ГГц */
    private double processor;

    /* Оперативная память, ГБ */
    private int memory;

    /* Операционная система */
    private String os;

    /* Энергоемкостьбатареи, Wh */
    private  int battery;

    /* цена, руб*/
    private int price;

    public Computer(String name, String brand, double diagonal, double processor, int memory, String os, int battery, int price  ){
        this.name = name;
        this.brand = brand;
        this.diagonal = diagonal;
        this.processor = processor;
        this.memory = memory;
        this.os = os;
        this.battery = battery;
        this.price = price;
    }

    public String toString() {
        return "Computer{" +
                "модель ='" + name + '\'' +
                ", бренд = " + brand +
                ", Диагональ экрана в дюймах = '" + diagonal + '\'' +
                ", Процессор,частота, ГГц = " + processor +
                ", Оперативная память, ГБ = " + memory + '\'' +
                ", Операционная система = '" + os + '\'' +
                ", Энергоемкостьбатареи, Wh = '" + battery + '\'' +
                ", Цена, руб = '" + price +
                '}';
    }

    public String getName(){ return name; }
    public String getBrand(){ return brand; }
    public double getDiagonal(){return  diagonal;}
    public double getProcessor(){ return processor;}
    public int getMemory(){ return memory;}
    public String getOs() { return  os;}
    public int getBattery(){ return battery; }
    public int getPrice(){ return price; }

}
