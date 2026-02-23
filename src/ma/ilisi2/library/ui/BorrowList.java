package ma.ilisi2.library.ui;

import ma.ilisi2.library.controller.BorrowController;
import ma.ilisi2.library.models.bo.Borrow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class BorrowList extends JFrame {

    private final BorrowController borrowController;
    private JTable borrowTable;

    public BorrowList() {
        this.borrowController = new BorrowController();
        initUI();
        loadBorrows();
    }

    private void initUI() {
        setTitle("Borrows");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Book", "User", "Borrow Date", "Status", "Return Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        borrowTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(borrowTable);

        add(scrollPane, BorderLayout.CENTER);

        setSize(900, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadBorrows() {
        Collection<Borrow> borrows = borrowController.getAllBorrows();
        DefaultTableModel model = (DefaultTableModel) borrowTable.getModel();
        model.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Borrow b : borrows) {
            String bookTitle = b.getBook() != null ? b.getBook().getTitle() : "";
            String userName = b.getUser() != null ? b.getUser().getName() : "";
            String borrowDate = b.getBorrowDate() != null ? b.getBorrowDate().format(formatter) : "";
            String returnDate = b.getReturnDate() != null ? b.getReturnDate().format(formatter) : "";
            model.addRow(new Object[]{
                    b.getId(),
                    bookTitle,
                    userName,
                    borrowDate,
                    b.getStatus(),
                    returnDate
            });
        }
    }
}

