package basic_interface;

public interface inter {
    public void m1();
    public void m2();
    public void m3();
}

abstract class B implements inter{
    public void m1(){
        System.out.println("hello m1");
    }
}
abstract class C implements inter{
    public void m2(){
        System.out.println("hello m2");
    }
}
abstract class D implements inter{
    public void m3(){
        System.out.println("hello m3");
    }
}

