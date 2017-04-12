package zajecia5;

/**
 * Created by Krzysztof Podlaski on 22.03.2017.
 */
public class Driver {
    public int id;
    public String name;
    public String licenceExpireDate; //Data ważności prawa jazdy
    private static int lastId = 0;

    public Driver(String name, String licenceExpireDate) {
        this.id = lastId++;
        this.name = name;
        this.licenceExpireDate = licenceExpireDate;
    }
}
