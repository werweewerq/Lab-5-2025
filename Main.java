import functions.*;

public class Main {
    public static void main(String[] args) {
        double[] values = {6, 11, 16, 21, 26, 31, 36, 41, 46, 51};
        testArray(values);
        testList(values);
    }

    private static void testArray(double[] v) {
        ArrayTabulatedFunction arr = new ArrayTabulatedFunction(0, 18, v);
        ArrayTabulatedFunction arrCopy = (ArrayTabulatedFunction) arr.clone();
        LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(0, 18, v);
        System.out.println("Проверка array:");
        System.out.println(arr.toString());
        System.out.println(arrCopy.toString());
        System.out.println(list.toString() + '\n');
        System.out.println("Сравнение для одинаковых классов");
        System.out.println(arr.equals(arrCopy) ? "Функции равны" : "Функции не равны");
        System.out.println("Сравнение для разных классов");
        System.out.println(arr.equals(list) ? "Функции равны" : "Функции не равны");
        System.out.println();
        System.out.println("hash для arr");
        System.out.println(arr.hashCode());
        System.out.println("hash для arrCopy");
        System.out.println(arrCopy.hashCode());
        System.out.println("hash для list");
        System.out.println(list.hashCode() + "\n");
        arrCopy.setPointY(5, arrCopy.getPointY(5) + 0.001);
        System.out.println("После изменения точки в arrCopy на 0.001");
        System.out.println(arr.toString());
        System.out.println(arrCopy.toString());
        System.out.println(list.toString() + '\n');
        System.out.println("Сравнение для одинаковых классов");
        System.out.println(arr.equals(arrCopy) ? "Функции равны" : "Функции не равны");
        System.out.println("Сравнение для разных классов");
        System.out.println(arr.equals(list) ? "Функции равны" : "Функции не равны");
        System.out.println();
        System.out.println("hash для arr");
        System.out.println(arr.hashCode());
        System.out.println("hash для arrCopy");
        System.out.println(arrCopy.hashCode());
        System.out.println("hash для list");
        System.out.println(list.hashCode() + "\n");
    }

    private static void testList(double[] v) {
        LinkedListTabulatedFunction list = new LinkedListTabulatedFunction(0, 18, v);
        LinkedListTabulatedFunction listCopy = (LinkedListTabulatedFunction) list.clone();
        ArrayTabulatedFunction arr = new ArrayTabulatedFunction(0, 18, v);
        System.out.println("Проверка List:");
        System.out.println(list.toString());
        System.out.println(listCopy.toString());
        System.out.println(arr.toString() + '\n');
        System.out.println("Сравнение для одинаковых классов");
        System.out.println(list.equals(listCopy) ? "Функции равны" : "Функции не равны");
        System.out.println("Сравнение для разных классов");
        System.out.println(list.equals(arr) ? "Функции равны" : "Функции не равны");
        System.out.println();
        System.out.println("hash для list");
        System.out.println(list.hashCode());
        System.out.println("hash для listCopy");
        System.out.println(listCopy.hashCode());
        System.out.println("hash для arr");
        System.out.println(arr.hashCode() + "\n");
        listCopy.setPointY(5, listCopy.getPointY(5) + 0.001);
        System.out.println("После изменения точки в listCopy на 0.001");
        System.out.println(list.toString());
        System.out.println(listCopy.toString());
        System.out.println(arr.toString() + '\n');
        System.out.println("Сравнение для одинаковых классов");
        System.out.println(list.equals(listCopy) ? "Функции равны" : "Функции не равны");
        System.out.println("Сравнение для разных классов");
        System.out.println(list.equals(arr) ? "Функции равны" : "Функции не равны");
        System.out.println();
        System.out.println("hash для list");
        System.out.println(list.hashCode());
        System.out.println("hash для listCopy");
        System.out.println(listCopy.hashCode());
        System.out.println("hash для arr");
        System.out.println(arr.hashCode() + "\n");
    }
}