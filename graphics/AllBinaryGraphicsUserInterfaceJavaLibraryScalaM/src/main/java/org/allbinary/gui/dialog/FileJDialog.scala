/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.gui.dialog

import _root_.org.allbinary.thread.ARunnable
import _root_.java.io.File
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author  USER  */
class FileJDialog private (super_1 : _root_.java.awt.Frame, super_2 : Boolean, constructor_ : Unit) extends _root_.javax.swing.JDialog(super_1, super_2) {
    import _root_.org.allbinary.gui.dialog.FileJDialog.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var finishedListenerInterface : FileJDialogListenerInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var jFileChooser1 : _root_.javax.swing.JFileChooser = null

    def this(parent : _root_.java.awt.Frame, modal : Boolean) = {
        this(parent, modal, ())
        this.initComponents()
        this.getJFileChooser1().setMultiSelectionEnabled(true)
    }

    /** Creates new form FileJDialog */
    def this() = {
        this(null, false, ())
        this.initComponents()
        this.getJFileChooser1().setMultiSelectionEnabled(true)
    }

    def addFinishedListener(finishedListenerInterface : FileJDialogListenerInterface) : Unit = {
        this.finishedListenerInterface = finishedListenerInterface
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.jFileChooser1 = new _root_.javax.swing.JFileChooser()
        setDefaultCloseOperation(_root_.javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
        this.jFileChooser1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jFileChooser1ActionPerformed(evt)
                }

            })
        var layout : _root_.org.jdesktop.layout.GroupLayout = new _root_.org.jdesktop.layout.GroupLayout(getContentPane())
        getContentPane().setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(_root_.org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup().addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).add(jFileChooser1, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, _root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addContainerGap()))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().addContainerGap().add(jFileChooser1, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 357, _root_.org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addContainerGap(_root_.org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE)))
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def jFileChooser1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.logUtil.putF("Starting Action Command: " + evt.getActionCommand(), this, "ActionPerformed")
        var files : Array[File] = this.getJFileChooser1().getSelectedFiles()
        if (evt.getActionCommand() eq _root_.javax.swing.JFileChooser.CANCEL_SELECTION) {
            this.setVisible(false)
        }
        //files[0] = this.getJFileChooser1().getSelectedFile();
        if (evt.getActionCommand() eq _root_.javax.swing.JFileChooser.APPROVE_SELECTION) {
            if ((files != null) && (files.length > 0)) {
                this.finishedListenerInterface.onFiles(files)
            }
        }
    }

    def getJFileChooser1() : _root_.javax.swing.JFileChooser = {
        return this.jFileChooser1
    }

    def setJFileChooser1(jFileChooser1 : _root_.javax.swing.JFileChooser) : Unit = {
        this.jFileChooser1 = jFileChooser1
    }

}

object FileJDialog {
    /**     * @param args the command line arguments     */
    def main(args : Array[String]) : Unit = {
        _root_.java.awt.EventQueue.invokeLater(new ARunnable {
                override def run() : Unit = {
                    new FileJDialog(new _root_.javax.swing.JFrame(), true).setVisible(true)
                }

            })
    }

}


