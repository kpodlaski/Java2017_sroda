package zajecia4;

import zajecia2.Person;

import java.util.*;

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

        List<Person> lista = new ArrayList<>();
        lista.add(new Person("Ąnna","Annowska"));
        lista.add(new Person("Tomasz","Tomaszewski"));
        lista.add(new Person("Monika","Monikowska"));
        lista.add(new Person("Adam","Adamski"));
        lista.add(new Person("Ewa","Adamska"));
        lista.addAll(Arrays.asList(persons));
        System.out.println("=================");
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i));
        }
        Collections.sort(lista);
        System.out.println("=================");
        Iterator<Person> it = lista.iterator();
        while(it.hasNext()){
            Person p = it.next();
            if (p.name.charAt(0)=='A') {
                System.out.println(p);
            }
            else it.remove();
        }
        System.out.println("======SET========");
        Set<Person> set = new HashSet<>();
        set.addAll(lista);
    }
}
