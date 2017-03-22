package zajecia2;

import java.util.Random;

/**
 * Created by Krzysztof Podlaski on 01.03.2017.
 */
public class Person implements Comparable<Person>{
    public String name;
    public String surname;
    public long pesel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Person person = (Person) o;

        if (pesel != person.pesel) return false;
        if (!name.equalsIgnoreCase(person.name)) return false;
        return surname.equalsIgnoreCase(person.surname);
    }

    @Override
    public int hashCode() {
        int result = 17*name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (int) (pesel ^ (pesel >>> 32));
        return result;
    }

    static Random rand = new Random();

    public Person(String _name, String surname){
        name=_name;
        this.surname=surname;
        pesel=Math.abs(rand.nextLong());
    }

    @Override
    public String toString() {
        return  name + ' ' + surname  + " "+pesel;
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
            persons[i].pesel=Math.abs(rand.nextLong());
        }
        int[] numbers = new int[12];
        for (int i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
            Integer integer =new Integer(numbers[i]);
            int x = integer.intValue();
            x=integer;
        }

        Object[] objects = new Object[8];
        for (int i=0; i<objects.length; i++){
            if (i< persons.length) objects[i]=persons[i];
            else if (i<numbers.length) objects[i]=numbers[i];
            System.out.println(objects[i] + "\t" + objects[i].getClass() );
        }

        System.out.println("===========================");
        for (int i=0; i<persons.length; i++){
            System.out.println(persons[i] + " " + persons[i].pesel);
        }
        System.out.println("===========================");
        System.out.println("======Sortowanie===========");
        System.out.println("===========================");

        for (int i=0; i<persons.length;i++){
            for (int j=i; j<persons.length;j++){
                if (persons[i].pesel<persons[j].pesel){
                    p = persons[j];
                    persons[j]=persons[i];
                    persons[i]=p;
                }
            }
        }

        for (int i=0; i<persons.length; i++){
            System.out.println(persons[i] + " " + persons[i].pesel);
        }

        //Pętla for each.
        for (Person person : persons){
            System.out.println(person.pesel);
        }
    }

    @Override
    public int compareTo(Person o) {
        return Long.signum(this.pesel - o.pesel) ;
    }
}
