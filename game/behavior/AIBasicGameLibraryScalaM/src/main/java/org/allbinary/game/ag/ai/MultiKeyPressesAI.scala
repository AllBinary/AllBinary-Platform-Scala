/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai

import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.time.GameTickTimeDelayHelper
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

class MultiKeyPressesAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends KeyPressesAI(param_hashtable, param_ownerLayerInterface, param_gameInput) {

    private val toggleTimeHelper : TimeDelayHelper = new TimeDelayHelper(600)

    private val gameTickTimeDelayHelper : GameTickTimeDelayHelper = GameTickTimeDelayHelperFactory.getInstance()

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.update()
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
    }

    private def update() : Unit = {
        var gameInput : GameInput = this.getGameInput()
        val keys : Array[Integer] = this.keys
        val size : Int = keys.length
        if (this.isOn()) {

            {
                var index : Int = 0
                while (index < size) {
                    var key : Int = keys(index).intValue()
                    if (key != -1) {
                        gameInput.add(this.gameKeyEventFactory.getInstanceForKey(this, key))
                    }
                    index += 1
                }
            }
        } else {

            {
                var index : Int = 0
                while (index < size) {
                    var key : Int = keys(index).intValue()
                    if (key != -1) {
                        gameInput.addForRemoval(this.gameKeyEventFactory.getInstanceForKey(this, key))
                    }
                    index += 1
                }
            }
        }
    }

    override def toggle() : Unit = {
        if (this.toggleTimeHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            super.toggle()
            this.update()
        }
    }

    override def disable() : Unit = {
        if (this.toggleTimeHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            super.disable()
            this.update()
        }
    }

    override def enable() : Unit = {
        if (this.toggleTimeHelper.isTime(this.gameTickTimeDelayHelper.startTime)) {
            super.enable()
            this.update()
        }
    }

}


