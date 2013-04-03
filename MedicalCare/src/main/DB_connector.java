package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tests.*;
import persons.*;

/**
 * This class allows the core to access and modify data in the database. It also using a design pattern called singleton.
 */
public class DB_connector {

    /**
     * Lets to have only one DB connector. The constructor has to be private to
     * avoid to create another object of this class. With this singleton if we
     * modify one parameters of this class, we modify all the objects of this
     * class.
     */
    private static DB_connector Instance;
    private Actor tempActor;
    private Analysis tempAnalysis;
    private String url, user, password;
    private Connection connect = null;
    private Statement state;
   
    /**
     * The construtor creates a new connector and allows this class to connect and keep the connection to the database.
     */
    private DB_connector() throws SQLException, IOException {
        this.getServerConfig();

        connect = DriverManager.getConnection(this.url, this.user, this.password);
        state = connect.createStatement();
    }
    
    private void getServerConfig() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/res/server_gphy.cfg")));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }

        this.url = br.readLine();
        this.user = br.readLine();
        this.password = br.readLine();

        br.close();
    }
    
    /**
     * This function permits to have only one instance of connection to the database.
     * A new connector is created only if there is no connector yet. Else, the function returns the current connector.
     * This way, all the application uses only one database connector because the application will execute only one query at the same time so, here, we avoid that there are a lot of connectors.
     * @return a DB_connector which can be null or not. If it is not null, it returns the current DB_connector which has been previously created.
     */
    public static DB_connector getInstance() throws SQLException, IOException  {
        if (Instance == null)   {
            Instance = new DB_connector();
        }
        return Instance;
    }

    /**
     * This method extends from the super class Object and permits to close the connection when DB_connector is destroyed.
     * @throws Throwable to raise all errors and exceptions in the Java language.
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            if (state != null) {
                state.close();
            }
            if (connect != null) {
                connect.close();
            }
            System.out.println("Deconnection !");
        } catch (SQLException ex) {
            System.err.println("Error while disconnecting : " + ex.getLocalizedMessage());
        }
    }
    
    

    /**
     *
     * @param p
     */
    public boolean addPatient(Patient p) {
        System.out.println("INSERT INTO Patient VALUES ('', '', '', '', '"+ p.getFirstName() +"', '"+ p.getLastName() +"')");
        return true;
    }

    /**
     *
     * @param bt
     */
    public boolean addBloodTest(BloodTest bt) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param electro
     */
    public boolean addEEG(EEG electro) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param effort
     */
    public boolean addEffortTest(EffortTest effort) {
        throw new UnsupportedOperationException();
    }

    public void addDoctor() {
        throw new UnsupportedOperationException();
    }

    public void addCRA() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return all the daily informations that had not been checked.
     */
    public DailyTest[] getUncheckedInfo() {
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @param user
     */
    public void addUser(String login, String password, String statut) throws SQLException {
        System.out.println("INSERT INTO Testu VALUES ('" + login + "', '" + password + "', '" + statut + "')");
        ResultSet query = this.connect.createStatement().executeQuery("INSERT INTO Testu VALUES ('" + login + "', '" + password + "', '" + statut + "')");
    }
    
    /**
     *
     * @param login
     * @param password
     */
    public void userSelection(String login, String password) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void delPatient(String id) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idDoctor
     */
    public ArrayList<Patient> getDoctorConsultations(int idDoctor) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void getPatient(String id) {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Patient> getListPatient() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idPatient
     * @param day
     */
    public void getDailyTests(String idPatient, String day) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idTest
     */
    public void updateDailyTest(int idTest) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param sg
     */
    public boolean addSubGroup(Group sg) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param p
     */
    public boolean setSubGroup(Patient p) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param p
     * @param g
     */
    public void addPatientToGroup(Patient p, Group g) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public Group getInfoSubGroup(String id) {
        throw new UnsupportedOperationException();
    }
}