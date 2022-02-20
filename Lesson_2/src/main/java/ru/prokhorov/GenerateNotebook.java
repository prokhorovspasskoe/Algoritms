package ru.prokhorov;

public class GenerateNotebook {
    private final int MIN = 500;
    private final int MAX = 2000;

    private int maxCount = 1;

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public Notebook generate(){
        Notebook notebook = new Notebook();

        int[] priceArray ={500, 550, 600, 650, 700, 750, 800, 850, 900, 950,
        1000, 1050, 1100, 1150, 1200, 1250, 1300, 1350, 1400, 1450, 1500,
        1550, 1600, 1650, 1700, 1750, 1800, 1850, 1900, 1950, 2000};

        int[] ramArray = {4, 8, 12, 16, 20, 24};

        int priceIndex = (int)(Math.random() * priceArray.length);
        notebook.setPrice(priceArray[priceIndex]);

        int indexMan = (int)(Math.random() * Manufacturer.values().length);
        Manufacturer manufacturer;

        switch (indexMan)
        {
            case 2: manufacturer = Manufacturer.Eser;
            break;
            case 3: manufacturer = Manufacturer.Lenuvo;
            break;
            case 4: manufacturer = Manufacturer.MacNote;
            break;
            case 5: manufacturer = Manufacturer.Xamiou;
                break;
            default:
                manufacturer = Manufacturer.Asos;
        }
        notebook.setManufacturer(manufacturer.toString());

        int ramIndex = (int)(Math.random() * ramArray.length);

        notebook.setRam(ramArray[ramIndex]);

        return notebook;
    }

    public Notebook[] arrGenerate(){
        Notebook[] arrNotebook = new Notebook[maxCount];
        for(int i = 0; i < maxCount; i++){
            arrNotebook[i] = generate();
        }
        return arrNotebook;
    }
}
