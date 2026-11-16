/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.media.image.analysis.ColorRangeInterface
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author  USER  */
class ColorAtActionScriptConditionJPanel(param_colorAtActionScriptConditionInterface : ColorAtActionScriptConditionInterface) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var colorAtActionScriptConditionInterface : ColorAtActionScriptConditionInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var blueJLabel : _root_.javax.swing.JLabel = null

    private var colorAtActionJButton : _root_.javax.swing.JButton = null

    private var colorAtActionJDialog : _root_.javax.swing.JDialog = null

    private var colorAtXJTextField : _root_.javax.swing.JTextField = null

    private var colorAtYJTextField : _root_.javax.swing.JTextField = null

    private var colorRangeJLabel : _root_.javax.swing.JLabel = null

    private var greenJLabel : _root_.javax.swing.JLabel = null

    private var jLabel1 : _root_.javax.swing.JLabel = null

    private var locationJLabel : _root_.javax.swing.JLabel = null

    private var maxBlueJTextField : _root_.javax.swing.JTextField = null

    private var maxGreenJTextField : _root_.javax.swing.JTextField = null

    private var maxJLabel : _root_.javax.swing.JLabel = null

    private var maxRedJTextField : _root_.javax.swing.JTextField = null

    private var minBlueJTextField : _root_.javax.swing.JTextField = null

    private var minGreenJTextField : _root_.javax.swing.JTextField = null

    private var minJLabel : _root_.javax.swing.JLabel = null

    private var minRedJTextField : _root_.javax.swing.JTextField = null

    private var okJButton : _root_.javax.swing.JButton = null

    private var redJLabel : _root_.javax.swing.JLabel = null

    private var titleJLabel : _root_.javax.swing.JLabel = null

    private var xJLabel : _root_.javax.swing.JLabel = null

    private var yJLabel : _root_.javax.swing.JLabel = null

    /** Creates new form ColorAtActionJPanel */
    //Constructor
    {
        val colorAtActionScriptConditionInterface : ColorAtActionScriptConditionInterface = param_colorAtActionScriptConditionInterface
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.initComponents()
        this.colorAtActionScriptConditionInterface = colorAtActionScriptConditionInterface
        this.set()
    }

    private def set() : Unit = {
        var colorRangeInterface : ColorRangeInterface = this.colorAtActionScriptConditionInterface.getColorRangeInterface()
        this.getMinRedJTextField().setText(Integer.toString(colorRangeInterface.getMinRed()))
        this.getMaxRedJTextField().setText(Integer.toString(colorRangeInterface.getMaxRed()))
        this.getMinGreenJTextField().setText(Integer.toString(colorRangeInterface.getMinGreen()))
        this.getMaxGreenJTextField().setText(Integer.toString(colorRangeInterface.getMaxGreen()))
        this.getMinBlueJTextField().setText(Integer.toString(colorRangeInterface.getMinBlue()))
        this.getMaxBlueJTextField().setText(Integer.toString(colorRangeInterface.getMaxBlue()))
        this.getColorAtXJTextField().setText(Integer.toString(this.colorAtActionScriptConditionInterface.getPoint().x))
        this.getColorAtYJTextField().setText(Integer.toString(this.colorAtActionScriptConditionInterface.getPoint().y))
        this.colorAtActionScriptConditionInterface.log()
    }

    private def update() : Unit = {
        var colorRangeInterface : ColorRangeInterface = this.colorAtActionScriptConditionInterface.getColorRangeInterface()
        colorRangeInterface.setMinRed(Integer.valueOf(this.getMinRedJTextField().getText()).intValue())
        colorRangeInterface.setMaxRed(Integer.valueOf(this.getMaxRedJTextField().getText()).intValue())
        colorRangeInterface.setMinGreen(Integer.valueOf(this.getMinGreenJTextField().getText()).intValue())
        colorRangeInterface.setMaxGreen(Integer.valueOf(this.getMaxGreenJTextField().getText()).intValue())
        colorRangeInterface.setMinBlue(Integer.valueOf(this.getMinBlueJTextField().getText()).intValue())
        colorRangeInterface.setMaxBlue(Integer.valueOf(this.getMaxBlueJTextField().getText()).intValue())
        var xString : String = this.getColorAtXJTextField().getText()
        if (!StringValidationUtil.getInstance().isEmpty(xString) && StringValidationUtil.getInstance().isNumber(xString)) {
            this.colorAtActionScriptConditionInterface.getPoint().x = Integer.parseInt(xString)
        }
        var yString : String = this.getColorAtYJTextField().getText()
        if (!StringValidationUtil.getInstance().isEmpty(yString) && StringValidationUtil.getInstance().isNumber(yString)) {
            this.colorAtActionScriptConditionInterface.getPoint().y = Integer.parseInt(xString)
        }
        this.colorAtActionScriptConditionInterface.log()
    }

    def getColorAtXJTextField() : _root_.javax.swing.JTextField = {
        return this.colorAtXJTextField
    }

    def setColorAtXJTextField(colorAtXJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.colorAtXJTextField = colorAtXJTextField
    }

    def getColorAtYJTextField() : _root_.javax.swing.JTextField = {
        return this.colorAtYJTextField
    }

    def setColorAtYJTextField(colorAtYJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.colorAtYJTextField = colorAtYJTextField
    }

    def getMaxBlueJTextField() : _root_.javax.swing.JTextField = {
        return this.maxBlueJTextField
    }

    def setMaxBlueJTextField(maxBlueJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxBlueJTextField = maxBlueJTextField
    }

    def getMaxGreenJTextField() : _root_.javax.swing.JTextField = {
        return this.maxGreenJTextField
    }

    def setMaxGreenJTextField(maxGreenJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxGreenJTextField = maxGreenJTextField
    }

    def getMaxRedJTextField() : _root_.javax.swing.JTextField = {
        return this.maxRedJTextField
    }

    def setMaxRedJTextField(maxRedJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.maxRedJTextField = maxRedJTextField
    }

    def getMinBlueJTextField() : _root_.javax.swing.JTextField = {
        return this.minBlueJTextField
    }

    def setMinBlueJTextField(minBlueJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minBlueJTextField = minBlueJTextField
    }

    def getMinGreenJTextField() : _root_.javax.swing.JTextField = {
        return this.minGreenJTextField
    }

    def setMinGreenJTextField(minGreenJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minGreenJTextField = minGreenJTextField
    }

    def getMinRedJTextField() : _root_.javax.swing.JTextField = {
        return this.minRedJTextField
    }

    def setMinRedJTextField(minRedJTextField : _root_.javax.swing.JTextField) : Unit = {
        this.minRedJTextField = minRedJTextField
    }

    def getYJLabel() : _root_.javax.swing.JLabel = {
        return this.yJLabel
    }

    def setYJLabel(yJLabel : _root_.javax.swing.JLabel) : Unit = {
        this.yJLabel = yJLabel
    }

    def getColorAtActionJDialog() : _root_.javax.swing.JDialog = {
        return this.colorAtActionJDialog
    }

    def setColorAtActionJDialog(colorAtActionJDialog : _root_.javax.swing.JDialog) : Unit = {
        this.colorAtActionJDialog = colorAtActionJDialog
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.colorAtActionJDialog = new _root_.javax.swing.JDialog()
        this.titleJLabel = new _root_.javax.swing.JLabel()
        this.locationJLabel = new _root_.javax.swing.JLabel()
        this.colorAtXJTextField = new _root_.javax.swing.JTextField()
        this.xJLabel = new _root_.javax.swing.JLabel()
        this.yJLabel = new _root_.javax.swing.JLabel()
        this.colorAtYJTextField = new _root_.javax.swing.JTextField()
        this.colorRangeJLabel = new _root_.javax.swing.JLabel()
        this.redJLabel = new _root_.javax.swing.JLabel()
        this.minJLabel = new _root_.javax.swing.JLabel()
        this.maxJLabel = new _root_.javax.swing.JLabel()
        this.greenJLabel = new _root_.javax.swing.JLabel()
        this.blueJLabel = new _root_.javax.swing.JLabel()
        this.minRedJTextField = new _root_.javax.swing.JTextField()
        this.maxRedJTextField = new _root_.javax.swing.JTextField()
        this.maxGreenJTextField = new _root_.javax.swing.JTextField()
        this.minBlueJTextField = new _root_.javax.swing.JTextField()
        this.maxBlueJTextField = new _root_.javax.swing.JTextField()
        this.okJButton = new _root_.javax.swing.JButton()
        this.minGreenJTextField = new _root_.javax.swing.JTextField()
        this.colorAtActionJButton = new _root_.javax.swing.JButton()
        this.jLabel1 = new _root_.javax.swing.JLabel()
        this.colorAtActionJDialog.setMinimumSize(new _root_.java.awt.Dimension(350, 250))
        this.titleJLabel.setText("              Color At Action Options            ")
        this.locationJLabel.setText("Location:")
        this.xJLabel.setText("X:")
        this.yJLabel.setText("Y:")
        this.colorRangeJLabel.setText("Color Range")
        this.redJLabel.setText("Red:")
        this.minJLabel.setText("Minimum")
        this.maxJLabel.setText("Maximum")
        this.greenJLabel.setText("Green:")
        this.blueJLabel.setText("Blue:")
        this.okJButton.setText("OK")
        this.okJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    okJButtonActionPerformed(evt)
                }

            })
        var colorAtActionJDialogLayout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this.colorAtActionJDialog.getContentPane())
        this.colorAtActionJDialog.getContentPane().setLayout(colorAtActionJDialogLayout)
        colorAtActionJDialogLayout.setHorizontalGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addContainerGap().addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(okJButton).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(blueJLabel).addComponent(greenJLabel).addComponent(redJLabel).addComponent(colorRangeJLabel)).addGap(29, 29, 29)).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, colorAtActionJDialogLayout.createSequentialGroup().addComponent(locationJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(xJLabel).addGap(18, 18, 18))).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addComponent(minBlueJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 40, _root_.java.lang.Short.MAX_VALUE).addComponent(minGreenJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 40, _root_.java.lang.Short.MAX_VALUE).addComponent(minJLabel, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addComponent(minRedJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 40, _root_.java.lang.Short.MAX_VALUE).addComponent(colorAtXJTextField, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 40, _root_.java.lang.Short.MAX_VALUE)).addGap(16, 16, 16))).addGap(6, 6, 6).addComponent(yJLabel).addGap(24, 24, 24).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(maxJLabel, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.java.lang.Short.MAX_VALUE).addGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, colorAtActionJDialogLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(maxBlueJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING).addComponent(maxRedJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 43, _root_.java.lang.Short.MAX_VALUE).addComponent(maxGreenJTextField, _root_.javax.swing.GroupLayout.Alignment.TRAILING, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, 43, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addComponent(colorAtYJTextField, _root_.javax.swing.GroupLayout.Alignment.LEADING, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, 44, _root_.java.lang.Short.MAX_VALUE)).addGap(22, 22, 22)).addGroup(_root_.javax.swing.GroupLayout.Alignment.TRAILING, colorAtActionJDialogLayout.createSequentialGroup().addComponent(titleJLabel).addGap(33, 33, 33)))))
        colorAtActionJDialogLayout.setVerticalGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addContainerGap().addComponent(titleJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(xJLabel).addComponent(locationJLabel).addComponent(colorAtXJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(yJLabel)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(minJLabel).addComponent(colorRangeJLabel)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(minRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(redJLabel)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(greenJLabel).addComponent(minGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(colorAtActionJDialogLayout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(blueJLabel).addComponent(minBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, _root_.java.lang.Short.MAX_VALUE).addComponent(okJButton)).addGroup(colorAtActionJDialogLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(colorAtYJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(maxJLabel).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(maxRedJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(maxGreenJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(maxBlueJTextField, _root_.javax.swing.GroupLayout.PREFERRED_SIZE, _root_.javax.swing.GroupLayout.DEFAULT_SIZE, _root_.javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()))
        setPreferredSize(new _root_.java.awt.Dimension(100, 0))
        this.colorAtActionJButton.setText("Edit")
        this.colorAtActionJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    colorAtActionJButtonActionPerformed(evt)
                }

            })
        this.jLabel1.setText("Color At:")
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(_root_.javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, _root_.java.lang.Short.MAX_VALUE).addComponent(colorAtActionJButton)))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(colorAtActionJButton)))
    }

    // </editor-fold>//GEN-END:initComponents
    private def okJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.update()
        this.getColorAtActionJDialog().setVisible(false)
    }

    //GEN-LAST:event_okJButtonActionPerformed
    private def colorAtActionJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        // TODO add your handling code here:
        this.getColorAtActionJDialog().setVisible(true)
    }

}


