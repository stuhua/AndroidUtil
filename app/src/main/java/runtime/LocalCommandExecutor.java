package runtime;

/**
 * Created by liulh on 2018/3/31.
 */

public interface LocalCommandExecutor {
    ExecuteResult executeCommand(String command, long timeout);
}
