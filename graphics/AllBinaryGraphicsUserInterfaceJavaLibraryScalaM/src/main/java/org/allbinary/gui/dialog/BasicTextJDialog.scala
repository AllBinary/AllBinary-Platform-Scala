/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.gui.dialog

import _root_.org.allbinary.thread.ARunnable

/**  *  * @author  USER  */
class BasicTextJDialog private (super_1 : _root_.java.awt.Frame, super_2 : Boolean, constructor_ : Unit) extends _root_.javax.swing.JDialog(super_1, super_2) {
    import _root_.org.allbinary.gui.dialog.BasicTextJDialog.{*}

    private var closeListenerInterface : CloseJDialogListenerInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var jButton1 : _root_.javax.swing.JButton = null

    private var textJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form BasicTextJDialog */
    def this(parent : _root_.java.awt.Frame, modal : Boolean, text : String) = {
        this(parent, modal, ())
        this.initComponents()
        this.setText(text)
    }

    def this(text : String) = {
        this(null, false, ())
        this.initComponents()
        this.textJLabel.setText(text)
    }

    def setText(text : String) : Unit = {
        this.textJLabel.setText(text)
    }

    def addCloseListener(closeListenerInterface : CloseJDialogListenerInterface) : Unit = {
        this.closeListenerInterface = closeListenerInterface
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.jButton1 = new _root_.javax.swing.JButton()
        this.textJLabel = new _root_.javax.swing.JLabel()
        setDefaultCloseOperation(_root_.javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
        this.jButton1.setText("OK")
        jButton1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton1ActionPerformed(evt)
                }

            })
        this.textJLabel.setText("No Text Set")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(getContentPane())
        getContentPane().setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(80, 80, 80).addComponent(jButton1)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(textJLabel, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 184, _root_.java.lang.Short.MAX_VALUE))).addContainerGap()))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(textJLabel, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 20, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30).addComponent(jButton1)))
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def jButton1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_jButton1ActionPerformed
        this.setVisible(false)
        if (this.closeListenerInterface != null) {
            this.closeListenerInterface.onClose()
        }
    }

}

object BasicTextJDialog {
    /**      * @param args the command line arguments      */
    def main(args : Array[String]) : Unit = {
        _root_.java.awt.EventQueue.invokeLater(new ARunnable {
                override def run() : Unit = {
                    new BasicTextJDialog(new _root_.javax.swing.JFrame(), true, "Test").setVisible(true)
                }

            })
    }

}


