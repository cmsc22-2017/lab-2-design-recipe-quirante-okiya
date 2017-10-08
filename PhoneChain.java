import tester.Tester;

interface ILoPhoneChain {
	
  // -> int
  // counts how many Players are linked in this PhoneChain
  // incuding the caller.
  public int countPlayers();

  // -> int
  //counts how many Players are linked in this PhoneChain
  // excluding the caller.
  public int countPlayersCalled();

  // String -> boolean
  // Returns true if this Player's name,
  // that is to be called, matches the given name.
  public boolean willCall(String name);

  // -> int
  // counts longest sequence of phone calls
  // that have to be made to reach any of the players.
  public int longestChain();

  // -> String
  // returns the name of the player
  public String getName();

  // -> int
  // computes for the longest chain
  public int computeLongestChain();
}



class MtLoPhoneChain implements ILoPhoneChain{
  MtLoPhoneChain(){}

  public int countPlayers() {
    return 0;
  }

  public int countPlayersCalled() {
    return 0;
  }

  public boolean willCall(String name) {
    return false;
  }

  public int longestChain() {
    return 0;
  }

  public String getName() {
    return "";
  }

  public int computeLongestChain() {
    return 0;
  }
}



class ConsLoPhoneChain implements ILoPhoneChain{
  String name;
  ILoPhoneChain player1;
  ILoPhoneChain player2;

  static int temp = 0;

  ConsLoPhoneChain(String name, ILoPhoneChain player1, ILoPhoneChain player2) {
    this.name = name;
    this.player1 = player1;
    this.player2 = player2;
  }

  public int countPlayers() {
    return 1 + this.player1.countPlayers() + this.player2.countPlayers();
  }

  public int countPlayersCalled() {
    return this.countPlayers() - 1;
  }

  public boolean willCall(String name) {
    return this.name.equals(name) || player1.willCall(name) || player2.willCall(name);
  }

  public int longestChain() {
    return this.computeLongestChain() - 1;
  }

  public int computeLongestChain() {
    temp = (this.player1.computeLongestChain() > this.player2.computeLongestChain()) 
	    ? 1 + this.player1.computeLongestChain() : 1 + this.player2.computeLongestChain();
    return temp;
  }

  /* TEMPLATE
  * 
  * Fields:
  * 		...this.name...		--	String
  * 		...this.player1...	--	ILoPhoneChain
  * 		...this.player2...	--	ILoPhoneChain
  * 
  * Methods on ConsLoPhoneChain class:
  * 		...this.countPlayers()...				-- int
  * 		...this.countPlayersCalled()...				-- int
  * 		...this.willCall(String name)...		        -- String
  * 		...this.longestChain()...				-- int
  * 		...this.getName()...					-- String
  *             ...this.computeLongestChain()...                        -- int
  * 
  * Methods on this.player1:
  * 		...this.player1.countPlayers()...				--	int
  * 		...this.player1.countPlayersCalled()...				--	int
  * 		...this.player1.willCall(String name)...			--	String
  * 		...this.player1.longestChain()...				--	int
  * 		...this.player1.getName()...					--	String
  *             ...this.player1.computeLongestChain()...                        -- 	int
  * 
  * Methods on this.player2:
  * 		...this.player2.countPlayers()...				--	int
  * 		...this.player2.countPlayersCalled()...				--	int
  * 		...this.player2.willCall(String name)...			--	String
  * 		...this.player2.longestChain()...				--	int
  * 		...this.player2.getName()...					--	String
  *             ...this.player2.computeLongestChain()...                        -- 	int
  */
  public String getName() {
    return this.name;
  }
}

class ExamplesILoPhoneChain {
  ExamplesILoPhoneChain() {}

  ILoPhoneChain mt = new MtLoPhoneChain();

  ILoPhoneChain tay = new ConsLoPhoneChain("Tay", this.mt, this.mt);
  ILoPhoneChain zoe = new ConsLoPhoneChain("Zoe", this.mt, this.mt);
  ILoPhoneChain meg = new ConsLoPhoneChain("Meg", this.mt, this.mt);
  ILoPhoneChain lou = new ConsLoPhoneChain("Lou", this.mt, this.mt);
  ILoPhoneChain cam = new ConsLoPhoneChain("Cam", this.mt, this.mt);
  ILoPhoneChain eve = new ConsLoPhoneChain("Eve", this.mt, this.mt);
  ILoPhoneChain tam = new ConsLoPhoneChain("Tam", this.mt, this.mt);
  ILoPhoneChain kim = new ConsLoPhoneChain("Kim", this.tay, this.zoe);
  ILoPhoneChain pat = new ConsLoPhoneChain("Pat", this.meg, this.lou);
  ILoPhoneChain ann = new ConsLoPhoneChain("Ann", this.cam, this.eve);
  ILoPhoneChain joy = new ConsLoPhoneChain("Joy", this.tam, this.mt);
  ILoPhoneChain may = new ConsLoPhoneChain("May", this.kim, this.pat);
  ILoPhoneChain bea = new ConsLoPhoneChain("Bea", this.ann, this.joy);
  ILoPhoneChain jen = new ConsLoPhoneChain("Jen", this.may, this.bea);


  boolean testCountPlayersMt(Tester t) {
    return t.checkExpect(this.mt.countPlayers(), 0);
  }

  boolean testCountPlayersCons(Tester t) {
    return 
	t.checkExpect(this.tay.countPlayers(), 1) &&
	t.checkExpect(this.joy.countPlayers(), 2) &&
	t.checkExpect(this.kim.countPlayers(), 3) &&
	t.checkExpect(this.jen.countPlayers(), 14);
 }

  boolean testCountPlayersCalledMt(Tester t) {
    return t.checkExpect(this.mt.countPlayersCalled(), 0);
  }

  boolean testCountPlayersCalledCons(Tester t) {
    return 
	t.checkExpect(this.tay.countPlayersCalled(), 0) &&
	t.checkExpect(this.joy.countPlayersCalled(), 1) &&
	t.checkExpect(this.kim.countPlayersCalled(), 2) &&
	t.checkExpect(this.jen.countPlayersCalled(), 13);
  }

  boolean testWillCallMt(Tester t) {
    return t.checkExpect(this.mt.willCall("Eve"), false);			
  }

  boolean testWillCallCons(Tester t) {
    return 
	t.checkExpect(this.may.willCall("Kim"), true) &&
	t.checkExpect(this.joy.willCall("Yana"), false) &&
	t.checkExpect(this.kim.willCall("Bae"), false) &&
	t.checkExpect(this.jen.willCall("May"), true);
  }

  boolean testLongestChain(Tester t) {
    return 
	t.checkExpect(this.may.longestChain(), 2) &&
	t.checkExpect(this.joy.longestChain(), 1) &&
	t.checkExpect(this.kim.longestChain(), 1) &&
	t.checkExpect(this.jen.longestChain(), 3);
  }
}
