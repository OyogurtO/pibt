package com.github.oyogurto.pibt.cli;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jingchun.Zhou
 * @since 6/27/2022
 */
@AllArgsConstructor
@Getter
public enum CommandLineArgEnum {
    /**
     * file location of input data
     */
    INSTANCE    ("i", "instance", true, ""),
    /**
     * file location of output result
     */
    OUTPUT      ("o", "output", true, ""),
    /**
     * type of solver
     */
    SOLVER      ("s", "solver", true, ""),
    /**
     * verbose
     */
    VERBOSE     ("v", "verbose", false, ""),
    /**
     * help
     */
    HELP        ("h", "help", false, ""),
    /**
     * time limit
     */
    TIME_LIMIT  ("T", "time-limit", true, ""),
    /**
     * log
     */
    LOG_SHORT   ("L", "log-short", false, ""),
    /**
     * 1
     */
    MAKE_SCEN   ("P", "make-scen", false, ""),
    ;
    String opt;
    String longOpt;
    boolean hasArg;
    String description;

    static Map<String, CommandLineArgEnum> argMap = new HashMap<>();
    static {
        for (CommandLineArgEnum arg : CommandLineArgEnum.values()) {
            argMap.put(arg.opt, arg);
        }
    }
    public static CommandLineArgEnum getArg(String opt) {
        return argMap.get(opt);
    }
}
