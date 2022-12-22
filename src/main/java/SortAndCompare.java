import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortAndCompare {
    static int totalZeroQty=0;
    public static void main(String[] args) throws IOException {
        Map<String, Data> map1 = readInput("input1.txt");
        Map<String, Data> map2 = readInput("input2.txt");
        for(Map.Entry<String, Data> e1: map1.entrySet()){
            if(map2.containsKey(e1.getKey())){
                int m1q = Integer.parseInt(e1.getValue().quantity.quantityNumber);
                int m2q = 0;
                if(map2.get(e1.getKey()).quantity.quantityNumber.startsWith("-")){
                    m2q =0;
                } else {
                    m2q = Integer.parseInt(map2.get(e1.getKey()).quantity.quantityNumber);
                }
                e1.setValue(new Data(e1.getKey(), e1.getValue().nodeId,
                    e1.getValue().orderLineId,
                    Math.min(m1q,m2q)+"",
                    e1.getValue().quantity.quantityUOM));
            }
        }
        try {
            FileWriter myWriter = new FileWriter("output.txt");

            for(Map.Entry<String, Data> e: map1.entrySet()) {
                int qty = Integer.parseInt(e.getValue().quantity.quantityNumber);
                if(qty==0) {
                    System.out.println("To anull: "+e.getValue().logisticSkuId);
                    totalZeroQty++;
                    continue;
                }
                String lsku = (e.getValue().logisticSkuId);
                String nodeid = (e.getValue().nodeId);
                String olid = (e.getValue().orderLineId);
                String ans = "{\n" +
                    "    \"logisticSkuId\": \"" + lsku + "\",\n" +
                    "    \"nodeId\": \"" + nodeid + "\",\n" +
                    "    \"orderLineId\": \""+olid+"\",\n" +
                    "    \"quantity\": {\n" +
                    "        \"quantityNumber\": \"" + qty + "\",\n" +
                    "        \"quantityUOM\": \"UNIT\"\n" +
                    "    }\n" +
                    "},\n";
                myWriter.write(ans);
            }

            myWriter.close();
            System.out.println("Total zero qty = "+ totalZeroQty+"/"+map1.size());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Set<String> m1sku = map1.keySet();
        Set<String> m2sku = map2.keySet();
        for (String sku: m1sku){
            if(!m2sku.contains(sku)){
                System.out.println(sku+" - is not present");
            }
        }
        for (String sku: m2sku){
            if(!m1sku.contains(sku)){
                System.out.println(sku+" - is not presents");
            }
        }
    }

    private static Map<String, Data> readInput(String s) throws IOException {
        Map<String, Data> map = new HashMap<>();
        FileReader fileReader = new FileReader("/Users/ishanrtripathi/IdeaProjects/SampleProject/src/main/java/"+s);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        String textfromfile = null;
        String logisticSkuId = "";
        String orderLineId = "";
        String nodeId = "";
        String quantityNumber = "";
        String quantityUOM = "";
        while( (textfromfile = bufferReader.readLine()) != null ){
            if(textfromfile.contains("logisticSkuIds") || textfromfile.contains("nodeIds")){
                continue;
            }
            if(textfromfile.contains("logisticSkuId") ){
                int i1 = textfromfile.indexOf("logisticSkuId")+17;
                int i2 = textfromfile.indexOf(",", i1+1)-1;
                logisticSkuId = textfromfile.substring(i1, i2);
            }
            if(textfromfile.contains("orderLineId")){
                int i1 = textfromfile.indexOf("orderLineId")+15;
                int i2 = textfromfile.indexOf(",", i1+1)-1;
                orderLineId = textfromfile.substring(i1, i2);
            }
            if(textfromfile.contains("nodeId")){
                int i1 = textfromfile.indexOf("nodeId")+10;
                int i2 = textfromfile.indexOf(",", i1+1)-1;
                nodeId = textfromfile.substring(i1, i2);
            }
             if(textfromfile.contains("quantityNumber")) {
                 if(textfromfile.contains(".")){
                     int i1 = textfromfile.indexOf("quantityNumber") + 17;
                     int i2 = textfromfile.indexOf(".", i1);
                     quantityNumber = textfromfile.substring(i1, i2);
                 } else {
                     int i1 = textfromfile.indexOf("quantityNumber") + 18;
                     int i2 = textfromfile.indexOf(",", i1) - 1;
                     quantityNumber = textfromfile.substring(i1, i2);
                 }
            }
             if(textfromfile.contains("quantityUOM")) {
                int i1 = textfromfile.indexOf("quantityUOM")+15;
                int i2 = textfromfile.indexOf("\"", i1);
                quantityUOM = textfromfile.substring(i1, i2);
            }
             if(!logisticSkuId.equals("") && !quantityNumber.equals("") && !quantityUOM.equals("") && !nodeId.equals("")) {
                 map.put(logisticSkuId, new Data(logisticSkuId, nodeId, orderLineId, quantityNumber, quantityUOM));
                 logisticSkuId="";
                 quantityNumber="";
                 quantityUOM="";
                 nodeId="";
                 orderLineId="";
             }
        }
        fileReader.close();
        bufferReader.close();
        return map;
    }
    static class Data {
        String logisticSkuId;
        String nodeId;
        String orderLineId;
        Quantity quantity;

        public Data(String logisticSkuId, String nodeId, String orderLineId, String quantityNumber, String quantityUOM) {
            this.logisticSkuId = logisticSkuId;
            this.nodeId = nodeId;
            this.orderLineId = orderLineId;
            this.quantity = new Quantity(quantityNumber, quantityUOM);
        }

        @Override
        public String toString() {
            return "{" +
                "logisticSkuId='" + logisticSkuId + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", orderLineId='" + orderLineId + '\'' +
                ", quantity=" + quantity +
                '}';
        }
    }
    static class Quantity {
        String quantityNumber;
        String quantityUOM;

        public Quantity(String quantityNumber, String quantityUOM) {
            this.quantityNumber=quantityNumber;
            this.quantityUOM=quantityUOM;
        }

        @Override
        public String toString() {
            return "{" +
                "quantityNumber='" + quantityNumber + '\'' +
                ", quantityUOM='" + quantityUOM + '\'' +
                '}';
        }
    }
}
