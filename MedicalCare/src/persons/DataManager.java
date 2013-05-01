package persons;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import main.*;


/**
 *
 * @author Cogotch
 */
public class DataManager extends Actor {

    private String password;
    private String login;
    private boolean assignment;

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param password
     * @param login
     */
    public DataManager(String id, String firstName, String lastName, String password, String login) {
        super(id, firstName, lastName);
        this.password = password;
        this.login = login;
        this.assignment = false;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return this.login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAssignment(boolean b) {
        this.assignment = b;
    }

    public boolean getAssignment() {
        return (this.assignment);
    }

    public void assignment() throws Exception {
        if (this.assignment== false) {
            int i =0;
            int cptGlob,sizeP,cpt55;
            int age;
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);

            ArrayList<Patient> listPatient = new ArrayList();
            listPatient = DB_connector.getListPatient();
            Collections.shuffle(listPatient);
            sizeP = listPatient.size();
            cptGlob = 1;
            cpt55 = 1;
            Group lG= new Group();
            for (i=0; i<sizeP;i++){
                age=currentYear-listPatient.get(i).getBirthDate().get(Calendar.YEAR);
                if (age>=55){
                    if (cpt55%2!=0) {
                        lG.getGroupe("PP1").add(listPatient.get(i));
                        cpt55+=1;
                    }
                    else {
                        lG.getGroupe("PP2").add(listPatient.get(i));
                        cpt55+=1; //je remet à zéro pour que le prochain assignement se fasse 
                    }
                }
                else {
                    if (cpt55 <=(lG.getGroupe("TV").size())) {
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
}