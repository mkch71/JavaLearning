/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */
public class Main {
    public static void main(String[] args) {
        String[] arrWord = {"Мама", "Мыла", "Раму"};

        possibleString(arrWord, 0);
        System.out.println("-------------------");
        //циклом
        for (int i=0;i< arrWord.length; i++){
            for( int j=0; j< arrWord.length;j++){
                if (j!=i){
                    System.out.println(arrWord[i]+arrWord[j]+arrWord[3-i-j]);
                }

            }
        }
    }
    public static void possibleString(String[] x, int index) {
        if (index == x.length) {
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i]);
            }
            System.out.println();
        }
        for (int i = index; i < x.length; i++) {
            String temp = x[index];
            x[index] = x[i];
            x[i] = temp;
            possibleString(x, index + 1);
            temp = x[index];
            x[index] = x[i];
            x[i] = temp;
        }
    }
}
/*
Решение нагуглил, как я понимаю этого никто не запрещал и мы не в вузе когда сданный код проганяется через антиплагиат и им подобные ))) (у обоих старших сыновей преподователи 
програмирования проверяли персноальность разработки)
Можно было делать через массив, но так красивше)))
Взято тут 
https://coderoad.ru/50205943/%D0%92%D1%8B%D0%B2%D0%B5%D0%B4%D0%B8%D1%82%D0%B5-%D0%B2%D1%81%D0%B5-%D0%B2%D0%BE%D0%B7%D0%BC%D0%BE%D0%B6%D0%BD%D1%8B%D0%B5-%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BD%D0%B0%D1%86%D0%B8%D0%B8-%D0%B4%D0%BB%D1%8F-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%BD%D0%BE%D0%B3%D0%BE-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%B0-%D1%8D%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82%D0%BE%D0%B2
*/
