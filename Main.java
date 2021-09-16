import java.util.ArrayList;

public class Main {
    static int[] inTime = new int[9];
    static int[] outTime = new int[9];
    static int timer = 1;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 9; i++) { adj.add(new ArrayList<>());}

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(6);
        adj.get(2).add(7);
        adj.get(6).add(8);
        adj.get(7).add(8);
        adj.get(3).add(4);
        adj.get(3).add(5);

        dfs(1, 0, adj);
        int type = 0;
        int oliver = 2;
        int bob = 8;

        if(!isCheck(bob, oliver) && !isCheck(oliver, bob)) System.out.println("No");

        if(isCheck(bob, oliver)) System.out.println("YES");
        else System.out.println("No");
    }

    static void dfs(int src, int parent, ArrayList<ArrayList<Integer>> graph) {
        inTime[src] = timer++;
        for (int x : graph.get(src)) {
            if(x!=parent) {
                dfs(x, src, graph);
            }
        }
        outTime[src] = timer++;
    }

    static boolean isCheck(int x, int y) {
        return inTime[x]>inTime[y] && outTime[x]<outTime[y];
    }
}