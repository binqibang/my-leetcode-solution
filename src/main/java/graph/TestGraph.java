package graph;

public class TestGraph {
    public static void main(String[] args) {
        CountHighestScoreNodes counter = new CountHighestScoreNodes();
        int[] parents = new int[] {-1,2,0,2,0};
        counter.countHighestScoreNodes(parents);
    }
}
