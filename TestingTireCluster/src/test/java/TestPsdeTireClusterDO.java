/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author cristiandrincu
 */
public class TestPsdeTireClusterDO {
   
    @Test
    public void psdeTireClusterTest() {
        PsdeTireClusterDO tireCluster1 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster2 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster3 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster4 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster5 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster6 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster7 = new PsdeTireClusterDO();               
        
        tireCluster1.setWltpId(54441);
        tireCluster1.setCo2Ausser("147.5");
        tireCluster1.setCo2Inner("90.3");
        tireCluster1.setCo2Comb("45.3");
        
        tireCluster2.setWltpId(54441);
        tireCluster2.setCo2Ausser("146.5");
        tireCluster2.setCo2Inner("95.3");
        tireCluster2.setCo2Comb("50.3");
        
        tireCluster3.setWltpId(54441);
        tireCluster3.setCo2Ausser("145.5");
        tireCluster3.setCo2Inner("85.3");
        tireCluster3.setCo2Comb("75.3");
        
        tireCluster4.setWltpId(54442);
        tireCluster4.setCo2Ausser("245.5");
        tireCluster4.setCo2Inner("285.3");
        tireCluster4.setCo2Comb("275.3");
        
        tireCluster5.setWltpId(54442);
        tireCluster5.setCo2Ausser("345.5");
        tireCluster5.setCo2Inner("385.3");
        tireCluster5.setCo2Comb("375.3");
        
        tireCluster6.setWltpId(54442);
        tireCluster6.setCo2Ausser("445.5");
        tireCluster6.setCo2Inner("485.3");
        tireCluster6.setCo2Comb("475.3");
        
        tireCluster7.setWltpId(54442);
        tireCluster7.setCo2Ausser("545.5");
        tireCluster7.setCo2Inner("585.3");
        tireCluster7.setCo2Comb("575.3");
        
        List<PsdeTireClusterDO> cluster1 = Arrays.asList(tireCluster1, tireCluster2, tireCluster3);
        List<PsdeTireClusterDO> cluster2 = Arrays.asList(tireCluster4, tireCluster5, tireCluster6, tireCluster7);
        
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId1 = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId2 = new LinkedHashMap<>();
        
        /*
            Group tire clusters by their wltpid
        */
        mapCluster1GroupedByWltpId1 = cluster1.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getWltpId));
        mapCluster1GroupedByWltpId2 = cluster2.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getWltpId));
        
        System.out.println(mapCluster1GroupedByWltpId1);
        System.out.println(mapCluster1GroupedByWltpId2);
          
        /*
            Merge cluster maps into a single map
        */
        Map<Integer, List<PsdeTireClusterDO>> mergedMap = new LinkedHashMap<>();
        mergedMap.putAll(mapCluster1GroupedByWltpId1);
        mergedMap.putAll(mapCluster1GroupedByWltpId2);                
        System.out.println(mergedMap);
        
        /*
            Set cluster indexes. Get max number of clusters in table
        */
        int maxNumberOfTableClusters = 0;
        for (Map.Entry<Integer, List<PsdeTireClusterDO>> mergedEntry: mergedMap.entrySet()) {
            for (int i = 0; i < mergedEntry.getValue().size(); i++) {
                if (mergedEntry.getValue().size() > maxNumberOfTableClusters) {
                    maxNumberOfTableClusters = mergedEntry.getValue().size();
                }
                mergedEntry.getValue().get(i).setClusterIndexNumber(i);
            }
        }
        
        List<PsdeTireClusterDO> listTireClusters = new ArrayList<>();
        
        /*
            Collect all cluster entry values to a list
        */
        for (Map.Entry<Integer, List<PsdeTireClusterDO>> mergedEntryWithIndex: mergedMap.entrySet()) {
              listTireClusters.addAll(mergedEntryWithIndex.getValue());
        }
        
        /*
            Final step - group clusters based on their array index
        */
        Map<Integer, List<PsdeTireClusterDO>> finalEntry = listTireClusters.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getClusterIndexNumber));
        
        System.out.println("Merged entry: " + mergedMap);              
        System.out.println("List tire clusters: " + listTireClusters);
        System.out.println("Final Entry: " + finalEntry);
        
        /*
            Testing to see if they were grouped as expected
        */
        
        assertEquals(maxNumberOfTableClusters, 4);
        assertEquals(finalEntry.get(0).get(0).getCo2Ausser(), "147.5");
        assertEquals(finalEntry.get(0).get(1).getCo2Ausser(), "245.5");
        assertEquals(finalEntry.get(1).get(0).getCo2Ausser(), "146.5");
        assertEquals(finalEntry.get(1).get(1).getCo2Ausser(), "345.5");
    }
    
    public class PsdeTireClusterDO {
        private int wltpId;
        private int clusterIndexNumber;
        private String co2Inner;
        private String co2Ausser;
        private String co2Comb;
        
        public PsdeTireClusterDO(PsdeTireClusterDO tireClusterDO) {
            this.wltpId = tireClusterDO.getWltpId();
            this.co2Inner = tireClusterDO.getCo2Inner();
            this.co2Comb = tireClusterDO.getCo2Comb();
        }

        private PsdeTireClusterDO() {}

        public int getWltpId() {
            return wltpId;
        }

        public void setWltpId(int wltpId) {
            this.wltpId = wltpId;
        }

        public int getClusterIndexNumber() {
            return clusterIndexNumber;
        }

        public void setClusterIndexNumber(int clusterIndexNumber) {
            this.clusterIndexNumber = clusterIndexNumber;
        }
               
        public String getCo2Inner() {
            return co2Inner;
        }

        public void setCo2Inner(String co2Inner) {
            this.co2Inner = co2Inner;
        }

        public String getCo2Ausser() {
            return co2Ausser;
        }

        public void setCo2Ausser(String co2Ausser) {
            this.co2Ausser = co2Ausser;
        }

        public String getCo2Comb() {
            return co2Comb;
        }

        public void setCo2Comb(String co2Comb) {
            this.co2Comb = co2Comb;
        }

        @Override
        public String toString() {
            return "PsdeTireClusterDO{" + "wltpId=" + wltpId + ", clusterIndexNumber=" + clusterIndexNumber + ", co2Inner=" + co2Inner + ", co2Ausser=" + co2Ausser + ", co2Comb=" + co2Comb + '}';
        }
    }
    
}
