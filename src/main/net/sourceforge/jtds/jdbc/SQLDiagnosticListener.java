package net.sourceforge.jtds.jdbc;

/**
 * Listener to register on <code>SQLDiagnostic</code> in order to receive
 * errors and warnings.
 * 
 * @author rbargezi
 */
public interface SQLDiagnosticListener {
    /**
     * Called if a diagnostic event is fired.
     * 
     * @param evt the diagnostic event.
     */
    void sqlDiagnostic(SQLDiagnosticEvent evt);

}
