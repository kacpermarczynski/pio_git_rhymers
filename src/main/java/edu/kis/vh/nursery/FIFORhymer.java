package edu.kis.vh.nursery;

/**
 * Klasa realizuje stos FIFO, dziedziczy ona DefaultCountingOutRhymer
 * Implementuje metodę countOut(), która usuwa elementy takiej kolejności, w jakiej zostały one dodane
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    /** Tymczasowy stos używany do realizacji FIFO */
    private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Nadpisana metoda countOut(), która usuwa elementy ze stosu w kolejności FIFO
     * @return usunięty element lub -1, jeśli stos był pusty.
     */
    @Override
    public int countOut() {
        // Przenosi elementy do tymczasowego stosu
        while (!callCheck())
            temp.countIn(super.countOut());

        // Usuwa element z tymczasowego stosu
        int ret = temp.countOut();

        // Przenosi elementy z powrotem na oryginalny stos
        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }

    // Getter dla zmiennej temp, jeśli jest to wymagane
    public DefaultCountingOutRhymer getTemp() {
        return temp;
    }
}
