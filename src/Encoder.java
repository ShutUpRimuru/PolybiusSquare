import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) {
        //переменные + массив
        Scanner sc = new Scanner(System.in);

        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,.-";
        char[][] alphabetSquare = new char[6][6];

        int stringNum = 0;

        //заполнение массива
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetSquare[stringNum][i % 6] = alphabet.charAt(i);
            if ((i + 1) % 6 == 0) {
                stringNum++;
            }
        }

//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.print(alphabetSquare[i][j]);
//            }
//            System.out.println();
//        }

        //ввод
        System.out.print("Введите сообщение: ");
        String text = sc.nextLine();

        //вытаскиваем индекс каждого символа и добаем+форматируем в строку вывода
        int indexInAlphabetString, indexI, indexJ = -1;
        String out = "";
        for (int i = 0; i < text.length(); i++) {
            indexInAlphabetString = alphabet.indexOf(text.charAt(i));
            indexI = indexInAlphabetString / 6;

            String temp = new String(alphabetSquare[indexI]);
            indexJ = temp.indexOf(text.charAt(i));

            if (text.charAt(i) == ' ') {
                out += "| ";
                continue;
            }
            out += String.format("%d%d ", indexI + 1, indexJ + 1);
        }
        String trimmedOut = out.trim();

        System.out.println(trimmedOut);

    }
}