package com.softserve.homework09.opencart.data;

public class App {
    public static void main(String[] args) {
        /*- 1. Use Constructor
        User user = new User("firstname_1", "lastname_1", "email_1",
                "telephone_1", "fax_1", "company_1", "address1_1", "address2_1",
                "city_1", "postcode_1", "country_1", "region_1", "password_1", true);
        System.out.println("user.getFirstname() = " + user.getFirstname());
        System.out.println(user);
        */
        /*- 2. Use Setters
        User user = new User();
        user.setFirstname("firstname_2");
        user.setLastname("lastname_2");
        user.setEmail("email_2");
        user.setTelephone("telephone_2");
        user.setFax("fax_2");
        user.setCompany("company_2");
        user.setAddress1("address1_2");
        user.setAddress2("address2_2");
        user.setCity("city_2");
        user.setPostcode("postcode_2");
        user.setCountry("country_2");
        user.setRegion("region_2");
        user.setPassword("password_2");
        user.setSubscribe(true);
        System.out.println("user.getFirstname() = " + user.getFirstname());
        System.out.println(user);
        */
        /*- 3. Fluent iInterface
        User user = new User()
            .setFirstname("firstname_3")
            .setLastname("lastname_3")
            .setEmail("email_3")
            .setTelephone("telephone_3")
            .setFax("fax_3")
            .setCompany("company_3")
            .setAddress1("address1_3")
            .setAddress2("address2_3")
            .setCity("city_3")
            .setPostcode("postcode_3")
            .setCountry("country_3")
            .setRegion("region_3")
            .setPassword("password_3")
            .setSubscribe(true);
        System.out.println("user.getFirstname() = " + user.getFirstname());
        System.out.println(user);
        */
        /*- 4. Add Static Factory
        User user = User.get()
            .setFirstname("firstname_4")
            .setLastname("lastname_4")
            .setEmail("email_4")
            .setTelephone("telephone_4")
            .setFax("fax_4")
            .setCompany("company_4")
            .setAddress1("address1_4")
            .setAddress2("address2_4")
            .setCity("city_4")
            .setPostcode("postcode_4")
            .setCountry("country_4")
            .setRegion("region_4")
            .setPassword("password_4")
            .setSubscribe(true);
        System.out.println("user.getFirstname() = " + user.getFirstname());
        System.out.println(user);
        */
        /*- 5. Add Builder
        User user = User.get()
                .setFirstname("firstname_5")
                .setLastname("lastname_5")
                .setEmail("email_5")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostcode("postcode_5")
                .setCountry("country_5")
                .setRegion("region_5")
                .setPassword("password_5")
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
        System.out.println("user.getFirstname() = " + user.getFirstname());
        //
        System.out.println("user.getFirstname() = " + user.setFirstname(""));
        System.out.println("user.getFirstname() = " + user.getFirstname());
        */
        /*- 6. Add Dependency Inversion
        IUser user = User.get()
                .setFirstname("firstname_5")
                .setLastname("lastname_5")
                .setEmail("email_5")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostcode("postcode_5")
                .setCountry("country_5")
                .setRegion("region_5")
                .setPassword("password_5")
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
        System.out.println("user.getFirstname() = " + user.getFirstname());
        //
        //System.out.println("user.getFirstname() = " + user.setFirstname("")); // Compile Error
        System.out.println("user.getFirstname() = " + ((User) user).setFirstname("")); // Code Smell
        System.out.println("user.getFirstname() = " + user.getFirstname());
        */
        // 7. 8. Add Singleton, Repository
        IUser user = UserRepository.get().getHahaha();
        System.out.println("user.getFirstname() = " + user.getFirstname());
    }
}
