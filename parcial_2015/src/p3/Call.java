package p3;

public class Call {
    protected String originPhone;
    protected String destinationPhone;
    protected Date startDate;
    protected int duration;

    public Call(String originPhone, String destinationPhone, Date startDate, int duration) {
        this.originPhone = originPhone;
        this.destinationPhone = destinationPhone;
        this.startDate = startDate;
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }
}
