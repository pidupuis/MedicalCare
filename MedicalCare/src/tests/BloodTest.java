package tests;

import persons.*;
/*
 * this class allows
 */

public class BloodTest extends Analysis {

    private float[] results;
    private float Hb;
    private float GR;
    private float GB;
    private float hemato;
    private float P;

    /**
     *
     * @param Hb
     * @param GR
     * @param GB
     * @param hemato
     * @param P
     */
    public BloodTest(float Hb, float GR, float GB, float hemato, float P, Patient p) {
        this.results = new float[5];

        this.results[0] = Hb;
        this.results[1] = GR;
        this.results[2] = GB;
        this.results[3] = hemato;
        this.results[4] = P;

        try {
            checkResult(Hb, GR, GB, hemato, P, p);
        } catch (Exception e) {
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
    public void checkResult(float Hb, float GR, float GB, float hemato, float P, Patient p) throws Exception {
        if (P >= 150.0 || P <= 400.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        }
        if (GB >= 4.0 || GB <= 10.0) {
            throw new Exception("the result given was not included in the physiologic norms");
        } else if (p.getGender() == false) {
            
            if (Hb >= 12.5 || Hb <= 15.5) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR >= 3.8 || GR <= 5.2) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato >= 37.0 || hemato <= 46.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }

        } else {

            if (Hb >= 14.0 || Hb <= 17.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (GR >= 4.4 || GR <= 6.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }
            if (hemato >= 40.0 || hemato <= 52.0) {
                throw new Exception("the result given was not included in the physiologic norms");
            }

        }
    }

    /**
     *
     * @param index
     * @return
     */
    public float getResults(int index) {
        return this.results[index];
    }

    /**
     *
     * @param results
     */
    public void setResults(float[] results) {
        throw new UnsupportedOperationException();
    }
}