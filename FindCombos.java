package Atm;

import java.util.ArrayList;


public class FindCombos {
    public static ArrayList<ArrayList> combos = new ArrayList<>(); //array to save all possible combos

    //method to find all possible combos (recursive method)
    public void change(ArrayList<Integer> nominalsForRecursion, int[] nominals,
                       int highest, int sum, int goal) {

        // to check if the goal is reached.
        if (sum == goal) { //if true, add combo to array of all combos
            ArrayList<ArrayList> combo = new ArrayList<>();
            for (int nominal : nominals) {
                int count = 0;
                for (int nom : nominalsForRecursion) { // Count loop
                    if (nom == nominal) {
                        count++;
                    }
                }
                Banknote note = new Banknote(); //to store nominal and quantity in combo
                note.setNominal(nominal);
                note.setQuant(count);
                ArrayList<Banknote> notes = new ArrayList<>(); //to add all banknotes in combo
                notes.add(note);
                combo.add(notes);
            }
            combos.add(combo); //add arrays of banknotes that make combo
                return;
            }

            if (sum > goal) {
                return;
            }

            // Add higher nominals to a new ArrayList of nominals for recursion.
            for (int value : nominals) {
                if (value >= highest) {
                    ArrayList<Integer> copy = new ArrayList<>();
                    copy.addAll(nominalsForRecursion);
                    copy.add(value);
                    // Recurse to check total and add further banknotes
                    change(copy, nominals, value, sum + value, goal);
                }
            }
        }
}
