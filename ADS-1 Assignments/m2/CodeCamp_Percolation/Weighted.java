import java.util.*;
class Weighted{
    private int[] id;
    private int[] size;
    Weighted(int n) {
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    int root(int p) {
        while(!(p == id[p])) {
            p = id[p];
        }
        return p;
    }
    boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    void Union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if(connected(p, q)) {
            return;
        }
        if(size[pid] < size[qid]) {
            id[pid] = qid;
            size[qid] += size[pid];
        } else {
            id[qid] = pid;
            size[pid] += size[qid];
        }
        // System.out.println(Arrays.toString(id));
        // System.out.println(Arrays.toString(size));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        Weighted wt = new Weighted(num);
        while(!scan.nextLine().equals("end")) {
            int p = Integer.parseInt(scan.nextLine());
            int q = Integer.parseInt(scan.nextLine());
            if (wt.connected(p, q)) continue;
            wt.Union(p, q);
            System.out.println(p + " " + q);
        }
    }
}