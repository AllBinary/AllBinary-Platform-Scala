/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.dialog

import _root_.java.awt.*
import _root_.java.awt.event.ActionEvent
import _root_.java.awt.event.ActionListener
import _root_.javax.swing.*
import _root_.org.allbinary.graphics.j2me.GraphicsException
import _root_.org.allbinary.graphics.j2me.MyFrame
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanel
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJPanelInterface

class NewWorkAreaJDialog(param_parent : MyFrame, param_modal : Boolean, param_dimension : Dimension, param_newName : String) extends _root_.javax.swing.JDialog(param_parent.asInstanceOf[_root_.java.awt.Frame], param_modal) {
    import _root_.org.allbinary.graphics.j2me.dialog.NewWorkAreaJDialog.{*}

    private var parent_NewWorkAreaJDialog : MyFrame = null

    private var dimension : Dimension = null

    private var xSizeJTextField : JTextField = null

    private var ySizeJTextField : JTextField = null

    private var nameJTextField : JTextField = null

    //Constructor
    {
        val parent : MyFrame = param_parent
        val modal : Boolean = param_modal
        val dimension : Dimension = param_dimension
        val newName : String = param_newName
        try {
            this.initComponents()
            this.parent_NewWorkAreaJDialog = parent
            this.xSizeJTextField = new JTextField("12")
            this.ySizeJTextField = new JTextField("12")
            this.nameJTextField = new JTextField(newName)
            this.dimension = dimension
            var submitButton : JButton = new JButton("Ok")
            submitButton.addActionListener(new ActionListener {
                    override def actionPerformed(evt : ActionEvent) : Unit = {
                        try {
                            disposeNewDialog()
                        } catch {
                            case e : Exception => {
                            }
                        }
                    }

                })
            this.setSize(150, 100)
            this.getContentPane().setLayout(new GridLayout(5, 2))
            this.getContentPane().add(new JLabel("Please enter"))
            this.getContentPane().add(new JLabel(" the size."))
            this.getContentPane().add(new JLabel("Name:"))
            this.getContentPane().add(this.nameJTextField)
            this.getContentPane().add(new JLabel("X: "))
            this.getContentPane().add(this.xSizeJTextField)
            this.getContentPane().add(new JLabel("Y: "))
            this.getContentPane().add(this.ySizeJTextField)
            this.getContentPane().add(submitButton)
            this.show()
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    private def disposeNewDialog() : Unit = {
        try {
            var canvasWidth : Integer = new Integer(this.xSizeJTextField.getText())
            var canvasHeight : Integer = new Integer(this.ySizeJTextField.getText())
            var newName : String = this.nameJTextField.getText()
            if (newName == null) {
                throw new GraphicsException("No Name", this, "disposeNewDialog")
            }
            var workAreaJPanel : WorkAreaJPanel = new WorkAreaJPanel(newName, this.dimension, canvasWidth.intValue(), canvasHeight.intValue())
            workAreaJPanel.setLayout(new GridLayout(1, 1))
            this.parent_NewWorkAreaJDialog.add(workAreaJPanel.asInstanceOf[WorkAreaJPanelInterface])
            this.dispose()
        } catch {
            case e : Exception => {
                throw e
            }
        }
    }

    private def initComponents() : Unit = {
        addWindowListener(new _root_.java.awt.event.WindowAdapter {
                override def windowClosing(evt : _root_.java.awt.event.WindowEvent) : Unit = {
                    closeDialog(evt)
                }

            })
        pack()
    }

    /** Closes the dialog */
    private def closeDialog(evt : _root_.java.awt.event.WindowEvent) : Unit = {
        //GEN-FIRST:event_closeDialog
        setVisible(false)
        dispose()
    }

}

object NewWorkAreaJDialog {
    //GEN-LAST:event_closeDialog
    def main(args : Array[String]) : Unit = {
        try {
            new NewWorkAreaJDialog(new MyFrame(), true, new Dimension(100, 100), "testing").show()
        } catch {
            case e : Exception => {
            }
        }
    }

}


