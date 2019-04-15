
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
