package edu.kis.vh.nursery;

/**
 * Klasa realizuje stos FIFO, dziedziczy ona DefaultCountingOutRhymer
 * Implementuje metode countOut(), ktora usuwa elementy takiej kolejnosci, w jakiej zostaly one dodane
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    /** Tymczasowy stos uzywany do realizacji FIFO */
    public DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Nadpisana metoda countOut(), ktora usuwa elementy ze stosu w kolejności FIFO
     * @return usunięty element lub -1, jesli stos byl pusty.
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
}