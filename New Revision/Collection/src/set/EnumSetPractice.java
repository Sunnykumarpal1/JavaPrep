package set;

import Classes.Days;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class EnumSetPractice {
    public static void run() {
        Set<Days> enumDays = EnumSet.of(Days.Monday,Days.Tuesday, Days.Wednesday , Days.Thursday );
        enumDays.add(Days.Sunday);
        System.out.println(enumDays);
//        Iterator<Days>it=enumDays.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        enumDays.remove(Days.Monday);
        System.out.println(enumDays);

        EnumSet<Days>weekdays=EnumSet.range(Days.Monday,Days.Friday);
        System.out.println(weekdays);


        EnumSet<Days>weekends=EnumSet.complementOf(weekdays);
        System.out.println(weekends);
    }
}
