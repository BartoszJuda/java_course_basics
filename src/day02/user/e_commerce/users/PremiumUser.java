package day02.user.e_commerce.users;

import day02.user.e_commerce.products_and_orders.Cart;

public class PremiumUser extends User{

    public PremiumUser(int id, String name) {
        super(id, name);
    }

    @Override
    public double getUserDiscount() {
        return 0.10;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("rabat przyslugujący użytkownikowi wynosi:" + getUserDiscount());
    }
}
