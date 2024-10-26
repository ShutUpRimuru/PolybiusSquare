import java.util.Scanner;

public class Decryptor {
    public static void main(String[] args) {
        //переменные + массивы
        Scanner sc = new Scanner(System.in);
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя,.-";
        char[][] alphabetSquare = new char[6][6];

        // заполнение таблицы алфовитом
        int stringNumToFill = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetSquare[stringNumToFill][i % 6] = alphabet.charAt(i);
            if ((i + 1) % 6 == 0) {
                stringNumToFill++;
            }
        }

        //ввод
        System.out.print("Введите зашифрованное сообщение: ");
        String text = sc.nextLine();

        // разбиваем каждое число на строку, считываем каждую цифру, парсим в инт и записывает в соответствующий индекс дабы вытащить этот символ из таблицы
        String[] nums = text.split(" ");
        String out = "";
        int indexI = -1, indexJ = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length(); j++) {
                if (nums[i].charAt(j) == '|'){
                    out += ' ';
                    continue;
                }
                if (j % 2 == 0) {
                    indexI = nums[i].charAt(j) - '0' - 1;
                    continue;
                }
                indexJ = nums[i].charAt(j) - '0' - 1;
                out += alphabetSquare[indexI][indexJ];
            }
        }

        //ввывод
        System.out.println(out);
    }
}
