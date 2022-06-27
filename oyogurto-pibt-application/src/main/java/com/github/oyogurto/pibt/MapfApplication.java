package com.github.oyogurto.pibt;

import com.github.oyogurto.pibt.cli.CommandLineArgEnum;
import com.github.oyogurto.pibt.model.MapfInstance;
import com.github.oyogurto.pibt.solver.*;
import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Jingchun.Zhou
 * @since 6/21/2022
 */
public class MapfApplication {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        for (CommandLineArgEnum arg : CommandLineArgEnum.values()) {
            options.addOption(arg.getOpt(), arg.getLongOpt(), arg.isHasArg(), arg.getDescription());
        }

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        Map<CommandLineArgEnum, Option> optionMap = new HashMap<>(cmd.getOptions().length);
        for (Option option : cmd.getOptions()) {
            optionMap.put(CommandLineArgEnum.getArg(option.getOpt()), option);
        }

        boolean showHelp = optionMap.containsKey(CommandLineArgEnum.HELP);
        if (showHelp) {
            printHelp();
            return;
        }

        String instanceFile = optionMap.get(CommandLineArgEnum.INSTANCE).getValue();
        MapfInstance p = new MapfInstance(instanceFile);

        int maxCompTime = Optional.ofNullable(optionMap.get(CommandLineArgEnum.TIME_LIMIT))
                .map(Option::getValue)
                .map(Integer::parseInt)
                .orElse(-1);
        p.setMaxCompTime(maxCompTime);

        String outputFile = Optional.ofNullable(optionMap.get(CommandLineArgEnum.OUTPUT))
                .map(Option::getValue)
                .orElse(DefaultParams.DEFAULT_OUTPUT_FILE);
        boolean makeScen = optionMap.containsKey(CommandLineArgEnum.MAKE_SCEN);
        if (makeScen) {
            p.makeScenFile(outputFile);
            return;
        }
        String solverName = optionMap.get(CommandLineArgEnum.SOLVER).getValue();
        AbstractMapfSolver solver = getSolver(solverName, p);

        boolean verbose = optionMap.containsKey(CommandLineArgEnum.VERBOSE);
        solver.setVerbose(verbose);

        boolean logShort = optionMap.containsKey(CommandLineArgEnum.LOG_SHORT);
        solver.setLogShort(logShort);

        // solve
        solver.solve();

        if (solver.succeed() && !solver.getSolution().validate(p)) {
            System.out.println("error@mapf: invalid results");
            return;
        }

    }

    static AbstractMapfSolver getSolver(String name, MapfInstance p) {
        switch (name) {
            case Pibt.NAME: return new Pibt(p);
            case Hca.NAME: return new Hca(p);
            case PibtPlus.NAME: return new PibtPlus(p);
            case PushAndSwap.NAME: return new PushAndSwap(p);
            default: return new Pibt(p);
        }
    }

    static void printHelp() {
        // TODO:
    }

}
