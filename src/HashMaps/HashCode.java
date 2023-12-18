package HashMaps;

public class HashCode {
    public static void main(String[] args) {
        String name="Singh";
        System.out.println(name.hashCode()%1000);
        System.out.println("Dheeraj".hashCode()%1000);
        System.out.println("Yogesh".hashCode()%100);
        Integer v=1234356;
        System.out.println(v.hashCode());
    }
}
