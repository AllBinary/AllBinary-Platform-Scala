/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script

import _root_.java.awt.event.ActionEvent
import _root_.java.awt.event.ActionListener
import _root_.javax.swing.*
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Node

class ProfileActionScriptItem private (super_1 : String, constructor_ : Unit) extends DefaultMutableTreeNode(super_1) with ProfileActionScriptItemInterface with ActionListener {
    import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.{DELETE as _, NEW_CONDITION as _, NEW_INPUT as _, NEW_OUTPUT as _, NEW_COLOR_AT as _, NEW_TIME_INTERVAL as _, NEW_ALWAYS as _, NEW_KEY_INPUT as _, NEW_MOUSE_INPUT as _, NEW_JOYSTICK_INPUT as _, NEW_IMAGE_OUTPUT as _, *}
    def DELETE : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.DELETE
    def NEW_CONDITION : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_CONDITION
    def NEW_INPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_INPUT
    def NEW_OUTPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_OUTPUT
    def NEW_COLOR_AT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_COLOR_AT
    def NEW_TIME_INTERVAL : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_TIME_INTERVAL
    def NEW_ALWAYS : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_ALWAYS
    def NEW_KEY_INPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_KEY_INPUT
    def NEW_MOUSE_INPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_MOUSE_INPUT
    def NEW_JOYSTICK_INPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_JOYSTICK_INPUT
    def NEW_IMAGE_OUTPUT : String = _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem.NEW_IMAGE_OUTPUT

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var jPopupMenu : JPopupMenu = null

    def this(label : String, node : Node) = {
        this(label, ())
        this.init()
        this.logUtil.putF("Label: " + label, this, this.commonStrings.CONSTRUCTOR)
    }

    def this(label : String) = {
        this(label, ())
        this.init()
        this.logUtil.putF("Label: " + label, this, this.commonStrings.CONSTRUCTOR)
    }

    private def init() : Unit = {
        this.setJPopupMenu(new JPopupMenu())
        var jMenuItemEdit : JMenuItem = new JMenuItem(EDIT)
        var jMenuItemDelete : JMenuItem = new JMenuItem(DELETE)
        //jMenuItem.setAction(customAction);
        jMenuItemEdit.addActionListener(this)
        jMenuItemDelete.addActionListener(this)
        this.getJPopupMenu().add(jMenuItemEdit)
        this.getJPopupMenu().add(jMenuItemDelete)
    }

    def process(frame : _root_.java.lang.Long) : Unit = {
        throw new RuntimeException()
    }

    def getJPopupMenu() : JPopupMenu = {
        return this.jPopupMenu
    }

    def showDialog() : Unit = {
        throw new RuntimeException()
    }

    def actionPerformed(actionEvent : ActionEvent) : Unit = {
        if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.EDIT) == 0) {
            this.showDialog()
        }
    }

    def setJPopupMenu(jPopupMenu : JPopupMenu) : Unit = {
        this.jPopupMenu = jPopupMenu
    }

}

object ProfileActionScriptItem {
    private val EDIT : String = "Edit"

    val DELETE : String = "Delete"

    val NEW_CONDITION : String = "New Condition"

    val NEW_INPUT : String = "New Input"

    val NEW_OUTPUT : String = "New Output"

    val NEW_COLOR_AT : String = "Color At"

    val NEW_TIME_INTERVAL : String = "Time Interval"

    val NEW_ALWAYS : String = "Always On/Off"

    val NEW_KEY_INPUT : String = "Key"

    val NEW_MOUSE_INPUT : String = "Mouse"

    val NEW_JOYSTICK_INPUT : String = "Joystick"

    val NEW_IMAGE_OUTPUT : String = "Image"

}


