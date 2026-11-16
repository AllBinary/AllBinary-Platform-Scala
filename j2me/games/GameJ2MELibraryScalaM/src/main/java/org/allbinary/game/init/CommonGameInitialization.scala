/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.init

import _root_.javax.microedition.lcdui.CommandListener
import _root_.org.allbinary.game.resource.ResourceInitialization
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.math.AngleFactory
import _root_.org.allbinary.string.CommonStrings

class CommonGameInitialization(param_resourceInitializationArray : Array[ResourceInitialization], param_portion : Int) extends BaseGameInitialization(param_resourceInitializationArray, param_portion) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //Constructor
    {
        val resourceInitializationArray : Array[ResourceInitialization] = param_resourceInitializationArray
        val portion : Int = param_portion
    }

    override def init(abeClientInformation : AbeClientInformationInterface, commandListener : CommandListener, level : Int) : Unit = {
        super.init(abeClientInformation, commandListener, level)
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (!this.isGameInitialized() && (level == resourceLoadingLevelFactory.LOAD_ALL.getLevel())) {
            //PreLogUtil.put("Game Init", this, this.commonStrings.INIT);
            this.setGameInitialized(true)
            val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
            SmallIntegerSingletonFactory.getInstance().init()
            progressCanvas.addNormalPortion(50, "Integers")
            PointFactory.getInstance().init()
            progressCanvas.addNormalPortion(50, "Points")
            AngleFactory.getInstance()
            progressCanvas.addNormalPortion(50, "Angles")
            this.initGame()
            this.resourceInitializationArray(this.GAME_RESOURCES).init()
        }
        super.resourceInitialization(level)
    }

    def initGame() : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

}


