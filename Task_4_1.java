/*Реализовать консольное приложение, которое:

Принимает от пользователя строку вида
text~num

Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.

text~num (например, word~4)
print~num (распечатать текст)

word~1
foo~5
qwerty~10
bar~5
print~10 -> qwerty
print~1 -> word
print~2 -> пустая строка или исключение NoSuchElementException
print~5 -> bar
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Task_4_1 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in); 
        Boolean notStop = true;
     
        while(notStop){
        String text = getString(scanner); 
      
        if(text.equals("p")){
            System.out.println(list);
            }
        else {
            addAndRemovElementInMyList(list,text);
            }
        if(text == "q"){
            notStop = false;
            }
        }
    }
    private static LinkedList<String> addAndRemovElementInMyList(LinkedList<String> list, String text){

        String[] split = text.split("~");
        String word = split[0];
        String numElem = split[1];
        int item = Integer.parseInt(numElem);
        int size = item- list.size();
        LinkedList<String> remList = new LinkedList<>();

        if (word.equals("print")){ 
            
            if (item > list.size()){
                System.out.println("Список короче. Сначала добавьте елемент");
            }
            if (list.get(item-1) == null){
                System.out.println("На этой позиции нет элемента");
            }
            remList.add(list.get(item-1));
            list.remove(item-1);
            list.add(item-1, null);
            System.out.println(remList);
            }
        else{
            if(list.size() < item){
                for (int index = 0; index < size-1; index++) {
                    list.add(null);
                    }
                    list.addLast(word);
                }
                if (list.size() == item){
                    list.set(item-1, word);
                }
                if (list.size() > item){
                    list.set(item-1, word);
                }    
           }
         return list;
        }

    public static String getString(Scanner scanner) {
        System.out.println("Введите строку по образцу:\n'text'~'num' (text: набор символов без пробелов. num: число) - сохранит text в связный список на позицию num;\n'print'~'num'- выводит text из позиции num и удаляет из списка;\n'p'- выводит Список на консоль\n'q' - выход.");
        String result = scanner.nextLine();
        return result;
    }
}
