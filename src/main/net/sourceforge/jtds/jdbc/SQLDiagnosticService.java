package net.sourceforge.jtds.jdbc;

import java.util.ArrayList;
import java.util.Iterator;

public class SQLDiagnosticService {

    private SQLDiagnosticService() {
        super();
    }

    /**
     * listeners on diagnostic
     */
    private final static ArrayList _diagnosticListeners = new ArrayList();

    /**
     * Adds a listener to receive diagnostic messages.
     * 
     * @param l
     *            the listener to add
     */
    public static void addDiagnosticListener(SQLDiagnosticListener l) {
        synchronized (_diagnosticListeners) {
            _diagnosticListeners.add(l);
        }
    }

    /**
     * Removes a listener receiving diagnostic messages.
     * 
     * @param l
     *            the listener to remove
     */
    public static void removeDiagnosticListener(SQLDiagnosticListener l) {
        synchronized (_diagnosticListeners) {
            _diagnosticListeners.remove(l);
        }
    }

    /**
     * Fire a diagnostic event to the attached listeners.
     * 
     * @param type
     *            <code>PRINT</code>, <code>WARNING</code> or <code>ERROR</code>
     *            .
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
    static void fireDiagnosticEvent(int type, int number, int state, int serverity, String message, String server,
            String procName,
            int line) {
        ArrayList diagnosticListeners = null;
        synchronized (_diagnosticListeners) {
            if (_diagnosticListeners.size() > 0) {
                diagnosticListeners = new ArrayList(_diagnosticListeners);
            }
        }
        if (diagnosticListeners != null) {
            SQLDiagnosticEvent evt = new SQLDiagnosticEvent(type, number, state, serverity, message, server, procName,
                    line);
            Iterator iter = diagnosticListeners.iterator();
            while (iter.hasNext()) {
                ((SQLDiagnosticListener) iter.next()).sqlDiagnostic(evt);
            }
        }
    }
}
