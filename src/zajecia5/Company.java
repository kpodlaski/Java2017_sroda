package zajecia5;

import java.util.*;

/**
 * Created by Krzysztof Podlaski on 22.03.2017.
 */
public class Company {
    private Map<Driver,Car> driverCarMap = new HashMap<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private static Random rand = new Random();

    public Company(){
        generateDriverList();
        generateCarList();
        randomizeDriverCarMap();
    }

    private void randomizeDriverCarMap() {

    }

    private void generateCarList() {

    }

    private void generateDriverList() {
        drivers.add(new Driver("Adam Tomaszewski","22-12-2022"));
        drivers.add(new Driver("Edward Rózga","11-03-2018"));
        drivers.add(new Driver("Iwona Wrocławska","05-07-2020"));
        drivers.add(new Driver("Magdalena Okruszek","30-04-2021"));
        drivers.add(new Driver("Tomasz Drzazga","12-02-2025"));
        drivers.add(new Driver("Dariusz Bursztyn","27-11-2017"));
        drivers.add(new Driver("Daria Dworska","22-12-2022"));
    }

}
