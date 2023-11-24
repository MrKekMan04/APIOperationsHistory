package ru.netology.vitaliyefimov.entity;

public class Operation implements ConsolePrintable {
    private int id;
    private int sum;
    private Currency currency;
    private String merchant;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getMerchant() {
        return merchant;
    }

    public Operation() {
    }

    public Operation(int id, int sum, Currency currency, String merchant) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Operation{ id = " + id +
                ", sum: " + sum +
                ", currency: " + currency +
                ", merchant: " + merchant + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Operation operation = (Operation) o;
        return id == operation.id
                && (sum == operation.sum
                && (currency != null && currency.equals(operation.getCurrency()))
                && (merchant != null && merchant.equals(operation.getMerchant())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int res = 1;
        res = prime * res + id;
        res = prime * res + sum;
        res = prime * res + ((currency == null) ? 0 : currency.hashCode());
        res = prime * res + ((merchant == null) ? 0 : merchant.hashCode());
        return res;
    }

    @Override
    public void printToConsole() {
        System.out.println("Твой id: " + id + "." +
                " Сумма операции, которую ты совершил " + sum +
                currency + "." +
                " Оператор, на которого была совершена операция" + merchant + ".");
    }
}
