package com.example.demo2.Question3;

public class Account implements OnlineAccount, Comparable<Account> {

    private String ownerName;
    private Integer noOfRegularMovies;
    private Integer noOfExclusiveMovies;

    public Account(String ownerName, Integer noOfRegularMovies, Integer noOfExclusiveMovies) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    @Override
    public Integer monthlyCost() {
        return BASE_PRICE + (noOfRegularMovies * REGULAR_MOVIE_PRICE) + (noOfExclusiveMovies * EXCLUSIVE_MOVIE_PRICE);
    }

    @Override
    public int compareTo(Account account) {
        return Integer.compare(this.monthlyCost(), account.monthlyCost());
    }

    @Override
    public String toString() {
        return "Owner is "+ ownerName + " and monthly cost is " +this.monthlyCost()+" USD.";
    }
}
