public class Test {

    public static void main(String[] args) {

        String s1 = "1 3 1 3 2 0 0 1 3 0 3 3 3 3 2 1 2 2 1 1 1 2 0 3 1 3 0 0 2 2 2 1 0 2 0 2 3 3 1 1 2 3 1 2 1 1 3 0 2 1 3 3 1 3 2 1 1 1 3 0 1 3 1 3 2 0 0 0 2 1 3 1 2 1 2 2 2 1 2 0 0 3 0 1 0 0 1 3 1 0 0 0 0 3 1 0 3 1 0 0 3 0 2 2 2 2 0 2 0 0 1 1 2 3 0 1 1 2 0 2 0 1 3 0 3 3 2 3 3 2 1 0 3 1 0 2 1 2 3 0 0 0 3 0 1 3 3 0 0 3 2 2 2 2 0 0 0 1 1 1 2 1 1 1 0 1 0 1 3 1 0 1 1 3 1 0 0 1 0 1 1 3 0 1 0 1 2 2 2 2 1 0 2 1 2 2 3 2 0 3 1 2 0 2 0 3 2 3 3 2 3 0 3 1 3 1 3 0 2 0 1 1 0 2 1 3 0 3 2 3 0 3 1 0 2 0 3 0 1 3 1 2 3 1 0 0 3 1 0 1 3 3 1 0 2 0 0 0 2 3 3 1 1 2 3 1 3 0 1 1 3 1 1 0 3 2 1 2 2 2 1 1 1 3 2 3 1 2 2 2 3 0 0 3 1 1 3 0 3 3 3 1 1 2 3 0 0 3 0 1 0 3 3 2 1 2 3 1 3 3 2 0 3 1 3 2 2 2 1 0 1 0 0 1 0 0 1 0 2 1 1 1 2 0 2 1 1 1 0 0 3 3 0 0 2 2 1 0 2 1 0 0 3 2 2 0 3 3 1 1 3 2 1 1 1 1 3 3 2 1 0 3 0 2 0 1 3 2 2 0 2 3 1 1 2 1 3 2 3 3 2 0 0 2 3 1 0 2 3 1 3 2 3 2 2 3 0 2 1 0 2 1 3 0 1 1 2 1 0 0 1 2 1 3 1 1 0 0 0 0 0 3 1 3 2 0 0 0 3 3 0 2 2 0 2 2 2 1 0 2 0 2 2 3 1 0 1 0 3 3 0 2 2 1 1 1 2 1 3 2 2 0 0 1 0 0 1 3 0 0 0 1 1 2 0 0 1 1 1 0";
        String s2 = "2 1 3 0 2 0 3 0 2 1 2 1 2 3 1 1 0 1 2 0 0 0 0 0 2 1 2 1 2 1 0 1 2 0 2 2 1 0 1 2 3 1 0 3 1 3 0 1 0 0 2 1 0 1 0 0 3 0 1 1 3 1 1 3 1 3 2 3 0 1 2 0 2 0 2 1 0 1 1 0 3 1 2 2 0 0 0 3 2 1 1 3 1 1 0 1 3 0 3 0 0 0 3 2 0 3 2 0 1 0 3 1 1 0 3 1 0 0 1 3 2 1 0 1 3 1 0 1 2 1 2 0 2 2 0 2 3 3 1 1 3 1 2 3 0 1 1 1 2 3 0 0 1 0 2 1 0 0 3 3 0 2 2 0 3 2 2 3 3 2 1 0 1 2 1 2 3 3 0 1 3 0 3 1 1 0 2 3 1 1 0 2 1 2 3 1 2 3 2 1 0 3 2 1 3 0 2 1 2 2 0 3 3 0 0 3 0 0 2 2 1 3 0 0 3 2 0 0 0 0 2 3 1 1 1 3 0 0 2 2 2 3 2 3 3 2 3 2 0 3 2 1 3 2 0 1 2 0 0 0 3 0 0 1 2 2 0 2 1 2 0 0 1 1 0 3 1 1 1 3 0 3 1 3 0 2 1 2 1 3 0 1 1 2 1 3 2 2 1 3 3 3 1 3 2 3 2 1 3 3 3 3 2 0 0 0 0 1 1 2 1 1 0 1 2 1 3 2 1 0 2 3 0 2 0 2 3 1 3 1 2 1 1 0 1 3 3 1 0 3 2 2 3 0 2 2 1 1 0 3 2 0 1 1 1 1 3 0 3 0 1 3 3 3 3 1 0 1 2 2 2 1 0 0 2 1 2 3 1 3 3 0 0 3 1 3 0 3 2 1 0 0 3 2 0 3 2 2 1 1 1 1 0 0 2 2 0 2 2 3 1 3 1 3 2 0 1 0 2 0 3 3 1 1 2 0 2 0 3 1 3 2 2 3 1 1 0 2 3 3 1 3 0 2 1 2 0 0 1 2 0 3 2 0 1 2 1 3 3 1 3 0 2 0 2 3 0 3 1 0 3 1 0 1 2 3 1 2 3 3 0 2 0 3 1 0 2 2 3 1";

        StringBuilder sb = new StringBuilder();

        int dif = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            }
            else {
                sb.append("*");
                dif++;
            }

        }
        System.out.println(sb.toString());
        System.out.println(dif);

    }

}
