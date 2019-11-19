package html_parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLPageParser implements Runnable {
	static Pattern USphone = Pattern.compile("\\d{3}-\\d{3}-\\d{4}", Pattern.DOTALL);
	
	private static int threadCount = 100; // Initialize the number of threads
	private List<String> directory; // Pending data
	private int perCount = 100; // Amount of data processed by each thread
	private int flag = 1; // ith thread
	private int count = 10000; // Total number of data to be processed
	private int havedCount = 0; // Amount of data that has been processed
	
	private List<String> result; // result list to store html which contains USphone number

	HTMLPageParser(List<String> directory, List<String> result){
		this.directory = directory;
		this.result = result;
	}
	
	public void run() {
		List<String> sublist = null;
		while(count - havedCount > 0){ // The thread will execute cyclically until all data has been processed
			synchronized(this){ // Thread synchronization is required during packetization to avoid processing duplicate data between threads
				if(count-havedCount != 0) {
					sublist = directory.subList(perCount*(flag-1), count - havedCount > perCount ? perCount*flag : perCount*(flag-1) + (count - havedCount));
					flag = flag+1;
					havedCount = sublist.size() + havedCount;
				}
			}
			
			if(sublist != null) {
				for(String url : sublist) {
					String url_info;
					try {
						url_info = getURLInfo(url);
						if(getDataStructure(url_info)) {
							result.add(url);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}

	public static List<String> getHtml(List<String> directory) throws Exception{
		List<String> list = new ArrayList<>();
		
		for(String url : directory) {
			String url_info = getURLInfo(url);
			if(getDataStructure(url_info)) {
				list.add(url);
			}
		}
		return list;
	}
	
	public static String getURLInfo(String urlInfo) throws Exception {
        URL url = new URL(urlInfo);
        HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("</?a[^>]*>", "");
            line = line.replaceAll("<(\\w+)[^>]*>", "<$1>");
            sb.append(line);
        }
        is.close();
        br.close();

        return sb.toString().trim();
    }
 
    private static boolean getDataStructure(String str) {
        String[] info = str.split("</li>");
        for (String s : info) {
            Matcher m = USphone.matcher(s);
            if (m.find()) {
            	return true;
            }
        }
        return false;
    }
}
