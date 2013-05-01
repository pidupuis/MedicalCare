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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        Recap of the table Analyseeffort
//        PK_ID_ANALYSEEFFORT
//        PK_ID_FICHEQUOTIDIENNE
//        RYTHME_AVANT
//        RYTHME_APRES
//        RYTHME_1MIN_APRES
//        OBSERVATIONS_EFFORT
        System.out.println("addEffortTest");
        throw new UnsupportedOperationException();
    }

    public void addDoctor(Doctor d, MedicalCenter centre, CRA c) throws SQLException {
//        Recap of the table Medecin
//        PK_ID_PERSONNE
//        PK_NOM_CENTRE
//        ARC_PK_ID_PERSONNE
//        NOM
//        PRENOM
        String query = "INSERT INTO Medecin VALUES ('', '"+centre.getName()+"', '"+c.getId()+"', '"+c.getLastName()+"', '"+c.getFirstName()+"')";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
    }

    public void addCRA(CRA c, DataManager dm) throws SQLException {
//        Recap of the table ARC
//        PK_ID_PERSONNE
//        DAT_PK_ID_PERSONNE
//        NOM
//        PRENOM
        String query = "INSERT INTO ARC VALUES ('', '"+dm.getId()+"', '"+c.getLastName()+"', '"+c.getFirstName()+"')";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        
    }

    public void addDataManager(DataManager dm) throws SQLException {
//        Recap of the table ARC
//        PK_ID_PERSONNE
//        NOM
//        PRENOM
        String query = "INSERT INTO ARC VALUES ('', '"+dm.getLastName()+"', '"+dm.getFirstName()+"')";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        
    }

    /**
     * Return all the daily informations that had not been checked.
     */
