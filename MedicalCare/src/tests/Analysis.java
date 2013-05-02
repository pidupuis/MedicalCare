package tests;

/**
 *
 * @author Cogotch
 */
public abstract class Analysis {

    private String observations;
    
    /**
     * Default constructor of the Analysis class.
     * 
     */
    public Analysis() {
        
    }
    
    /**
     * Constructor of the Analysis class.
     * 
     * @param observations
     */
    public Analysis(String observations) {
        this.observations = observations;
    }
    

    /**
     * Returns the observations.
     * 
     * @return String
     */
    public String getObservations() {
        return this.observations;
    }

    /**
     * Set new observations to the Analysis
     * .
     * @param observations
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

}