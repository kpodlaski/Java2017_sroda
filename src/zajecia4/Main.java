package zajecia4;

import zajecia2.Person;

import java.util.Arrays;

/**
 * Created by Krzysztof Podlaski on 15.03.2017.
 */
public class Main {

    public static void main(String[] a){
        Person[] persons = new Person[5];
        persons[0] = new Person("Ąnna","Annowska");
        persons[1] = new Person("Tomasz","Tomaszewski");
        persons[2] = new Person("Monika","Monikowska");
        persons[3] = new Person("Adam","Adamski");
        persons[4] = new Person("Ewa","Adamska");
        for(Person p : persons){
            System.out.println(p + " "+p.pesel);
        }
        Arrays.sort(persons);
        System.out.println("=================");
        for(Person p : persons){
            System.out.println(p.pesel + " " +p);
        }
        Arrays.sort(persons,
                new PersonComparatorByName());
        System.out.println("=================");
        for(Person p : persons){
            System.out.println(p.pesel + " " +p);
        }
    }
}
