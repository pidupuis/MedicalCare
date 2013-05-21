package tests;

import persons.*;
/*
 * this class allows
 */

public class BloodTest extends Analysis {


    
    private float Hb;
    private float GR;
    private float GB;
    private float hemato;
    private float P;

    public BloodTest(float Hb, float GR, float GB, float hemato, float P, Patient p) throws Exception {
        this.Hb = Hb;
        this.GR = GR;
        this.GB = GB;
        this.hemato = hemato;
        this.P = P;
    
        try {
            checkResult(p);
        } catch (Exception e) {
            throw new Exception ("The results is not good!");
        }

    }

    
   

    public BloodTest() {}

    /**
     *
     * @param Hb
     * @param GR
     * @param GB
     * @param hemato
     * @param P
     * @param p
     * @throws Exception
     */
    public void checkResult(Patient p) throws Exception {
        if (P < 150.0 || P > 400.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        }
        if (GB < 4.0 || GB > 10.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        } else if (p.getGender() == false) {

            if (Hb < 12.5 || Hb > 15.5) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR < 3.8 || GR > 5.2) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato < 37.0 || hemato > 46.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }

        } else {

            if (Hb < 14.0 || Hb > 17.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR < 4.4 || GR > 6.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato < 40.0 || hemato > 52.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }

        }
    }

    /**
     *
     * @param Hb
     * @param GR
     * @param GB
     * @param hemato
     * @param P
     * @param p
     * @throws Exception
     */
    public boolean checkAllResults(Patient p) throws Exception {
        if (P < 150.0 || P > 400.0) {
            return false;
        }
        if (GB < 4.0 || GB > 10.0) {
            return false;
        } else if (p.getGender() == false) {

            if (Hb < 12.5 || Hb > 15.5) {
                return false;
            }
            if (GR < 3.8 || GR > 5.2) {
                return false;
            }
            if (hemato < 37.0 || hemato > 46.0) {
                return false;
            }

        } else {

            if (Hb < 14.0 || Hb > 17.0) {
                return false;
            }
            if (GR < 4.4 || GR > 6.0) {
                return false;
            }
            if (hemato < 40.0 || hemato > 52.0) {
                return false;
            }

        }
        return true;
    }

    

    public float getHb() {
        return Hb;
    }

    public void setHb(float Hb) {
        this.Hb = Hb;
    }

    public float getGR() {
        return GR;
    }

    public void setGR(float GR) {
        this.GR = GR;
    }

    public float getGB() {
        return GB;
    }

    public void setGB(float GB) {
        this.GB = GB;
    }

    public float getHemato() {
        return hemato;
    }

    public void setHemato(float hemato) {
        this.hemato = hemato;
    }

    public float getP() {
        return P;
    }

    public void setP(float P) {
        this.P = P;
    }


}
