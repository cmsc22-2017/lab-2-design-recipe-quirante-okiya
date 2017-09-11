//Person -> boolean
// Returns true if this Person  is older than the Person given
// boolean isOlder(Person other) {
//	return false;
// }

/* TEMPLATE
 *  Person(){
 *    ...this.name...      --> String
 *    ...this.pet...       --> inference
 *    ...this.age...       --> int
 *  }
 * 
 *  Cat(){
 *    ...this.name...       --> String
 *    ...this.kind...       --> String
 *    ...this.longhaired... --> boolean
 *  }
 *  
 *  Dog(){
 *   ...this.name... --> String
 *   ...this.kind... --> String
 *   ...this.male... --> boolean
 *  }
 *  
 *  METHOD: 
 *  isOlder(){        --> boolean
 *  }
 */


import tester.Tester;


interface IPet { }

class Person {
  String name;
  IPet pet;
  int age;
  
  Person(String name, IPet pet, int age) {
    this.name = name;
	this.pet = pet;
	this.age = age;
  }
  
  boolean isOlder(Person other){
	  if(this.age > other.age) {
	    return true;
	  }
	  else {
	    return false;
	  }
  }
}

class Cat implements IPet {
  String name;
  String kind;
  boolean longhaired;
  
  Cat(String name, String kind, boolean longhaired) {
   this.name = name;
   this.kind = kind;
   this.longhaired = longhaired;
  }
}

class Dog implements IPet {
  String name;
  String kind;
  boolean male;
  
  Dog(String name, String kind, boolean male) {
    this.name = name;
    this.kind = kind;
    this.male = male;
  }
}

class ExamplesIPet {
  ExamplesIPet() {}
  
  IPet a = new Cat("Franky", "Bengal cat", false);
  IPet b = new Cat("Cutie", "Maine Coon", true);
  IPet c = new Dog("Bantay", "Dalmatian", true);
  IPet d = new Dog("Franco", "Rottweiler", false);
  
  Person frank = new Person("Frank", this.a, 20);
  Person trint = new Person("Trint", this.b, 19);
  Person mike = new Person("Mike", this.c, 24);
  Person kobe = new Person("Kobe", this.d, 40);
  
  boolean testIsOlder(Tester t) {
    return
	  t.checkExpect(this.frank.isOlder(this.trint), true) &&
	  t.checkExpect(this.frank.isOlder(this.kobe), false) &&
	  t.checkExpect(this.mike.isOlder(this.frank), true);
  }
}
