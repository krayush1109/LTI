public class TourPackage implements Comparable<TourPackage>{

    private String packageID;
    private String destination;
    private double price;  

    public TourPackage(String packageID, String destination, double price) {
        this.destination = destination;
        this.packageID = packageID;
        this.price = price;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(TourPackage that){
        return this.destination.compareTo(that.destination);
    }

    @Override
    public String toString(){
        System.out.println(this.packageID + ", " + this.destination + ", " + this.price );
        return this.packageID + ", " + this.destination + ", " + this.price;
    }

}