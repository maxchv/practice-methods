package ua.step.homework;

/**
 * Палиндром — это последовательность символов, которая слева-направо и
 * справа-налево пишется одинаково. Например «АБА» или «АББ ББА». Дана
 * последовательность символов. Метод makePalindrome() должен преобразовать
 * строку удалив минимальное количество символов из строки,
 * чтобы получить палиндром.
 * Длина последовательности не больше 20 символов, вводится с клавиатуры.
 * <p>
 * Алгоритм решения данной задачи <a href='https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D1%81%D0%B8%D1%8F#%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%C2%AB%D0%A1%D0%B4%D0%B5%D0%BB%D0%B0%D0%B9_%D0%BF%D0%B0%D0%BB%D0%B8%D0%BD%D0%B4%D1%80%D0%BE%D0%BC%C2%BB'>Задача «Сделай палиндром»</>
 */
public class Task03 {
    public static void main(String[] args) {
        String word = "AADDAFD";
        String result = makePalindrome(word);
        System.out.println("result = " + result);
    }

    /**
     * Рекурсивный метод превращающий входную строку в палиндром
     * @param word - входная строка - не палиндром
     * @return палиндром
     */
    public static String makePalindrome(String word) {
        // TODO: удалите исключение и пишите здесь код
        throw new RuntimeException("Not implemented yet");
    }
}
