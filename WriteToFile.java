package com.cimb.springboot;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.Scanner;

public class WriteToFile {

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	private static final String NUMBER = "0123456789";
	private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	private static SecureRandom random = new SecureRandom();
	
public static void main(String[] args) {
final Integer number = 1073741823;
try (Scanner scanner = new Scanner(System.in);/*
FileChannel rwChannel = new RandomAccessFile("textfile.txt", "rw").getChannel();*/) {
System.out.println("Enter your Number : ");
final Integer userNum = scanner.nextInt();
if (userNum > number || userNum < 1) {
System.out.println("Please Enter a Number between 1 and 1073741823");
}
System.out.println(userNum);
long time = System.currentTimeMillis();
File file = new File("E://testFilechannel.txt");
PrintWriter pw = new PrintWriter(new FileWriter(file));
for (int i = 0; i < userNum; i++)
pw.println(getUniqueString(i));
pw.close();
/*ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, 45 * userNum);
for (int i = 1; i <= userNum; i++) {
String uniqueStr = getUniqueString(i);
wrBuf.put(uniqueStr.getBytes());
}*/
System.out.println("total time : "+(System.currentTimeMillis() - time));
} catch (Exception e) {
e.printStackTrace();
System.out.println("Please Enter a Number between 1 and 1073741823");
}
}
//To Get Unique String
private static String getUniqueString(final Integer i) {
StringBuilder builder = null;
builder = new StringBuilder("abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+={[}]|\\:'<,>.?/ABCDEFGHIJKLMNOPQRSTUVWXYZ");
String str = getRemString(("" + i).length());
builder.append(str);
builder.append(i);
// builder.append("\n");
return builder.toString();
}
//Remaining string
private static String getRemString(final Integer length) {
switch (length) {
case 1:
return "xxxxxxxxx";
case 2:
return "xxxxxxxx";
case 3:
return "xxxxxxx";
case 4:
return "xxxxxx";
case 5:
return "xxxxx";
case 6:
return "xxxx";
case 7:
return "xxx";
case 8:
return "xx";
case 9:
return "x";
}
return "";
}


//for future use, to generate Random string
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
