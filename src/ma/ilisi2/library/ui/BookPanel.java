package ma.ilisi2.library.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import ma.ilisi2.library.models.bo.Book;

import javax.swing.*;
import java.awt.*;

public class BookPanel extends JPanel {
    private JPanel bookpanel;
    private JTextField tprice;
    private JTextField tauthor;
    private JTextField tyear;
    private JTextField tisbn;
    private JTextField tid;
    private JTextField tdescription;
    private JLabel ttitle;

    public BookPanel(Book b) {
        setupUI();
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(100, 200));
        setBorder(BorderFactory.createTitledBorder("Book Details"));
        add(bookpanel, BorderLayout.CENTER);
        setBookData(b);
    }

    private void setupUI() {
        bookpanel = new JPanel();
        bookpanel.setLayout(new GridLayoutManager(7, 3, new Insets(10, 30, 30, 50), -1, -1));
        // Horizontal Spacer
        bookpanel.add(new Spacer(), new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));

        // Labels
        bookpanel.add(new JLabel("Title"), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ttitle = new JLabel("Title");
        bookpanel.add(ttitle, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        bookpanel.add(new JLabel("Id"), new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bookpanel.add(new JLabel("Isbn"), new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bookpanel.add(new JLabel("Price"), new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bookpanel.add(new JLabel("Author"), new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bookpanel.add(new JLabel("Year"), new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bookpanel.add(new JLabel("Description"), new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        // Text Fields (matching your XML properties: non-editable)
        tid = createField(1);
        tisbn = createField(2);
        tprice = createField(3);
        tauthor = createField(4);
        tyear = createField(5);
        tdescription = createField(6);
    }

    private JTextField createField(int row) {
        JTextField field = new JTextField();
        field.setEditable(false);
        bookpanel.add(field, new GridConstraints(row, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        return field;
    }

    // Getters for setting data later
    public void setBookData(Book b) {
        tid.setText(String.valueOf(b.getId()));
        ttitle.setText(b.getTitle());
        tisbn.setText(b.getIsbn());
        tprice.setText(String.valueOf(b.getPrice()));
        tauthor.setText(b.getAuthor());
        tyear.setText(Integer.toString(b.getYear()));
        tdescription.setText(b.getDescription());
    }
}