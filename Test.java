package Atm;


public class Test {
    public static void main(String[] args) {
        //creating of all needed banknotes
        Banknote note20 = new Banknote(20, 1);
        Banknote note50 = new Banknote(50, 2);
        Banknote note100 = new Banknote(100, 1);

        //new ATM object
        Atm atm = new Atm();
        //to load money in ATM
        atm.loadMoney(note20);
        atm.loadMoney(note50);
        atm.loadMoney(note100);

        //all possible combinations to get requested sum
        atm.getMoney(120);
    }
}
