package zajecia4;

import zajecia2.Person;

import java.util.Comparator;

/**
 * Created by Krzysztof Podlaski on 15.03.2017.
 */
public class PersonComparatorByName
        implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareToIgnoreCase(o2.name);
    }
}
