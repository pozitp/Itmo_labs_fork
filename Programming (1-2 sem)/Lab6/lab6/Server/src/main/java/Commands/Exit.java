package Commands;

import Managers.CollectionManager;
import Utility.Command;
import Utility.ExecutionResponse;

/**
 * Команда save: сохраняет коллекцию в файл.
 * @author sh_ub
 */
public class Exit extends Command {
    CollectionManager collectionManager;

    public Exit(CollectionManager collectionManager) {
        super("exit", "выйти из приложения");
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse execute(Object arg) {
        if (arg != null){
            return new ExecutionResponse("Illegal number of arguments!", false);
        }
        collectionManager.saveCollection();
        return new ExecutionResponse("Connection closed", true);
    }
}
