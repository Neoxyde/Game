/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import java.io.File;
import model.Userbank;
import view.Frame;

/**
 *
 * @author David Darío Del Prado González
 */
public class Run
{
    public static void main(String[] args)
    {
        File file   = new File("..\\Game\\src\\model\\data.json");
        Userbank userbank   = new Userbank(file);
        Frame frame = new Frame(userbank);        
    }
}
