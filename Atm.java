package Atm;

import java.util.*;

public class Atm {
    private Set<Banknote> notes = new HashSet<>(); //array to store all loaded banknotes

    public Set<Banknote> getNotes() {
        return notes;
    }

    public void loadMoney(Banknote banknote) {
        notes.add(banknote);
    } //to load money to ATM

    //to get total amount of cash in ATM
    private int totalAmount() {
        int amount = 0;
        for (Banknote note : notes) {
            amount = amount + note.getNominal()*note.getQuant();
        }
        return amount;
    }

    //to get an array of all nominals loaded in ATM
    private int[] getNominal() {
        ArrayList<Integer> nom = new ArrayList<>();
        for (Banknote note : notes) {
            nom.add(note.getNominal());
        }
        int[] nominals = new int[nom.size()];
        for (int i = 0; i < nominals.length; i++) {
            nominals[i] = nom.get(i);
        }
        return nominals;
    }

    //to get requested amount of cash (sum) by all possible combinations using banknotes in ATM
    public void getMoney(int sum) {
        boolean matches = false; //boolean field to keep track of found combos
        if (sum > totalAmount()) {
            System.out.println("Not enough cash in ATM");
        } else {
            ArrayList<Integer> nominalsForRecursion = new ArrayList<>(); //to be used in recursion
            int[] nominals = getNominal(); // array of all nominals
            FindCombos cp = new FindCombos();
            cp.change(nominalsForRecursion, nominals, 0, 0, sum); //finds all combos that add up requested sum

            for (ArrayList<ArrayList> array : cp.combos) {// loop to iterate over all combos
                ArrayList<Banknote> result = new ArrayList<>(); //array to add all possible combos using banknotes in ATM
                Banknote note;
                for (int i = 0; i < array.size(); i++) { //loop to iterate over banknotes (combination of nominal and quantity) in combo
                    ArrayList<Banknote> banknotes = array.get(i);
                    note = banknotes.get(0);
                    for (Banknote inAtm : notes) { //loop to check if there are needed banknotes (nominal and quantity) in ATM
                        if (inAtm.getNominal() == note.getNominal() && inAtm.getQuant() >= note.getQuant()) {
                            result.add(note); //if true, add banknote to result array
                        }
                    }
                }
                if (result.size() == notes.size()) { //all nominals of banknotes must be used
                    System.out.println(result);
                    matches = true;
                }
            }
            if (!matches) { //if no match found
                System.out.println("No match found");
            }
        }
    }
}
