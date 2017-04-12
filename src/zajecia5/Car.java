package zajecia5;

/**
 * Created by Krzysztof Podlaski on 22.03.2017.
 */
public class Car {
    public int id;
    public String name;
    public String plateID;
    public int milage;
    private static int lastId = 0;

    public Car(String name, String plateID, int milage) {
        this.id=lastId++;
        this.name = name;
        this.plateID = plateID;
        this.milage = milage;
    }
}
