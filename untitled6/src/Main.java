import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("// 1");
        List<Double> passengerTimes = new ArrayList<>();
        List<Double> boatTimes = new ArrayList<>();
        System.out.println("Введите среднее время между появлением пассажиров утром:");
        passengerTimes.add(sc.nextDouble());
        System.out.println("Введите среднее время между появлением пассажиров днём:");
        passengerTimes.add(sc.nextDouble());
        System.out.println("Введите среднее время между появлением пассажиров вечером:");
        passengerTimes.add(sc.nextDouble());
        System.out.println("Введите среднее время между появлением катеров утром:");
        boatTimes.add(sc.nextDouble());
        System.out.println("Введите среднее время между появлением катеров днём:");
        boatTimes.add(sc.nextDouble());
        System.out.println("Введите среднее время между появлением катеров вечером:");
        boatTimes.add(sc.nextDouble());
        System.out.println("Введите тип остановки катера (конечная или нет):");
        String stopType = sc.next();

        Random random = new Random();
        int randomSeats = random.nextInt(50) + 1;
        double averageStay = (passengerTimes.get(0) + passengerTimes.get(1) + passengerTimes.get(2)) / 3;
        System.out.println("Среднее время пребывания человека на остановке: " + averageStay);
        System.out.println("Введите N (максимальное кол-во людей на остановке):");
        int n = sc.nextInt();
        double sufficientInterval = ((boatTimes.get(0) + boatTimes.get(1) + boatTimes.get(2)) / 3) + (n * 0.2);
        System.out.println("Достаточный интервал прихода катеров для удержания не более " + n + " человек: " + sufficientInterval);
        System.out.println("Случайное кол-во свободных мест в катере: " + randomSeats);
        System.out.println("Тип остановки катера: " + stopType);
        System.out.println("Powered by ak1ne");

        System.out.println("// 2");
        Map<String, List<String>> dictionary = new HashMap<>();
        Map<String, Integer> popularity = new HashMap<>();
        System.out.println("Введите кол-во начальных слов в словаре:");
        int initialWords = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < initialWords; i++) {
            System.out.println("Введите слово:");
            String word = sc.nextLine();
            System.out.println("Введите переводы слова через запятую:");
            String[] translates = sc.nextLine().split(",");
            List<String> list = new ArrayList<>();
            for (String t : translates) list.add(t.trim());
            dictionary.put(word, list);
            popularity.put(word, 0);
        }
        boolean dictRunning = true;
        while (dictRunning) {
            System.out.println("Выберите действие (циферкой):");
            System.out.println("1 - Показать переводы слова");
            System.out.println("2 - Добавить перевод к слову");
            System.out.println("3 - Заменить перевод слова");
            System.out.println("4 - Удалить перевод слова");
            System.out.println("5 - Добавить новое слово");
            System.out.println("6 - Заменить слово");
            System.out.println("7 - Удалить слово");
            System.out.println("8 - Показать топ-10 самых популярных слов");
            System.out.println("9 - Показать топ-10 самых непопулярных слов");
            System.out.println("0 - Завершить работу со словарём");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Введите слово:");
                    String w1 = sc.nextLine();
                    if (dictionary.containsKey(w1)) {
                        System.out.println("Переводы: " + dictionary.get(w1));
                        popularity.put(w1, popularity.get(w1) + 1);
                    } else {
                        System.out.println("Слова нет в словаре");
                    }
                    break;
                case 2:
                    System.out.println("Введите слово:");
                    String w2 = sc.nextLine();
                    if (dictionary.containsKey(w2)) {
                        System.out.println("Введите перевод для добавления:");
                        String addTr = sc.nextLine();
                        dictionary.get(w2).add(addTr);
                    } else {
                        System.out.println("Слова нет в словаре");
                    }
                    break;
                case 3:
                    System.out.println("Введите слово:");
                    String w3 = sc.nextLine();
                    if (dictionary.containsKey(w3)) {
                        System.out.println("Введите старый перевод:");
                        String oldTr = sc.nextLine();
                        System.out.println("Введите новый перевод:");
                        String newTr = sc.nextLine();
                        List<String> trList = dictionary.get(w3);
                        if (trList.contains(oldTr)) {
                            trList.remove(oldTr);
                            trList.add(newTr);
                            dictionary.put(w3, trList);
                        } else {
                            System.out.println("Такого перевода нет");
                        }
                    } else {
                        System.out.println("Слова нет в словаре");
                    }
                    break;
                case 4:
                    System.out.println("Введите слово:");
                    String w4 = sc.nextLine();
                    if (dictionary.containsKey(w4)) {
                        System.out.println("Введите перевод для удаления:");
                        String delTr = sc.nextLine();
                        dictionary.get(w4).remove(delTr);
                    } else {
                        System.out.println("Слова нет в словаре");
                    }
                    break;
                case 5:
                    System.out.println("Введите новое слово:");
                    String w5 = sc.nextLine();
                    System.out.println("Введите переводы нового слова через запятую:");
                    String[] newTrans = sc.nextLine().split(",");
                    List<String> newList = new ArrayList<>();
                    for (String t : newTrans) newList.add(t.trim());
                    dictionary.put(w5, newList);
                    popularity.put(w5, 0);
                    break;
                case 6:
                    System.out.println("Введите существующее слово:");
                    String oldWord = sc.nextLine();
                    if (dictionary.containsKey(oldWord)) {
                        System.out.println("Введите новое слово:");
                        String newWord = sc.nextLine();
                        List<String> existing = dictionary.remove(oldWord);
                        int oldPop = popularity.remove(oldWord);
                        dictionary.put(newWord, existing);
                        popularity.put(newWord, oldPop);
                    } else {
                        System.out.println("Слова нет в словаре");
                    }
                    break;
                case 7:
                    System.out.println("Введите слово для удаления:");
                    String w7 = sc.nextLine();
                    dictionary.remove(w7);
                    popularity.remove(w7);
                    break;
                case 8:
                    List<String> popularWords = new ArrayList<>(dictionary.keySet());
                    popularWords.sort((a, b) -> popularity.get(b) - popularity.get(a));
                    System.out.println("Топ-10 популярных слов:");
                    for (int i = 0; i < Math.min(10, popularWords.size()); i++) {
                        System.out.println(popularWords.get(i) + " - " + popularity.get(popularWords.get(i)));
                    }
                    break;
                case 9:
                    List<String> unpopWords = new ArrayList<>(dictionary.keySet());
                    unpopWords.sort(Comparator.comparingInt(popularity::get));
                    System.out.println("Топ-10 непопулярных слов:");
                    for (int i = 0; i < Math.min(10, unpopWords.size()); i++) {
                        System.out.println(unpopWords.get(i) + " - " + popularity.get(unpopWords.get(i)));
                    }
                    break;
                case 0:
                    dictRunning = false;
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        }
        System.out.println("Powered by ak1ne");

        System.out.println("// 3");
        class Fine {
            String type;
            double amount;
            String city;
            Fine(String type, double amount, String city) {
                this.type = type;
                this.amount = amount;
                this.city = city;
            }
        }
        class Person {
            String name;
            String id;
            List<Fine> fines;
            Person(String name, String id) {
                this.name = name;
                this.id = id;
                this.fines = new ArrayList<>();
            }
        }
        Map<String, Person> taxDB = new HashMap<>();
        boolean taxRunning = true;
        while (taxRunning) {
            System.out.println("Выберите действие (циферкой):");
            System.out.println("1 - Полный вывод базы данных");
            System.out.println("2 - Вывод по коду");
            System.out.println("3 - Вывод по типу штрафа");
            System.out.println("4 - Вывод по городу");
            System.out.println("5 - Добавить новую запись о человеке");
            System.out.println("6 - Добавить новые штрафы для существующего человека");
            System.out.println("7 - Удалить штраф у человека");
            System.out.println("8 - Изменить информацию о человеке и его штрафах");
            System.out.println("0 - Завершить работу с базой данных");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    for (String key : taxDB.keySet()) {
                        Person p = taxDB.get(key);
                        System.out.println("Имя: " + p.name + ", Код: " + p.id);
                        for (Fine f : p.fines) {
                            System.out.println("Штраф: " + f.type + ", Сумма: " + f.amount + ", Город: " + f.city);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите код:");
                    String code = sc.nextLine();
                    if (taxDB.containsKey(code)) {
                        Person px = taxDB.get(code);
                        System.out.println("Имя: " + px.name + ", Код: " + px.id);
                        for (Fine f : px.fines) {
                            System.out.println("Штраф: " + f.type + ", Сумма: " + f.amount + ", Город: " + f.city);
                        }
                    } else {
                        System.out.println("Нет записи с таким кодом");
                    }
                    break;
                case 3:
                    System.out.println("Введите тип штрафа:");
                    String typeFine = sc.nextLine();
                    for (Person p : taxDB.values()) {
                        for (Fine f : p.fines) {
                            if (f.type.equalsIgnoreCase(typeFine)) {
                                System.out.println("Имя: " + p.name + ", Код: " + p.id + ", Штраф: " + f.type + ", Сумма: " + f.amount + ", Город: " + f.city);
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите город:");
                    String cityFine = sc.nextLine();
                    for (Person p : taxDB.values()) {
                        for (Fine f : p.fines) {
                            if (f.city.equalsIgnoreCase(cityFine)) {
                                System.out.println("Имя: " + p.name + ", Код: " + p.id + ", Штраф: " + f.type + ", Сумма: " + f.amount + ", Город: " + f.city);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Введите имя:");
                    String nameNew = sc.nextLine();
                    System.out.println("Введите код:");
                    String codeNew = sc.nextLine();
                    Person newPerson = new Person(nameNew, codeNew);
                    taxDB.put(codeNew, newPerson);
                    System.out.println("Введите кол-во штрафов:");
                    int cntFines = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < cntFines; i++) {
                        System.out.println("Введите тип штрафа:");
                        String tF = sc.nextLine();
                        System.out.println("Введите сумму штрафа:");
                        double aF = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Введите город:");
                        String cF = sc.nextLine();
                        newPerson.fines.add(new Fine(tF, aF, cF));
                    }
                    break;
                case 6:
                    System.out.println("Введите код:");
                    String codeExist = sc.nextLine();
                    if (taxDB.containsKey(codeExist)) {
                        Person pe = taxDB.get(codeExist);
                        System.out.println("Введите кол-во добавляемых штрафов:");
                        int addFines = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < addFines; i++) {
                            System.out.println("Введите тип штрафа:");
                            String tF = sc.nextLine();
                            System.out.println("Введите сумму штрафа:");
                            double aF = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Введите город:");
                            String cF = sc.nextLine();
                            pe.fines.add(new Fine(tF, aF, cF));
                        }
                    } else {
                        System.out.println("Нет записи с таким кодом");
                    }
                    break;
                case 7:
                    System.out.println("Введите код:");
                    String codeDel = sc.nextLine();
                    if (taxDB.containsKey(codeDel)) {
                        Person pd = taxDB.get(codeDel);
                        System.out.println("Введите тип штрафа для удаления (скопипастите с бд если не помните):");
                        String typeDel = sc.nextLine();
                        Fine removeFine = null;
                        for (Fine f : pd.fines) {
                            if (f.type.equalsIgnoreCase(typeDel)) {
                                removeFine = f;
                                break;
                            }
                        }
                        if (removeFine != null) {
                            pd.fines.remove(removeFine);
                            System.out.println("Штраф удалён");
                        } else {
                            System.out.println("Штраф не найден");
                        }
                    } else {
                        System.out.println("Нет записи с таким кодом");
                    }
                    break;
                case 8:
                    System.out.println("Введите код:");
                    String codeRep = sc.nextLine();
                    if (taxDB.containsKey(codeRep)) {
                        Person pr = taxDB.get(codeRep);
                        System.out.println("Текущее имя: " + pr.name + ", изменить? (да/нет)");
                        String ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("да")) {
                            System.out.println("Введите новое имя:");
                            pr.name = sc.nextLine();
                        }
                        System.out.println("Текущее кол-во штрафов: " + pr.fines.size() + ", изменить? (да/нет)");
                        ans = sc.nextLine();
                        if (ans.equalsIgnoreCase("да")) {
                            pr.fines.clear();
                            System.out.println("Введите кол-во штрафов заново:");
                            int newSize = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < newSize; i++) {
                                System.out.println("Введите тип штрафа:");
                                String tF = sc.nextLine();
                                System.out.println("Введите сумму штрафа:");
                                double aF = sc.nextDouble();
                                sc.nextLine();
                                System.out.println("Введите город:");
                                String cF = sc.nextLine();
                                pr.fines.add(new Fine(tF, aF, cF));
                            }
                        }
                    } else {
                        System.out.println("Нет записи с таким кодом :/");
                    }
                    break;
                case 0:
                    taxRunning = false;
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        }
        System.out.println("Powered by ak1ne");
    }
}
