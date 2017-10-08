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
	
	//-> boolean
	// determines whether this Person has a pet with the given name.
	boolean hasPetNamed(String name);
}

// interface of list of pets
interface ILoPet {
	
	//-> boolean
	// determines whether this Person has a pet with the given name.
	boolean hasPetNamed(String name);
	
}

// empty list of pets
class MtLoPet implements ILoPet {
	public MtLoPet(){}
	
	public boolean hasPetNamed(String name) {
		return false;
	}
}

//list of pets
class ConsLoPet implements ILoPet {
	IPet first;
	ILoPet rest;
	
	public ConsLoPet(IPet first, ILoPet rest) {
		this.first = first;
		this.rest = rest;
	}

	public boolean hasPetNamed(String name) {
		if(this.first.hasPetNamed(name)) {
			return true;
		}
		else {
			return this.rest.hasPetNamed(name);
		}
	}
}


class Person {
  String name;
  ILoPet pet;
  int age;
  
  Person(String name, ILoPet pet, int age) {
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
  
  //String -> boolean
  //Returns true if this Dog's name matches the given pet name.
  // TEMPLATE
  /* FIELD:
   * 		... this.name   -- String 
   * 		... this.kind   -- String
   *    ... this.longhaired   -- boolean
   */
	public boolean hasPetNamed(String name) {
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
  
 
  //String -> boolean
  //Returns true if this Dog's name matches the given pet name.
  // TEMPLATE
  /* FIELD:
   * 		... this.name   -- String 
   * 		... this.kind   -- String
   *    ... this.longhaired   -- boolean
   */
	public boolean hasPetNamed(String name) {
		return this.name.equals(name);
	}
}

class ExamplesIPet {
  ExamplesIPet() {}
  
  
  IPet a = new Cat("Franky", "Bengal cat", false);
  IPet b = new Cat("Cutie", "Maine Coon", true);
  IPet c = new Dog("Bantay", "Dalmatian", true);
  IPet d = new Dog("Franco", "Rottweiler", false);
  
  ILoPet mt = new MtLoPet();
  ILoPet catList = new ConsLoPet(this.a, new ConsLoPet(this.b, this.mt));
  ILoPet dogList = new ConsLoPet(this.c, new ConsLoPet(this.d, this.mt));

  Person frank = new Person("Frank", this.catList, 20);
  Person trint = new Person("Trint", this.dogList, 19);
 
  
  boolean testHasPetNamed(Tester t) {
  	return
  		t.checkExpect(this.catList.hasPetNamed("Franky"), true) &&
  		t.checkExpect(this.catList.hasPetNamed("Bantay"), false) &&
  		t.checkExpect(this.dogList.hasPetNamed("Franco"), true) &&
  		t.checkExpect(this.dogList.hasPetNamed("Cutie"), false);
  }
}
