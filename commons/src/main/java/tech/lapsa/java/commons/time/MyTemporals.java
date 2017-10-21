package tech.lapsa.java.commons.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import tech.lapsa.java.commons.function.MyObjects;

public final class MyTemporals {

    public static MyTemporals getInstance() {
	return getInstance(ZoneId.systemDefault());
    }

    public static MyTemporals getInstance(ZoneId zoneId) {
	return new MyTemporals(MyObjects.requireNonNull(zoneId, "zoneId"));
    }

    private final ZoneId zoneId;
    private final DateUtil dateUtil;
    private final LocalDateTimeUtil localDateTimeUtil;
    private final LocalDateUtil localDateUtil;
    private final InstantUtil instantUtil;

    private MyTemporals(ZoneId zoneId) {
	this.zoneId = zoneId;
	this.dateUtil = new DateUtil();
	this.instantUtil = new InstantUtil();
	this.localDateUtil = new LocalDateUtil();
	this.localDateTimeUtil = new LocalDateTimeUtil();
    }

    public DateUtil forDate() {
	return dateUtil;
    }

    public LocalDateTimeUtil forLocalDateTime() {
	return localDateTimeUtil;
    }

    public LocalDateUtil forLocalDate() {
	return localDateUtil;
    }

    public InstantUtil forInstance() {
	return instantUtil;
    }

    public interface TemporalUtil<T> {

	LocalDate toLocalDate(T value);

	Instant toInstant(T value);

	LocalDateTime toLocalDateTime(T value);

	T now();

	default Date toDate(T value) {
	    return value == null ? null : Date.from(toInstant(value));
	}

	default boolean isToday(T value) {
	    return value == null ? false : LocalDate.now().isEqual(toLocalDate(value));
	}

	default boolean isYesterday(T value) {
	    return value == null ? false : LocalDate.now().minusDays(1).isEqual(toLocalDate(value));
	}

	default boolean isTommorow(T value) {
	    return value == null ? false : LocalDate.now().plusDays(1).isEqual(toLocalDate(value));
	}
    }

    public final class InstantUtil implements TemporalUtil<Instant> {
	private InstantUtil() {
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

    public final class LocalDateUtil implements TemporalUtil<LocalDate> {
	private LocalDateUtil() {
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

    public final class LocalDateTimeUtil implements TemporalUtil<LocalDateTime> {
	private LocalDateTimeUtil() {
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

    public final class DateUtil implements TemporalUtil<Date> {
	private DateUtil() {
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
    }
}
