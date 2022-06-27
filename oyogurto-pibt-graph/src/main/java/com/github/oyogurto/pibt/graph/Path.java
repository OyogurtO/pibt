package com.github.oyogurto.pibt.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
@AllArgsConstructor
public class Path {
    List<Node> nodes;
}
