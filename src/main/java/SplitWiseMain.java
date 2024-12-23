import dto.Expense;
import dto.Group;
import dto.User;
import service.SplitWiseService;
import service.SplitWiseServiceImpl;
import split.EqualSplit;
import split.PercentSplit;
import split.Split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitWiseMain {
    public static void main(String[] args) {
        SplitWiseService splitWiseService = new SplitWiseServiceImpl();

        User user1 = new User(1, "Krishna", 0.0d, new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Teja", 0.0d, new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Mintu", 0.0d, new ArrayList<>(), new ArrayList<>());

        splitWiseService.addUsers(Arrays.asList(user1, user2, user3));

        List<User> users = Arrays.asList(user1, user2, user3);
        Group group1 = new Group(1, "Flatmates", users, new ArrayList<>());
        splitWiseService.createGroup(group1);

        Expense expense = new Expense(1, group1, 100, user1, "Vegetables");
        Split split1 = new EqualSplit(user1.getId());
        Split split2 = new EqualSplit(user2.getId());
        Split split3 = new PercentSplit(user3.getId(), 25.0d);

        user1.setSplit(split1);
        user2.setSplit(split2);
        user3.setSplit(split3);

        splitWiseService.addExpense(expense, group1);

        splitWiseService.settleExpense(user1.getId(), user2.getId(), expense.getExpenseId());
        splitWiseService.settleExpense(user1.getId(), user3.getId(), expense.getExpenseId());

    }
}
