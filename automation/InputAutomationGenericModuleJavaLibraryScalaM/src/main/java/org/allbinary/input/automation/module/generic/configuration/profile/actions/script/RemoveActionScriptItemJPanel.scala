/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile.actions.script

import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionInterface
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileAction
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActionJPanel
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author  USER  */
class RemoveActionScriptItemJPanel(param_genericProfileActionJPanel : GenericProfileActionJPanel, param_profileActionScriptConditionInterface : ProfileActionScriptConditionInterface) extends _root_.java.awt.Panel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var genericProfileActionJPanel : GenericProfileActionJPanel = null

    private var profileActionScriptConditionInterface : ProfileActionScriptConditionInterface = null

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private var removeJButton : _root_.javax.swing.JButton = null

    /** Creates new form RemoveActionScriptItemJPanel */
    //Constructor
    {
        val genericProfileActionJPanel : GenericProfileActionJPanel = param_genericProfileActionJPanel
        val profileActionScriptConditionInterface : ProfileActionScriptConditionInterface = param_profileActionScriptConditionInterface
        this.initComponents()
        this.genericProfileActionJPanel = genericProfileActionJPanel
        this.profileActionScriptConditionInterface = profileActionScriptConditionInterface
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        this.removeJButton = new _root_.javax.swing.JButton()
        setLayout(new _root_.java.awt.GridLayout())
        this.removeJButton.setText("Remove")
        this.removeJButton.addActionListener(new _root_.java.awt.event.ActionListener {
                override def actionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
                    removeJButtonActionPerformed(evt)
                }

            })
        add(this.removeJButton)
    }

    // </editor-fold>//GEN-END:initComponents
    private def removeJButtonActionPerformed(evt : _root_.java.awt.event.ActionEvent) : Unit = {
        //GEN-HEADEREND:event_removeJButtonActionPerformed
        val genericProfileAction : GenericProfileAction = this.genericProfileActionJPanel.getGenericProfileAction()
        if (genericProfileAction == null) {
            this.logUtil.putF("GenericProfileAction was null", this, "removeJButtonActionPerformed")
            return
        }
        genericProfileAction.getGenericProfileActionScript().removeCondition(this.profileActionScriptConditionInterface)
        this.genericProfileActionJPanel.updateProfileActionUI()
    }

}


