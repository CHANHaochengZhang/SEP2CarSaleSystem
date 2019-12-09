package persistence;

import model.buyerModel.Buyer;
import model.mailModel.Message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {


    public static void main(String[] args) {
        ArrayList<String> texs = new ArrayList<>();
        DbGetter dbGetter = new DbGetterImp();
        DbAdder dbAdder = new DbAdderImp();
//
//        System.out.println(dbGetter.getMessage());
//        System.out.println(dbGetter.getBuyer());
//        System.out.println(dbGetter.getSeller());

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DbAdder adder = new DbAdderImp();
//        String d = sdf.format(date);
//        adder.addMessage(new Message("hello w", d,888,999));
//        System.out.println(dbGetter.getMessage());

//        dbAdder.addBuyer(new Buyer("c","hello",780));

    }
}
