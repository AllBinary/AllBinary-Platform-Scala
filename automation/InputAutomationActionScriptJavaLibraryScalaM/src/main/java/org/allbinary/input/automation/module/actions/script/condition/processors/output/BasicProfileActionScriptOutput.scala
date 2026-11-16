/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.org.allbinary.input.automation.actions.script.condition.processors.BasicProfileActionScriptProcessor
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicProfileActionScriptOutput private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptProcessor(super_1, super_2) with ProfileActionScriptOutputInterface {

    def this(label : String, node : Node) = {
        this(label, node, ())
    }

    def this(label : String) = {
        this(label, null, ())
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfileActionScriptOutputData.NAME)
        return node
    }

}


