package zajecia1;

/**
 * Created by Krzysztof Podlaski on 22.02.2017.
 */
public class First {

    public double multiply(double x, double y){
        return x*y;
    }

    @Override
    public String toString() {
        return " obiekt klasy first";
    }

    public static void main(String[] a){
        System.out.println("Coś");
        int i = 12;
        i+=6;
        i=i<<2;
        i=i&7;//^
        double x = 7.8;
        x=i;
        i= (int) x;
        boolean b =false;

        System.out.println(i);
        System.out.println(x);
        First first = new First();
        System.out.println( first.multiply(2,7.5) );
        System.out.println( "ala ma kota o id "+first );
    }
}
