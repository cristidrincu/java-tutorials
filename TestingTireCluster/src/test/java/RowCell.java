/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
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
