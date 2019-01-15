import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
Есть программа, хранящая в памяти телефонную книгу (забита в коде программы).
Телефонная книга для каждого ФИО хранит список номеров.
Входные данные
Иванов И.И. +8 800 2000 500 +8 800 200 600
Петров П.П. +8 800 2000 700
Сидоров С.С. +8 800 2000 800 +8 800 2000 900 +8 800 2000 000

На вход программе подается ФИО, программа печатает телефоны, привязанные к этому ФИО.
Если телефона нет, программа должна выдать сообщение о том, что такого ФИО в БД нет.

Пример:
Пользователь вводит
Иванов И.И.
Программа выдает
1. +8 800 2000 500
2. +8 800 200 600
*/

//В программе используется только ввод/вывод, т.к. по условию телефонная книга уже существует в памяти приложения
//написание тестов, считаю, избыточно
public class Main {
    static String
            personOne = "Иванов И.И.",
            personTwo = "Петров П.П.",
            personThree = "Сидоров С.С.";

    static ArrayList<String> personOneNumbs = new ArrayList<String>(),
                             personTwoNumbs = new ArrayList<String>(),
                             personThreeNumbs = new ArrayList<String>();

    static HashMap<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

    static void initRecords() {
        personOneNumbs.add("+8 800 2000 500");
        personOneNumbs.add("+8 800 200 600");
        personTwoNumbs.add("+8 800 2000 700");
        personThreeNumbs.add("+8 800 2000 800");
        personThreeNumbs.add("+8 800 2000 900");
        personThreeNumbs.add("+8 800 2000 000");

        phoneBook.put(personOne, personOneNumbs);
        phoneBook.put(personTwo, personTwoNumbs);
        phoneBook.put(personThree, personThreeNumbs);
    }

    static void printPhones(ArrayList<String> arr){
        for(String s : arr) {
            System.out.println(arr.indexOf(s) + 1 + ". " + s);
        }
    }

    static void printContacts(){
        int count = 0;
        Iterator<String> it = phoneBook.keySet().iterator();
        while(it.hasNext())
            System.out.println(++count + ". " + it.next());
    }

    static {
        initRecords();
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Контакты:");
        printContacts();

        System.out.println("Введите ФИО");
        String fio;
        while ((fio = sc.nextLine()) != null)
            printPhones(phoneBook.get(fio));
    }
}
