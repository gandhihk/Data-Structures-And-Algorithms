package ds.graphs;

public class DisjointSet {
    int[] rank, size, parent;
    int count;
    DisjointSet(int count){
        this.rank = new int[count];
        this.size = new int[count];
        this.parent = new int[count];
        for(int i=0; i<count; i++){
            rank[i] = 0;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(this.parent[node] == node)
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int node1, int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if(parent1==parent2)
            return;

        if(rank[parent1]<rank[parent2]){
            parent[parent1] = parent2;
        }else if(rank[parent2]<rank[parent1])
            parent[parent2] = parent[parent1];
        else{
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public void unionBySize(int node1, int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if(parent1==parent2)
            return;

        if(size[parent1] > size[parent2]){
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }else{
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
    }

    public static void main(String[] args){
        int size = 5;
        DisjointSet ds = new DisjointSet(size);

        // Perform some union operations
        ds.unionByRank(0, 1);
        ds.unionByRank(2, 3);
        ds.unionByRank(1, 3);

        // Find the representative of each element and print
        // the result
        for (int i = 0; i < size; i++) {
            System.out.println(
                    "Element " + i
                            + " belongs to the set with representative "
                            + ds.findParent(i));
        }

        DisjointSet ds1 = new DisjointSet(size);

        // Perform some union operations
        ds1.unionBySize(0, 1);
        ds1.unionBySize(2, 3);
        ds1.unionBySize(0, 4);

        // Find the representative of each element and print
        // the result
        for (int i = 0; i < size; i++) {
            System.out.println(
                    "Element " + i
                            + " belongs to the set with representative "
                            + ds1.findParent(i));
        }
    }
}
