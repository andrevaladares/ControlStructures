@groovy.transform.ToString
class AccountStructures {
    BigDecimal balance = 0.0
    String type
    
    void deposit(BigDecimal value){
        if(value < 0){
            throw new Exception("invalid amount: ${value}")
        }
        
        balance+=value
    }
    
    void deposit(List<BigDecimal> amounts){
        for(BigDecimal amount in amounts){
            deposit(amount)
        }
    }
    
    void withDraw(BigDecimal value){
        balance-=value
    }

    BigDecimal plus(Account other){
        balance:balance+other.balance
    }
}    

AccountStructures account = new AccountStructures()
account.deposit 10
println account.balance
//account.deposit(-20)
//println account.balance
try {
    account.deposit (-5)
}
catch(Exception e){
    println(e.message)
}
println account.balance
account.deposit ([10,20,30])
println account.balance