package Amazon;
/**
 * 
 * @author Ricky
 *	two pointer	
 *	O(min(M,N)*K) M: the length of codelist  	N: the length of shopping cart	K: the average length of groups in codelist
 *	O(1)
 */


public class FreshPromotion {
	 public static int winPrize(String[][] codeList, String[] shoppingCart) {
		 if(codeList == null || codeList.length == 0) return 1;
		 if(shoppingCart == null || shoppingCart.length == 0) return 0;
		 
		 int c_idx = 0, s_idx = 0;
		 while(c_idx < codeList.length && s_idx+codeList[c_idx].length <= shoppingCart.length) {
			 String[] list = codeList[c_idx];
			 if(check(list, shoppingCart, s_idx)) {
				 c_idx++;
				 s_idx += list.length;
			 }
			 else {
				 s_idx++;
			 }
		 }
		 return c_idx == codeList.length ? 1 :0;
	 }
	 
	 public static boolean check(String[] list, String[] shoppingCart, int idx) {
		 for(int i = 0; i < list.length; i++) {
			 if(list[i].equals("anything") || list[i].equals(shoppingCart[idx+i])) continue;
			 else return false;
		 }
		 return true;
	 }
	 
	 public static void main(String[] args) {
	        // test cases
		 	String[][] codeList0 = { { "anything" }};
	        String[] shoppingCart0 = {"orange", "apple", "apple", "banana", "orange", "banana"};
	        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
	        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
	        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
	        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
	        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
	        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
	        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
	        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
	        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
	        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
	        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
	        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
	        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
	        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
	        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
	        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
	        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
	        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

	        System.out.println(winPrize(codeList0, shoppingCart0));
	        System.out.println(winPrize(codeList1, shoppingCart1));
	        System.out.println(winPrize(codeList2, shoppingCart2));
	        System.out.println(winPrize(codeList3, shoppingCart3));
	        System.out.println(winPrize(codeList4, shoppingCart4));
	        System.out.println(winPrize(codeList5, shoppingCart5));
	        System.out.println(winPrize(codeList6, shoppingCart6));
	        System.out.println(winPrize(codeList7, shoppingCart7));
	        System.out.println(winPrize(codeList8, shoppingCart8));
	        System.out.println(winPrize(codeList9, shoppingCart9));
	        
//	        test(codeList0, shoppingCart0, 1);
//	        test(codeList1, shoppingCart1, 1);
//	        test(codeList2, shoppingCart2, 0);
//	        test(codeList3, shoppingCart3, 0);
//	        test(codeList4, shoppingCart4, 0);
//	        test(codeList5, shoppingCart5, 1);
//	        test(codeList6, shoppingCart6, 1);
//	        test(codeList7, shoppingCart7, 1);
//	        test(codeList8, shoppingCart8, 1);
//	        test(codeList9, shoppingCart9, 1);
	    }
}
