class BankAccount
{
	private final String ownerLastName;
	private final String ownerFirstName;
	private final String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int bankAccountCount = 0;
	
	/**
	 * Value constructor for BankAccount.
	 * Constructs a bank account with all the acount information initialized based upon the values specified.
	 * 
	 * A unique account number is made via a delegate call to the makeAccountNumber() helper function.
	 * 
	 * @param String ownerLastName 		- the account owner's last name	 
	 * @param String ownerFirstName 	- the account owner's first name
	 * @param double checkingBalance 	- the starting checking balance
	 * @param double savingsBalance 	- the starting savings balance
	 */ 
	BankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = makeAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
		bankAccountCount = bankAccountCount+1;
	}
	
	/**
	 * Another value constructor for BankAcount.
	 * Constructs a bank account with the specified first and last name for the owner. 
	 * The starting balances for the checking and savings account will be initialized to be zero.
	 * 
	 * @param String ownerLastName 	- the account owner's last name  
	 * @param String ownerFirstName - the account owner's first name
	 */ 
	BankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	/**
	 * Attempts to withdraw the specified amount from the checking balance.
	 * The checking balance is only withdrawn from if there are sufficient funds to make the withdrawal.
	 * 
	 * Returns true if there are sufficient funds to make the withdrawal.
	 * Returns false if there are insufficient funds to make the withdrawal.
	 * 
	 * @param double amount - the amount to attempt to withdraw from the checking balance
	 * @return 				- whether the withdrawal was successful 
	 */ 
	public boolean withdrawFromChecking(double amount)
	{
		boolean successful = false;
		
		if(amount <= checkingBalance)
		{
			checkingBalance -= amount;
			successful = true;
		}

		return successful;
	}
	
	/**
	 * Attempts to withdraw the specified amount from the savings balance.
	 * The savings balance is only withdrawn from if there are sufficient funds to make the withdrawal.
	 * 
	 * Returns true if there are sufficient funds to make the withdrawal.
	 * Returns false if there are insufficient funds to make the withdrawal.
	 * 
	 * @param double amount - the amount to attempt to withdraw from the savings balance
	 * @return 				- whether the withdrawal was successful 
	 */ 
	public boolean withdrawFromSavings(double amount)
	{
		//TODO - implement
    boolean successful = false;
    if (amount <= savingsBalance)
    {
      savingsBalance -= amount;
      successful = true;
    }
		return successful; 
	}
	
	/**
	 * Attempts to transfer the specified amount from the savings balance to the checking balance.
	 * The savings balance is only transfered from if there are sufficient funds to make the transfer.
	 * 
	 * Returns true if there are sufficient funds to make the transfer.
	 * Returns false if there are insufficient funds to make the transfer.
	 * 
	 * @param double amount - the amount to attempt to transfer from the savings balance to the checking balance
	 * @return 				- whether the transfer was successful 
	 */ 
	public boolean transferFromSavingsToChecking(double amount)
	{
		//TODO - implement
    boolean successful = false;
    if (amount <= savingsBalance)
    {
      savingsBalance -= amount;
      checkingBalance += amount;
      successful = true;
    }
		return successful;
	}
	
	/**
	 * Attempts to transfer the specified amount from the checking balance to the savings balance.
	 * The checking balance is only transfered from if there are sufficient funds to make the transfer.
	 * 
	 * Returns true if there are sufficient funds to make the transfer.
	 * Returns false if there are insufficient funds to make the transfer.
	 * 
	 * @param double amount - the amount to attempt to transfer from the checking balance to the savings balance
	 * @return 				- whether the transfer was successful 
	 */ 
	public boolean transferFromCheckingToSavings(double amount)
	{
		//TODO - implement
		boolean successful = false;
    if (amount <= checkingBalance)
    {
      checkingBalance -= amount;
      savingsBalance += amount;
      successful = true;
    }
		return successful;
	}

	/**
	 * Deposits the specified amount to the checking balance.
	 * 
	 * @param double amount - the amount to deposit into the checking balance
	 */ 
	public void depositToChecking(double amount)
	{
		//TODO - implement
    checkingBalance += amount;
	}
	
	/**
	 * Deposits the specified amount to the savings balance.
	 * 
	 * @param double amount - the amount to deposit into the savings balance
	 */ 
	public void depositToSavings(double amount)
	{
		//TODO - implement
    savingsBalance += amount;
	}
	
	/**
	 * Constructs a string to represent the BankAccount object's current state.
	 * 
	 * @return a string representing the BankAccount 
	 */ 
	@Override
	public String toString()
	{
		//TODO - implement
    String currentState = "Bank Account: " + getAccountNumber() + "\n" + "Owner Name: " + getOwnerFirstName() + " " + getOwnerLastName() + "\n" + "Checking Balance: $" + String.format("%.2f", getCheckingBalance()) + "\n" + "Savings Balance: $" + String.format("%.2f", getSavingsBalance());
		return currentState;
	}
	
	/**
	 * Getter for the BankAccount owner's last name.
	 * 
	 * @return the owner's last name
	 */ 
	public String getOwnerLastName()
	{
		return ownerLastName;
	}
	
	/**
	 * Getter for the BankAccount owner's first name.
	 * 
	 * @return the owner's first name
	 */ 
	public String getOwnerFirstName()
	{
		return ownerFirstName;
	}
	
	/**
	 * Getter for the BankAccount's account number. 
	 * 
	 * @return the BankAccount's account number
	 */ 
	public String getAccountNumber()
	{
		//TODO - implement
		return accountNumber;
	}
	
	/**
	 * Getter for the BankAccount's checking balance.
	 * 
	 * @return the BankAccount's checking balance
	 */ 
	public double getCheckingBalance()
	{
		//TODO - implement
		return checkingBalance;
	}
	
	/**
	 * Getter for the BankAccount's savings balance.
	 * 
	 * @return the BankAccount's savings balance
	 */ 
	public double getSavingsBalance()
	{
		//TODO - implement
		return savingsBalance;
	}
	
	/**
	 * Private helper method that is used to make an account number for each BankAccount
	 * that gets constructed.
	 * 
	 * @return the account number of the BankAccount
	 */ 
	private String makeAccountNumber()
	{
		String aNumber = "" + bankAccountCount;
		
		while( aNumber.length() < 6 )
		{
			aNumber = "0" + aNumber;
		}
		return aNumber;
	}
	
	/**
	 * Returns how many BankAccount objects have been constructed.
	 * 
	 * @return the total number of BankAccount objects that have been constructed.
	 */ 
	public static int getBankAccountCount()
	{
		return bankAccountCount;
	}
}
