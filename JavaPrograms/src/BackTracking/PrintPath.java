package BackTracking;

public class PrintPath {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        String str = "";
        maze(1,1,rows,cols,str);
    }

    private static void maze(int sr, int sc, int er, int ec, String str) {

        //Check for boundaries
        if(sr > er || sc > ec) {
            return;
        }
        if(sr == er && sc == ec) {
            System.out.println(""+str);
        }
         maze(sr+1,sc,er,ec,str+"D"); // Go Down
         maze(sr,sc+1,er,ec,str+"R"); // Go Right

    }
}
