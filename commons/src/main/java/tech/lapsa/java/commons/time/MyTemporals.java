package tech.lapsa.java.commons.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import tech.lapsa.java.commons.function.MyObjects;

public final class MyTemporals {

    private final static MyTemporals DEFAULT = getInstance(ZoneId.systemDefault());

    public static MyTemporals getInstance(ZoneId zoneId) {
	return new MyTemporals(MyObjects.requireNonNull(zoneId, "zoneId"));
    }

    public static FromDate date() {
	return DEFAULT.fromDate;
    }

    public static FromCalendar calendar() {
	return DEFAULT.fromCalendar;
    }

    public static FromLocalDateTime localDateTime() {
	return DEFAULT.fromLocalDateTime;
    }

    public static FromLocalDate localDate() {
	return DEFAULT.fromLocalDate;
    }

    public static FromInstant instant() {
	return DEFAULT.fromInstant;
    }

    private final ZoneId zoneId;
    private final FromDate fromDate;
    private final FromLocalDateTime fromLocalDateTime;
    private final FromLocalDate fromLocalDate;
    private final FromInstant fromInstant;
    private final FromCalendar fromCalendar;

    private MyTemporals(ZoneId zoneId) {
	this.zoneId = zoneId;
	this.fromDate = new FromDate();
	this.fromInstant = new FromInstant();
	this.fromLocalDate = new FromLocalDate();
	this.fromLocalDateTime = new FromLocalDateTime();
	this.fromCalendar = new FromCalendar();
    }

    public FromDate forDate() {
	return fromDate;
    }

    public FromLocalDateTime forLocalDateTime() {
	return fromLocalDateTime;
    }

    public FromLocalDate forLocalDate() {
	return fromLocalDate;
    }

    public FromInstant forInstant() {
	return fromInstant;
    }

    public abstract class AFromTemporal<T> {

	public abstract LocalDate toLocalDate(T value);

	public abstract Instant toInstant(T value);

	public abstract LocalDateTime toLocalDateTime(T value);

	public abstract T now();

	public Calendar toCalendar(T value) {
	    if (value == null)
		return null;
	    return GregorianCalendar.from(toInstant(value).atZone(zoneId));
	}

	public Date toDate(T value) {
	    return value == null ? null : Date.from(toInstant(value));
	}

	public boolean isToday(T value) {
	    return value == null ? false : LocalDate.now().isEqual(toLocalDate(value));
	}

	public boolean isYesterday(T value) {
	    return value == null ? false : LocalDate.now().minusDays(1).isEqual(toLocalDate(value));
	}

	public boolean isTommorow(T value) {
	    return value == null ? false : LocalDate.now().plusDays(1).isEqual(toLocalDate(value));
	}
    }

    public final class FromInstant extends AFromTemporal<Instant> {
	private FromInstant() {
	}

	@Override
	public LocalDate toLocalDate(Instant value) {
	    return value == null ? null : value.atZone(zoneId).toLocalDate();
	}

	@Override
	public Instant toInstant(Instant value) {
	    return value;
	}

	@Override
	public LocalDateTime toLocalDateTime(Instant value) {
	    return value == null ? null : value.atZone(zoneId).toLocalDateTime();
	}

	@Override
	public Instant now() {
	    return Instant.now();
	}
    }

    public final class FromLocalDate extends AFromTemporal<LocalDate> {
	private FromLocalDate() {
	}

	@Override
	public LocalDate toLocalDate(LocalDate value) {
	    return value;
	}

	@Override
	public Instant toInstant(LocalDate value) {
	    return value == null ? null : value.atStartOfDay(zoneId).toInstant();
	}

	@Override
	public LocalDateTime toLocalDateTime(LocalDate value) {
	    return value == null ? null : value.atStartOfDay();
	}

	@Override
	public LocalDate now() {
	    return LocalDate.now();
	}
    }

    public final class FromLocalDateTime extends AFromTemporal<LocalDateTime> {
	private FromLocalDateTime() {
	}

	@Override
	public LocalDate toLocalDate(LocalDateTime value) {
	    return value.toLocalDate();
	}

	@Override
	public Instant toInstant(LocalDateTime value) {
	    return value == null ? null : value.atZone(zoneId).toInstant();
	}

	@Override
	public LocalDateTime toLocalDateTime(LocalDateTime value) {
	    return value;
	}

	@Override
	public LocalDateTime now() {
	    return LocalDateTime.now();
	}
    }

    public final class FromDate extends AFromTemporal<Date> {
	private FromDate() {
	}

	@Override
	public LocalDate toLocalDate(Date value) {
	    return value == null ? null : value.toInstant().atZone(zoneId).toLocalDate();
	}

	@Override
	public Instant toInstant(Date value) {
	    return value == null ? null : value.toInstant();
	}

	@Override
	public LocalDateTime toLocalDateTime(Date value) {
	    return value == null ? null : value.toInstant().atZone(zoneId).toLocalDateTime();
	}

	@Override
	public Date now() {
	    return new Date();
	}

	@Override
	public Date toDate(Date value) {
	    return value;
	}
    }

    public final class FromCalendar extends AFromTemporal<Calendar> {
	private FromCalendar() {
	}

	@Override
	public LocalDate toLocalDate(Calendar value) {
	    return value == null ? null : value.toInstant().atZone(zoneId).toLocalDate();
	}

	@Override
	public Instant toInstant(Calendar value) {
	    return value == null ? null : value.toInstant();
	}

	@Override
	public LocalDateTime toLocalDateTime(Calendar value) {
	    return value == null ? null : value.toInstant().atZone(zoneId).toLocalDateTime();
	}

	@Override
	public Calendar now() {
	    return Calendar.getInstance(TimeZone.getTimeZone(zoneId));
	}

	@Override
	public Date toDate(Calendar value) {
	    return value == null ? null : value.getTime();
	}

	@Override
	public Calendar toCalendar(Calendar value) {
	    return value;
	}
    }
}
