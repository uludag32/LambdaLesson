import java.io.LineNumberInputStream;
import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));
        ciftKarePrint(sayi);
        System.out.println("\n ");
        tekKupBirFazlaPrit(sayi);
        System.out.println(" \n");
        ciftElKareKokPrint(sayi);
        System.out.println(" \n");
        maxElBul(sayi);
        System.out.println(" \n");
        structuredMaxElBul(sayi);
        System.out.println(" \n");
        ciftMaxElBul(sayi);
    }


        // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
        // ayni satirda aralarina bosluk bırakarak print ediniz

        public static void ciftKarePrint(List<Integer>sayi){
            sayi.
                    stream().
                    filter(Lambda01::ciftBul).// akısdakı cıft sayıları fıltreledım, 4,2,6
                    map(t->t*t).        // 16,4,36 stream ıcerısndekı elemanları baska tıplere donustururu
                    forEach(Lambda01::yazdir);

        }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazlaPrit(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t %2!= 0).
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);
    }
    // Task-3 : Functional Programming ile listin cift elemanlarinin
   // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftElKareKokPrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).        //double
                forEach(t-> System.out.print(t+ " "));
    }

    // Task 4 Lıstın en buyuk elemanının yazıdırınız

    public static void maxElBul(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);
        System.out.println(maxSayi);
    }

    // struuctral yapı ıle
    public static void structuredMaxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);  //max.soutv
        for(int i = 0; i<sayi.size(); i++){
            if(sayi.get(i)>max) max = sayi.get(i);
        }
        System.out.println(" en buyuk sayı :" +max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftMaxElBul(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));
    }
}

