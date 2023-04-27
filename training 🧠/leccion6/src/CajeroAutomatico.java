public class CajeroAutomatico {
    PilaSE<Billete> billetes20 = new PilaSE<>();
    PilaSE<Billete> billetes10 = new PilaSE<>();
    PilaSE<Billete> billetes5 = new PilaSE<>();

    public CajeroAutomatico() {}

    public CajeroAutomatico(int c5, int c10, int c20) {
        for (int i = 0; i < c5; i++)
            billetes5.push(new Billete(5));
        for (int i = 0; i < c10; i++)
            billetes10.push(new Billete(10));
        for (int i = 0; i < c20; i++)
            billetes20.push(new Billete(20));
    }

    public void SurtirCajero(int monto) {

        if (billetes10.size() * 10 < monto) {
            int falta = monto / 10 - billetes10.size();
            for (int i = 0; i < falta; i++)
                billetes10.push(new Billete(10));
        }

        if (billetes20.size() < billetes10.size() / 2) {
            int falta = billetes10.size() / 2 - billetes20.size();
            for (int i = 0; i < falta; i++)
                billetes20.push(new Billete(20));
        }

        int falta = (billetes10.size() + billetes20.size()) - billetes5.size() ;
        for (int i = 0; i < falta; i++)
            billetes5.push(new Billete(5));
    }

    public int cantidadBilletes5() {
        return billetes5.size();
    }

    public int cantidadBilletes10() {
        return billetes10.size();
    }

    public int cantidadBilletes20() {
        return billetes20.size();
    }
}
