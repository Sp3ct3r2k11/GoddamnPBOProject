/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Ryo
 */
public class CountDown extends JLabel implements Runnable{

    @Override
        public void run() {

            while(true){
                try {
                    setText(now());
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(gui.Passanger.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            
        }
    private String now(){
        int SECONDS_IN_A_DAY = 24 * 60 * 60;
        Calendar thatDay =Calendar.getInstance();
        thatDay.setTime(Database.DataAccess.selectingNearestFlight());
        Calendar today = Calendar.getInstance();
        long diff =  thatDay.getTimeInMillis() - today.getTimeInMillis(); 
        long diffSec = diff / 1000;
        System.out.println(thatDay.getWeekYear());
        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long seconds = secondsDay % 60;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600); // % 24 not needed
        if(days==0&&seconds==0&&minutes==0&&hours==0){
            Database.DataAccess.TakeOff();
        }
        return "Next flight :"+days+" days "+hours+" hours "+minutes+" minutes "+seconds+" seconds "+"left.";
    }
}
