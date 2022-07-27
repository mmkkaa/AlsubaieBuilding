
import java.awt.Color;
import java.awt.Component;


import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class EnabledComboBoxRenderer extends BasicComboBoxRenderer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListSelectionModel enabledItems;

    private Color disabledColor = Color.lightGray;

    public EnabledComboBoxRenderer() {}

    public EnabledComboBoxRenderer(ListSelectionModel enabled) {
        super();
        this.enabledItems = enabled;
    }

    public void setEnabledItems(ListSelectionModel enabled) {
        this.enabledItems = enabled;
    }

    public void setDisabledColor(Color disabledColor) {
        this.disabledColor = disabledColor;
    }

    @Override
    public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        if (!enabledItems.isSelectedIndex(index)) {// not enabled
            if (isSelected) {
                c.setBackground(UIManager.getColor("ComboBox.background"));
            } else {
                c.setBackground(super.getBackground());
            }

            c.setForeground(disabledColor);

        } else {
            c.setBackground(super.getBackground());
            c.setForeground(super.getForeground());
        }
        return c;
    }

    /** private class DisabledListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JComboBox) e.getSource()).getSelectedIndex() != SELECTION_INTERVAL[0]
                    && ((JComboBox) e.getSource()).getSelectedIndex() != SELECTION_INTERVAL[1]) {
                JOptionPane.showMessageDialog(null,
                        "You can't Select that Item", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println(((JComboBox) e.getSource())
                        .getSelectedItem());
            }
        }
    }


   protected void disableItemsInComboBox() {
        comboBox.removeActionListener(enabledListener);
        comboBox.addActionListener(disabledListener);
        model.setSelectionInterval(SELECTION_INTERVAL[0], SELECTION_INTERVAL[1]);
    }
   */
}