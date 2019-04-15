
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
public class TableTireClusterHeader {
    private int startCellIndex = 0;
    private List<PsdeTireClusterHeader> tireClusterHeaderEntry;
    private TableRow salesDesignationTableRow;
    private TableRow motorDescriptionTableRow;
    private TableRow sovTableRow;
    private List<TableRow> tableRows;
    
    public TableTireClusterHeader(List<PsdeTireClusterHeader> tireClusterHeaderEntry) {
        this.tireClusterHeaderEntry = tireClusterHeaderEntry;
    }
    
    public TableRow buildMotorDescription() {
        List<String> motorDescriptions = new ArrayList<>();
        motorDescriptionTableRow.setCategoryName("Motor description");
        tireClusterHeaderEntry.forEach(headerEntry -> 
                motorDescriptions.add(headerEntry.getMotorDescription()));
        
        motorDescriptions.stream()
                .map(motorDescriptionValue -> new RowCell(motorDescriptionValue))
                .forEachOrdered(rowCell -> motorDescriptionTableRow.getRowCells().add(rowCell));
        
        tableRows.add(motorDescriptionTableRow);        
        return motorDescriptionTableRow;
    }

    public int getStartCellIndex() {
        return startCellIndex;
    }

    public void setStartCellIndex(int startCellIndex) {
        this.startCellIndex = startCellIndex;
    }

    public TableRow getSalesDesignationTableRow() {
        return salesDesignationTableRow;
    }

    public void setSalesDesignationTableRow(TableRow salesDesignationTableRow) {
        this.salesDesignationTableRow = salesDesignationTableRow;
    }

    public TableRow getMotorDescriptionTableRow() {
        return motorDescriptionTableRow;
    }

    public void setMotorDescriptionTableRow(TableRow motorDescriptionTableRow) {
        this.motorDescriptionTableRow = motorDescriptionTableRow;
    }

    public TableRow getSovTableRow() {
        return sovTableRow;
    }

    public void setSovTableRow(TableRow sovTableRow) {
        this.sovTableRow = sovTableRow;
    }

    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }        
}
