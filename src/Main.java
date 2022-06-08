import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static char op;
    static int n1, n2, result_r;
    static String result, bl1, bl2;

    public static void main(String args[]) {
        String st = scan.nextLine();                         //Принемаем строку
        char ch1[] = new char[12];                           //Переводим в массив символов
        //Определяем операцию
g:  {
    try {
        for (int i = 0; i < st.length(); i++) {
            ch1[i] = st.charAt(i);
            if (ch1[i] == ('.' | ','))
                throw new InputMismatchException();
            if (ch1[i] == '+')
                op = '+';
            if (ch1[i] == '-')
                op = '-';
            if (ch1[i] == '*')
                op = '*';
            if (ch1[i] == '/')
                op = '/';
        }
    } catch (InputMismatchException e) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
            String text = "Введите целое число";
            bw.write(text);
        } catch (IOException ex) {}
        break g;
    }

    try {
        String st_tr = st.trim();                              //обрезаем строку
        String bl[] = st_tr.split("[+-/*]");             //делим строку
        if(bl.length>2) throw new InputMismatchException();
        bl1 = bl[0];
        bl2 = bl[1];
    } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
            String text = "Введите выражение а+в, а-в, а*в, а/в";
            bw.write(text);
        } catch (IOException ex) {}
        break g;
    }

    n1 = Convertor1(bl1);                                                           //конвертируем строки в числа
    n2 = Convertor1(bl2);

    if (n1 > 0 && n2 > 0) {
        try {


        result_r = calculater(n1, n2, op);                                          //производим вычичления
        if (result_r < 1) throw new InputMismatchException();
        result = String.valueOf(Convertor2(result_r));
        }catch (InputMismatchException e){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
                String text = "В римской системе нет отрицательных чисел";
                bw.write(text);
            } catch (IOException ex) {}
            break g;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
            String text = result;
            bw.write(text);                                                           //Записываем результат в файл
            } catch (IOException ex) {}

        } else {
            try {
                    n1 = Integer.parseInt(bl1);
                    n2 = Integer.parseInt(bl2);

                    if (n1 > 0 && n1 <= 10 && n2 > 0 && n2 <= 10) {
                        int result_a = calculater(n1, n2, op);
                        result = String.valueOf(result_a);
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
                            String text = result;
                            bw.write(text);
                        } catch (IOException ex) {}
                    }
                    else throw new  NumberFormatException ();

                } catch (NumberFormatException e) {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))) {
                        String text = "Введите числа от 1(I) до 10(X), одной системы счисления";
                        bw.write(text);
                    } catch (IOException ex) {}
                    break g;
                  }
               }
    }
    }

    public static String Convertor2(int a) {
        try {
            String[] r = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                    "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                    "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                    "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
                    "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                    "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                    "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII",
                    "XCIX", "C"};
            String s = r[a];
            return s;
        }catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public static int Convertor1(String r) {

        if (r.equals("I"))
            return 1;
        if (r.equals("II"))
            return 2;
        if (r.equals("III"))
            return 3;
        if (r.equals("IV"))
            return 4;
        if (r.equals("V"))
            return 5;
        if (r.equals("VI"))
            return 6;
        if (r.equals("VII"))
            return 7;
        if (r.equals("VIII"))
            return 8;
        if (r.equals("IX"))
            return 9;
        if (r.equals("X"))
            return 10;
        else return 0;
    }

    public static int calculater (int n1, int n2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
        }
        return result;
    }
}