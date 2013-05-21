package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.exception.EmptySQLResultException;
import main.exception.UnknownUsernameException;
import main.exception.WrongParameterException;
import main.exception.WrongPasswordException;
import main.exception.WrongRoleException;
import persons.*;
import tests.*;

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
    static DB_connector Instance;
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
    
    /**
     * This method is used to get the configuration of the server which is stocked into a file.
     * @throws IOException 
     */
    private void getServerConfig() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/server_home.cfg")));
            //br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/server_gphy.cfg")));
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
    
    private void convert(ResultSet rs) throws SQLException {
        while (rs.next()) {
            LinkedHashMap<String, String> tmpMap = new LinkedHashMap<String, String>();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                tmpMap.put(rs.getMetaData().getColumnName(i), rs.getString(i));
            }
            //this.ret.put(rs.getString(this.idFieldName), tmpMap);
        }
    }
       
    /**
     * When we add a new patient, we suppose that the database manage the auto-incrementation of the id
     * @param p Patient that is going to be recorded into the database 
     */
    public void addPatient(Patient p) throws SQLException {
        String query;
        String d, m, y;
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
            query = "INSERT INTO Patient (NOM, PRENOM, DATE_NAISSANCE, SEXE, STATUT, MED_PK_ID_PERSONNE) VALUES ("
                    + "'"+ p.getLastName() +"',"
                    + "'"+ p.getFirstName() +"',"
                    + "'"+ d+"/"+m+"/"+y +"', "
                    + "'"+ sexe +"', "
                    + "'"+ inclusion +"', "
                    + "'"+ p.getDoctor().getId() + "'"
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
    public void addBloodTest(BloodTest bt, String idFiche) throws Exception {
        int check;
        if (bt.checkAllResults())   {
            check = 1;
        }
        else    {
            check = 0;
        }
        
        String queryAjoutSang = "INSERT INTO AnalyseSang "
                + "VALUES ("
                    + "''," //pk_id_analysesang => auto-increment
                    + "'"+ idFiche +"'," //pk_id_fichequotidienne
                    + "'"+ bt.getHb() +"'," //HEMOGLOBINE
                    + "'"+ bt.getGR() +"'," //TAUX_GLOBULES_ROUGE
                    + "'"+ bt.getGB() +"'," //HEMATOCRITE
                    + "'"+ bt.getHemato() +"'," //TAUX_GLOBULES_ROUGE
                    + "'"+ bt.getP() +"'," //PLAQUETTES
                    + "'"+ bt.getObservations() +"'," //OBSERVATIONS_SANG
                    + "'"+ check +"'" //CORRECT_SANG
                    + ")";
        System.out.println("queryAjout => " + queryAjoutSang);
        ResultSet rsAjoutSang = this.connect.createStatement().executeQuery(queryAjoutSang);
        rsAjoutSang.next();    	
    }

    /**
     *  This method permits to add an EEG analysis into the database.
     * @param electro contains all the information about the EEG analysis
     * @param p is the patient link to the EEG analysis
     */
    public void addEEG(EEG electro, String idFiche) throws SQLException {
        String query = "INSERT INTO analyseeeg "
                + "VALUES ("
                + "''," //PK_ID_ANALYSEEEG
                + "'"+ idFiche +"'," //PK_ID_FICHEQUOTIDIENNE
                + "'"+ electro.getResult() +"'," //RESULTAT_EEG
                + "'"+ electro.getObservations() +"')"; //OBSERVATIONS_EEG
        System.out.println("query : " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
    }

    /**
     *
     * @param effort
     */
    public void addEffortTest(EffortTest effort, String idFiche) throws SQLException {
        String query = "INSERT INTO analyseeffort "
                + "VALUES ("
                + "''," //PK_ID_ANALYSEEFFORT
                + "'"+ idFiche +"'," //PK_ID_FICHEQUOTIDIENNE
                + "'"+ effort.getBeforeEffort() +"'," //RYTHME_AVANT
                + "'"+ effort.getPostEffort() +"'," //RYTHME_APRES
                + "'"+ effort.getTimePlusOne() +"'," //RYTHME_1MIN_APRES
                + "'"+ effort.getObservations() +"')"; //OBSERVATIONS_EFFORT
        System.out.println("query : " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
    }
    
    public boolean checkIfAnalysisExists(String analyse, String idPatient) throws WrongParameterException, SQLException {
        String table;
        if ((!(analyse.equals("eeg"))) && (!(analyse.equals("sang"))) && (!(analyse.equals("effort"))))  {
            throw new WrongParameterException("Le type d'analyse doit être 'eeg' ou 'valide' ou 'sang' ou 'effort' !");
        }
        else    {
            if (analyse.equals("eeg")) {
                table = "analyseEEG";
            }
            else if (analyse.equals("eeg")) {
                table = "analyseSang";
            }
            else    {
                table = "analyseEffort";                
            }
            String queryEEG = "SELECT COUNT(*) AS total FROM "+ table +" "
                    + "JOIN fichequotidienne "
                    + "ON "+ table +".pk_id_fichequotidienne = fichequotidienne.pk_id_fichequotidienne  "
                    + "JOIN rempli_fiche "
                    + "ON fichequotidienne.pk_id_fichequotidienne = rempli_fiche.pk_id_fichequotidienne "
                    + "WHERE rempli_fiche.pk_id_personne = '"+ idPatient +"'";
            System.out.println("query => " + queryEEG);
            ResultSet rs = this.connect.createStatement().executeQuery(queryEEG);
            rs.next();
            if (rs.getString("total").equals("1")) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    /**
     * This method is called to add a new doctor into the database.
     * @param d Reference to the doctor which contains all information that the database needed.
     * @param centre Reference to the center because the doctor is linked to a medical center
     * @param c Reference to the CRA who is the manager of the doctor
     * @throws SQLException to lead the errors until the main program
     */
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
    
    /**
     * This method is called to add a new CRA into the database
     * @param c Reference to the CRA which contains all information needed
     * @param dm Reference to the data manager who is the manager of the CRA
     * @throws SQLException to lead the errors until the main program
     */
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
    
    /**
     * This method is called to add a new data manager into the database
     * @param dm Reference to the data manager which contains all information needed
     * @throws SQLException to lead the errors until the main program
     */
    public void addDataManager(DataManager dm) throws SQLException {
//        Recap of the table ARC
//        PK_ID_PERSONNE
//        NOM
//        PRENOM
        String query = "INSERT INTO DATAMANAGER VALUES ('', '"+dm.getLastName()+"', '"+dm.getFirstName()+"')";
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
     * This method allows the DB_connector to add a new user who is could be a doctor or a cra or a data manager. Use it cautiously.
     * @param id Caution : this parameter has to be getted before. This identifier is the id of the user (CRA, doctor, data manager). It corresponds to the identifier which is saved in the corresponding table (CRA, doctor or data manager).
     * @param login Caution : this parameter has also been created when a CRA or a doctor or a data manager is created. You have to give this login as parameter.
     * @param password Caution : this parameter has also been created when a CRA or a doctor or a data manager is created. You have to give this password as parameter.
     * @param statut Indicate the status of the user (CRA or doctor or data manager). This is the correspondance : 1 => Data Manager    ;   2 => CRA    ;   3 => Doctor
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicate to the main program when the status is wrong
     */
    public void addUser(String id, String login, String password, int statut, String question) throws SQLException, Exception {
        String query = "INSERT INTO UTILISATEUR VALUES ('',";
        String job = "";
        
        if (statut == 1)  {
            query += "'"+ id +"',"
                    + "'',"
                    + "'', ";
            job = "Data Manager";
        }
        else if (statut == 2)  {
            query += "'',"
                    + "'"+ id +"',"
                    + "'', ";   
            job = "ARC";
        }
        else if (statut == 3)   {
            query += "'',"
                    + "'',"
                    + "'"+ id +"', ";       
            job = "Médecin";
        }
        else    {
            throw new Exception("Ce statut n'existe pas !");
        }
            
        query += "'"+ login +"',"
                    + "'"+ password +"',"
                    + "'"+ job +"',"
                    + "'"+ question +"')";
        
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
    }
    
    /**
     * This method indicates if the login given in parameter already exists or not
     * @param login This is the login of the user which is created by the constructor of child of Actor class (CRA, doctor, data manager)
     * @return a boolean : true if the login is already taken, else false.
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     */
    public boolean checkUser(String login) throws SQLException {
        String query = "SELECT COUNT (*) AS Total FROM UTILISATEUR WHERE UTILISATEUR_LOGIN ='" + login + "'";
        System.out.println(query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        if (rs.next() && rs.getInt("Total") >= 1)    {
            return true;
        }
        else    {
            return false;
        }
    }
    
    public int getUserId(String firstname, String lastname, int statut) throws SQLException, Exception {
        String table = "";
        if (statut == 1) {
            table = "DATAMANAGER";
        }
        else if (statut == 2) {
            table = "ARC";
        }
        else if (statut == 3) {
            table = "MEDECIN";
        }
        else    {
            throw new Exception("Ce statut n'existe pas !");
        }
        
        String query = "SELECT COUNT (*) AS Total FROM "+ table +" WHERE "
                + "NOM ='" + lastname + "' AND PRENOM = '" + firstname + "'";
        System.out.println(query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        if (rs.getInt("Total") == 1)    {
            String query2 = "SELECT PK_ID_PERSONNE FROM "+ table +" WHERE "
                + "NOM ='" + lastname + "' AND PRENOM = '" + firstname + "'";
            System.out.println(query2);
            ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
            rs2.next();
            return rs2.getInt("PK_ID_PERSONNE");
        }
        else if (rs.getInt("Total") == 0)    {
            throw new Exception("This user does not exist ! ");
        }
        else    {
            throw new Exception("ATTENTION : Cet utilisateur existe au moins deux fois !");
        }
    }
    
    /**
     * This method returns an Actor (CRA or doctor or data manager). It could be used by the HCI to know which interface display to the user thanks to the status which is recorded into the database.
     * @param login This is the login of the user
     * @param password This is the password of the user
     * @return Actor which could be a CRA() or a Doctor() or a DataManager()
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicates to the main program if the user does not exist
     */
    public Actor getUserById(int id, int statut) throws SQLException, Exception {
        String table = "";
        String query = "SELECT COUNT (*) AS Total FROM ";
        if (statut == 1) {
            table += "DATAMANAGER ";
        }
        else if (statut == 2) {
            table += "ARC ";
        }
        else if (statut == 3) {
            table += "MEDECIN  ";
        }
        else    {
            throw new Exception("Ce statut n'existe pas !");
        }
        
        query += table + " WHERE PK_ID_PERSONNE = '" + id + "'";
        System.out.println(query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        
        if (rs.getInt("Total") == 1) {
            String query2 = "SELECT * FROM " + table + " WHERE PK_ID_PERSONNE = '" + id + "'";
            System.out.println(query2);
            ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
            rs2.next();
            
            if (statut == 1)    {
                DataManager tmpDM = new DataManager(rs2.getNString("PRENOM"), rs2.getNString("NOM"));
                tmpDM.setId(rs2.getNString("PK_ID_PERSONNE"));
                return tmpDM;
            }
            else if (statut == 2)    {
                CRA tmpCRA = new CRA(rs2.getNString("PRENOM"), rs2.getNString("NOM"));
                tmpCRA.setId(rs2.getNString("PK_ID_PERSONNE"));
                return tmpCRA;
            }
            else    {
                Doctor tmpDoctor = new Doctor(rs2.getNString("PRENOM"), rs2.getNString("NOM"), rs2.getNString("PK_ID_PERSONNE"), null);
                tmpDoctor.setId(rs2.getNString("PK_ID_PERSONNE"));
                return tmpDoctor;
            }
        }
        else if (rs.getInt("Total") == 0) {
            throw new Exception("Cet utilisateur n'existe pas !");
        }
        else    {
            throw new Exception("This user exists twice at least!");
        }
    }
    
    /**
     * 
     * @param login
     * @param password
     * @param user
     * @return 
     */
    public Actor connectionUser(String login, String password, String user) throws SQLException, Exception  {
        int id, statut;
        String queryCount = "SELECT COUNT (*) AS Total FROM UTILISATEUR WHERE UTILISATEUR_LOGIN ='" + login + "'";
        System.out.println(queryCount);
        ResultSet rsCount = this.connect.createStatement().executeQuery(queryCount);
        rsCount.next();
        
        //if there is no user with this login
        if (rsCount.getInt("Total") == 0)    {
            throw new UnknownUsernameException("Il n'existe pas d'utilisateur avec cet identifiant !");
        }
        //else if there more than 1 user with this login
        else if (rsCount.getInt("Total") > 1)    {
            throw new Exception("Il y a au moins deux utilisateurs possédant cet identifiant !");
        }
        //if there is one user
        else    {
            String queryPass = "SELECT UTILISATEUR_PASSWORD FROM UTILISATEUR WHERE UTILISATEUR_LOGIN ='" + login + "'";
            System.out.println(queryPass);
            ResultSet rsPass = this.connect.createStatement().executeQuery(queryPass);
            rsPass.next();

            //if the password is not correct
            if (!(rsPass.getString("UTILISATEUR_PASSWORD").equals(password)))  {
                throw new WrongPasswordException("Le mot de passe n'est pas correct !");
            }
            //if the password is correct
            else    {
                String querySelect = "SELECT * FROM UTILISATEUR WHERE UTILISATEUR_LOGIN ='" + login + "'";
                System.out.println(querySelect);
                ResultSet rsSelect = this.connect.createStatement().executeQuery(querySelect);
                rsSelect.next();

                if (user.equals("Data Manager")) {
                    //if the user is a data manager but the login is not corresponding to a data manager
                    if (rsSelect.getString("DM_ID") == null) {
                        throw new WrongRoleException("Vous n'êtes pas autorisé à vous connecter en tant que Data Manager !");
                    }
                    else    {
                        id = Integer.parseInt(rsSelect.getString("DM_ID"));
                        statut = 1;
                    }
                }
                else if (user.equals("Attaché de recherche clinique")) {
                    //if the user is a cra but the login is not corresponding to a cra
                    if (rsSelect.getString("ARC_ID") == null) {
                        throw new WrongRoleException("Vous n'êtes pas autorisé à vous connecter en tant qu'Attaché de Recherche Clinique !");
                    }
                    else    {
                        id = Integer.parseInt(rsSelect.getString("ARC_ID"));
                        statut = 2;
                    }
                }
                else if (user.equals("Médecin")) {
                    //if the user is a doctor but the login is not corresponding to a doctor
                    if (rsSelect.getString("MEDECIN_ID") == null) {
                        throw new WrongRoleException("Vous n'êtes pas autorisé à vous connecter en tant que Médecin !");
                    }
                    else    {
                        id = Integer.parseInt(rsSelect.getString("MEDECIN_ID"));
                        statut = 3;
                    }
                }
                else    {
                    throw new WrongRoleException("Ce statut n'existe pas !");
                }
                return getUserById(id, statut);
            }
        }
    }
    
    /**
     * This method return the secret question to reinitialize the password.
     * @param user Actor who want to reinitialize his/her password.
     * @return The question in String format.
     */
    public String getUserQuestion(String login) throws SQLException, Exception   {
        String question = "";
        String column = "";
        
        String query = "SELECT UTILISATEUR_QUESTION FROM Utilisateur WHERE Utilisateur_login = "
                + "'" + login + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        return rs.getString("UTILISATEUR_QUESTION");
    }
    
    /**
     * This method permits to check if the answer given by the user is correct or not.
     * @param answer String which contains the answer of the user.
     * @return Boolean to know if the answer is correct or not.
     */
    public boolean checkUserAnswer(String answer, String login) throws SQLException, Exception   {
        String question = "";
        String column = "";
        String reponse = "";
        
        String query = "SELECT UTILISATEUR_REPONSE FROM Utilisateur WHERE Utilisateur_login = "
                + "'" + login + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        reponse = rs.getString("UTILISATEUR_REPONSE");
        
        if (reponse.equals(answer)) {
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
     * @return
     */
    public boolean checkPassword(String password) throws Exception {
        if (password.length() > 4 && password.length() < 15) {
            return true;
        } else {
            throw new Exception("Le mot de passe doit contenir entre 4 et 15 caractère!");
        }
    }
    
    /**
     * 
     * @param login
     * @param password 
     */
    public void resetPassword(String login, String password) throws Exception {        
        if (this.checkPassword(password))   {
            String query = "UPDATE Utilisateur SET Utilisateur_Password = ('"+ password +"')"
                    + " WHERE Utilisateur_Login = '"+ login +"'";
            System.out.println("query => " + query);
            ResultSet rs = this.connect.createStatement().executeQuery(query);
            rs.next();
        }
    }
   
    /**
     * This method is used to exclude a Patient from the clinical trial.
     * @param id This is the identifier of the Patient which has been getted from the database. You have to get it before called this method
     * @param why This is the reason of the exclusion.
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicates to the main program when there is a problem during the exclusion of the patient
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
     * This method is used to get only one patient using his/her lastname, firstname and birthdate
     * @param lastname lastname of the patient
     * @param firstname firstname of the patient
     * @param birthday birth date of the patient. Caution with it : the parameter is a String() type, not a Calendar() or GregorianCalendar() or Date(), etc
     * @return an object Patient() with all information
     * @throws Exception to indicates to the main program when there is a problem during the getting of the patient
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
            throw new Exception("Ce patient existe au moins deux fois !");
        }
        if (rs.getInt("Total") == 0) {
            throw new Exception("Ce patient n'existe pas !");            
        }
        else    {
            try {
        
                String query2 = "SELECT PK_ID_PERSONNE, PRENOM, NOM, SEXE, DATE_NAISSANCE, STATUT FROM Patient"
                    + " WHERE NOM = '" + lastname + "' AND PRENOM = '" + firstname + "' AND DATE_NAISSANCE = '" + birthday + "'";

                System.out.println("query2 => " + query2);
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
                tmpPatient = new Patient(firstname, lastname, y, m, d, sexe, null);
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
    
    public Patient getPatientById(String id) throws Exception {
        Patient tmpPatient;
        Boolean sexe, inclut;
        int y, m, d;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        String query = "SELECT COUNT (*) AS Total FROM Patient WHERE PK_ID_PERSONNE ='" + id + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        if (rs.getInt("Total") > 1)    {
            throw new Exception("Ce patient existe au moins deux fois !");
        }
        if (rs.getInt("Total") == 0) {
            throw new Exception("Ce patient n'existe pas !");            
        }
        else    {
            try {
        
                String query2 = "SELECT PK_ID_PERSONNE, PRENOM, NOM, SEXE, DATE_NAISSANCE, STATUT FROM Patient"
                    + " WHERE PK_ID_PERSONNE = '" + id + "'";

                System.out.println("query2 => " + query2);
                ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
                rs2.next();
                SimpleDateFormat birth = new SimpleDateFormat();
                birth.applyPattern("dd/MM/yyyy");

                Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}).*");
                Matcher match = p.matcher(rs2.getString("DATE_NAISSANCE"));
                
                if (match.find())   {
                    y = Integer.parseInt(match.group(1));
                    m = Integer.parseInt(match.group(2));
                    d = Integer.parseInt(match.group(3));

                    //y = (y < (currentYear%100)) ? y + 2000 : y + 1900;
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
                tmpPatient = new Patient(rs2.getString("PRENOM"), rs2.getString("NOM"), y, m, d, sexe, null);
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

    
    /**
     * This method is used by the DataManager() class to get all the patients which are recoreded into the database
     * @return This method returns an ArrayList of Patients which contains all information about Patient
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicates if there is a problem during the getting of all patients
     */
    public ArrayList<Patient> getListPatient() throws SQLException, Exception {
        ArrayList<Patient> tmpListPatients = new ArrayList<Patient>();
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
                tmpPatient = new Patient(firstname, lastname, y, m, d, sexe, null);
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
     * A VERIFIER
     * This method allow us to get all the patients which are recoreded into the database and followed by a doctor
     * @param Doctor who supervise all the patient
     * @return This method returns an ArrayList of Patients which contains all information about Patient
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicates if there is a problem during the getting of all patients
     */
    public ArrayList<Patient> getListPatientFromDoctor(Doctor doc) throws SQLException, Exception {
        ArrayList<Patient> tmpListPatients= new ArrayList<Patient>();
        Boolean sexe, inclut;
        String query = "SELECT * FROM Patient WHERE Med_pk_id_personne = '" + doc.getId() + "'";
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
                tmpPatient = new Patient(firstname, lastname, y, m, d, sexe, doc);
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
     * This method permits to get one Doctor with his/her name and his/her firstname
     * @param nom name of the doctor
     * @param prenom firstname of the doctor
     * @return 
     */
    public Doctor getDoctorByName(String nom, String prenom) throws SQLException, Exception   {        
        String query = "SELECT * FROM Medecin"
                + " WHERE nom = '"+ nom +"'"
                + " AND prenom = '"+ prenom +"'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        if(rs.getString("pk_id_personne") == null)  {
            throw new Exception("Il n'existe aucun médecin comportant ce nom et ce prénom !");
        }
        else    {
            String query2 = "SELECT * FROM ARC"
                + " WHERE pk_id_personne = '"+ rs.getString("ARC_pk_id_personne") +"'";
            System.out.println("query => " + query2);
            ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
            rs2.next();
            return new Doctor(rs.getString("prenom"), rs.getString("nom"), rs.getString("pk_id_personne"), new CRA(rs2.getString("pk_id_personne"), rs2.getString("prenom"), rs2.getString("nom")));
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Doctor getDoctorById(String id) throws SQLException, Exception   {
        String query = "SELECT * FROM Medecin"
                + " WHERE pk_id_personne = '"+ id +"'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        if(rs.getString("pk_id_personne") == null)  {
            throw new Exception("Il n'existe aucun médecin comportant ce nom et ce prénom !");
        }
        else    {
            String query2 = "SELECT * FROM ARC"
                + " WHERE pk_id_personne = '"+ rs.getString("ARC_pk_id_personne") +"'";
            System.out.println("query => " + query2);
            ResultSet rs2 = this.connect.createStatement().executeQuery(query2);
            rs2.next();
            CRA c = new CRA(rs2.getString("pk_id_personne"), 
                        rs2.getString("prenom"), 
                        rs2.getString("nom"));
            Doctor d = new Doctor(
                    rs.getString("prenom"), 
                    rs.getString("nom"), 
                    rs.getString("pk_id_personne"),
                    c);
            /*
            return new Doctor(
                    rs.getString("prenom"), 
                    rs.getString("nom"), 
                    rs.getString("pk_id_personne"), 
                    new CRA(rs2.getString("pk_id_personne"), 
                        rs2.getString("prenom"), 
                        rs2.getString("nom")));
            */
            return d;
        }
    }
    
    /**
     * This method is used to select all the doctors which works wich the loged ARC
     * @return This method returns an ArrayList of Doctor which contains all information about Doctor
     * @throws SQLException to lead all the errors triggred by the SQL to the main program
     * @throws Exception to indicates if there is a problem during the getting of all doctor
     */
    public ArrayList<Doctor> getListDoctor(CRA cra) throws SQLException, Exception {
        ArrayList<Doctor> tmpListDoctor= new ArrayList<Doctor>();
        String query = "SELECT pk_id_personne, nom, prenom FROM Medecin WHERE ARC_pk_id_personne='" + cra.getId() + "'";
        System.out.println("query => " + query);
        
        try {
        
            ResultSet rs = this.connect.createStatement().executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("pk_id_personne");
                String firstname = rs.getString("prenom");
                String lastname = rs.getString("nom");

                Doctor tmpDoctor;
                tmpDoctor = new Doctor(firstname, lastname, id, cra); 
                tmpDoctor.setPatientList(this.getListPatientFromDoctor(tmpDoctor));
                tmpListDoctor.add(tmpDoctor);
            }
            
            return tmpListDoctor;
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'obtention de la listes des patients => " + ex);
            return null;
        }
    }
    
    /**
     * A VERIFIER
     * @param pat
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public ArrayList<Analysis> getAnalysis(Patient pat) throws SQLException, Exception{
    	//LinkedHashMap ListAnalysis= new LinkedHashMap();
    	ArrayList<Analysis> tmpListAnalysis = new ArrayList<Analysis>();
        String query = "SELECT * FROM FicheQuotidienne JOIN Rempli_fiche ON Rempli_fiche.pk_id_fichequotidienne = FicheQuotidienne.pk_id_fichequotidienne WHERE Rempli_fiche.pk_id_personne='" + Integer.parseInt(pat.getId()) + "'";
       
        SimpleDateFormat birth = new SimpleDateFormat();
        birth.applyPattern("dd/MM/yyyy");
        
        System.out.println("query => " + query);

        try {
        
            ResultSet rs = this.connect.createStatement().executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("pk_id_fichequotidienne");
                String dateFiche = rs.getString("date_fiche");
                int pression_systolique = rs.getInt("pression_systolique");
                int pression_diastolique = rs.getInt("pression_diastolique");
                int rythme_cardiaque = rs.getInt("rythme_cardiaque");
                String obs = rs.getString("observation_quotidienne");
                int d, m, y;
                Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}).*");
                Matcher match = p.matcher(dateFiche);

                if (match.find())   {
                    y = Integer.parseInt(match.group(1));
                    m = Integer.parseInt(match.group(2));
                    d = Integer.parseInt(match.group(3));
                }
                else    {
                    throw new Exception("Erreur de date !");
                }
                GregorianCalendar birthDate = new GregorianCalendar(y, m, d);
                //Analysis a = new DailyTest(pression_systolique,pression_diastolique, rythme_cardiaque ,obs, false, false, false, birthDate, pat, null);
                //tmpListAnalysis.add(a);            
            }
            
            return tmpListAnalysis;
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'obtention de la listes des patients => " + ex);
            return null;
        }
    }
    
    /**
     * 
     * @param dt
     * @param p
     * @param d
     * @param eeg
     * @param sang
     * @param effort
     * @throws SQLException
     * @throws Exception 
     */
    public void addDailyTest(DailyTest dt, Patient p, Doctor d, EEG eeg, BloodTest sang, EffortTest effort) throws SQLException, Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormatBDD = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar currentDate = Calendar.getInstance();
        int duree;
        String idPatient;
        String idFiche = "";
        String jour = "";
        Date debutDate;
        
        /**
         * Requête de sélection de la date d'entrée du patient
         */
        String querySelectPatient = "SELECT pk_id_personne, date_debut FROM Patient "
                + "WHERE pk_id_personne = '"+ p.getId() +"'";
        System.out.println("querySelect => " + querySelectPatient);
        ResultSet rsSelectPatient = this.connect.createStatement().executeQuery(querySelectPatient);
        rsSelectPatient.next();
        idPatient = rsSelectPatient.getString("pk_id_personne");
        debutDate = rsSelectPatient.getDate("date_debut");
        
        /*
         * Attention ce qui suit est extrêment moche et dégueulasse !
         */
        duree = currentDate.getTime().getDate() - debutDate.getDate();
        jour = (duree>10) ? String.valueOf(duree) : '0' +String.valueOf(duree);
                
        /**
         * Requête d'insertion dans la table FicheQuotidienne
         */
        String queryAjoutFiche = "DECLARE X NUMBER; BEGIN "
                    + "INSERT INTO FicheQuotidienne "
                    + "VALUES ("
                    + "'',"
                    + "'"+ this.getLotByIdPatient(idPatient).getNumero() +"'," //pk_num_lot
                    + "'"+ dt.getSystole() +"'," //pression_systolique
                    + "'"+ dt.getDiastole() +"'," //pression_diastolique
                    + "'"+ dt.getHeartBeats() +"'," //rythme_cardiaque
                    + "'"+ dt.getObservations() +"'," //observation_quotidienne
                    + "'en_cours'," //state => status is 'en_cours' (default)
                    + "'"+ jour +"'" //date_fiche => day of clinical assay
                    + ") RETURNING pk_id_fichequotidienne INTO X; "
                    + "END;";
        System.out.println("queryAjout => " + queryAjoutFiche);
        //declare x number; begin INSERT INTO fichequotidienne VALUES ('', '101', '12', '8', '70', '', 'en_cours', '05') RETURNING pk_id_fichequotidienne INTO x; UPDATE testu SET testu.X = x; end;
        
        /**
         * TEST
         */
        CallableStatement statement = this.connect.prepareCall(queryAjoutFiche);
        statement.executeQuery();
        this.connect.commit();
        
//        ResultSet rsAjoutFiche = this.connect.createStatement().executeQuery(queryAjoutFiche);  
//        rsAjoutFiche.next();
//        rsAjoutFiche.getInt(9);
        
        for (int i = 0; i < statement.getMetaData().getColumnCount(); i++) {
            System.out.println(i + " : " + statement.getMetaData().getColumnName(i) + " " + statement.getString(i));
        }
                
        idFiche = "toto";
        
        /**
         * Requête d'insertion dans la table Rempli_Fiche
         */
        String queryRempliFiche = "INSERT INTO Rempli_Fiche "
                + "VALUES ("
                + "'"+ rsSelectPatient.getString("pk_id_personne") +"'," //pk_id_personne
                + "'"+  idFiche +"'," //pk_id_fichequotidienne
                + "'"+ d.getId() +"'" //Med_pk_id_personne
                + ")";
        System.out.println("queryAjout => " + queryRempliFiche);
        ResultSet rsRempliFiche = this.connect.createStatement().executeQuery(queryRempliFiche);  
        rsRempliFiche.next();    
        
        if (eeg != null)    {
            this.addEEG(((EEG)eeg), idFiche);    
        }
        if (sang != null)    {
            this.addBloodTest(((BloodTest)sang), idFiche);
        }
        if (effort != null)    {
            this.addEffortTest(((EffortTest)effort), idFiche);
        }
    }
    
    /**
     * This method permits to update the status of one specific daily sheet which is given in parameters
     * @param d is a DailyTest object
     * @param statut is a String which contains the new statut
     * @throws WrongParameterException is raised when the parameter statut contains the wrong word for update the status
     * @throws SQLException is raised when there are SQL errors
     */
    public void updateStateDailyTest (String id, String statut) throws WrongParameterException, SQLException {
        String query = "";
        System.out.println("statut : " + statut);
        if ((!(statut.equals("en_cours"))) && (!(statut.equals("valide"))) && (!(statut.equals("invalide"))) && (!(statut.equals("a_verifier"))))  {
            throw new WrongParameterException("Le statut doit être 'en_cours' ou 'valide' ou 'invalide' ou 'a_verifier' !");
        }
        else    {
            query = "UPDATE fichequotidienne "
                    + "SET state = '"+ statut +"' "
                    + "WHERE pk_id_fichequotidienne = '"+ id +"'";
            System.out.println("query => " + query);
            this.connect.createStatement().executeUpdate(query);
        }
    }

    /**
     * A VERIFIER
     * This method permits to get a specific daily test thanks to a patient identifier and a day
     * @param idPatient is the patient identifier
     * @param day is the day of the clinical assay
     * @return a filled DailyTest
     * @throws SQLException warn if there have been SQL errors
     * @throws EmptySQLResultException warn if there any are empty results of queries
     * @throws Exception warn you for each others errors
     */
    public DailyTest getDailyTests(String idPatient, String day) throws SQLException, EmptySQLResultException, Exception {
        boolean eeg = false;
        boolean sang = false;
        boolean effort = false;
        
        String query = "SELECT * FROM fichequotidienne "
                + "JOIN rempli_fiche "
                + "ON rempli_fiche.pk_id_fichequotidienne = fichequotidienne.pk_id_fichequotidienne "
                + "WHERE rempli_fiche.pk_id_personne = '"+ idPatient +"' "
                + "AND fichequotidienne.date_fiche = '"+ day +"'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        
        if (rs.getString("pk_id_fichequotidienne") == null) {
            throw new EmptySQLResultException("Il n'y a aucune fiche correspondante !");
        }
        else    {
            Patient p = getPatientById(idPatient);
            
            if (checkIfAnalysisExists("eeg", idPatient)){
                eeg = true;
            }
            if (checkIfAnalysisExists("sang", idPatient)){
                sang = true;
            }
            if (checkIfAnalysisExists("effort", idPatient)){
                effort = true;
            }
        
            //Recap of the constructor of the Daily Test
            return new DailyTest(
                    Integer.parseInt(rs.getString("pression_systolique")), //int systole
                    Integer.parseInt(rs.getString("pression_diastolique")), //int diastole
                    Integer.parseInt(rs.getString("rythme_cardiaque")), //int heart
                    rs.getString("observations_quotidiennes"), //String observations
                    effort, //boolean prescEffort
                    eeg, //boolean prescEEG
                    sang, //boolean prescBlood
                    Integer.parseInt(rs.getString("date_fiche")), //int date
                    p //Patient p
                    );
        }
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
     * @param id
     * @return
     */
    public Lot getLotByIdPatient(String id) throws SQLException, Exception {
        String query = "SELECT * FROM Lot " + "WHERE pk_id_personne = '" + id + "'";
        System.out.println("query => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();

        if (rs.getString("pk_id_personne") == null) {
            throw new Exception("Il n'existe aucun patient comportant ce nom et ce prénom !");
        } else {
            return new Lot(rs.getString("pk_num_lot"), rs.getString("date_lot"));
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Lot getLotByIdFiche(String id) throws SQLException, Exception {
        String query = "SELECT * FROM Lot " 
                + "JOIN Patient " 
                + "ON Lot.pk_id_personne = " 
                + "Patient.pk_id_personne " 
                + "JOIN Rempli_fiche " 
                + "ON Patient.pk_id_personne = " 
                + "Rempli_fiche.pk_id_personne " 
                + "JOIN FicheQuotidienne " 
                + "ON Rempli_fiche.pk_id_fichequotidienne = " 
                + "FicheQuotidienne.pk_id_fichequotidienne"
                + "WHERE FicheQuotidienne.pk_id_fichequotidienne = '" + id + "'";        
        System.out.println("query1 => " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();

        if (rs.getString("pk_id_personne") == null) {
            throw new Exception("Il n'existe aucun patient comportant ce nom et ce prénom !");
        } else {
            return new Lot(rs.getString("pk_num_lot"), rs.getString("date_lot"));
        }

    }

    /**
     *
     * @param p
     * @param g
     */
    public void addPatientToGroup(Group g, DataManager dm) throws Exception {
        if (dm.getAssignment()) {
            throw new Exception("All the patients has already a group !");
        }
        else    {
            String query = "";
            HashMap<String, ArrayList> groups = g.getListeGroupe();
            HashMap<String, Integer> names = new HashMap<String, Integer>();
            names.put("PP1", getGroupId("PP1"));
            names.put("PP2", names.get("PP1"));
            names.put("VPaltPP", getGroupId("VPaltPP"));
            names.put("VP", getGroupId("VP"));
            names.put("TPaltPP", getGroupId("TPaltPP"));
            names.put("TP", getGroupId("TP"));
            names.put("TValtPP", getGroupId("TValtPP"));
            names.put("TV", getGroupId("TV"));
                        
            for (String groupName : groups.keySet()) {
                //System.out.println("groupName : " + groupName);
                //System.out.println("WTF ? " + groups.get(groupName));
                for (Patient p : (ArrayList<Patient>)groups.get(groupName)) {
                    query = "UPDATE Patient SET PK_ID_GROUPE = '"+ names.get(groupName) +"'"
                        + " WHERE PK_ID_PERSONNE = '" + p.getId() + "'";
                    System.out.println("query => " + query);
                    ResultSet rs2 = this.connect.createStatement().executeQuery(query);
                }
            }
        }
    }
    
    public int getGroupId(String g) throws Exception    {
        String query = "";
        String mol1, mol2, alt = "";
        if (g.equals("PP1") || g.equals("PP2")) {
            mol1 = "placebo";
            mol2 = mol1;
            alt = "0";
        }
        else if (g.equals("TV")) {
            mol1 = "vicazen";
            mol2 = "tricazen";
            alt = "0";
        }
        else if (g.equals("TValtPP")) {
            mol1 = "vicazen";
            mol2 = "tricazen";
            alt = "1";
        }
        else if (g.equals("TP")) {
            mol1 = "tricazen";
            mol2 = "placebo";
            alt = "0";
        }
        else if (g.equals("TPaltPP")) {
            mol1 = "tricazen";
            mol2 = "placebo";
            alt = "1";
        }
        else if (g.equals("VP")) {
            mol1 = "vicazen";
            mol2 = "placebo";
            alt = "0";
        }
        else if (g.equals("VPaltPP")) {
            mol1 = "vicazen";
            mol2 = "placebo";
            alt = "1";
        }
        else    {
            throw new Exception("This group does not exist !");
        }
        
        query = "SELECT PK_ID_GROUPE FROM GROUPE WHERE MOL1 = '"+mol1+"' AND MOL2 = '"+mol2+"' AND ALTERNATIF = '"+alt+"' ";
        System.out.println("query : " + query);
        ResultSet rs = this.connect.createStatement().executeQuery(query);
        rs.next();
        
        return Integer.parseInt(rs.getString("PK_ID_GROUPE"));
    }
       
    /**
     * A VERIFIER
     * @param idMedecin
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public LinkedHashMap<Patient, ArrayList<Analysis>> getPatientsWithAnalysis(String idMedecin) throws SQLException, Exception {
    	
    	LinkedHashMap<Patient, ArrayList<Analysis>> tmpPatientsWithAnalysis = new LinkedHashMap<Patient, ArrayList<Analysis>>();
    	
    	String date_jour = String.valueOf(Calendar.getInstance().get(Calendar.DATE))+"/"+String.valueOf(Calendar.getInstance().get(Calendar.MONTH))+"/"+String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String query = "SELECT patient.PK_ID_PERSONNE, patient.NOM, patient.PRENOM, PlanningPatient.Date_sang, PlanningPatient.Date_eeg, PlanningPatient.Date_effort FROM Patient FULL JOIN PlanningPatient ON (Patient.PK_ID_PERSONNE = PlanningPatient.PK_ID_PERSONNE) WHERE Patient.Med_pk_id_personne = "+Integer.valueOf(idMedecin);
        
        System.out.println("Query => " + query);
        
        try {
        
            ResultSet rs = this.connect.createStatement().executeQuery(query);

            if (rs != null) {
	            while (rs.next()) {
	                String id = rs.getString("PK_ID_PERSONNE");
	                String firstname = rs.getString("NOM");
	                String lastname = rs.getString("PRENOM");
	                
	                System.out.println(rs.getString("NOM"));
	
	                Patient tmpPatient;
	                
	                tmpPatient = new Patient(firstname, lastname, id);
	                
	                ArrayList<Analysis> myAnalysis = new ArrayList<Analysis>();

	                if (rs.getString("Date_sang") != null)
	                	if (rs.getString("Date_sang").equalsIgnoreCase(date_jour))
	                		myAnalysis.add(new BloodTest());

	                if (rs.getString("Date_eeg") != null)
	                	if (rs.getString("Date_eeg").equalsIgnoreCase(date_jour))
	                		myAnalysis.add(new EEG());

	                if (rs.getString("Date_effort") != null)
	                	if (rs.getString("Date_effort").equalsIgnoreCase(date_jour))
	                		myAnalysis.add(new EffortTest());
	                tmpPatientsWithAnalysis.put(tmpPatient, myAnalysis);
	            }
            }
            
            System.out.println("Fin de la méthode de récupération des patients");
            return tmpPatientsWithAnalysis;
        }
        catch (SQLException ex) {
            System.out.println("Erreur lors de l'obtention de la listes des patients => " + ex);
            System.out.println("Fin de la méthode de récupération des patients");
            return null;
        }
    }
    
    public String toto() {
        return "totototo";
    }
}
