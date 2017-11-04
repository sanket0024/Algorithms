 public class A {
public String doit(int x, int y) {
return "a";
}
public String doit(int... vals) {
return "b"; }
public static void main(String... args)
{
A a=new A();
System.out.println(a.doit(4, 5));}
}