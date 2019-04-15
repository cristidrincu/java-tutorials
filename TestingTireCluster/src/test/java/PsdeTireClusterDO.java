/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiandrincu
 */
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
            this.co2Comb = tireClusterDO.getCo2Ausser();
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