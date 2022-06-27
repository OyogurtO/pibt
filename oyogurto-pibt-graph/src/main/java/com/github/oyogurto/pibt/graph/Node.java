package com.github.oyogurto.pibt.graph;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Node {
    @EqualsAndHashCode.Include
    int id;
    Position pos;
    List<Node> neighbor;
}
