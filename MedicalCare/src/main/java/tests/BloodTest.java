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
    private Patient pat;

    public BloodTest(float Hb, float GR, float GB, float hemato, float P, Patient pat) throws Exception {
        this.Hb = Hb;
        this.GR = GR;
        this.GB = GB;
        this.hemato = hemato;
        this.P = P;
        this.pat = pat;

        try {
            checkResult();
        } catch (Exception e) {
            throw new Exception("The results is not good!");
        }

    }

    public BloodTest() {
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
    public void checkResult() throws Exception {
        if (P < 150.0 || P > 400.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        }
        if (GB < 4.0 || GB > 10.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        } else if (this.pat.getGender() == false) {

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
    public boolean checkP() {
        return !(P < 150.0 || P > 400.0);

    }

    public boolean checkGB() {
        return !(GB < 4.0 || GB > 10.0);
    }

    public boolean checkHb() {
        if (this.pat.getGender()) {
            return !(Hb < 14.0 || Hb > 17.0);
        }

        return !(Hb < 12.5 || Hb > 15.5);
    }

    public boolean checkGR() {
        if (this.pat.getGender()) {
            return !(GR < 4.4 || GR > 6.0);
        }

        return !(GR < 3.8 || GR > 5.2);
    }

    public boolean checkHemato() {
        if (this.pat.getGender()) {
            return !(hemato < 40.0 || hemato > 52.0);
        }

        return !(hemato < 37.0 || hemato > 46.0);
    }

    public boolean checkAllResults() throws Exception {
        if (P < 150.0 || P > 400.0) {
            return false;
        }
        if (GB < 4.0 || GB > 10.0) {
            return false;
        } else if (this.pat.getGender() == false) {

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

    public void setHb(float Hb) throws Exception {
        if (!this.checkHb()) {
            throw new Exception("Hb value is not good");
        }
        this.Hb = Hb;
    }

    public float getGR() {
        return GR;
    }

    public void setGR(float GR) throws Exception {
        if (!this.checkGR()) {
            throw new Exception("GR value is not good");
        }
        this.GR = GR;
    }

    public float getGB() {
        return GB;
    }

    public void setGB(float GB) throws Exception {
        if (!this.checkGB()) {
            throw new Exception("GB value is not good");
        }
        this.GB = GB;
    }

    public float getHemato() {
        return hemato;
    }

    public void setHemato(float hemato) throws Exception {
        if (!this.checkHemato()) {
            throw new Exception("Hemato value is not good");
        }
        this.hemato = hemato;
    }

    public float getP() {
        return P;
    }

    public void setP(float P) throws Exception {
        if (!this.checkP()) {
            throw new Exception("P value is not good");
        }
        this.P = P;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    @Override
    public String toString() {
        return "BloodTest{" + "Hb=" + Hb + ", GR=" + GR + ", GB=" + GB + ", hemato=" + hemato + ", P=" + P + '}';
    }
}
