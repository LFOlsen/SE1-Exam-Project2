package dtu.planning.domain;


public class RegularActivity {
    TypeRegularActivity type;
    DateField period;

    public RegularActivity(TypeRegularActivity type, DateField period) {
        this.type = type;
        this.period = period;
    }

    public boolean isWithin(DateField testPeriod) {
        return testPeriod.dateStart.isBefore(period.dateEnd) && testPeriod.dateEnd.isAfter(period.dateStart);
    }

    public boolean isCritical() { return this.type == TypeRegularActivity.SICKNESS; }
    public DateField getPeriod() { return this.period; }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof RegularActivity)) {
            return false;
        }

        RegularActivity r = (RegularActivity) o;
        return (type == r.type) && (period.dateStart.isEqual(r.period.dateStart)) && (period.dateEnd.isEqual(r.period.dateEnd));
    }

    /**
     * Need to override hashCode as well -- look into this
     */
}