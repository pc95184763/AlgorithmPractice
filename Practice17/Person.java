package Practice17;

public class Person {

  public final String name ;
  private int age ;
  public String getName() {
    return name ;
  }
  public int getAge() {
    return age ;
  }

  public Person(String name) {
    this.name = name ;
  }
  public static void main(String[] args) {
    Employee e1 = new Employee("tansen") ;
    
  }
}
class Employee extends Person {

  public Employee(String name) {
    super(name);
  }
}
