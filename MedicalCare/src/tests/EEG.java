package tests;

public class EEG extends Analysis {

    private int result;

    /**
     *
     * @param res
     */
    public EEG(int res) {
        this.result = res;
    }

    public int getResult() {
        return this.result;
    }

    /**
     *
     * @param Result
     */
    public void setResult(int result) {
        if ((result > 0) && (result <= 10)) {
            this.result = result;
        }
        else    {
            System.out.println("Le résultat doit être compris entre 1 et 10.");
        }
    }
    
    public boolean checkEEG()   {
        String query = "";
        query = "SELECT * FROM ANALYSE_EEG WHERE rownum < 4 ORDER BY ANALYSE_EEG_RESULTAT DESC";
        return false;
    }
}