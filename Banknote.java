package Atm;

public class Banknote {
    private int nominal; //nominal of banknote
    private int quant; // quantity of banknotes

    //constructors
    public Banknote() {
    }

    public Banknote(int nominal, int quant) {
        this.nominal = nominal;
        this.quant = quant;
    }

    //getter and setters
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    //toString method
    @Override
    public String toString() {
        return "Banknote{" +
                "nominal=" + nominal +
                ", quantity=" + quant +
                '}';
    }
}
