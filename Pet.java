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


interface IPet {
	public boolean sameNamePet(String name);
}

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
  
  // -> Person
  // produces this Person whose pet is perished.
  Person petPerish() {
  	return new Person(this.name, new NoPet(), this.age);
  }
}

class NoPet implements IPet{
	NoPet() {}
	
	public boolean sameNamePet(String name) {
		return false;
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
  
  //String -> boolean
  //Returns true if this Person's pet name matches the given pet name.
  // TEMPLATE
  /* FIELD:
   * 		... this.name   -- String 
   * 		... this.kind   -- String
   *    ... this.longhaired   -- boolean
   */
  public boolean sameNamePet(String name) {
	  return this.name.equals(name);
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
  
  
  //String -> boolean
  //Returns true if this Person's pet name matches the given pet name.
  // TEMPLATE
  /* FIELD:
   * 		... this.name   -- String 
   * 		... this.kind   -- String
   *    ... this.longhaired   -- boolean
   */
  public boolean sameNamePet(String name) {
  	return this.name.equals(name);
  }
}

class ExamplesIPet {
  ExamplesIPet() {}
  
  IPet nopet = new NoPet();
  
  IPet a = new Cat("Franky", "Bengal cat", false);
  IPet b = new Cat("Cutie", "Maine Coon", true);
  IPet c = new Dog("Bantay", "Dalmatian", true);
  IPet d = new Dog("Franco", "Rottweiler", false);
  
  Person frank = new Person("Frank", this.a, 20);
  Person trint = new Person("Trint", this.b, 19);
  Person mike = new Person("Mike", this.c, 24);
  Person kobe = new Person("Kobe", this.d, 40);
  Person frank1 = new Person("Frank", nopet, 20);
  Person trint1 = new Person("Trint", nopet, 19);

  
  boolean testIsOlder(Tester t) {
    return
	  t.checkExpect(this.frank.isOlder(this.trint), true) &&
	  t.checkExpect(this.frank.isOlder(this.kobe), false) &&
	  t.checkExpect(this.mike.isOlder(this.frank), true);
  }
  
  boolean testSameNamePet(Tester t) {
  	return
  		t.checkExpect(this.a.sameNamePet("Franky"), true) &&
  		t.checkExpect(this.b.sameNamePet("Trint"), false) &&
  		t.checkExpect(this.c.sameNamePet("Bantay"), true) &&
  		t.checkExpect(this.d.sameNamePet("Dan"), false);
  }
  
  boolean testPetPerish(Tester t) {
  	return
  		t.checkExpect(this.frank.petPerish(), frank1) &&
  		t.checkExpect(this.trint.petPerish(), trint1);
  }
}