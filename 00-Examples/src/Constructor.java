class Alpha {
    static {
        System.out.println("Alpha Static Block");
    }

    {
        System.out.println("Alpha Instance Block");
    }

    private Alpha() { //6
        System.out.println("Alpha Private Constructor");
    }

    protected Alpha(int x) {
        this();//5
        System.out.println("Alpha Parameterized Constructor: " + x);
    }
}

class Beta extends Alpha {
    static {
        System.out.println("Beta Static Block");
    }

    {
        System.out.println("Beta Instance Block");
    }

    private Beta() {
        super(1);//4
        System.out.println("Beta Private Constructor");
    }
    int a = 0;

    protected Beta(int y) {
        this(); //3
        System.out.println("Beta Parameterized Constructor: " + y);
    }
    public static void h() {
//    	System.out.println(a);// error compile ctime
    }
}

class Gamma extends Beta {
    static {
        System.out.println("Gamma Static Block");
    }

    {
        System.out.println("Gamma Instance Block");
    }

    private Gamma() { //1
        super(2); //2
        System.out.println("Gamma Private Constructor");
    }

    public Gamma(int z) {
        this();
        System.out.println("Gamma Parameterized Constructor: " + z);
    }

    public static Gamma createInstance() {
        return new Gamma();
    }
}

class Outer {
    static int x = 10;

     static class Inner {
        void display() {
            System.out.println("x = " + x);
        }
    }
}


public class Constructor {
    public static void main(String[] args) {
//        System.out.println("Creating first object via factory:");
//        Gamma g1 = Gamma.createInstance();
//
//        System.out.println("----");
//
//        System.out.println("Creating second object via parameterized constructor:");
//        Gamma g2 = new Gamma(10);
    	Outer.Inner obj = new Outer.Inner();
        obj.display(); // x = 10
    }
}