package sample;

public class UserInput{

    private String description;
    private String size;
    private double pieces;
    private double price;

    public UserInput(String description, String size, double pieces, double price) {
        this.description = description;
        this.size = size;
        this.pieces = pieces;
        this.price = price;
    }

    public String getDescription() {return description;}
    public void  setDescription(String description) {this.description = description;}

    public String getSize() {return size;}
    public void  setSize (String size) {this.size = size;}

    public double getPieces() {return pieces;}
    public void  setPieces(double pieces) {this.pieces = pieces;}

    public double getPrice() {return price;}
    public void  setPrice(double price) {this.price = price;}

}