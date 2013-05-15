/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import persons.Patient;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vincent
 */
public class BloodTestTest {
    
    public BloodTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkResult method, of class BloodTest.
     */
    @Test
    public void testCheckResult() throws Exception {
        System.out.println("checkResult");
        /* POUR UN HOMME */
        Patient p = new Patient("prenom","nom",1980,12,12,true);
        Boolean expRes;
        Boolean Res=true;
        
        /* cas où toutes les valeurs sont en dessous des notmes physiologiques*/
        float Hb = 0;
        float GR = 0;
        float GB = 0;
        float hemato = 0;
        float P = 0;
        expRes = false;
        
        try {
            BloodTest instance=new BloodTest( Hb,  GR,  GB,  hemato,  P, p);
            Res=true;
        }
        catch (Exception e) { 
                Res = false;
        } 
       assertEquals(expRes,Res);
       
       /* cas où toutes les valeurs sont en dessus des notmes physiologiques*/
       Hb = 1000000.0F;
       GR = 10000000.0F;
       GB = 10000000.0F;
       hemato = 10000000.0F;
       P = 10000000.0F;

        expRes = false;
        
        try {
            BloodTest instance=new BloodTest( Hb,  GR,  GB,  hemato,  P, p);
            Res=true;
        }
        catch (Exception e) { 
                Res = false;
        } 
       assertEquals(expRes,Res);
       
        /* cas où toutes les valeurs sont dans les notmes physiologiques*/
        Hb = 15.0F;
        GR = 5.0F;
        GB = 8.0F;
        hemato = 45.0F;
        P = 300;
        expRes = true;
        
        try {
            BloodTest instance=new BloodTest( Hb,  GR,  GB,  hemato,  P, p);
            Res=true;
        }
        catch (Exception e) { 
                Res = false;
        } 
       assertEquals(expRes,Res);
    
    
     /* POUR UNE FEMME */
        p = new Patient("prenom","nom",1980,12,12,false);
        
        /* cas où toutes les valeurs sont dans les notmes physiologiques*/
        Hb = 15.0F;
        GR = 5.0F;
        GB = 8.0F;
        hemato = 45.0F;
        P = 300;
        expRes = true;
        
        try {
            BloodTest instance=new BloodTest( Hb,  GR,  GB,  hemato,  P, p);
            Res=true;
        }
        catch (Exception e) { 
                Res = false;
        } 
       assertEquals(expRes,Res);
    }

    /**
     * Test of getResults method, of class BloodTest.
     */
    @Test
    public void testGetResults() throws Exception {
        System.out.println("getResults");
        float Hb = 15.0F;
        float GR = 5.0F;
        float GB = 8.0F;
        float hemato = 45.0F;
        float P = 300F;
        float expResult;
        float result;
        int i;
        Patient p = new Patient("prenom","nom",1980,12,12,false);
        BloodTest instance = new BloodTest( Hb,  GR,  GB,  hemato,  P,  p);
        for (i=0;i<5;i++){
            if (i==0){
                expResult = 15.0F;
                result = instance.getResults(i);
                assertEquals(expResult, result,0.0);
            } 
            else if (i==1){
                expResult = 5.0F;
                result = instance.getResults(i);
                assertEquals(expResult, result,0.0);
            }
            else if (i==2){
                expResult = 8.0F;
                result = instance.getResults(i);
                assertEquals(expResult, result,0.0);
            } 
            else if (i==3){
                expResult = 45.0F;
                result = instance.getResults(i);
                assertEquals(expResult, result,0.0);
            }
            else if (i==4){
                expResult = 300F;
                result = instance.getResults(i);
                assertEquals(expResult, result,0.0);
            } 
            
        }
        
    }

    /**
     * Test of setResults method, of class BloodTest.
     */
    @Test
    public void testSetResults() throws Exception {
        System.out.println("setResults");
        float[] results= new float[5];
        float Hb = 15.0F;
        float GR = 5.0F;
        float GB = 8.0F;
        float hemato = 45.0F;
        float P = 300F;
        float expResult;
        float res;
        results[0] = Hb;
        results[1] = GR;
        results[2] = GB;
        results[3] = hemato;
        results[4] = P;        
        P = 300F;
        Patient p = new Patient("prenom","nom",1980,12,12,true);
        BloodTest instance = new BloodTest( 17,  6,  6,  46, 350,  p);
        instance.setResults( Hb,  GR,  GB,  hemato,  P,  p);
        expResult = 15.0F;
        res=instance.getResults(0);
        assertEquals(expResult, res,0.0);
        expResult = 5.0F;
        res=instance.getResults(1);
        assertEquals(expResult, res,0.0);        
        expResult = 8.0F;
        res=instance.getResults(2);
        assertEquals(expResult, res,0.0);
        expResult = 45.0F;
        res=instance.getResults(3);
        assertEquals(expResult, res,0.0);
        expResult = 300F;
        res=instance.getResults(4);
        assertEquals(expResult, res,0.0);


    }
}
