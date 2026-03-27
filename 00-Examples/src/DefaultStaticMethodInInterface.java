interface Animal {
    
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    static void info() {
        System.out.println("This is Animal interface");
    }
}
class A {
	protected static void d() {
		System.out.println("A");
	}
}
class B extends A {
	public static void d() {
		System.out.println("B");
	}
}

class Dog implements Animal {
}

interface Aa {
    void show();
}

interface Bb extends Aa {
    void display();
}

class Test implements Bb {
    public void show() {
        System.out.println("Show");
    }

    public void display() {
        System.out.println("Display");
    }
}

abstract class Aaa {
	public void display() {
		System.out.println("AAA");
	}
}

class Bbb extends Aaa {
	public void display() {
		System.out.println("BBB");
	}
}

public class DefaultStaticMethodInInterface {
    public static void main(String[] args) {
//       Dog d = new Dog();
//        d.sleep(); // object se call
//        
//        Animal.info();   // interface name se call
    	
//    	A a = new B();
//    	a.d(); // static hata diya to B ka chalega.
    	
    	Aaa a = new Bbb(); 
    	a.display(); // same ayega sab me hi BBB.
    }
}