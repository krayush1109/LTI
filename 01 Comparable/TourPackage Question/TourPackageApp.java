
public class TourPackageApp{
    public static void main(String[] args) {
        // System.out.println("Hello Wwwwwwwwwwwwww");

        TourPackage tp1 = new TourPackage("109", "Mumbai", 50000.0);
        TourPackage tp2 = new TourPackage("106", "Bhopal", 22000.0);
        TourPackage tp3 = new TourPackage("104", "Kerla", 31000.5);

        TourPackageOperations op = new TourPackageOperations();

        op.addPackageToList(tp1);
        op.addPackageToList(tp2);
        op.addPackageToList(tp3);

        for(TourPackage pkg : op.getPackages()){
            System.out.println(pkg.getPackageID() + ", " + pkg.getDestination() + ", " + pkg.getPrice() );
        }

        // apply a sorting operation
        // op.sortPackageByDestination();
        // op.sortPackageById();
        op.sortPackageByPrice();

        System.out.println("\n------------------");
        for(TourPackage pkg : op.getPackages()){
            System.out.println(pkg.getPackageID() + ", " + pkg.getDestination() + ", " + pkg.getPrice() );
        }

        // tp1.toString();
        // tp2.toString();

    }
}