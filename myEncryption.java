// I was inspired by "Shift Cipher" while doing this assignment.
// The encryption system uses the length of the input as a key value. 
// E.g., the input "Hello" has 5 letters so every letter gets shifted 5 letters forward when doing an encryption. 
// The same goes for decryption but it does backwards shifting.
// Don't forget to set your encoding to UTF-8, otherwise some special characters will have wrong values such as -1

import java.util.*;

public class myEncryption {
    public static Scanner scan = new Scanner(System.in); 

    static Character[] letters = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z'};
    static List<Character> alphabet = Arrays.asList(letters);

    public static int optionScreen(){
        System.out.println("Make a choice. (0: Encryption | 1: Decryption)");
        int choice  = Integer.valueOf(scan.nextLine());
        if(choice != 0 && choice != 1){
            System.out.println("Please make a proper choice!\n");
            return optionScreen();
        }
        return choice;
    }

    public static String takeInput(int choice){
        switch(choice){
            case 0:
                System.out.print("Plain text? ");
                break;
            case 1:
                System.out.print("Cipher text? ");
                break;
            default:
        }
        String input = scan.nextLine().toLowerCase();
        return input;
    }

    public static void encryption(String text){
        char[] textChar = text.toCharArray();
        StringBuilder cipherText = new StringBuilder();
        int x, k;
        for(int i=0; i<textChar.length; i++){
            x = alphabet.indexOf(textChar[i]);
            k = textChar.length;
            cipherText.append(alphabet.get( (x + k) % 29) );
        }
        System.out.println("Cipher text: " + cipherText.toString().toLowerCase());
    }

    public static void decryption(String text){
        char[] textChar = text.toCharArray();
        StringBuilder plainText = new StringBuilder();
        int x, k;
        for(int i=0; i<textChar.length; i++){
            x = alphabet.indexOf(textChar[i]);
            k = textChar.length;
            int backShift = x - k;
            if (backShift < 0){
                backShift = (backShift + 29) % 29;
            }
            else {
                backShift = backShift % 29;
            }
            plainText.append(alphabet.get(backShift));
        }
        System.out.println("Plain text: " + plainText.toString().toLowerCase());
    }

    public static void main(String args[]){
        int choice = optionScreen();
        String input = takeInput(choice);
        switch(choice){
            case 0:
                encryption(input);
                break;
            case 1:
                decryption(input);
                break;
            default:
        } 
        scan.close();
    }
}