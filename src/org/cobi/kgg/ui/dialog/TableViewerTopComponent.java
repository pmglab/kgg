/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cobi.kgg.ui.dialog;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.cobi.kgg.ui.ArrayListStringArrayTableModel;
import org.cobi.util.text.LocalFile;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDisplayer;
import org.openide.ErrorManager;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.StatusDisplayer;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.cobi.kgg.ui.dialog//TableViewer//EN",
        autostore = false)
@TopComponent.Description(
        preferredID = "TableViewerTopComponent",
        iconBase = "org/cobi/kgg/ui/png/16x16/Table.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.cobi.kgg.ui.dialog.TableViewerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_TableViewerAction",
        preferredID = "TableViewerTopComponent")
@Messages({
    "CTL_TableViewerAction=Table Viewer",
    "CTL_TableViewerTopComponent=TableViewer Window",
    "HINT_TableViewerTopComponent=This is a TableViewer window"
})
public final class TableViewerTopComponent extends TopComponent implements LookupListener {

    private ArrayList<String[]> listTableData = null;
    private ArrayListStringArrayTableModel listTableModel = null;

    public TableViewerTopComponent() {
        listTableData = new ArrayList<String[]>();
        listTableModel = new ArrayListStringArrayTableModel();
        initComponents();
        setName(Bundle.CTL_TableViewerTopComponent());
        setToolTipText(Bundle.HINT_TableViewerTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        dataTable.setModel(listTableModel);
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
     private Lookup.Result<File> result = null;

    @Override
    public void componentOpened() {
        result = Utilities.actionsGlobalContext().lookupResult(File.class);
        result.addLookupListener(this);
    }

    @Override
    public void componentClosed() {
        result.removeLookupListener(this);
        result = null;
    }

    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Collection<? extends File> allEvents = result.allInstances();
        try {
            if (!allEvents.isEmpty()) {
                File event = allEvents.iterator().next();
                //if(event instanceof GeneBasedAssociation) return;
                if ( event.getName().endsWith(".html") || event.getName().endsWith(".htm"))  return;
                listTableData.clear();
                LocalFile.retrieveData(event.getAbsolutePath(), listTableData, 500);
                if (listTableData.isEmpty()) {
                    NotifyDescriptor nd = new NotifyDescriptor.Message("The file has no data!", NotifyDescriptor.ERROR_MESSAGE);
                    DialogDisplayer.getDefault().notifyLater(nd);
                }
                String[] tmpArray = new String[listTableData.get(0).length];
                Arrays.fill(tmpArray, "");
                listTableModel.setTitle(tmpArray);
                if (listTableData.isEmpty()) {
                    tmpArray = new String[listTableModel.getColumnCount()];
                    Arrays.fill(tmpArray, "");
                    listTableData.add(tmpArray);
                }
                listTableModel.setDataList(listTableData);
                listTableModel.fireTableStructureChanged();
                StatusDisplayer.getDefault().setStatusText("Note: Only present 500 items!");
                this.open();
                this.requestActive();
            } else {
            }

        } catch (Exception ex) {
            ErrorManager.getDefault().notify(ex);
        }
    }
}
