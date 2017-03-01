package zajecia2;

/**
 * Created by Krzysztof Podlaski on 01.03.2017.
 */
public class Person {
    public String name;
    public String surname;
    public long pesel;

    public Person(String _name, String surname){
        name=_name;
        this.surname=surname;
    }

    @Override
    public String toString() {
        return  name + ' ' + surname ;
    }

    public static void main(String[] a){
        Person p = new Person("Jasio","Kowalski");
        System.out.println(p);

        Person persons1[];
        Person[] persons = new Person[5];
        persons[0] = new Person("Anna","Annowska");
        persons[1] = new Person("Tomasz","Tomaszewski");
        persons[2] = new Person("Monika","Monikowska");
        persons[3] = new Person("Adam","Adamski");
        persons[4] = new Person("Ewa","Adamska");
        for (int i=0; i</*7*/persons.length; i++){
            System.out.println(persons[i]);
            persons[i].pesel=i*1000;
        }
    }
}
