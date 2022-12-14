import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.print(calc(expression));
    }

    public static String calc(String input) throws ScannerException {

        String[] elementOfInput = input.split(" ");
        String checkArabic = "1 2 3 4 5 6 7 8 9 10";
        String checkRoman = "I II III IV V VI VII VIII IX X";
        String[] romanInput = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (elementOfInput.length == 3 && checkRoman.contains(elementOfInput[0]) && checkRoman.contains(elementOfInput[2])) {
            int firstNumberRoman = 0;
            int secondNumberRoman = 0;
            int result = 0;
            for (int i = 0; i < romanInput.length; i++) {
                if (elementOfInput[0].equals(romanInput[i])) {
                    firstNumberRoman += i + 1;
                }
            }
            for (int i = 0; i < romanInput.length; i++) {
                if (elementOfInput[2].equals(romanInput[i])) {
                    secondNumberRoman += i + 1;
                }
            }
            switch (elementOfInput[1]) {
                case "+":
                    result += firstNumberRoman + secondNumberRoman;
                    return romanNumerals[result - 1];
                case "-":
                    result += firstNumberRoman - secondNumberRoman;
                    if (result > 1) {
                        return romanNumerals[result - 1];
                    } else {
                        throw new ScannerException("?? ?????????????? ?????????????? ?????? ?????????????????????????? ??????????");
                    }
                case "*":
                    result += firstNumberRoman * secondNumberRoman;
                    return romanNumerals[result - 1];
                case "/":
                    result += firstNumberRoman / secondNumberRoman;
                    return romanNumerals[result - 1];
                default:
                    throw new ScannerException("?????????????????????? ????????????????");
            }
        } else if (elementOfInput.length == 3 && checkArabic.contains(elementOfInput[0]) && checkArabic.contains(elementOfInput[2])) {
            int firstNumberArabic = Integer.valueOf(elementOfInput[0]);
            int secondNumberArabic = Integer.valueOf(elementOfInput[2]);
            int result = 0;
            switch (elementOfInput[1]) {
                case "+":
                    result += firstNumberArabic + secondNumberArabic;
                    return Integer.toString(result);
                case "-":
                    result += firstNumberArabic - secondNumberArabic;
                    return Integer.toString(result);
                case "*":
                    result += firstNumberArabic * secondNumberArabic;
                    return Integer.toString(result);
                case "/":
                    result += firstNumberArabic / secondNumberArabic;
                    return Integer.toString(result);
                default:
                    throw new ScannerException("?????????????????????? ????????????????");
            }
        } else if (elementOfInput.length == 3 &&
                ((checkArabic.contains(elementOfInput[0]) && checkRoman.contains(elementOfInput[2])) ||
                        (checkRoman.contains(elementOfInput[0]) && checkArabic.contains(elementOfInput[2])))) {
            throw new ScannerException("???????????????? ???????????? ???????????? ??????????????????");
        } else if (elementOfInput.length < 3) {
            throw new ScannerException("???????????? ???? ???????????????? ???????????????????????????? ??????????????????");
        } else if (elementOfInput.length > 3) {
            throw new ScannerException("???????????? ???????????????????????????? ???????????????? ???? ?????????????????????????? ?????????????? - ?????? ???????????????? ?? ???????? ???????????????? (+, -, /, *)");
        } else {
            throw new ScannerException("???????????????? ???? ?????????????????????? ?????????????????? ???? 1 ???? 10");
        }
    }
}



