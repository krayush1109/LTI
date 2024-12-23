
import java.util.HashMap;
import java.util.Map;



class ReviseHashMap {
    public static void main(String args[]){
        System.out.println("Hello");

        Map<Integer, String> mp= new HashMap<>();

        mp.put(1, "Ayush");
        mp.put(2, "Sahil");

        mp.put(1, "Rohit");
        for(Map.Entry<Integer, String> e : mp.entrySet() ){
            System.out.println(e.getKey() + ", " + e.getValue());
        }
        
        

        System.out.println(mp.get(2));
        System.out.println(mp.remove(1));
        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsKey(1));


    }
}