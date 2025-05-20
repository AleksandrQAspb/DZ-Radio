public class Radio {
    private int currentStation;
    private int currentVolume;
    private int numberOfStations;

    // Конструктор по умолчанию
    public Radio() {
        this(10); // По умолчанию 10 станций
    }

    // Конструктор с параметром
    public Radio(int numberOfStations) {
        if (numberOfStations <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть положительным");
        }
        this.numberOfStations = numberOfStations;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < numberOfStations) {
            this.currentStation = station;
        }
    }

    public void next() {
        currentStation = (currentStation + 1) % numberOfStations;
    }

    public void prev() {
        currentStation = (currentStation - 1 + numberOfStations) % numberOfStations;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}

