import org.junit.Test;
import org.junit.Assert;

public class BankAccountTest {

    @Test
    public void testDepositWithPositiveAmount() {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        Assert.assertEquals(1500, account.getBalance());
    }

    @Test
    public void testDepositWithZeroAmount() {
        BankAccount account = new BankAccount(1000);
        account.deposit(0);
        Assert.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testDepositWithNegativeAmount() {
        BankAccount account = new BankAccount(1000);
        try {
            account.deposit(-500);
            Assert.fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testWithdrawWithValidAmount() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(500);
        Assert.assertEquals(500, account.getBalance());
    }

    @Test
    public void testWithdrawWithOverdraft() {
        BankAccount account = new BankAccount(1000);
        try {
            account.withdraw(1500);
            Assert.fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

}
