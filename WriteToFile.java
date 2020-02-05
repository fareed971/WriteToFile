package com.cimb.springboot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class WriteToFile {
	
private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
private static final String NUMBER = "0123456789";



private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
private static SecureRandom random = new SecureRandom();

public static void main(String[] args) throws IOException {
    int x = 536870911;
    BufferedWriter bw = new BufferedWriter(new FileWriter("E://testFile.txt"));
    if(x >= 1 && x <= (Math.pow(2,30))-1) {
        for(int i=1;i<=x;i++) {
            
            //Write Content
            bw.write(generateRandomString(100));
            bw.newLine();
    }
        bw.flush();
        bw.close();
}
}

 
public static String generateRandomString(int length) {
    if (length < 1) throw new IllegalArgumentException();



    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {



        // 0-62 (exclusive), random returns 0-61
        int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
        char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);



        sb.append(rndChar);



    }



    return sb.toString();
}

}
