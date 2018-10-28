package oocomposition.computer.composition;

/**
 *
 * @author cristiandrincu
 */
public class Motherboard {
    private String model;
    private String mb_manufacturer;
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String mb_manufacturer, int ramSlots, int cardSlots, String bios) {
        this.model = model;
        this.mb_manufacturer = mb_manufacturer;
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }
    
    public void loadProgram(String programName) {
        System.out.println("Program " + programName + " is now loading...");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMb_manufacturer() {
        return mb_manufacturer;
    }

    public void setMb_manufacturer(String mb_manufacturer) {
        this.mb_manufacturer = mb_manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public void setRamSlots(int ramSlots) {
        this.ramSlots = ramSlots;
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public void setCardSlots(int cardSlots) {
        this.cardSlots = cardSlots;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }
    
    
}
