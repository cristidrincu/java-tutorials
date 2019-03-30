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
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author cristiandrincu
 */
public class TestPsdeTireClusterDO {
   
    @Test
    public void psdeTireClusterTest() throws FileNotFoundException, IOException {
        PsdeTireClusterDO tireCluster1 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster2 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster3 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster4 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster5 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster6 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster7 = new PsdeTireClusterDO();   
        PsdeTireClusterDO tireCluster8 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster9 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster10 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster11 = new PsdeTireClusterDO();
        PsdeTireClusterDO tireCluster12 = new PsdeTireClusterDO();
        
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
        
        List<PsdeTireClusterDO> cluster1 = Arrays.asList(tireCluster1, tireCluster2, tireCluster3);
        List<PsdeTireClusterDO> cluster2 = Arrays.asList(tireCluster4, tireCluster5, tireCluster6, tireCluster7, tireCluster8, tireCluster9, tireCluster10);
        List<PsdeTireClusterDO> cluster3 = Arrays.asList(tireCluster11, tireCluster12);
        
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId1 = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId2 = new LinkedHashMap<>();
        Map<Integer, List<PsdeTireClusterDO>> mapCluster1GroupedByWltpId3 = new LinkedHashMap<>();
        
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
        System.out.println(mergedMap);
        
        /*
            Set cluster indexes. Get largest...
        */
        int getLargestSize = 0;
        for (Map.Entry<Integer, List<PsdeTireClusterDO>> mergedEntry: mergedMap.entrySet()) {
            for (int i = 0; i < mergedEntry.getValue().size(); i++) {
                if (mergedEntry.getValue().size() > getLargestSize) {
                    getLargestSize = mergedEntry.getValue().size();
                }
            }
        }
        
        System.out.println("Largest list: " + getLargestSize);
        
        for (Map.Entry<Integer, List<PsdeTireClusterDO>> mergedEntry: mergedMap.entrySet()) {
            for (int i = 0; i < getLargestSize; i++) {
                if (mergedEntry.getValue().size() < getLargestSize) {
                    mergedEntry.getValue().add(new PsdeTireClusterDO());
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
        
        for (TableTireCluster tableCluster : tableClustersList) {
            tableCluster.buildTableRowCO2Ausser();
            tableCluster.buildTableRowCO2Inner();            
            tableCluster.buildTableRowCO2Comb();
            tableClustersListFinal.add(tableCluster);
        }      
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");               
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

        public PsdeTireClusterDO() {}               

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
    
    public class TableTireCluster {
        private int tireClusterId;
        private int startCellIndex = 0;
        private List<PsdeTireClusterDO> tireClusterEntry;
        private List<Row> excelRowsForTireCluster;
        private TableRow tableRowCO2Inner = new TableRow();
        private TableRow tableRowCO2Ausser = new TableRow();
        private TableRow tableRowCO2Comb = new TableRow();
        private List<TableRow> tableRows = new ArrayList<>();
        
        public TableTireCluster() {}
        
        public TableTireCluster(int tableTireClusterId) {
            this.tireClusterId = tableTireClusterId;
        }
        
        public TableTireCluster(List<PsdeTireClusterDO> tireClusterEntry) {
            this.tireClusterEntry = tireClusterEntry;
        }
        
        public TableRow buildTableRowCO2Inner() {            
            List<String> co2InnerValues = new ArrayList<>();           
            tableRowCO2Inner.setCategoryName("CO2 Inner");
            tireClusterEntry.forEach((psdeTireClusterDO) -> {
                co2InnerValues.add(psdeTireClusterDO.getCo2Inner());
            });
            
            co2InnerValues.stream()
                    .map((co2InnerValue) -> new RowCell(co2InnerValue))
                    .forEachOrdered((co2InnerCell) -> {                                        
                        tableRowCO2Inner.getRowCells().add(co2InnerCell);
            });
            tableRows.add(tableRowCO2Inner);
            return tableRowCO2Inner;
        }
        
        public TableRow buildTableRowCO2Ausser() {
            List<String> co2AusserValues = new ArrayList<>();
            tableRowCO2Ausser.setCategoryName("CO2 Ausser");
            tireClusterEntry.forEach((psdeTireClusterDO) -> {
                co2AusserValues.add(psdeTireClusterDO.getCo2Ausser());
            });
            
            co2AusserValues.stream()
                    .map(co2AusserValue -> new RowCell(co2AusserValue))
                    .forEachOrdered(co2AusserCell -> {                        
                        tableRowCO2Ausser.getRowCells().add(co2AusserCell);
                    });
            tableRows.add(tableRowCO2Ausser);
            return tableRowCO2Ausser;
        }
        
        public TableRow buildTableRowCO2Comb() {            
            List<String> co2CombValues = new ArrayList<>();
            tableRowCO2Comb.setCategoryName("CO2 Combined");
            tireClusterEntry.forEach(psdeTireClusterDO -> co2CombValues.add(psdeTireClusterDO.getCo2Comb()));
            co2CombValues.stream()
                    .map(co2CombinedValue -> new RowCell(co2CombinedValue))
                    .forEachOrdered(co2CombCell -> {                        
                        tableRowCO2Comb.getRowCells().add(co2CombCell);
                    });
            tableRows.add(tableRowCO2Comb);
            return tableRowCO2Comb;
        }             

        public int getStartCellIndex() {
            return startCellIndex;
        }                

        public int getTireClusterId() {
            return tireClusterId;
        }

        public void setTireClusterId(int tireClusterId) {
            this.tireClusterId = tireClusterId;
        }

        public List<PsdeTireClusterDO> getTireClusterEntry() {
            return tireClusterEntry;
        }

        public void setTireClusterEntry(List<PsdeTireClusterDO> tireClusterEntry) {
            this.tireClusterEntry = tireClusterEntry;
        }

        public List<Row> getExcelRowsForTireCluster() {
            return excelRowsForTireCluster;
        }

        public void setExcelRowsForTireCluster(List<Row> excelRowsForTireCluster) {
            this.excelRowsForTireCluster = excelRowsForTireCluster;
        }                
        
        public TableRow getTableRowCO2Inner() {
            return tableRowCO2Inner;
        }

        public void setTableRowCO2Inner(TableRow tableRowCO2Inner) {
            this.tableRowCO2Inner = tableRowCO2Inner;
        }

        public TableRow getTableRowCO2Ausser() {
            return tableRowCO2Ausser;
        }

        public void setTableRowCO2Ausser(TableRow tableRowCO2Ausser) {
            this.tableRowCO2Ausser = tableRowCO2Ausser;
        }

        public TableRow getTableRowCO2Comb() {
            return tableRowCO2Comb;
        }

        public void setTableRowCO2Comb(TableRow tableRowCO2Comb) {
            this.tableRowCO2Comb = tableRowCO2Comb;
        }

        public List<TableRow> getTableRows() {
            return tableRows;
        }

        public void setTableRows(List<TableRow> tableRows) {
            this.tableRows = tableRows;
        }
        
        
        
        public String test() {
            return this.tireClusterEntry.toString();
        }

        @Override
        public String toString() {
            return "TableTireCluster{" + "tableRowCO2Inner=" + tableRowCO2Inner + ", tableRowCO2Ausser=" + tableRowCO2Ausser + ", tableRowCO2Comb=" + tableRowCO2Comb + '}';
        }                
    }
    
    public class TableRow {
        private int rowIndex;
        private String categoryName;
        private List<RowCell> rowCells = new ArrayList<>();       
        
        public TableRow() {}
        
        public TableRow(String categoryName, List<RowCell> rowCells) {
            this.categoryName = categoryName;
            this.rowCells = rowCells;
        }             

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }       
        
        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
                
        public List<RowCell> getRowCells() {
            return rowCells;
        }

        public void setRowCells(List<RowCell> rowCells) {
            this.rowCells = rowCells;
        }     

        @Override
        public String toString() {
            return "TableRow{" + "rowIndex=" + rowIndex + ", categoryName=" + categoryName + ", rowCells=" + rowCells + '}';
        }                      
    }
    
    public class RowCell {
        String value;
        
        public RowCell(String value) {
            this.value = value == null ? "N/A" : value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }  

        @Override
        public String toString() {
            return "RowCell{" + "value=" + value + '}';
        }                
    }
}
