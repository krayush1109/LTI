
import java.util.HashMap;
import java.util.Map;

class Basics{
    public static void main(String[] args) {
        System.out.println("Hello");

        Map<String, Integer> mp = new HashMap<>();
        mp.put("Ayush", 12);
        mp.put("Aakash", 45);
        mp.put("Rohit", 19);

        for(Map.Entry<String, Integer> e : mp.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println(mp);
        
        System.out.println(mp.get("Ayush"));
        System.out.println(mp.get("Ayu"));
        System.out.println(mp.get("Kum"));
        System.out.println(mp.containsKey("Kum"));
        System.out.println(mp.containsValue(45));

        

    }
}