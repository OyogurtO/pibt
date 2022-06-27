package com.github.oyogurto.pibt.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
@AllArgsConstructor
public class Position {
    int x;
    int y;

    public int manhattanDist(Position other) {
        return Math.abs(other.x - this.x) + Math.abs(other.y - this.y);
    }

    public double euclideanDist(Position other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
