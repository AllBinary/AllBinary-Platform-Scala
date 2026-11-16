/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.util.HashtableUtil
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.util.ABHashtable

class KeyPressesAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    private var on : Boolean = true

    var keys : Array[Integer] = null

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.keys = new Array[Integer](hashtable.size())
        var objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(hashtable)
        var size : Int = objectArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.keys(index) = hashtable.get(objectArray(index).asInstanceOf[Object]).asInstanceOf[Integer]
                index += 1
            }
        }
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.on) {
            //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS);

            {
                var index : Int = 0
                while (index < this.keys.length) {
                    super.processKeyAI(this.keys(index).intValue())
                    index += 1
                }
            }
        }
    }

    def toggle() : Unit = {
        if (this.isOn()) {
            this.setOn(false)
        } else {
            this.setOn(true)
        }
    }

    def disable() : Unit = {
        this.setOn(false)
    }

    def enable() : Unit = {
        this.setOn(true)
    }

    private def setOn(on : Boolean) : Unit = {
        this.on = on
    }

    def isOn() : Boolean = {
        return this.on
    }

}


