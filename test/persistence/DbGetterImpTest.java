package persistence;

import org.junit.Test;

import static org.junit.Assert.*;

public class DbGetterImpTest {
    DbGetter dbGetter = new DbGetterImp();

    @Test
    public void getCar() {
        dbGetter.getCar();
    }

    @Test
    public void getSeller() {
        dbGetter.getSeller();
    }

    @Test
    public void getBuyer() {
        dbGetter.getBuyer();
    }

    @Test
    public void getMessage() {
        dbGetter.getMessage();
    }
}