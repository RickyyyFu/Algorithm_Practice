package invoice;

import java.util.*;

public class Invoice_System {
	static class Invoice{
		private int id;
		private int amount;
		private String currency;
		private String status;
		
		Invoice(int id, int amount, String currency){
			this.id = id;
			this.amount = amount;
			this.currency = currency;
			this.status = "created";
		}
		
		public int getId() {
			return this.id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getAmount() {
			return this.amount;
		}
		
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public String getCurrency() {
			return this.currency;
		}
		
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		
		public String getStatus() {
			return this.status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
	}
	
	Map<Integer, Invoice> map = new HashMap<>();
	
	int calculate_total_owed(int action_count, String[] actions) {
		int res = 0;
		if(action_count < actions.length) {
			String[] subarray = Arrays.copyOfRange(actions, 0, action_count);
			service(subarray);
		}
		else {
			service(actions);
		}
		
		for(int key : map.keySet()) {
			if(!map.get(key).getStatus().equals("paid") && map.get(key).getCurrency().equals("USD") ){
				res += map.get(key).getAmount();
			}
		}
		return res;
	}
	
	void service(String[] actions) {
		for(String action : actions) {
			String[] a = action.split(":");
			if(a.length != 2) continue; // 防止越界
			String cmd = a[0].trim(); 
			String data = a[1].trim();
			
			int id = -1;
			int amount = -1;
			String currency = "";
			
			if(cmd.equals("CREATE")) {
				String[] attributes = data.split("\\s*&\\s*");
				for(String attribute : attributes) {
					if(attribute.startsWith("id")) {
						String[] attribute_id = attribute.split("=");
						if(attribute_id.length != 2) continue; // 防止越界
						String id_s = attribute_id[1].trim(); 
						if(!id_s.isEmpty()) {
							id = Integer.valueOf(id_s);
						}
					}
					else if(attribute.startsWith("amount")) {
						String[] attribute_amount = attribute.split("=");
						if(attribute_amount.length != 2) continue; // 防止越界
						String amount_s = attribute_amount[1].trim();
						if(!amount_s.isEmpty()) {
							amount = Integer.valueOf(amount_s);
						}
					}
					else if(attribute.startsWith("currency")) {
						String[] attribute_currency = attribute.split("=");
						if(attribute_currency.length != 2) continue; // 防止越界
						String currency_s = attribute_currency[1].trim();
						if(!currency_s.isEmpty()) {
							currency = currency_s;
						}
					}
				}
				if(id != -1 && !map.containsKey(id)) {
					Invoice invoice = new Invoice(id, amount, currency);
					map.put(id, invoice);
				}
			}
			
			else if(cmd.equals("FINALIZE")) {
				String[] attributes = data.split("\\s*&\\s*");
				for(String attribute : attributes) {
					if(attribute.startsWith("id")) {
						String[] attribute_id = attribute.split("=");
						if(attribute_id.length != 2) continue; // 防止越界
						String id_s = attribute_id[1].trim(); 
						if(!id_s.isEmpty()) {
							id = Integer.valueOf(id_s);
						}
					}
					else if(attribute.startsWith("amount")) {
						String[] attribute_amount = attribute.split("=");
						if(attribute_amount.length != 2) continue; // 防止越界
						String amount_s = attribute_amount[1].trim();
						if(!amount_s.isEmpty()) {
							amount = Integer.valueOf(amount_s);
						}
					}
					else if(attribute.startsWith("currency")) {
						String[] attribute_currency = attribute.split("=");
						if(attribute_currency.length != 2) continue; // 防止越界
						String currency_s = attribute_currency[1].trim();
						if(!currency_s.isEmpty()) {
							currency = currency_s;
						}
					}
				}
				if(map.containsKey(id) && map.get(id).getStatus().equals("created")) {
					Invoice invoice = map.get(id);
					invoice.setAmount(amount);
					invoice.setCurrency(currency);
					invoice.setStatus("finalized");
					map.put(id, invoice);
				}
			}
			
			else if(cmd.equals("PAY")) {
				String[] attributes = data.split("\\s*&\\s*");
				for(String attribute : attributes) {
					if(attribute.startsWith("id")) {
						String[] attribute_id = attribute.split("=");
						if(attribute_id.length != 2) continue; // 防止越界
						String id_s = attribute_id[1].trim(); 
						if(!id_s.isEmpty()) {
							id = Integer.valueOf(id_s);
						}
					}
				}
				if(map.containsKey(id) && map.get(id).getStatus().equals("finalized")) {
					Invoice invoice = map.get(id);
					invoice.setStatus("paid");
					map.put(id, invoice);
				}
			}
		}
	}
}
