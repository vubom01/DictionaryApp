package source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.*;
import java.util.logging.Logger;

public class database {

    private Connection conn;
    private Statement pst;
    public database() {
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                this.conn = DriverManager.getConnection("jdbc:sqlite:dict.db");
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pst = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException throwables) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, throwables);
        }

    }

    public String Lookup(String word){
        String query = "select * from av where word = '" + word + "';";
        ResultSet str = null;
        try {
            str = this.pst.executeQuery(query);
        } catch (SQLException throwables) { }
        String result = "Not found";
        try {
            result = str.getString("html");
        } catch (SQLException throwables) { }
        return result;
    }
}
