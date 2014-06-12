/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openjtalkdicedit;

/**
 *
 * @author user
 */
public class OpenJTalkDicEdit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame frm = new MainFrame();
        //frm.csvFilename = args[0];
        frm.readFile(args[0]);
        frm.setVisible(true);
    }
    
}
