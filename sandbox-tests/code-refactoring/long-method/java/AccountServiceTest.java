import com.epam.aicode.java.Account;
import com.epam.aicode.java.AccountResponse;
import com.epam.aicode.java.AccountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountServiceTest {

    private static final String EMAIL = "email";
    private static final long ID = 123L;
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private final AccountService accountService = new AccountService();

    @Test
    public void testHandleResponseSuccess() {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(ID);
        accountResponse.setName(NAME);
        accountResponse.setEmail(EMAIL);
        accountResponse.setPhone(PHONE);

        Account account = accountService.handleResponse(accountResponse);

        assertEquals(account.getEmail(), accountResponse.getEmail());
        assertEquals(account.getName(), accountResponse.getName());
        assertEquals(account.getPhone(), accountResponse.getPhone());
        assertEquals(account.getId(), accountResponse.getId());
    }

    @Test
    public void testHandleResponseNullEmail() {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(ID);
        accountResponse.setName(NAME);
        accountResponse.setEmail(null);
        accountResponse.setPhone(PHONE);

        try {
            accountService.handleResponse(accountResponse);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Email is required");
        }
    }

    @Test
    public void testHandleResponseNullName() {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(ID);
        accountResponse.setName(null);
        accountResponse.setEmail(EMAIL);
        accountResponse.setPhone(PHONE);

        try {
            accountService.handleResponse(accountResponse);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Name is required");
        }
    }

    @Test
    public void testHandleResponseNullPhone() {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(ID);
        accountResponse.setName(NAME);
        accountResponse.setEmail(EMAIL);
        accountResponse.setPhone(null);

        try {
            accountService.handleResponse(accountResponse);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Phone is required");
        }
    }

    @Test
    public void testHandleResponseNullId() {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(null);
        accountResponse.setName(NAME);
        accountResponse.setEmail(EMAIL);
        accountResponse.setPhone(PHONE);

        try {
            accountService.handleResponse(accountResponse);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Id is required");
        }
    }
}
