package runtime;

/**
 * Created by liulh on 2018/3/31.
 */

public class ExecuteResult {
    private int exitCode;
    private String executeOut;

    public ExecuteResult(int exitCode, String executeOut) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
    }
}
