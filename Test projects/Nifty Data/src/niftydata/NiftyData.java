/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niftydata;

import niftydata.scheduler.QuartzScheduler;

/**
 *
 * @author nishant.vibhute
 */
public class NiftyData {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        {
//            try {
//
//                String url = "";
//
//                url = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbolCode=-10003&symbol=NIFTY&symbol=NIFTY&instrument=OPTIDX&date=-&segmentLink=17&segmentLink=17";
//
//                String html = "";
//                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
//
//                try {
//                    OkHttpClient client = getUnsafeOkHttpClient();
//                    Request request = new Request.Builder()
//                            .url(url)
//                            .build();
//
//                    Response response = client.newCall(request).execute();
//
//                    html = response.body().string();
//
//                    Document doc = Jsoup.parse(html);
//
////                    for (Element table : doc.select("table.tablehead")) {
////                        for (Element row : table.select("tr")) {
////                            Elements tds = row.select("td");
////                            if (tds.size() > 6) {
////                                System.out.println(tds.get(0).text() + ":" + tds.get(1).text());
////                            }
////                        }
////                    }
//                    Elements info = doc.select("table#octable");
//                    Elements rows = info.select("tr");
//
//                    for (int i = 2; i < rows.size(); i++) {
//                        String strikePrice = "";
//                        String openCallInterest = "";
//                        String openPutInterest = "";
//                        Element row = rows.get(i);
//                        Elements cols = row.select("td");
//                        int j = 0;
//                        cols.get(i).getAllElements().get(i).text();
//                        for (Element element : cols) {
//
//                            System.out.print(element.text().equals("-") ? "0" : element.text().replace(",", "") + " ");
//
//                            j++;
//                        }
//                        System.out.println("");
//
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

       new QuartzScheduler();
    }



   

}
