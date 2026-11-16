/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.input.GameInputProcessor

class AnalogInputBuilder {
    import _root_.org.allbinary.game.layer.special.AnalogInputBuilder.{*}

    def disable(inputProcessorArray : Array[GameInputProcessor], collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer) : Unit = {
        //Stick
        inputProcessorArray(Canvas.UP) = new SpecialUpGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.DOWN) = new SpecialDownGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.RIGHT) = new SpecialRightGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.LEFT) = new SpecialLeftGameInputProcessor(collidableDestroyableDamageableLayer)
        //Triggers
        inputProcessorArray(Canvas.KEY_NUM0) = new Special1GameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.KEY_NUM5) = new Special3GameInputProcessor(collidableDestroyableDamageableLayer)
    }

    def enable(inputProcessorArray : Array[GameInputProcessor], collidableDestroyableDamageableLayer : CollidableDestroyableDamageableLayer) : Unit = {
        inputProcessorArray(Canvas.UP) = new SpecialAnalogUpGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.DOWN) = new SpecialAnalogDownGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.RIGHT) = new SpecialAnalogRightGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.LEFT) = new SpecialAnalogLeftGameInputProcessor(collidableDestroyableDamageableLayer)
        //Triggers
        inputProcessorArray(Canvas.KEY_NUM0) = new SpecialAnalogLeftTriggerGameInputProcessor(collidableDestroyableDamageableLayer)
        inputProcessorArray(Canvas.KEY_NUM5) = new SpecialAnalogRightTriggerGameInputProcessor(collidableDestroyableDamageableLayer)
    }

}

object AnalogInputBuilder {
    private val instance : AnalogInputBuilder = new AnalogInputBuilder()

    /**      * @return the instance      */
    def getInstance() : AnalogInputBuilder = {
        return AnalogInputBuilder.instance
    }

}


