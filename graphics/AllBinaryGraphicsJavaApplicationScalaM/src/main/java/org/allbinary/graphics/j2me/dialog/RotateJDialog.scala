/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.dialog

import _root_.org.allbinary.thread.ARunnable
import _root_.java.util.HashMap
import _root_.org.allbinary.gui.dialog.HashMapJDialogListenerInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  user  */
class RotateJDialog(param_parent : _root_.java.awt.Frame, param_modal : Boolean) extends _root_.javax.swing.JDialog(param_parent, param_modal) {
    import _root_.org.allbinary.graphics.j2me.dialog.RotateJDialog.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var angleIncrementJTextField : _root_.javax.swing.JTextField = null

    private var jButton1 : _root_.javax.swing.JButton = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var jLabel2 : _root_.javax.swing.JLabel = null

    private var jPanel1 : _root_.javax.swing.JPanel = null

    private var totalRotationJTextField : _root_.javax.swing.JTextField = null

    /** Creates new form RotateJDialog */
    //Constructor
    {
        val parent : _root_.java.awt.Frame = param_parent
        val modal : Boolean = param_modal
        this.initComponents()
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        angleIncrementJTextField = new _root_.javax.swing.JTextField()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.totalRotationJTextField = new _root_.javax.swing.JTextField()
        this.jLabel2 = new _root_.javax.swing.JLabel()
        this.jPanel1 = new _root_.javax.swing.JPanel()
        this.jButton1 = new _root_.javax.swing.JButton()
        setDefaultCloseOperation(_root_.javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
        this.angleIncrementJTextField.setText("36")
        this.jLabel1.setText("Angle Increment:")
        this.totalRotationJTextField.setText("360")
        this.jLabel2.setText("Total Angular Rotation:")
        this.jButton1.setText("OK")
        this.jButton1.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    jButton1ActionPerformed(evt)
                }

            })
        var jPanel1Layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.jPanel1)
        this.jPanel1.setLayout(jPanel1Layout)
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(62, 62, 62).addComponent(jButton1).addContainerGap(62, _root_.java.lang.Short.MAX_VALUE)))
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton1))
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(getContentPane())
        getContentPane().setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel2)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(totalRotationJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 31, _root_.java.lang.Short.MAX_VALUE).addComponent(angleIncrementJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 31, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()).addComponent(jPanel1, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(angleIncrementJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(totalRotationJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, _root_.java.lang.Short.MAX_VALUE).addComponent(jPanel1, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()))
        pack()
    }

    // </editor-fold>//GEN-END:initComponents
    private def jButton1ActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.hashMap.put(Integer.valueOf(0), Integer.valueOf(this.angleIncrementJTextField.getText()))
            this.hashMap.put(Integer.valueOf(1), Integer.valueOf(this.totalRotationJTextField.getText()))
            (this.getParent().asInstanceOf[HashMapJDialogListenerInterface]).onHashMap(this.hashMap)
            this.setVisible(false)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.putF(commonStrings.EXCEPTION, this, "jButton1ActionPerformed")
            }
        }
    }

}

object RotateJDialog {
    /**      * @param args the command line arguments      */
    def main(args : Array[String]) : Unit = {
        _root_.java.awt.EventQueue.invokeLater(new ARunnable {
                override def run() : Unit = {
                    var dialog : RotateJDialog = new RotateJDialog(new _root_.javax.swing.JFrame(), true)
                    dialog.addWindowListener(new _root_.java.awt.event.WindowAdapter {
                        override def windowClosing(e : _root_.java.awt.event.WindowEvent) : Unit = {
                            System.exit(0)
                        }

                    })
                    dialog.setVisible(true)
                }

            })
    }

}


