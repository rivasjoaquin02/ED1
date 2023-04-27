package p3;

public class Date {
    protected int a;
    protected int m;
    protected int hh;
    protected int mm;
    protected int ss;

    public Date(int a, int m, int hh, int mm, int ss) {
        this.a = a;
        this.m = m;
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }

    public int getA() {
        return a;
    }

    public int getM() {
        return m;
    }

    public int getHh() {
        return hh;
    }

    public int getMm() {
        return mm;
    }

    public int getSs() {
        return ss;
    }

    public int compareTo(Date date) {
        if (this.a - date.a != 0)
            return this.a - date.a;
        if (this.m - date.m != 0)
            return this.m - date.m;
        if (this.hh - date.hh != 0)
            return this.hh - date.hh;
        if (this.mm - date.mm != 0)
            return this.mm - date.mm;
        if (this.ss - date.ss != 0)
            return this.ss - date.ss;

        return 0;
    }
}
