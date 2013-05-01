package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/res/server_home.cfg")));
            //br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/res/server_gphy.cfg")));
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
     * When we add a new patient, we suppose that the database manage the auto-incrementation of the id
     * @param p Patient that is going to be recorded into the database 
     */
    public void addPatient(Patient p) throws SQLException {
        String query;
        String d, m, y = "";
        query = "";
        SimpleDateFormat birthdate = new SimpleDateFormat();
        
        birthdate.applyPattern("dd/MM/y");
        d = String.valueOf(p.getBirthDate().get(Calendar.DAY_OF_MONTH));
        m = String.valueOf(p.getBirthDate().get(Calendar.MONTH)+1);
        y = String.valueOf(p.getBirthDate().get(Calendar.YEAR));
        y = y.substring(2);
        
        int sexe = (p.getGender()) ? 0 : 1;
        int inclusion = (p.getInclusion()) ? 1 : 0;
        
//        Recap of the table called Patient
//        PK_ID_PERSONNE
//        PK_ID_GROUPE
//        MED_PK_ID_PERSONNE
//        NOM
//        PRENOM
//        DATE_NAISSANCE DD/MM/YY
//        SEXE 0/1
//        NUM_CHAMBRE
//        STATUT 0/1
//        CAUSE_EXCLU
                
        try {        
            query = "INSERT INTO Patient (NOM, PRENOM, DATE_NAISSANCE, SEXE, STATUT) VALUES ("
                    + "'"+ p.getLastName() +"',"
                    + "'"+ p.getFirstName() +"',"
                    + "'"+ d+"/"+m+"/"+y +"', "
                    + "'"+ sexe +"', "
                    + "'"+ inclusion +"'"
                    + ")";
            
            System.out.println("query : " + query);

            ResultSet rs = this.connect.createStatement().executeQuery(query);
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion du patient => " + ex);
            
        }
    }

    /**
     *
     * @param bt
     */
    public boolean addBloodTest(BloodTest bt) {
        System.out.println("addBloodTest");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param electro
     */
    public boolean addEEG(EEG electro) {
        System.out.println("addEEG");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param effort
     */
    public boolean addEffortTest(EffortTest effort) {
        System.out.println("addEffortTest");
        throw new UnsupportedOperationException();
    }

    public void addDoctor() {
        System.out.println("addDoctor");
        throw new UnsupportedOperationException();
    }

    public void addCRA() {
        System.out.println("addCRA");
        throw new UnsupportedOperationException();
    }

    /**
     * Return all the daily informations that had not been checked.
     */
    public DailyTest[] getUncheckedInfo() {
        System.out.println("getUncheckedInfo");
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
    
    public boolean checkUser(String login) throws SQLException {
        String query = "SELECT COUNT (*) AS Total FROM UTILISATEUR WHERE UTILISATEUR_LOGIN ='" + login + "'";
        
        System.out.println(query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        
        if (rs.getInt("Total") >= 1)    {
            return true;
        }
        else    {
            return false;
        }
    }
    
    /**
     *
     * @param login
     * @param password
     */
    public void userSelection(String login, String password) {
        System.out.println("userSelection");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void delPatient(String id) {
        System.out.println("delPatient");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idDoctor
     */
    public ArrayList<Patient> getDoctorConsultations(int idDoctor) {
        System.out.println("getDoctorConsultations");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public void getPatient(String lastname, String firstname, Calendar birthday) {
        System.out.println("getPatient");
    }

    public ArrayList<Patient> getListPatient() {
        System.out.println("getListPatient");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idPatient
     * @param day
     */
    public void getDailyTests(String idPatient, String day) {
        System.out.println("getDailyTests");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idTest
     */
    public void updateDailyTest(int idTest) {
        System.out.println("updateDailyTest");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param sg
     */
    public boolean addSubGroup(Group sg) {
        System.out.println("addSubGroup");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param p
     */
    public boolean setSubGroup(Patient p) {
        System.out.println("setSubGroup");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param p
     * @param g
     */
    public void addPatientToGroup(Patient p, Group g) {
        System.out.println("addPatientGroup");
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param id
     */
    public Group getInfoSubGroup(String id) {
        System.out.println("getInfoSubGroup");
        throw new UnsupportedOperationException();
    }
}