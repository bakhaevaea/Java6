package src.main.java.org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Computer> computers = getComputers();
        System.out.println(computers);
        Map<Integer, String> filterParams = getFilterParams();
        if (filterParams.size() != 0) {
            filterComputers(computers, filterParams);
        }

    }
/* формируется список компьютеров*/
    private static List getComputers(){
        Computer comp1 = new Computer("BOD-WDI9", "HUAWEI", 15.6,
                3.0, 8, "Windows 11 Home", 42, 39990);
        Computer comp2 = new Computer("Spirit 2", "ITEL", 15.6,
                3.0, 8, "Linux", 50, 29990);
        Computer comp3 = new Computer("Corebook X 14/16/512", "CHUWI", 14,
                2.1, 16, "Windows 11 Home", 46, 35990);
        Computer comp4 = new Computer("Sword 15 A12UE-487XRU", "MSI", 15.6,
                2.1, 16, "Free DOS", 53, 119990);
        Computer comp5 = new Computer("V15 G2 ITL", "LENOVO", 15.6,
                3.0, 8, "Free DOS", 38, 43990);
        Computer comp6 = new Computer("MateBook X Pro MRGF-X", "HUAWEI", 14.2,
                2.1, 16, "Windows 11 Home", 60, 113990);
        Computer comp7 = new Computer("MegaBook T1", "TECNO", 15.6,
                1.2, 16, "Windows 11 Home", 80, 49990);
        Computer comp8 = new Computer("EVE 15 P417", "DIGMA", 15.6,
                1.6, 4, "Windows 10 Home", 5, 19990);

        List<Computer> computers = new ArrayList<>();
        computers.add(comp1);
        computers.add(comp2);
        computers.add(comp3);
        computers.add(comp4);
        computers.add(comp5);
        computers.add(comp6);
        computers.add(comp7);
        computers.add(comp8);

        return computers;
    }
    /* Формирует список нужных параметров */
    private static Map<Integer, String> getFilterParams(){
        Map<Integer, String> filterParams = new HashMap<>();
        int parametr = -1;
        String value = "";
        while (true ) {
            System.out.println("Выберите критерий поиска ( можно по очереди указать несколько критериев)");
            System.out.println("1 - модель \n" +
                    "2 - бренд \n" +
                    "3 - Диагональ экрана в дюймах \n" +
                    "4 - Процессор,частота, ГГц \n" +
                    "5 - Оперативная память, ГБ \n" +
                    "6 - Операционная система \n" +
                    "7 - Энергоемкость батареи, Wh \n" +
                    "8 - Цена, руб \n " +
                    "\n0 - Поиск по введенным параметрам\n");
            Scanner in = new Scanner(System.in);
            parametr = in.nextInt();
            switch (parametr){
                case 1 :
                    System.out.println("Введите нужную модель ноутбука: ");
                    Scanner in1 = new Scanner(System.in);
                    value = in1.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 2:
                    System.out.println("Введите нужный бренд: ");
                    Scanner in2 = new Scanner(System.in);
                    value = in2.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 3 :
                    System.out.println("Введите минимальную диагональ: ");
                    Scanner in3 = new Scanner(System.in);
                    value = in3.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 4 :
                    System.out.println("Введите минимальную частоту процессора, ГГц: ");
                    Scanner in4 = new Scanner(System.in);
                    value = in4.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 5:
                    System.out.println("Введите минимальный объем оперативной памяти: ");
                    Scanner in5 = new Scanner(System.in);
                    value = in5.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 6 :
                    System.out.println("Введите нужную операционную систему: ");
                    Scanner in6 = new Scanner(System.in);
                    value = in6.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case  7 :
                    System.out.println("Введите минимальную энергоемкость батареи: ");
                    Scanner in7 = new Scanner(System.in);
                    value = in7.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 8:
                    System.out.println("Введите максимальную цену: ");
                    Scanner in8 = new Scanner(System.in);
                    value = in8.nextLine();
                    filterParams.put(parametr, value);
                    break;
                case 0 :
                    return filterParams;
                default:
                    System.out.println("Введите корректно число");
                    break;
            }

        }
    }
/* выводит компьютеры с нужными параметрами*/
    private  static void filterComputers(List<Computer> computers, Map<Integer, String> params){
        System.out.println("Результат поиска: ");
        computers.stream()
                .filter(p -> (p.getName().contains( ((params.containsKey(1))? params.get(1):"") )))
                .filter(p -> (p.getBrand().contains( ((params.containsKey(2))? params.get(2):"") )))
                .filter(p -> (p.getDiagonal() >=( (params.containsKey(3)) ? Double.parseDouble(params.get(3)): 0)) )
                .filter(p -> (p.getProcessor() >=( (params.containsKey(4)) ? Double.parseDouble(params.get(4)): 0)) )
                .filter(p -> (p.getMemory() >=( (params.containsKey(5)) ? Integer.parseInt(params.get(5)): 0)) )
                .filter(p -> (p.getOs().contains( ((params.containsKey(6))? params.get(6):"") )))
                .filter(p -> (p.getBattery() >=( (params.containsKey(7)) ? Integer.parseInt(params.get(7)): 0)) )
                .filter(p -> (p.getPrice() <=( (params.containsKey(8)) ? Integer.parseInt(params.get(8)): Integer.MAX_VALUE)) )
                .collect( Collectors.toList())
                .forEach(System.out::println);
    }
}