package net.sourceforge.jtds.jdbc;

import javax.print.attribute.standard.Severity;

public class SQLDiagnosticEvent {
    /**
     * Print event
     */
    public static final int PRINT = 0;

    /**
     * Warning event
     */
    public static final int WARNING = 1;

    /**
     * Exception event
     */
    public static final int EXCEPTION = 2;

    private final int _type;

    private final int _number;

    private final int _state;

    private final int _serverity;

    private final String _message;

    private final String _server;

    private final String _procName;

    private final int _line;

    /**
     * Construct a new diagnostic event of the given type.
     * 
     * @param type
     *            <code>PRINT</code>, <code>WARNING</code> or
     *            <code>ERROR</code>.
     * @param number
     *            SQL Server error number.
     * @param state
     *            SQL Server state code.
     * @param serverity
     *            SQL Server serverity > 10 = error.
     * @param message
     *            SQL Server error message text.
     * @param server
     *            SQL Server name.
     * @param procName
     *            SQL Server stored procedure name.
     * @param line
     *            SQL Server error line number in SQL source.
     */
    SQLDiagnosticEvent(int type, int number, int state, int serverity, String message, String server, String procName,
            int line) {
        _type = type;
        _number = number;
        _state = state;
        _serverity = serverity;
        _message = message;
        _server = server;
        _procName = procName;
        _line = line;
    }

    /**
     * @return Returns the line.
     */
    public final int getLine() {
        return _line;
    }

    /**
     * @return Returns the message.
     */
    public final String getMessage() {
        return _message;
    }

    /**
     * @return Returns the number.
     */
    public final int getNumber() {
        return _number;
    }

    /**
     * @return Returns the procName.
     */
    public final String getProcName() {
        return _procName;
    }

    /**
     * @return Returns the server.
     */
    public final String getServer() {
        return _server;
    }

    /**
     * @return Returns the serverity.
     */
    public final int getServerity() {
        return _serverity;
    }

    /**
     * @return Returns the state.
     */
    public final int getState() {
        return _state;
    }

    /**
     * @return Returns the type.
     */
    public final int getType() {
        return _type;
    }
}
