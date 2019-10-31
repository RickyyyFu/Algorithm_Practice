package invoice;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Invoice_System s1 = new Invoice_System();
		List<String> test1 = new ArrayList<>();
        test1.add("CREATE: id=13  &amount =800 & currency = USD");
        String[] t1 = test1.toArray(new String[test1.size()]);
        System.out.println("test1: " + s1.calculate_total_owed(1, t1)); //800

        Invoice_System s2 = new Invoice_System();
        List<String> test2 = new ArrayList<>();
        test2.add("CREATE: id=16&amount=800&currency=USD");
        test2.add("FINALIZE: id=16&amount=600&currency=USD");
        String[] t2 = test2.toArray(new String[test2.size()]);
        System.out.println("test2: " + s2.calculate_total_owed(2, t2));//600
        
        Invoice_System s3 = new Invoice_System();
        List<String> test3 = new ArrayList<>();
        test3.add("CREATE: id=16&amount=800&currency=USD");
        test3.add("FINALIZE: id=16&amount=600&currency=USD");
        test3.add("CREATE: id=13&amount=800&currency=USD");
        String[] t3 = test3.toArray(new String[test3.size()]);
        System.out.println("test3: " + s3.calculate_total_owed(3, t3));//1400
        
        Invoice_System s4 = new Invoice_System();
        List<String> test4 = new ArrayList<>();
        test4.add("CREATE: id=16&amount=800&currency=USD");
        test4.add("FINALIZE: id=16&amount=600&currency=USD");
        test4.add("PAY: id=16");
        String[] t4 = test4.toArray(new String[test4.size()]);
        System.out.println("test4: " + s4.calculate_total_owed(3, t4));//0
        
        Invoice_System s5 = new Invoice_System();
        List<String> test5 = new ArrayList<>();
        test5.add("CREATE: amount=800&id=16&currency=USD");
        test5.add("FINALIZE: id=16&amount=600&currency=USD&otherfield=a");
        test5.add("PAY: otherfield=a&id=16");
        String[] t5 = test5.toArray(new String[test5.size()]);
        System.out.println("test5: " + s5.calculate_total_owed(3, t5));//0
        
        Invoice_System s6 = new Invoice_System();
        List<String> test6 = new ArrayList<>();
        test6.add("CREATE: amount=800&id=16&currency=USD");
        test6.add("FINALIZE: id=16&amount=600&currency=US"); // invalid? not USD ignore?
        test6.add("PAY: id=16");
        String[] t6 = test6.toArray(new String[test6.size()]);
        System.out.println("test6: " + s6.calculate_total_owed(2, t6));// 800
        System.out.println("test6: "+ s6.calculate_total_owed(3, t6)); // 800 ?
        
        Invoice_System s7 = new Invoice_System();
        List<String> test7 = new ArrayList<>();
        test7.add("Random action");
        String[] t7 = test7.toArray(new String[test7.size()]);
        System.out.println("test7: " + s7.calculate_total_owed(1, t7));//0
        
        Invoice_System s8 = new Invoice_System();
        List<String> test8 = new ArrayList<>();
        test8.add("CREATE: id=16&amount=800&currency=USD");
        test8.add("FINALIZE: id=16&amount=600&currency=USD");
        test8.add("PAY: id=16");
        test8.add("CREATE: id=16&amount=800&currency=USD");
        String[] t8 = test8.toArray(new String[test8.size()]);
        System.out.println("test8: " + s8.calculate_total_owed(4, t8));//0
        
        Invoice_System s9 = new Invoice_System();
        List<String> test9 = new ArrayList<>();
//        test9.add("FINALIZE: id=16&amount=800&currency=USD");
        test9.add("CREATE: id=14&amount=500&currency=RMB");
        test9.add("CREATE: id=15&amount=500&currency=USD");
        test9.add("FINALIZE: id=14&amount=600&currency=USD");
        test9.add("FINALIZE: id=15&amount=400&currency=USD");
//        test9.add("PAY: id=16");
        String[] t9 = test9.toArray(new String[test9.size()]);
        System.out.println("test9: " + s9.calculate_total_owed(4, t9));// 0 ?
        
        Invoice_System s11 = new Invoice_System();
        List<String> test11 = new ArrayList<>();
        test11.add("CREATE: id=1&amount=5000&currency=USD");
        test11.add("FINALIZE: id=1&amount=5000&currency=USD");
        test11.add("PAY: id=1");
        test11.add("CREATE: id=2&amount=2500&currency=USD");
        test11.add("FINALIZE: id=2&amount=0&currency=USD");
        test11.add("FINALIZE: id=3&amount=3000&currency=USD");
        test11.add("CREATE: id=3&amount=3000&currency=USD");
        test11.add("FINALIZE: id=4&amount=3500&currency=USD");
        test11.add("CREATE: id=5&amount=70000&currency=USD");
        test11.add("PAY: id=5");
        test11.add("CREATE: id=6&amount=19000&currency=CAD");
        test11.add("PAY: id=4");
        test11.add("CREATE: id=7&amount=6000&currency=USD");
        test11.add("FINALIZE: id=7&amount=6500&currency=USD");
        test11.add("CREATE: id=8&amount=3000&currency=USD");
        test11.add("FINALIZE: id=8&amount=2500&currency=USD");
        test11.add("PAY: id=8");
        test11.add("PAY: id=1");
        String[] t11 = test11.toArray(new String[test11.size()]);
        System.out.println("test11: " + s11.calculate_total_owed(20, t11));// 79500
	}
}
