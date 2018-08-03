package nemchinovrp.streamtask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.

        Затем вывести только группы, содержащие более одного элемента. Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове.

        Слова внутри группы нужно сортировать по убыванию (по количеству символов); если число символов равное, то сортировать в алфавитном порядке.

        Пример строки: String s = "сапог сарай арбуз болт бокс биржа"
        Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]”*/


public class StreamTask {
    public static void main(String[] args) {
        System.out.print(Arrays.toString((Arrays.stream("сапог сарай арбуз болт бокс биржа".split(" "))
                .collect(Collectors.groupingBy(word -> word.substring(0, 1))))
                .entrySet()
                .stream()
                .filter((mapa) -> (mapa.getValue().size() > 1))
                .sorted(Comparator.comparing(mapaF -> mapaF.getValue().get(0)))
                .peek((mapa2) -> mapa2.getValue().sort((word1, word2) ->
                        Integer.compare(word1.length(), word2.length()) * -1 != 0?
                                Integer.compare(word1.length(), word2.length()) * -1:word1.compareTo(word2)
                ))
                .toArray()));
    }
}
