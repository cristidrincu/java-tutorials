/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author cristiandrincu
 */
@RunWith(JUnit4.class)
public class TestPsdeTireClusterDO {
    
    private PsdeTireClusterHeader header1;
    private PsdeTireClusterHeader header2;
    private PsdeTireClusterHeader header3;
    
    private PsdeTireClusterDO tireCluster1;
    private PsdeTireClusterDO tireCluster2;
    private PsdeTireClusterDO tireCluster3;
    private PsdeTireClusterDO tireCluster4;
    private PsdeTireClusterDO tireCluster5;
    private PsdeTireClusterDO tireCluster6;
    private PsdeTireClusterDO tireCluster7;
    private PsdeTireClusterDO tireCluster8;
    private PsdeTireClusterDO tireCluster9;
    private PsdeTireClusterDO tireCluster10;
    private PsdeTireClusterDO tireCluster11;
    private PsdeTireClusterDO tireCluster12;
    
    @Before
    public void setUp() {
        header1 = new PsdeTireClusterHeader();
        header2 = new PsdeTireClusterHeader();
        header3 = new PsdeTireClusterHeader();        
        
        header1.setWltpId(54441);
        header2.setWltpId(54442);
        header3.setWltpId(54443);
        
        tireCluster1 = new PsdeTireClusterDO();
        tireCluster2 = new PsdeTireClusterDO();
        tireCluster3 = new PsdeTireClusterDO();
        tireCluster4 = new PsdeTireClusterDO();
        tireCluster5 = new PsdeTireClusterDO();
        tireCluster6 = new PsdeTireClusterDO();
        tireCluster7 = new PsdeTireClusterDO();
        tireCluster8 = new PsdeTireClusterDO();
        tireCluster9 = new PsdeTireClusterDO();
        tireCluster10 = new PsdeTireClusterDO();
        tireCluster11 = new PsdeTireClusterDO();
        tireCluster12 = new PsdeTireClusterDO();
        
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
        
        tireCluster8.setWltpId(54442);
        tireCluster8.setCo2Ausser("645.5");
        tireCluster8.setCo2Inner("685.3");
        tireCluster8.setCo2Comb("675.3");
        
        tireCluster9.setWltpId(54442);
        tireCluster9.setCo2Ausser("745.5");
        tireCluster9.setCo2Inner("785.3");
        tireCluster9.setCo2Comb("775.3");
        
        tireCluster10.setWltpId(54442);
        tireCluster10.setCo2Ausser("845.5");
        tireCluster10.setCo2Inner("885.3");
        tireCluster10.setCo2Comb("875.3");
        
        tireCluster11.setWltpId(54443);
        tireCluster11.setCo2Ausser("945.5");
        tireCluster11.setCo2Inner("985.3");
        tireCluster11.setCo2Comb("975.3");
        
        tireCluster12.setWltpId(54443);
        tireCluster12.setCo2Ausser("1045.5");
        tireCluster12.setCo2Inner("1085.3");
        tireCluster12.setCo2Comb("1075.3");
    }
   
    @Test
    public void psdeTireClusterTest() throws FileNotFoundException, IOException {                               
        List<PsdeTireClusterHeader> headers = Arrays.asList(header1, header2, header3);
        List<PsdeTireClusterDO> cluster1 = Arrays.asList(tireCluster1, tireCluster2, tireCluster3);
        List<PsdeTireClusterDO> cluster2 = Arrays.asList(tireCluster4, tireCluster5, tireCluster6, tireCluster7, tireCluster8, tireCluster9, tireCluster10);
        List<PsdeTireClusterDO> cluster3 = Arrays.asList(tireCluster11, tireCluster12);
        
        Map<Integer, PsdeTireClusterHeader> headersMap = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId1 = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId2 = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId3 = new LinkedHashMap<>();
        Map<PsdeTireClusterHeader, List<PsdeTireClusterDO>> headersAndClustersEntry = new LinkedHashMap<>();                
        
        /*
            Group headers for a model type based on their wltpid
        */
        for (PsdeTireClusterHeader header: headers) {
            headersMap.put(header.getWltpId(), header);
        }
        System.out.println(headersMap.toString());
        
        /*
            Group tire clusters by their wltpid
        */
        mapCluster1GroupedByWltpId1 = cluster1.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getWltpId));
        mapCluster1GroupedByWltpId2 = cluster2.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getWltpId));
        mapCluster1GroupedByWltpId3 = cluster3.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getWltpId));
          
        /*
            Merge cluster maps into a single map - in the code, this step is already done - we recieve a map with maps merged
        */
        Map<Integer, List<PsdeTireClusterDO>> mergedMap = new LinkedHashMap<>();
        mergedMap.putAll(mapCluster1GroupedByWltpId1);
        mergedMap.putAll(mapCluster1GroupedByWltpId2);                
        mergedMap.putAll(mapCluster1GroupedByWltpId3);
        
        /*
            Assign each cluster header an entry of clusters if both cluster header and cluster entries have the same wltp_id
        */
        for(Map.Entry<Integer, PsdeTireClusterHeader> headerEntry: headersMap.entrySet()) {
            for(Map.Entry<Integer, List<PsdeTireClusterDO>> clustersEntry: mergedMap.entrySet()) {
                if (Objects.equals(headerEntry.getKey(), clustersEntry.getKey())) {
                    headersAndClustersEntry.put(headerEntry.getValue(), clustersEntry.getValue());
                }
            }
        }
        
        System.out.println(headersAndClustersEntry.toString());
        
        /*
            Set cluster indexes. Get largest...
        */
        int getLargestSize = 0;
        for (Map.Entry<PsdeTireClusterHeader, List<PsdeTireClusterDO>> mergedEntry: headersAndClustersEntry.entrySet()) {
            for (int i = 0; i < mergedEntry.getValue().size(); i++) {
                if (mergedEntry.getValue().size() > getLargestSize) {
                    getLargestSize = mergedEntry.getValue().size();
                }
            }
        }
        
        System.out.println("Largest list: " + getLargestSize);
        
        /*
            Old stuff we can ignore
        */
