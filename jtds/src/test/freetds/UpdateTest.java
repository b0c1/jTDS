package freetds;

import java.sql.*;
import junit.framework.TestCase;

/**
 *  Title: Description: Copyright: Copyright (c) 2001 Company:
 *
 *@author
 *@created    March 17, 2001
 *@version    1.0
 */

public class UpdateTest
         extends BaseTest {

    public UpdateTest(String name)
    {
        super(name);
    }

    public void testTemp()
    throws Exception
    {
        Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );

        stmt.execute( "CREATE TABLE #temp ( pk INT PRIMARY KEY, f_string VARCHAR(30), f_float FLOAT )" );

        //populate in the traditional way
        for ( int i=0; i<100; i++ ) {
            stmt.execute(
                "INSERT INTO #temp "
                + "VALUES( " + i
                + "," +  "'The String " + i + "'"
                + ", " + i + ")"
            );
        }

        dump( stmt.executeQuery( "SELECT Count(*) FROM #temp" ) );

        //Navigate around
        ResultSet rs = stmt.executeQuery( "SELECT * FROM #temp" );

        rs.first();
        dumpRow( rs );

        rs.last();
        dumpRow( rs );

        rs.first();
        dumpRow( rs );

        stmt.execute( "DROP TABLE #temp" );

        stmt.close();
    }

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(UpdateTest.class);
    }
}
