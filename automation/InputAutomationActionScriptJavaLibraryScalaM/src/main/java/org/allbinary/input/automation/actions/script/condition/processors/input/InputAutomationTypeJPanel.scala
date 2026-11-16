/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input


/**  *  * @author  USER  */
class InputAutomationTypeJPanel() extends _root_.javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var inputAutomationTypeJComboBox : _root_.javax.swing.JComboBox[Object] = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    /** Creates new form InputAutomationTypeJPanel */
    //Constructor
    {
        this.initComponents()
    }

    def getInputAutomationTypeJComboBox() : _root_.javax.swing.JComboBox[Object] = {
        return this.inputAutomationTypeJComboBox
    }

    def setInputAutomationTypeJComboBox(inputAutomationTypeJComboBox : _root_.javax.swing.JComboBox[Object]) : Unit = {
        this.inputAutomationTypeJComboBox = inputAutomationTypeJComboBox
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.inputAutomationTypeJComboBox = new _root_.javax.swing.JComboBox[Object]()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.inputAutomationTypeJComboBox.setModel(new _root_.javax.swing.DefaultComboBoxModel[Object](Array[String]("DirectX", "DirectX 8", "Low Level", "Java Robot").asInstanceOf[Array[Object]]))
        this.jLabel1.setText("Input Type:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(inputAutomationTypeJComboBox, 0, 98, _root_.java.lang.Short.MAX_VALUE)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(inputAutomationTypeJComboBox, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)))
    }

}


