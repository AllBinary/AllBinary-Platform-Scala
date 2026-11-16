/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.tactical

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.ag.ai.InputProbability
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.time.GameTickTimeDelayHelperFactory

class BasicRandomAI(param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput, param_inputProbability : InputProbability, param_visitor : Visitor) extends BasicAI(param_ownerLayerInterface, param_gameInput) {

    private var i_random : Int = 0

    private var inputProbability : InputProbability = null

    private var visitor : Visitor = null

    private val keyArray : Array[Int] = Array[Int](Canvas.UP, Canvas.DOWN, Canvas.LEFT, Canvas.RIGHT, Canvas.KEY_NUM1, Canvas.KEY_NUM7, Canvas.KEY_NUM9)

    private val myRandomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    //Constructor
    {
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        val inputProbability : InputProbability = param_inputProbability
        val visitor : Visitor = param_visitor
        this.inputProbability = inputProbability
        this.visitor = visitor
    }

    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        if (this.inputProbability.getTimeDelayHelper().isTime(GameTickTimeDelayHelperFactory.getInstance().startTime)) {
            this.i_random = this.myRandomFactory.getAbsoluteNextInt(this.inputProbability.getMax())
            var repeat : Boolean = false
            var repeatLikelyhoodIntegerArray : Array[Integer] = this.inputProbability.getRepeatLikelyhoodIntegerArray()
            if ((this.getLastKey() != -1) && (repeatLikelyhoodIntegerArray(this.getLastKey()).intValue() >= this.i_random)) {
                repeat = true
            }
            if (!repeat) {
                var likelyhoodIntegerArray : Array[Array[Integer]] = this.inputProbability.getLikelyhoodIntegerArray()
                this.i_random = this.myRandomFactory.getAbsoluteNextInt(this.inputProbability.getMax())
                var size : Int = this.keyArray.length
                var likelyhoodIntegerKeyArray : Array[Integer] = null

                {
                    var index : Int = 0
                    scala.util.boundary { (break_N71075 : scala.util.boundary.Label[Unit]) ?=>
                        while (index < size) {
                            var key : Int = this.keyArray(index)
                            likelyhoodIntegerKeyArray = likelyhoodIntegerArray(key)
                            if ((likelyhoodIntegerArray.length >= key) && (likelyhoodIntegerKeyArray(0) != null)) {
                                if ((this.i_random >= likelyhoodIntegerKeyArray(0).intValue()) && (this.i_random < likelyhoodIntegerKeyArray(1).intValue())) {
                                    this.setLastKey(key)
                                    scala.util.boundary.break()(using break_N71075)
                                }
                            }
                            index += 1
                        }
                    }
                }
            }
            this.visitor.visit(this)
        }
    }

}


