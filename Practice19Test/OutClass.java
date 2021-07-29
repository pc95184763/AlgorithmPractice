package Practice19Test;

public class OutClass {

  public static void main(String[] args) {
    People zhao = new People("Zhao") ;
    People.Bike zhaoBike = zhao.new Bike() ;



    zhaoBike.printAge();

    SharedBikeUser.Bike sharedBike1 = new SharedBikeUser.Bike() ;
    sharedBike1.lock();
    SharedBikeUser.Bike sharedBike2 = new SharedBikeUser.Bike() ;
    SharedBikeUser.Bike sharedBike3 = new SharedBikeUser.Bike() ;
    SharedBikeUser.Bike sharedBike4 = new SharedBikeUser.Bike() ;
    SharedBikeUser.Bike sharedBike5 = new SharedBikeUser.Bike() ;
    SharedBikeUser Anna = new SharedBikeUser("Anna") ;
  }

}

class People {
    String name ;
    int age = 10 ;
    static int height = 20 ;
    People(String name) {
      this.name = name ;
    }
     class Bike {

      String owner = name;
      People p = People.this;
      void printName() {
        System.out.println(name == p.name);
      }
      void printAge() {
        System.out.println(age) ;
      }
      void printHeight() {
        System.out.println(height) ;
      }


    }
}
class SharedBikeUser {
  static String name ;
  int age ;
  SharedBikeUser(String name) {
    this.name = name;
  }

  static class Bike {
    String owner = name ;
    String key ;
    void lock() {

    }


  }
}