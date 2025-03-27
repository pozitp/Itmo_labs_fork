package Commands;

import Managers.CollectionManager;
import Utility.Command;
import Utility.ExecutionResponse;

/**
 * Команда clear: очищает коллекцию.
 * @author sh_ub
 */
public class Clear extends Command {
    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse execute(Object arg) {

        if (arg != null){
            return new ExecutionResponse("Illegal number of arguments!", false);
        }
        collectionManager.clear();
        return new ExecutionResponse("Collection successfully cleared!", true);
    }
}
