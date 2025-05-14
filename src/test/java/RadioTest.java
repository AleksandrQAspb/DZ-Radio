import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void testInitialStation() {
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationValid() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationInvalidLow() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationInvalidHigh() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testNextStation() {
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        for (int i = 0; i < 99; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume(); // Should not increase
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        radio.decreaseVolume(); // Should not decrease
        assertEquals(0, radio.getCurrentVolume());
        radio.increaseVolume();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // Should not decrease below 0
    }
}
