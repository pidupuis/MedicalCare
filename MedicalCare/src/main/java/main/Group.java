package main;

import java.util.ArrayList;
import persons.*;
import java.util.*;

/**
 *
 * @author Cogotch
 */
public class Group {

    private HashMap<String, ArrayList> listeGroupe=new HashMap();
    private ArrayList<Patient> TV = new ArrayList();
    private ArrayList<Patient> TValtPP = new ArrayList();
    private ArrayList<Patient> TP = new ArrayList();
    private ArrayList<Patient> TPaltPP = new ArrayList();
    private ArrayList<Patient> VP = new ArrayList();
    private ArrayList<Patient> VPaltPP = new ArrayList();
    private ArrayList<Patient> PP1 = new ArrayList();
    private ArrayList<Patient> PP2 = new ArrayList();

    /**
     *
     */
    public Group() {
        listeGroupe.put("TV", TV);
        listeGroupe.put("TValtPP", TValtPP);
        listeGroupe.put("TP", TP);
        listeGroupe.put("TPaltPP", TPaltPP);
        listeGroupe.put("VP", VP);
        listeGroupe.put("VPaltPP", VPaltPP);
        listeGroupe.put("PP1", PP1);
        listeGroupe.put("PP2", PP2);
    }

    /**
     *
     * @param groupe
     * @param nouveau
     */
    public void setGroupe(String groupe, ArrayList nouveau) { 
        listeGroupe.put(groupe, nouveau);
    }

    /**
     *
     * @param groupe
     * @return
     */
    public ArrayList getGroupe(String groupe) {
        Iterator<String> it = listeGroupe.keySet().iterator();
	//ArrayList<ArrayList> aL = new ArrayList();
        //int i;
        //for (i=0; i<listeGroupe.size();i++){
            return (listeGroupe.get(groupe));
        //}


	//return aL;
    }

    public HashMap<String, ArrayList> getListeGroupe() {
        return listeGroupe;
    }
}