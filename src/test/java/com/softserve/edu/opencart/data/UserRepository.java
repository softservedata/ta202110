package com.softserve.edu.opencart.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UserRepository {
    private static volatile UserRepository instance = null;
    //
    private final String TIME_TEMPLATE = "HH_mm_ss_S";

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return getHahaha();
    }

    public IUser getHahaha() {
        return User.get()
                .setFirstname("hahaha")
                .setLastname("hahaha")
                .setEmail("hahaha@gmail.com")
                .setTelephone("hahaha")
                .setAddress1("address1")
                .setCity("city_5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("qwerty")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getAwdrt() {
        return User.get()
                .setFirstname("my")
                .setLastname("hahaha")
                .setEmail("xdknxusqvjeovowpfk@awdrt.com")
                .setTelephone("hahaha")
                .setAddress1("address1")
                .setCity("city_5")
                .setPostcode("postcode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("awdrt123")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getNewUser() {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String newEmail = "temp" + currentTime + "@gmail.com";
        return User.get()
                .setFirstname("firstName3")
                .setLastname("lastName3")
                .setEmail(newEmail)
                .setTelephone("telephone3")
                .setAddress1("address13")
                .setCity("city3")
                .setPostcode("postCode3")
                .setCountry("Ukraine")
                .setRegion("Kyiv")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                //.setPassword("password3")
                .setSubscribe(true)
                .setFax("fax3")
                .build();
    }


    /*-
    public IUser getInvalidUser() {

    }
    */

    /*-
    public List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }
    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }
    public List<IUser> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }
    public List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }
    */
}