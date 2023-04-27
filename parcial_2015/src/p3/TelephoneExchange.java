package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TelephoneExchange {
    protected Queue<Call> calls;

    public TelephoneExchange(Queue<Call> calls) {
        this.calls = calls;
    }

    public void addCall(Call call){
        calls.add(call);
    }

    public List<Call> callsMadeUntil(Date date) {
        List<Call> totalCallsMadeUntil = new ArrayList<>();

        for(Call ci: calls)
            if (ci.getStartDate().equals(date))
                totalCallsMadeUntil.add(ci);

        return totalCallsMadeUntil;
    }
}






