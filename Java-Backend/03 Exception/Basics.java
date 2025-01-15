
public class Basics{

    public static void main(String[] args) {
        System.out.println("Hello WOrld");

        try {
            int d =0;
            int a = 42/d;
            System.out.println(a);
            
        } catch (Exception e) {
            // e.printStackTrace();            
            System.out.println("Divide by zero - handled");
            
        } finally{
            System.err.println("Finally block executed");
        }

        // System.out.println(a);

    }

}