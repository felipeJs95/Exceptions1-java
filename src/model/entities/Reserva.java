package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reserva {

    private Integer romNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int duracao = 0;

    public Reserva() {

    }

    public Reserva(Integer romNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de check-out deve ser posterior à data de check-in");
        }
        this.romNumber = romNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRomNumber() {
        return romNumber;
    }

    public void setRomNumber(Integer romNumber) {
        this.romNumber = romNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCkeckOut() {
        return checkOut;
    }

    public long duracao() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Error na reserva: As data para atualização das reservas devem ser futuras");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("A data de check-out deve ser posterior à data de check-in");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Reserva" + romNumber + ", check-in:" + sdf.format(checkIn) + ", checkOut" + sdf.format(checkOut) + "," + duracao() + " noites";
    }

}
