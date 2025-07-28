package com.raiovack.mysql;

import java.sql.*;

/**
 * Class created by Ruan Pereira Mattos, GitHub: <a href="https://github.com/RuanPereiraMattos">Ruan Pereira Mattos</a> to easily connect to mysql with MySQL connector j already included into pom.xml in version 9.0.0
 * <p>
 * Methods of use:
 * <p>
 * 1 - First default constructor is used when your database is in your computer and your username and password are "root" and "root", so you won't need to specify anything, so less job to do
 * <p>
 * 2 - Second default constructor is used when your database is NOT in your computer and your username and password are NOT "root" and "root", so you will need to specify the url, username and password
 * <p>
 * 3 - Third default constructor is used when your database is in your computer but your username and password are NOT "root" and "root", so you will only need to specify the username and password
 */
public class MySQL {

    /**
     * Variable used to connect to MySQL using this default url as value
     */
    private static final String URL = "jdbc:mysql://localhost:3306";
    /**
     * Variable used to connect to MySQL using this default username as value
     */
    private static final String USERNAME = "root";

    /**
     * Variable used to connect to MySQL using this default password as value
     */
    private static final String PASSWORD = "root";
    /**
     * Variable used to, after the constructor call getConnection retrieve the connection to this variable, you can use it to handle mysql inside your own code
     */
    public Connection connection;

    /**
     * Default constructor that calls getConnection method getting URL, USERNAME and PASSWORD from MySQL class as private static final Strings and "return"  to Connection variable the result from getConnection
     * <p>
     * URL = "jdbc:mysql://localhost:3306"
     * <p>
     * USERNAME = "admin"
     * <p>
     * PASSWORD = "admin"
     *
     * @throws SQLException If getConnection method throws SQLException, this exception is thrown back to constructor
     */
    public MySQL() throws SQLException {
        connection = getConnection();
    }

    /**
     * Default constructor that calls getConnection method getting URL, USERNAME and PASSWORD as parameters from user input and "return"  to Connection variable the result from getConnection
     *
     * @param url      Full url to the database. Eg.: "jdbc:mysql://localhost:3306"
     * @param username Username to access MySQL database from URL above
     * @param password Password to access MySQL database from URL above
     * @throws SQLException If getConnection method throws SQLException, this exception is thrown back to constructor
     */
    public MySQL(String url, String username, String password) throws SQLException {
        connection = getConnection(url, username, password);
    }

    /**
     * Default constructor that calls getConnection method getting USERNAME and PASSWORD as parameters from user input and "return"  to Connection variable the result from getConnection
     *
     * @param username Username to access MySQL database from URL from MySQL class above
     * @param password Password to access MySQL database from URL from MySQL class above
     * @throws SQLException If getConnection method throws SQLException, this exception is thrown back to constructor
     */
    public MySQL(String username, String password) throws SQLException {
        connection = getConnection(URL, username, password);
    }

    /**
     * Method used to try to connect to MySQL using URL, USERNAME and PASSWORD from MySQL class as private static final Strings
     *
     * @return It returns connection, the first use case is in the constructor that this return returns back to Connection variable so the user can use connection variable to use it
     * @throws SQLException If anything happens during the connection or something with MySQL itself, it will throw this exception back to the user
     */
    public Connection getConnection() throws SQLException {
        return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Method used to try to connect to MySQL using URL, USERNAME and PASSWORD from user input
     *
     * @param url      Full url to the database. Eg.: "jdbc:mysql://localhost:3306"
     * @param username Username to access MySQL database from URL above
     * @param password Password to access MySQL database from URL above
     * @return It returns connection, the first use case is in the constructor that this return returns back to Connection variable so the user can use connection variable to use it
     * @throws SQLException If anything happens during the connection or something with MySQL itself, it will throw this exception back to the user
     */
    public Connection getConnection(String url, String username, String password) throws SQLException {
        return connection = DriverManager.getConnection(url, username, password);
    }

    /**
     * After calling constructor and verifying if connection variable is not null, use this method to connect to your database passing the database name as parameter
     * <p>
     * Observation, if you are using the constructor with parameters, you can pass your database name together in URL param so is not needed to use this method to connect to your database
     *
     * @param databaseName The name of your database
     * @return Return 0 if the connection was successfully
     * @throws SQLException If anything happens during the connection or something with MySQL itself, it will throw this exception back to the user
     */
    public int use(String databaseName) throws SQLException {
        Statement st = connection.createStatement();
        return st.executeUpdate("use " + databaseName);
    }

    /**
     * Method used to close MySQL connection to the database
     *
     * @throws SQLException If anything happens during the closing of the connections with MySQL itself, it will throw this exception back to the user
     */
    public void close() throws SQLException {
        connection.close();
    }

    /**
     * MySQL class used only to be able to call this class
     *
     * @param args Non used
     */
    public static void main(String[] args) {
        //new Main(Main.URL, Main.USERNAME, Main.PASSWORD);
    }

}