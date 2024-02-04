package countstatistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CountStatistics {

    public static void main(String[] args) {
        Scanner stdInput = new Scanner(System.in);
        System.out.println("������� �� path ��� �������:");
        String filename = "";
        
        try {
            filename = stdInput.nextLine();
            stdInput.close();
            
            if (!filename.isEmpty()) {
                int countAlphaUpper = 0;
                int countAlphaLower = 0;
                int countGammaUpper = 0;
                int countGammaLower = 0;
                int countOmegaUpper = 0;
                int countOmegaLower = 0;
                int countOne = 0;
                int countThree = 0;
                int countFive = 0;
                int countSeven = 0;
                int countNine = 0;
                
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                char c;
                
                while (reader.ready()) {
                    c = (char) reader.read();
                    switch (c) {
                        case '�':
                            countAlphaUpper++;
                            break;
                        case '�':
                            countAlphaLower++;
                            break;
                        case '�':
                            countGammaUpper++;
                            break;
                        case '�':
                            countGammaLower++;
                            break;
                        case '�':
                            countOmegaUpper++;
                            break;
                        case '�':
                            countOmegaLower++;
                            break;
                        case '1':
                            countOne++;
                            break;
                        case '3':
                            countThree++;
                            break;
                        case '5':
                            countFive++;
                            break;
                        case '7':
                            countSeven++;
                            break;
                        case '9':
                            countNine++;
                            break;
                        default:
                            break;
                    }
                }
                reader.close();
                System.out.println("File statistics:");
                System.out.println("A: " + countAlphaUpper);
                System.out.println("�: " + countAlphaLower);
                System.out.println("Ó: " + countGammaUpper);
                System.out.println("�: " + countGammaLower);
                System.out.println("�: " + countOmegaUpper);
                System.out.println("�: " + countOmegaLower);
                System.out.println("1: " + countOne);
                System.out.println("3: " + countThree);
                System.out.println("5: " + countFive);
                System.out.println("7: " + countSeven);
                System.out.println("9: " + countNine);
            } else {
                //file name is empty
                System.out.println("No file path provided");
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
} 
    
    
