/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input

import _root_.javax.swing.*
import _root_.abbot.tester.KeyStrokeMap
import _root_.org.allbinary.input.KeySingletonFactory

class KeyCharDefaultComboBoxModelFactory private() {
    import _root_.org.allbinary.input.automation.actions.script.condition.processors.input.KeyCharDefaultComboBoxModelFactory.{*}

}

object KeyCharDefaultComboBoxModelFactory {
    def getInstance() : DefaultComboBoxModel[Object] = {
        var defaultComboBoxModel : DefaultComboBoxModel[Object] = new DefaultComboBoxModel[Object]()
        var keyArray : Array[Integer] = KeySingletonFactory.getArray()

        {
            var index : Int = 0
            while (index < keyArray.length) {
                var nextKey : Integer = keyArray(index)
                var keyStroke : KeyStroke = KeyStroke.getKeyStroke(nextKey.intValue(), 0)
                var keyChar : Char = KeyStrokeMap.getChar(keyStroke)
                //this.logUtil.putF("Key: " + nextKey + " = " + keyChar, //    "KeyCharDefaultComboBoxModelFactory", commonStrings.GET_INSTANCE);
                defaultComboBoxModel.addElement(Character.toString(keyChar))
                index += 1
            }
        }
        return defaultComboBoxModel
    }

}


