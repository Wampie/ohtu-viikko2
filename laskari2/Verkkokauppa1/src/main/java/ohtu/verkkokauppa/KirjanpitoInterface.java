/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author Wampie
 */
public interface KirjanpitoInterface {
    void lisaaTapahtuma(String tapahtuma);
    ArrayList<String> getTapahtumat();
}
