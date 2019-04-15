
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
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
