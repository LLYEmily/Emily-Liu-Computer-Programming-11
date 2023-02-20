package com.example.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Didn't use
public class CreateAccount {
    private static String name;
    private static String password;
    static boolean loggedIn;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList createALlAcc(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String accString = "";
        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                accString += line;
            }else{
                String[] fields = accString.split(",");
                String name = fields[0];
                String password = fields[1];
                boolean loggedIn = Boolean.parseBoolean(fields[3]);
                accounts.add(new Account(name.trim(), password.trim()));
                accString = "";
            }
        }
        return accounts;
    }
}
