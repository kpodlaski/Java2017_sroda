package zajecia3;

/**
 * Created by Krzysztof Podlaski on 08.03.2017.
 */
public class Test {
    public int number;
    public int number2 = 7;
    private String st;
    private String st2 = "John Doe"; //new String("John Doe");
    static boolean stBool =true;
    static boolean stBool2;

    public Test(){
        System.out.println("Start konstruktora");
        System.out.println("wartosci pól");
        System.out.println(number +";"+number2+";"+st+";"+st2);
        number = 6;
        number2+=number;
        st="Ela";
        st2+=st;
        System.out.println("Koniec konstruktora");
    }

    public static void main(String[] s) throws InterruptedException {
        Test t;
        System.out.println(Test.stBool + ";" + Test.stBool2);
        t = new Test();
        System.out.println(t.number + ";" + t.number2 + ";" + t.st + ";" + t.st2);
        StaticTest st;
        System.out.println("========================");
        st=new StaticTest();
        st.number=13;
        //st=new StaticTest();st=new StaticTest();st=new StaticTest();
        //st=new StaticTest();
        st=null;
        //System.gc();
        Thread.sleep(300);
        /*while (true){
            st=new StaticTest();
        }
        */
    }
}

class StaticTest extends Test{
    private static long maxid;
    public long id;
    public int number;
    static {
        System.out.println("Konstruktor statyczny StaticTest");
    }

    public StaticTest(){
        System.out.println("Start konstruktora StaticTest");
        id= maxid++;
        number=6;
        super.number=18;
    }

    @Override
    public void finalize(){
        System.out.println("Metoda finalize odpalona "+id);
    }
}