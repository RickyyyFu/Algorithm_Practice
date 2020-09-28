package StripeInBox;

import java.util.*;

public class StripeInBox {
	class Charge{
		String charge_id;
		String merchant_id;
		String card_network;
		int amount;
		
		// String status = "Wait";
		
		public Charge(String charge_id, String merchant_id, String card_network, int amount) {
			this.charge_id = charge_id;
			this.merchant_id = merchant_id;
			this.card_network = card_network;
			this.amount = amount;
		}
		
		public float getConfirmedAmount() {
			float percentage_card = card_percentages.get(card_network);
			float fee = amount * (percentage_card + stripe_fee);
			return amount - fee;
		}
		
		public float getRefundDeduct() {
			return amount*stripe_fee;
		}
	}
	
	static float stripe_fee = 0.02f;
	Map<String, Float> card_percentages = new HashMap<>();
	// Map<String, Integer> payout_amount = new HashMap<>(); // Key: merchant id	Value: total payout amount to return   Math.ceil() 
	Map<String, Float> payout_balance = new HashMap<>();  // Key: merchant id	Value: total payout amount to return   Math.ceil() 
	Map<String, Charge> charge_list = new HashMap<>();	// Key: charge id
	
	
	public void service() {
		try (Scanner scanner = new Scanner(System.in)) {
			int N = Integer.parseInt(scanner.nextLine());
			for(int k = 0; k < N; k++) {
				String card_network_percent = scanner.nextLine();
				String[] str = card_network_percent.split(" ");
				String card_name = str[0];
				String percent_str = str[1];
				float percent = Float.parseFloat(percent_str);
				
				card_percentages.put(card_name, percent / 100);
			}
			
			int M = Integer.parseInt(scanner.nextLine());
			for(int k = 0; k < M; k++) {
				String action = scanner.nextLine();
				String[] str = action.split("\\?");
				String cmd = str[0];
				String attributes = str[1];
				
				if(cmd.substring(1).equals("charge")) {
					String charge_id = "";
					String merchant_id = "";
					String card_network = "";
					int amount = 0;
					
					String[] attr = attributes.split("&");
					for(String a : attr) {
						if(a.startsWith("charge_id")) {
							String[] chargeIdStr = a.split("=");
							if(chargeIdStr.length != 2) continue; // 防止越界
							charge_id = chargeIdStr[1].trim(); 
							if(!charge_id.isEmpty()) {
							}
						}
						else if(a.startsWith("merchant_id")) {
							String[] merchantIdStr = a.split("=");
							if(merchantIdStr.length != 2) continue; // 防止越界
							merchant_id = merchantIdStr[1].trim(); 
							if(!merchant_id.isEmpty()) {
							}
						}
						else if(a.startsWith("network")) {
							String[] networkStr = a.split("=");
							if(networkStr.length != 2) continue; // 防止越界
							card_network = networkStr[1].trim(); 
							if(!card_network.isEmpty()) {
							}
						}
						else if(a.startsWith("amount")) {
							String[] amountStr = a.split("=");
							if(amountStr.length != 2) continue; // 防止越界
							String amount_str = amountStr[1].trim(); 
							if(!amount_str.isEmpty()) amount = Integer.parseInt(amount_str);
						}
					}
					
					Charge charge = new Charge(charge_id, merchant_id, card_network, amount);
					charge_list.put(charge_id, charge);
					// payout_balance.put(merchant_id, payout_balance.getOrDefault(merchant_id, 0) + amount);
				}
				else if(cmd.substring(1).equals("confirm")) {
					String[] chargeIdStr = attributes.split("=");
					if(chargeIdStr.length != 2) continue; // 防止越界
					String charge_id = chargeIdStr[1].trim(); 
					Charge charge = charge_list.get(charge_id);
					
					float confirmed_amount = charge.getConfirmedAmount();
					String merchant_id = charge.merchant_id;
					payout_balance.put(merchant_id, payout_balance.getOrDefault(merchant_id, 0.0f) + confirmed_amount);
				}
				else if(cmd.substring(1).equals("refund")) {
					String[] chargeIdStr = attributes.split("=");
					if(chargeIdStr.length != 2) continue; // 防止越界
					String charge_id = chargeIdStr[1].trim(); 
					Charge charge = charge_list.get(charge_id);
					
					float refund_deduct = charge.getRefundDeduct();
					String merchant_id = charge.merchant_id;
					payout_balance.put(merchant_id, payout_balance.getOrDefault(merchant_id, 0.0f) - refund_deduct);
				}
				else if(cmd.substring(1).equals("payout")) {
					String[] merchantIdStr = attributes.split("=");
					if(merchantIdStr.length != 2) continue; // 防止越界
					String merchant_id = merchantIdStr[1].trim(); 
					float total_amout = 0.0f;
					if(payout_balance.containsKey(merchant_id)) {
						total_amout = payout_balance.get(merchant_id);
						payout_balance.put(merchant_id, 0.0f);
					}
					System.out.println(merchant_id + ", " + (int)Math.ceil(total_amout));
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		StripeInBox s = new StripeInBox();
		s.service();
	}
}
