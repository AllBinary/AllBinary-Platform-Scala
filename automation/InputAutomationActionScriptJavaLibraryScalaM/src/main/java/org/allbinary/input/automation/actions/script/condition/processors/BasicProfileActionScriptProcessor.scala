/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors

import _root_.java.awt.event.ActionEvent
import _root_.org.allbinary.input.automation.actions.script.JTreeInterfaceFactory
import _root_.org.allbinary.input.automation.actions.script.ProfileActionScriptItem
import _root_.org.allbinary.input.automation.actions.script.condition.ProfileActionScriptConditionInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicProfileActionScriptProcessor private (super_1 : String, super_2 : Node, constructor_ : Unit) extends ProfileActionScriptItem(super_1, super_2) with ProfileActionScriptProcessorInterface {

    def this(label : String, node : Node) = {
        this(label, node, ())
    }

    def this(label : String) = {
        this(label, null, ())
    }

    override def actionPerformed(actionEvent : ActionEvent) : Unit = {
        super.actionPerformed(actionEvent)
        if (actionEvent.getActionCommand().compareTo(ProfileActionScriptItem.DELETE) == 0) {
            if (this.getParent().isInstanceOf[ProfileActionScriptConditionInterface]) {
                var profileActionScriptConditionInterface : ProfileActionScriptConditionInterface = this.getParent().asInstanceOf[ProfileActionScriptConditionInterface]
                profileActionScriptConditionInterface.removeProcessor(this.asInstanceOf[ProfileActionScriptProcessorInterface])
                JTreeInterfaceFactory.getInstance().getJTreeInterface().updateJTree()
            }
        }
    }

    //TWB - Fix to use Node Structure instead of nodes for each
    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfileActionScriptProcessorData.NAME)
        return node
    }

}


