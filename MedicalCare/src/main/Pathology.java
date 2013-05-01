package main;

/**
 *
 * @author Aurelie
 */
public enum Pathology {

    Diabetes_type_1 ("Diabète de type 1"),
    Diabetes_type_2 ("Diabète de type 2"),
    Hypertension ("Hypertension"), 
    viral_hepatitis ("Hepathite viral"),
    cancer ("Cancer"),
    myocardial_infarction( "infarctus du myocarde"),
    Arthrite_rhumatoïde ( "Arthrite rhumatoide"),
    Mucoviscidose ("Mucoviscidose"),
    maladie_auto_immune ("maladie auto-immune"),
    Maladie_de_Parkinson ("Maladie de Parkinson"),
    Maladie_Alzheimer ("Maladie d'Alheimer"); 

    private String description;
    private Pathology (String description){
        this.description = description;
    }
    public static void affichePatho (){
        Pathology [] patho = Pathology.values();
        System.out.println("\n Liste des pathologies:");
        for (int i=0; i< patho.length; i++){
            if (patho[i] == Diabetes_type_1){
                System.out.println(patho[i].description);
            }
            else
                System.out.println(patho[i].description);
        }
    }
}