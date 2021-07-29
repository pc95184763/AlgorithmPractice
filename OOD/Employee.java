package OOD;

public class Employee {

  private final String name ;
  private final String id ;
  private  int age ;
  protected   int salary ;
  protected   int level ;
  public Employee(String name, String id) {
    this.name = name;
    this.id = id;
  }
  public void printInfo() {
    System.out.println("Name: "+name + " Age: " + age + " Id:" + id) ;
  }
}
class Manager extends Employee {
    public void xxx() {


    System.out.println(salary) ;
    Employee ee = new Employee("tansen", "123") ;
//    System.out.println(ee.name + ee.age)  ;

    Manager m = new Manager("xiaopang", "32") ;
//    System.out.println(m.name + m.age)  ;

  }
  public Manager(String name, String id) {
    super(name, id);
  }
}





