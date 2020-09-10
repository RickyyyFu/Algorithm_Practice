package AdsConversionRate;

import java.util.*;

public class AdsConversionRate {
	public static void main(String[] args) {
		String[] completedPurchaseUserIds = {"3123122444","234111110", "8321125440", "99911063"};
		String[] adClicks = {"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
			  "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
			  "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
			  "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
			  "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
			  "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens"};
		String[] allUserIps = {"2339985511,122.121.0.155",
			  "234111110,122.121.0.1",
			  "3123122444,92.130.6.145",
			  "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
			  "8321125440,82.1.106.8",
			  "99911063,92.130.6.144"};
		System.out.println(adsConversionRate(completedPurchaseUserIds, adClicks, allUserIps));
	}
	
	public static List<String> adsConversionRate(String[] completedPurchaseUserIds, String[] adClicks, String[] allUserIps){
		Set<String> PurchaseIds = new HashSet<>();
		for(String id : completedPurchaseUserIds) PurchaseIds.add(id);
		
		Map<String, String> IpToId = new HashMap<>();
		for(String userId : allUserIps) {
			String[] info = userId.split(",");
			IpToId.put(info[1], info[0]);
		}
		
		Map<String, int[]> Ad_Buy_Click = new HashMap<>();
		for(String adclick : adClicks) {
			String[] info = adclick.split(",");
			String ad = info[2];
			if(!Ad_Buy_Click.containsKey(ad)) Ad_Buy_Click.put(ad, new int[2]);
			Ad_Buy_Click.get(ad)[1]++;
			
			String ip = info[0];
			if(PurchaseIds.contains(IpToId.get(ip))) Ad_Buy_Click.get(ad)[0]++;
		}
		
		List<String> res = new ArrayList<>();
		for(String ad : Ad_Buy_Click.keySet()) {
			res.add(Ad_Buy_Click.get(ad)[0] + " of " + Ad_Buy_Click.get(ad)[1] + " " + ad);
		}
		
		return res;
	}
}
