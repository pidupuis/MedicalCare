package tests;

import persons.*;
/*
 * this class allows
 */

public class BloodTest extends Analysis {

    private int Hb;
    private int GR;
    private int GB;
    private int hemato;
    private int P;
    private Patient pat;

    public BloodTest(int Hb, int GR, int GB, int hemato, int P, Patient pat) throws Exception {
        this.Hb = Hb;
        this.GR = GR;
        this.GB = GB;
        this.hemato = hemato;
        this.P = P;

        this.pat = pat;

        try {
            checkAllResults();
        } catch (Exception e) {
            throw new Exception("The results is not good!");
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
    public void checkResult() throws Exception {
        if (P < 150 || P > 400) {
            throw new Exception("the result given was not included in the physiologic norms");
        }
        if (GB < 4 || GB > 10) {
            throw new Exception("the result given was not included in the physiologic norms");
        } else if (this.pat.getGender() == false) {

            if (Hb < 12 || Hb > 15) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR < 3 || GR > 5) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato < 37 || hemato > 46) {
                throw new Exception("the result given was not included in the physiologic norms");
            }

        } else {

            if (Hb < 14 || Hb > 17) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR < 4 || GR > 6) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato < 40 || hemato > 52) {
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
        return !(P < 150 || P > 400);

    }

    public boolean checkGB() {
        return !(GB < 4 || GB > 10);
    }

    public boolean checkHb() {
        if (this.pat.getGender()) {
            return !(Hb < 14 || Hb > 17);
        }

        return !(Hb < 12 || Hb > 15);
    }

    public boolean checkGR() {
        if (this.pat.getGender()) {
            return !(GR < 4 || GR > 6);
        }

        return !(GR < 3 || GR > 5);
    }

    public boolean checkHemato() {
        if (this.pat.getGender()) {
            return !(hemato < 40 || hemato > 52);
        }

        return !(hemato < 37 || hemato > 46);
    }

    public boolean checkAllResults() throws Exception {
        if (P < 150 || P > 400) {
            return false;
        }
        if (GB < 4 || GB > 10) {
            return false;
        } else if (this.pat.getGender() == false) {

            if (Hb < 12 || Hb > 15) {
                return false;
            }
            if (GR < 3 || GR > 5) {
                return false;
            }
            if (hemato < 37 || hemato > 46) {
                return false;
            }

        } else {

            if (Hb < 14 || Hb > 17) {
                return false;
            }
            if (GR < 4 || GR > 6) {
                return false;
            }
            if (hemato < 40 || hemato > 52) {
                return false;
            }

        }
        return true;
    }

    public int getHb() {
        return Hb;
    }

    public void setHb(int Hb) throws Exception {
        if (!this.checkHb()) {
            throw new Exception("Hb value is not good");
        }
        this.Hb = Hb;
    }

    public int getGR() {
        return GR;
    }

    public void setGR(int GR) throws Exception {
        if (!this.checkGR()) {
            throw new Exception("GR value is not good");
        }
        this.GR = GR;
    }

    public int getGB() {
        return GB;
    }

    public void setGB(int GB) throws Exception {
        if (!this.checkGB()) {
            throw new Exception("GB value is not good");
        }
        this.GB = GB;
    }

    public int getHemato() {
        return hemato;
    }

    public void setHemato(int hemato) throws Exception {
        if (!this.checkHemato()) {
            throw new Exception("Hemato value is not good");
        }
        this.hemato = hemato;
    }

    public int getP() {
        return P;
    }

    public void setP(int P) throws Exception {
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
