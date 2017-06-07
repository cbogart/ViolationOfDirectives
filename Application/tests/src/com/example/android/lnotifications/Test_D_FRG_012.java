package com.example.android.lnotifications;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ZFC on 6/7/2017.
 * 
 * Command to compile: "C:\Program Files\Java\jdk1.8.0_131\bin\javac" com\example\android\lnotifications\Test_D_FRG_012.java
 * Command to run: java com.example.android.lnotifications.Test_D_FRG_012
 * 
 */

public class Test_D_FRG_012{

    private static boolean lastCallParameterIsFalse(String call){
        int startOfParas = call.indexOf('(');
        int endOfParas = call.indexOf(')');
        String parameters = call.substring(startOfParas + 1,endOfParas);
        System.out.print(parameters);
        String[] pramList = parameters.split(",");
        if(pramList[pramList.length - 1].trim().equals("false")){
           return true;
        }
        return false;
    }

    public static void main(String[] args){
        try {
             System.out.println("Working Directory = " + System.getProperty("user.dir"));
            BufferedReader br = new BufferedReader(new FileReader("..\\..\\src\\main\\java\\com\\example\\android\\lnotifications\\HeadsUpNotificationFragment.java"));
            String line = br.readLine();
            boolean inOnCreateView = false;
            //return inflater.inflate(R.layout.fragment_heads_up_notification, container);
            //the sentence above is an incorrect sentence - the pattern below is not exact but
            //handles the case above - it should be improved later to handle other cases
            //if necessary
            while(line != null){
                System.out.println(line);
                if (line.contains("public View onCreateView(")){
                   inOnCreateView = true;
                }
                //this is too general of a check for a solid test case, this test
                //should be strengthened to accept other inner branches like try-catch branches
                //This current would say that ending a try-catch branch or an if statement also
                //ends the method
                else if(line.trim().equals("}")){
                    inOnCreateView = false;
                }
                else if(inOnCreateView){
                    System.out.println("in onCreateView");
                    line = line.trim();
                    if(line.startsWith("return inflater.inflate")){
                        System.out.println("first check");
                        if(!lastCallParameterIsFalse(line)) {
                           System.err.println("last parameter is not fail");
                        }
                    }
                }
                line = br.readLine();
            }

        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            System.err.println("The requesedfile was not found");
        }
        catch (IOException e){
            System.err.println("There was an error when reading the file");
        }

    }
}
