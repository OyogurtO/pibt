package com.github.oyogurto.pibt.model;

import com.github.oyogurto.pibt.graph.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Jingchun.Zhou
 * @since 6/20/2022
 */
@Data
@AllArgsConstructor
public class Config {
    List<Node> nodes;
}
