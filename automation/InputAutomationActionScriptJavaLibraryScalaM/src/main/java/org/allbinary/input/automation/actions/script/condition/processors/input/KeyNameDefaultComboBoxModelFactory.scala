/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.java.awt.event.KeyEvent
import _root_.javax.swing.*
import _root_.org.allbinary.input.KeySingletonFactory

class KeyNameDefaultComboBoxModelFactory private() {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyNameDefaultComboBoxModelFactory.{*}

}

object KeyNameDefaultComboBoxModelFactory {
    def getInstance() : DefaultComboBoxModel[Object] = {
        var defaultComboBoxModel : DefaultComboBoxModel[Object] = new DefaultComboBoxModel[Object]()
        var keyArray : Array[Integer] = KeySingletonFactory.getArray()

        {
            var index : Int = 0
            while (index < keyArray.length) {
                var keyAsString : String = KeyEvent.getKeyText(keyArray(index))
                defaultComboBoxModel.addElement(keyAsString)
                index += 1
            }
        }
        return defaultComboBoxModel
    }

}


