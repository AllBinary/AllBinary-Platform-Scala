/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.util.Set
import _root_.javax.swing.*
import _root_.org.allbinary.input.automation.robot.InputRobotFactory

class InputAutomationTypeDefaultComboBoxModelFactory private() {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.InputAutomationTypeDefaultComboBoxModelFactory.{*}

}

object InputAutomationTypeDefaultComboBoxModelFactory {
    def getInstance() : DefaultComboBoxModel[Object] = {
        var defaultComboBoxModel : DefaultComboBoxModel[Object] = new DefaultComboBoxModel[Object]()
        var set : Set[Object] = InputRobotFactory.getInstance().get().keySet().asInstanceOf[Set[Object]]
        val nameArray : Array[Object] = set.toArray()
        val size : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size) {
                defaultComboBoxModel.addElement(nameArray(index).asInstanceOf[String])
                index += 1
            }
        }
        return defaultComboBoxModel
    }

}


