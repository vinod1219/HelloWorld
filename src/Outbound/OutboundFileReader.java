package Outbound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutboundFileReader {
    public static String filePath = "/Users/vinik/IdeaProjects/HelloWorld/Files/largefile.txt";

    public static void main(String[] args) {
        Map<String, String> headerValue = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNumber =0;
            while ((line = reader.readLine()) != null) {
                rowNumber = rowNumber+1;
                if(!headerValue.containsKey(line)){
                    if(line.contains("ISA*01")){
                        String str = line.substring(7);
                        String str1 = rowNumber +"-"+ str;
                        //System.out.println("---"+str1);
                        headerValue.put("ISA*01", str1);
                    }
                }else{
                        System.out.println("Duplicate ISA*01 " + line);
                }
                if(!headerValue.containsKey(line)){
                    if(line.contains("GS*PO")){
                        String str = line.substring(6);
                        String str1 = rowNumber +"-"+ str;
                        headerValue.put("GS*PO", str1);
                    }
                }else{
                    System.out.println("Duplicate GS*PO* " + line);
                }
                if(!headerValue.containsKey(line)){
                    if(line.contains("INS*Y")){
                        String str = line.substring(6);
                        String str1 = rowNumber +"-"+ str;
                        headerValue.put("INS*Y", str1);
                    }
                }else{
                    System.out.println("Duplicate INS*Y " + line);
                }
            }

            System.out.println(headerValue.entrySet());
            System.out.println(headerValue.get("INS*Y"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