//        for (Map.Entry<Integer, List<PsdeTireClusterDO>> mergedEntry: mergedMap.entrySet()) {
//            for (int i = 0; i < getLargestSize; i++) {
//                if (mergedEntry.getValue().size() < getLargestSize) {
//                    mergedEntry.getValue().add(new PsdeTireClusterDO());
//                }
//                mergedEntry.getValue().get(i).setClusterIndexNumber(i);
//            }
//        }
        
        for (Map.Entry<PsdeTireClusterHeader, List<PsdeTireClusterDO>> mergedEntry: headersAndClustersEntry.entrySet()) {
            for (int i = 0; i < getLargestSize; i++) {
                if (mergedEntry.getValue().size() < getLargestSize) {
                    mergedEntry.getValue().add(new PsdeTireClusterDO());
                }
                mergedEntry.getValue().get(i).setClusterIndexNumber(i);
            }
        }
        
        List<PsdeTireClusterHeader> listTireClustersHeaders = new ArrayList<>();
        List<PsdeTireClusterDO> listTireClusters = new ArrayList<>();
        
        
        
        /*
            Collect all cluster entry values to a list. Collect all cluster header values to a list.
        */
        for (Map.Entry<PsdeTireClusterHeader, List<PsdeTireClusterDO>> mergedEntryWithIndex: headersAndClustersEntry.entrySet()) {
              listTireClustersHeaders.add(mergedEntryWithIndex.getKey()); //collect cluster headers
              listTireClusters.addAll(mergedEntryWithIndex.getValue()); //collect clusters for each existing header
        }
        
        /*
            Final step - group clusters based on their array index
        */
        Map<Integer, List<PsdeTireClusterDO>> finalEntry = listTireClusters.stream().collect(Collectors.groupingBy(PsdeTireClusterDO::getClusterIndexNumber));
        
        /*
            Testing to see if they were grouped as expected
        */
        
        assertEquals(finalEntry.get(0).get(0).getCo2Ausser(), "147.5");
        assertEquals(finalEntry.get(0).get(1).getCo2Ausser(), "245.5");
        assertEquals(finalEntry.get(1).get(0).getCo2Ausser(), "146.5");
        assertEquals(finalEntry.get(1).get(1).getCo2Ausser(), "345.5");
                      
        List<TableTireCluster> tableClustersList = new ArrayList<>();
        List<TableTireCluster> tableClustersListFinal = new ArrayList<>();
        
        for(Map.Entry<Integer, List<PsdeTireClusterDO>> entry: finalEntry.entrySet()) {
            tableClustersList.add(new TableTireCluster(entry.getValue()));
        }
        
        TableTireClusterHeader tableHeader = new TableTireClusterHeader(listTireClustersHeaders);
        
        for (TableTireCluster tableCluster : tableClustersList) {
            tableCluster.buildTableRowCO2Ausser();
            tableCluster.buildTableRowCO2Inner();            
            tableCluster.buildTableRowCO2Comb();
            tableClustersListFinal.add(tableCluster);
        }      
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");
        int rowIndexForHeaders = 0;
        int rowIndex = 10;               
        
        for (TableTireCluster tireTableCluster: tableClustersListFinal) {            
            for (TableRow tableRow: tireTableCluster.getTableRows()) {                                                           
                tableRow.setRowIndex(rowIndex++);
            }            
        }               
        
        for (TableTireCluster tireTableCluster: tableClustersListFinal) {
            for (TableRow tableRow: tireTableCluster.getTableRows()) {
                Row row = sheet.createRow(tableRow.getRowIndex());
                for (RowCell cell: tableRow.getRowCells()) {
                    row.createCell(tireTableCluster.getStartCellIndex()).setCellValue(tableRow.getCategoryName());
                    row.createCell(tableRow.getRowCells().indexOf(cell) + 1).setCellValue(cell.getValue());
                }
            }
        }
        
        System.out.println(tableClustersListFinal.toString());
        
        try (FileOutputStream fos = new FileOutputStream("TestCristi.xlsx")) {
            workbook.write(fos);
        }
        System.out.println("TestCristi.xlsx written successfully");
    }          
}
