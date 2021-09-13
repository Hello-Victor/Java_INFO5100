/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Utilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Function;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aeloyq
 */
public class SortableTable extends JTable {

    String[] columns;
    Integer numOfColumns;
    Integer sortedColumn = -1;
    Listable listable;
    Integer order = 0;
    ArrayList<Object[]> objects;
    Boolean indexing = false;
    static String[] flags = {"▲", "▼"};
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static String floatFormat = "%.2f";

    public SortableTable(Listable listable, Boolean indexing) {
        super();
        this.listable = listable;
        this.indexing = indexing;
        columns = listable.getColumns();
        numOfColumns = listable.getNumOfColumns();
        getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int nextSortedColumn = columnAtPoint(e.getPoint());
                if (nextSortedColumn != sortedColumn) {
                    sortedColumn = nextSortedColumn;
                    order = 0;
                } else {
                    order = 1 - order;
                }
                refresh();
            }
        }
        );
        refresh();
    }

    public void reset() {
        sortedColumn = -1;
        order = 0;
        refresh();
    }

    public void refresh() {
        DefaultTableModel model = new DefaultTableModel();
        Object[] columns = new Object[numOfColumns];
        for (int i = 0; i < numOfColumns; i++) {
            columns[i] = i != sortedColumn ? this.columns[i] : this.columns[i] + " " + flags[order];
        }
        model.setColumnIdentifiers(columns);
        objects = listable.getObjects();
        if (sortedColumn != -1 && objects.size() > 0) {
            if (objects.get(0)[sortedColumn] instanceof Integer) {
                Collections.sort(objects, Comparator.comparing((Object[] os) -> (int) os[sortedColumn]));
            } else if (objects.get(0)[sortedColumn] instanceof Double) {
                Collections.sort(objects, Comparator.comparing((Object[] os) -> (double) os[sortedColumn]));
            } else if (objects.get(0)[sortedColumn] instanceof Float) {
                Collections.sort(objects, Comparator.comparing((Object[] os) -> (float) os[sortedColumn]));
            } else if (objects.get(0)[sortedColumn] instanceof Date) {
                Collections.sort(objects, Comparator.comparing((Object[] os) -> (Date) os[sortedColumn]));
            } else {
                Collections.sort(objects, Comparator.comparing((Object[] os) -> (String) os[sortedColumn]));
            }
        }
        int offset = indexing ? 1 : 0;
        int numOfColumnsInRow = indexing ? numOfColumns + 1 : numOfColumns;
        for (int i = 0; i < objects.size(); i++) {
            Object[] row = new Object[numOfColumnsInRow + 1];
            if (indexing) {
                row[0] = i;
            }
            for (int j = 0; j < numOfColumns; j++) {
                Object[] os = objects.get(i);
                if (os[j] instanceof Double) {
                    row[j + offset] = String.format(floatFormat, (double) os[j]);
                } else if (os[j] instanceof Float) {
                    row[j + offset] = String.format(floatFormat, (float) os[j]);
                } else if (os[j] instanceof Date) {
                    row[j + offset] = dateFormat.format((Date) os[j]);
                } else {
                    row[j + offset] = objects.get(i)[j];
                }
            }
            model.addRow(row);
        }
        setModel(model);
    }

    private Object getKeyExtractor(Object[] os) {
        return os[sortedColumn];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