//    public DailyTest[] getUncheckedInfo() {
//        System.out.println("getUncheckedInfo");
//        throw new UnsupportedOperationException();
//    }
    
    /**
     *
     * @param user
     */
    public void addUser(String id, String login, String password, String statut) throws SQLException {
        String query = "INSERT INTO UTILISATEUR VALUES ('',";
        if (statut.equals("Data Manager"))  {
            query += "'"+ id +"',"
                    + "'',"
                    + "'', ";
        }
        else if (statut.equals("ARC"))  {
            query += "'',"
                    + "'"+ id +"',"
                    + "'', ";
        }
        else {
            query += "'',"
                    + "'',"
                    + "'"+ id +"', ";            
        }
            
        query += "'"+ login +"',"
                    + "'"+ password +"',"
                    + "'"+ statut +"')";
        
            
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
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
    public Actor userSelection(String login, String password) throws SQLException, Exception {
        String query = "SELECT * FROM UTILISATEUR WHERE UTILISATEUR_LOGIN = '" + login + "' AND UTILISATEUR_PASSWORD = '" + password + "'";
        System.out.println(query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        System.out.println("Statut : " + rs.getString("UTILISATEUR_STATUT"));
        
        if (checkUser(login))    {
            String query2;
            switch (rs.getString("UTILISATEUR_STATUT")) {
                case "ARC":
                    {
                        query2 = "SELECT * FROM ARC WHERE PK_ID_PERSONNE = '" + rs.getString("ARC_ID") +  "'";
                        System.out.println("query2 => " + query2);
                        ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
                        rs2.next();
                        return new CRA(rs2.getString("PRENOM"), rs2.getString("NOM"));
                    }
                case "Médecin":
                    {
                        query2 = "SELECT * FROM MEDECIN WHERE PK_ID_PERSONNE = '" + rs.getString("Medecin_ID") +  "'";
                        System.out.println("query2 => " + query2);
                        ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
                        rs2.next();
                        return new Doctor(rs2.getString("PRENOM"), rs2.getString("NOM"));
                    }
                default:
                    {
                        query2 = "SELECT * FROM DATAMANAGER WHERE PK_ID_PERSONNE = '" + rs.getString("DM_ID") +  "'";
                        System.out.println("query2 => " + query2);
                        ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
                        rs2.next();
                        return new DataManager(rs2.getString("PRENOM"), rs2.getString("NOM"));
                    }
            }
        }
        else    {
            return null;
        }
    }

    /**
     * This method update the patient statut to exclude
     * @param id
     */
    public void excludePatient(String id, String why) throws SQLException, Exception {
        String query = "SELECT COUNT (*) AS Total FROM Patient WHERE PK_ID_PERSONNE ='" + id + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        
        try {
            if (rs.getInt("Total") > 0)    {
//                UPDATE [schéma.] Nom_Table [@DBLink]
//                SET  column = expression | (subquery) 
//                    (column1, column2,...) = (subquery)
//             [WHERE (conditions)];
                String update = "UPDATE Patient SET Statut = 0, CAUSE_EXCLU = '" + why + "'"
                        + " WHERE PK_ID_PERSONNE = '" + id + "'";
                System.out.println("update => " + update);
                ResultSet rs2 = this.connect.createStatement().executeQuery(update);
            }
            else    {
                throw new Exception("Erreur de date !");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'exclusion du patient => " + ex);
        }
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
    public Patient getPatient(String lastname, String firstname, String birthday) throws Exception {
        Patient tmpPatient;
        Boolean sexe, inclut;
        int y, m, d;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        String query = "SELECT COUNT (*) AS Total FROM Patient WHERE NOM ='" + lastname + "'"
                + " AND PRENOM = '" + firstname + "' AND DATE_NAISSANCE = '" + birthday + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        if (rs.getInt("Total") > 1)    {
            throw new Exception("This patient is twice in the database !");
        }
        else    {
        
            String query2 = "SELECT PK_ID_PERSONNE, PRENOM, NOM, SEXE, DATE_NAISSANCE, STATUT FROM Patient"
                    + " WHERE NOM = '" + lastname + "' AND PRENOM = '" + firstname + "' AND DATE_NAISSANCE = '" + birthday + "'";

            System.out.println("query2 => " + query2);
            try {
                ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
                rs2.next();
                String id = rs2.getString("PK_ID_PERSONNE");
                SimpleDateFormat birth = new SimpleDateFormat();
                birth.applyPattern("dd/MM/yyyy");

                Pattern p = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{2}).*");
                Matcher match = p.matcher(birthday);

                if (match.find())   {
                    d = Integer.parseInt(match.group(1));
                    m = Integer.parseInt(match.group(2));
                    y = Integer.parseInt(match.group(3));

                    y = (y < (currentYear%100)) ? y + 2000 : y + 1900;
                }
                else    {
                    throw new Exception("Erreur de date !");
                }

                if (rs2.getString("SEXE").equals("0"))    {
                    sexe = false;
                }
                else    {
                    sexe = true;
                }
                if (rs2.getString("STATUT").equals("0"))    {
                    inclut = false;
                }
                else    {
                    inclut = true;
                }
                tmpPatient = new Patient(firstname, lastname, y, m, d, sexe);
                tmpPatient.setInclusion(inclut);
                tmpPatient.setId(id);

                return tmpPatient;
            }
            catch (SQLException ex) {
                System.out.println("Erreur lors de l'obtention du patient => " + ex);
                return null;
            }
        }
    }

    public ArrayList<Patient> getListPatient() throws SQLException, Exception {
        ArrayList<Patient> tmpListPatients = new ArrayList<>();
        Boolean sexe, inclut;
        String query = "SELECT PK_ID_PERSONNE, PRENOM, NOM, SEXE, DATE_NAISSANCE, STATUT FROM Patient";
        SimpleDateFormat birth = new SimpleDateFormat();
        birth.applyPattern("dd/MM/yyyy");
        
        System.out.println("query => " + query);
        
        try {
        
            ResultSet rs = this.connect.createStatement().executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("PK_ID_PERSONNE");
                String firstname = rs.getString("PRENOM");
                String lastname = rs.getString("NOM");
                String birthdate = rs.getString("DATE_NAISSANCE");
                String tabBirthdate[] = new String[3];
                String tabBirthDay[] = new String[2];
                int d, m, y;
                Patient tmpPatient;
                
                Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}).*");
                Matcher match = p.matcher(birthdate);

                if (match.find())   {
                    y = Integer.parseInt(match.group(1));
                    m = Integer.parseInt(match.group(2));
                    d = Integer.parseInt(match.group(3));
                }
                else    {
                    throw new Exception("Erreur de date !");
                }
                
                tabBirthdate = birthdate.split("-");
                tabBirthDay = tabBirthdate[2].split(" ");
                               
                if (rs.getString("SEXE").equals("0"))    {
                    sexe = false;
                }
                else    {
                    sexe = true;
                }
                if (rs.getString("STATUT").equals("0"))    {
                    inclut = false;
                }
                else    {
                    inclut = true;
                }
                tmpPatient = new Patient(firstname, lastname, y, m, d, sexe);
                tmpPatient.setInclusion(inclut);
                tmpPatient.setId(id);
                
                tmpListPatients.add(tmpPatient);
            }
            
            return tmpListPatients;
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'obtention de la listes des patients => " + ex);
            return null;
        }
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
        //faire attention, plus valable quand assignement des groupes
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