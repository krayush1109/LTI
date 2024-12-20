
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TourPackageOperations{
    private List<TourPackage> packages;

    public TourPackageOperations(){
        this.packages = new ArrayList<>();
    }

    public List<TourPackage> getPackages(){
        return packages;
    }

    public void addPackageToList(TourPackage tourPackage){
        packages.add(tourPackage);
    }

    public void sortPackageByDestination(){
        Collections.sort(packages, Comparator.comparing(TourPackage::getDestination));
    }

    public void sortPackageByPrice(){
        Collections.sort(packages, Comparator.comparing(TourPackage::getPrice));
    }

    public void sortPackageById(){
        Collections.sort(packages, Comparator.comparing(TourPackage::getPackageID));
    }    

}