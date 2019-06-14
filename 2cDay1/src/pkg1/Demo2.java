package pkg1;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        readFile();

        //writeFile();
        //testInput();
    }

    public static void testInput() throws IOException {
        InputStream in  = System.in;
//        int content = in.read();
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println(bufferedReader.readLine());
    }

    public static void writeFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/jc/Desktop/a.txt");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
        outputStreamWriter.write("大家好");

        outputStreamWriter.close();
    }

    public static void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/jc/Desktop/a.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        int content = 0;
        while ((content = inputStreamReader.read())!=-1){
            System.out.println((char)content);
        }

        inputStreamReader.close();

    }
}