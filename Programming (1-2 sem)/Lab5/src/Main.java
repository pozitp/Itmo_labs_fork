import Client.StandardConsole;
import Commands.*;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.DumpManager;


import Utility.Runner;
import model.Route;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Utility.Path.getJsonPath;


public class Main {
    public static void main(String[] args) {

        var console = new StandardConsole();
        var dumpManager = new DumpManager(getJsonPath(), console);
        final var collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.init()) {
            System.exit(1);
        }

        var commandManager = new CommandManager() {{
            register("help", new Help(console, this));
            register("info", new Info(console, collectionManager));
            register("show", new Show(collectionManager));
            register("add", new Add(console, collectionManager));
            register("update", new UpdateId(console, collectionManager));
            register("remove_by_id", new RemoveById(console, collectionManager));
            register("clear", new Clear(collectionManager));
            register("save", new Save(collectionManager));
            register("execute_script", new ExecuteScript());
            register("exit", new Exit(console));
            register("remove_first", new RemoveFirst(collectionManager));
            register("sort", new Sort(console, collectionManager));
            register("max_by_name", new MaxByName(collectionManager));
            register("filter_contains_name", new FilterContainsName(console, collectionManager));
            register("print_field_ascending_distance", new PrintFieldAscendingDistance(collectionManager));
        }};
        commandManager.register("history", new History(commandManager, console));
        new Runner(console, commandManager).interactiveMode();
    }
}
