package Stringss;

public class DefangingIpAddress {
    public static void main(String[] args) {
        String s = "1.1.1.1"; // output as 1[.]1[.]1[.]1
        StringBuilder ans = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '.'){
                ans.append("[.]");
                continue;
            }
            ans.append(s.charAt(i));
        }
        System.out.print(ans);
    }
}
