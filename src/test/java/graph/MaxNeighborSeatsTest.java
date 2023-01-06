package graph;

import org.junit.jupiter.api.Test;

class MaxNeighborSeatsTest {

    @Test
    void maxNeighborSeats() {
        MaxNeighborSeats mns = new MaxNeighborSeats();
        int[][] seats = new int[][] {
                {1,0,0,1,0,0,0},
                {1,0,0,0,0,1,1},
                {0,0,0,1,0,0,0},
                {1,1,0,1,1,0,0}
        };
        System.out.println(mns.maxNeighborSeats(seats));
    }
}