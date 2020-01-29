public class P2 {
    public void show(Object ob) {
        if (ob.equals(2)) {
        // if (ob == 2) {
            System.out.println("Correct A AND D");
        } else {
            System.out.println("Error B AND C");
        }
    }
    public static void main(String[] args) {
        // String s="ABC";
        int a = 2;
        P2 obj=new P2();
        obj.show(a);
    }
}