package persons;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import main.*;


/**
 * Class that implements attributes of the datamanager and the assignement of the patients
 * to groups. 
 * 
 * @author Cogotch
 */
public class DataManager extends Actor {

    private String password;
    private String login;
    private boolean assignment;

    /**
     *
     * @param firstName is the first name of the DataManager
     * @param lastName is the lastname of the datamanager
     * @param password is the password for connection for the HcI
     * @param login is the login for connection for the HcI
     */
    public DataManager(String firstName, String lastName) throws Exception {
        super(firstName, lastName);
        this.generateLogin(firstName, lastName);
        this.password = this.login;
        this.assignment = false;
    }

    /**
     * getter of the login of the datamanager
     * @return login 
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * setter of the login of the datamanager
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getter of the password of the datamanager
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * setter of the password of the datamanager
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * setter of the statute of the assignement
     * @param b
     */
    public void setAssignment(boolean b) {
        if (b==true) {
            if (getAssignment()==false) {
                this.assignment = b;
            }
            else {
                System.out.println("Assignement already done! You can't do it again!");
            }
        }
        else{
            System.out.println("You can't do it!");
            }
    }

    /**
     * getter of the statute of the assignement 
     * @return
     */
    public boolean getAssignment() {
        return (this.assignment);
    }

    /**
     * Class that do automaticaly the assignement of the patients in groups 
     * 
     * @throws Exception
     */
    public void assignment() throws Exception {
        DB_connector dbc = DB_connector.getInstance();
        if (this.assignment== false) { // if the assignement is on false we can do it
            /* declaration zone */
            int i =0;
            int cptGlob,sizeP,cpt55;
            int age;
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            ArrayList<Patient> listPatient = new ArrayList<Patient>();
            listPatient = dbc.getListPatient();
            
            /* list of patients is shuffleling, it's right for the rondomization */
            Collections.shuffle(listPatient);
            
            /* initialization of counters */
            sizeP = listPatient.size(); //size of the list of patients
            cptGlob = 1; //counter using for the attribution of patients in groups
            cpt55 = 1;   //counter using only for the attribution of the patients more of 55 years old
            Group lG= new Group(); 
            
            /* starting of the attribution of patients to groups */
            for (i=0; i<sizeP;i++){  
                age=currentYear-listPatient.get(i).getBirthDate().get(Calendar.YEAR);//we need age of patients for the assignement
                if (age>=55){ //if patient have more of 55 years old
                    if (cpt55%2!=0) { //if cpt55 is pair
                        lG.getGroupe("PP1").add(listPatient.get(i)); //we add the patient to the first group that takes placebo only
                        cpt55+=1;
                    }
                    else {
                        lG.getGroupe("PP2").add(listPatient.get(i));
                        cpt55+=1;
                    }
                }
                else { //if patient is less of 55 years old we can attribute it for a group
                    if ((cpt55)/2 <=(lG.getGroupe("VPaltPP").size())) { // this condition is use to bring homogenous groups
                        switch (cptGlob) { 
                            case 1: 
                                lG.getGroupe("PP1").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 2: 
                                lG.getGroupe("PP2").add(listPatient.get(i)); 
                                cptGlob+=1;
                                break; 
                            case 3: 
                                lG.getGroupe("TV").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 4: 
                                lG.getGroupe("TValtPP").add(listPatient.get(i)); 
                                cptGlob+=1;
                                break; 
                            case 5: 
                                lG.getGroupe("TP").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 6: 
                                lG.getGroupe("TPaltPP").add(listPatient.get(i)); 
                                cptGlob+=1;
                                break; 
                            case 7: 
                                lG.getGroupe("VP").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 8: 
                                lG.getGroupe("VPaltPP").add(listPatient.get(i)); 
                                cptGlob=1;
                                break; 
                            default: 
                                throw new Exception ("Erreur dans la répartition des groupes -> Contacter l'admin"); 
                        }
                    }
                    else{
                        switch (cptGlob) { 
                            case 1: 
                                lG.getGroupe("TV").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 2: 
                                lG.getGroupe("TValtPP").add(listPatient.get(i)); 
                                cptGlob+=1;
                                break; 
                            case 3: 
                                lG.getGroupe("TP").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 4: 
                                lG.getGroupe("TPaltPP").add(listPatient.get(i)); 
                                cptGlob+=1;
                                break; 
                            case 5: 
                                lG.getGroupe("VP").add(listPatient.get(i));
                                cptGlob+=1;
                                break; 
                            case 6 :
                                lG.getGroupe("VPaltPP").add(listPatient.get(i)); 
                                cptGlob=1;
                                break;
                            case 7 :
                                lG.getGroupe("TV").add(listPatient.get(i)); 
                                cptGlob=2;
                                break;
                            case 8 :
                                lG.getGroupe("TV").add(listPatient.get(i)); 
                                cptGlob=2;
                                break;
                            default: 
                                throw new Exception ("Erreur dans la répartition des groupes -> Contacter l'admin"); 
                        }
                    }
                }
            }
        System.out.println("Cpt55 : "+cpt55);
        System.out.println("Cptglob : "+cptGlob);
        System.out.println("PP1 : "+lG.getGroupe("PP1").size());
        System.out.println("PP2 : "+lG.getGroupe("PP2").size());
        System.out.println("TP : "+lG.getGroupe("TP").size());
        System.out.println("TV : "+lG.getGroupe("TV").size());
        System.out.println("VP : "+lG.getGroupe("TValtPP").size());
        System.out.println("TPaltPP : "+lG.getGroupe("TPaltPP").size());
        System.out.println("VPalPP : "+lG.getGroupe("VPaltPP").size());
        System.out.println("TValtPP : "+lG.getGroupe("TValtPP").size());
        } 
        else {
            System.out.println("L'assignement a déjà été effectué. Vous ne pouvez pas le relancer");
        }
    }
    private void generateLogin(String firstName, String lastName) throws Exception {
        String log = firstName.substring(0, 1) + lastName;

        DB_connector db = DB_connector.getInstance();
        
        log = log.replace(" ","");
        log = log.replace("-","");
        log = log.toLowerCase();
        this.login = log;
        boolean continueLoop = true;
        int i = 1;
        while (continueLoop) {
            if (db.checkUser(this.login)) {
                this.login = log + String.valueOf(i);
            }
            else {
                continueLoop = false;
            }
        }
    }

}