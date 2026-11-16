/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.ai.scroller

import _root_.javax.microedition.lcdui.Canvas
import _root_.org.allbinary.game.ai.BasicAI
import _root_.org.allbinary.game.input.GameInput
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.media.audio.PlayerQueue
import _root_.org.allbinary.media.audio.SecondaryPlayerQueueFactory
import _root_.org.allbinary.media.audio.Sound
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.ABHashtable

class HorizontalScreenPatrolAI(param_hashtable : ABHashtable[Object, Object], param_ownerLayerInterface : AllBinaryLayer, param_gameInput : GameInput) extends BasicAI(param_ownerLayerInterface, param_gameInput) {
    import _root_.org.allbinary.game.ag.ai.scroller.HorizontalScreenPatrolAI.{SOUND as _, *}
    def SOUND : Integer = _root_.org.allbinary.game.ag.ai.scroller.HorizontalScreenPatrolAI.SOUND

    //private boolean changedDirection = true;
    var keyDirection : Int = Canvas.LEFT

    private val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private var firingX : Int = this.displayInfoSingleton.getLastHalfWidth()

    private var firedIndex : Int = 0

    private val MAX_FIRE : Int = 28

    private val timeDelayHelper : TimeDelayHelper = new TimeDelayHelper(240)

    private val secondaryPlayerQueue : PlayerQueue = SecondaryPlayerQueueFactory.getInstance()

    private var sound : Sound = null

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val ownerLayerInterface : AllBinaryLayer = param_ownerLayerInterface
        val gameInput : GameInput = param_gameInput
        this.sound = hashtable.get(HorizontalScreenPatrolAI.SOUND).asInstanceOf[Sound]
        //SleighBells4Sound.getInstance()
        if (this.sound == null) {
            throw new Exception("No Sound Provided!!")
        }
    }

    //Current go left always and fire when towards the middle
    override def processAI(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.PROCESS);
        super.processKeyAI(this.keyDirection)
        if (this.timeDelayHelper.isTimeTNT()) {
            var layerInterface : AllBinaryLayer = this.getOwnerLayerInterface()
            var currentOwnerLayerX : Int = layerInterface.getXP()
            // }
            if (currentOwnerLayerX < -layerInterface.getWidth()) {
                var y : Int = MyRandomFactory.getInstance().getAbsoluteNextIntAllowZero(50)
                // PreLogUtil.put(PositionStrings.getInstance().Y_LABEL + y, this, this.commonStrings.PROCESS);
                layerInterface.setPosition((this.displayInfoSingleton.getLastWidth() + layerInterface.getWidth()) + 50, y, layerInterface.getZP())
                this.firedIndex = 0
                this.firingX = this.displayInfoSingleton.getLastHalfWidth() + MyRandomFactory.getInstance().getNextInt(this.displayInfoSingleton.getLastHalfWidth())
                this.secondaryPlayerQueue.add(this.sound)
            }
            if ((currentOwnerLayerX < this.firingX) && (currentOwnerLayerX > -layerInterface.getWidth())) {
                // PreLogUtil.put("Fire: " + currentOwnerLayerX +"<" + this.firingX + " index: " + this.firedIndex, this, this.commonStrings.PROCESS);
                super.processKeyAI(Canvas.KEY_NUM1)
                // this.changedDirection = false;
                val gameLayerManager : AllBinaryGameLayerManager = allBinaryLayerManager.asInstanceOf[AllBinaryGameLayerManager]
                var FIRE : Int = (gameLayerManager.getGameInfo().getCurrentLevel() + 12) >> 2
                if (FIRE > this.MAX_FIRE) {
                    FIRE = this.MAX_FIRE
                }
                if (this.firedIndex > FIRE) {
                    this.firedIndex = 0
                    this.firingX = Integer.MIN_VALUE
                }
                this.firedIndex += 1
            }
        }
    }

    def nextDirection() : Unit = {
    }

}

object HorizontalScreenPatrolAI {
    val SOUND : Integer = SmallIntegerSingletonFactory.getInstance().getAt(433)

}


