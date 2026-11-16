/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.ai.ArtificialIntelligence
import _root_.org.allbinary.ai.ArtificialIntelligenceInterface
import _root_.org.allbinary.game.collision.CollidableBaseBehavior
import _root_.org.allbinary.game.collision.CollidableBaseBehaviorFactory
import _root_.org.allbinary.game.collision.CollidableInterfaceCompositeInterface
import _root_.org.allbinary.game.collision.CollidableNeverCollideBehaviorFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.view.ViewPositionBase
import _root_.org.allbinary.logic.NullUtil

/*  * The Game Layers/Objects requirements change a bunch from game to game.  * As such Game Layers/Objects are very complex in nature.  * As a result it is best to create a game specific composite game layer for a specific game.  * Although, I have 3 classes that break this rule because I have not thought of composites that fit yet.  * The 3 classes are MultiPlayerGameLayer -> CollidableDestroyableDamageableLayer -> CollidableCompositeLayer.  * In the future these 3 classes should probably go away and be pushed into game Layer/Object composites/properties.  * I will probably always have one magical game class for new features that don't fit into a composite yet regardless.  * For now just think of the 3 classes (MultiPlayerGameLayer -> CollidableDestroyableDamageableLayer -> CollidableCompositeLayer)  * as SpecialGameLayer or MagicalGameLayer.  */
class CollidableCompositeLayer(param_name : String, param_layerInfo : Rectangle, param_viewPosition : ViewPositionBase, param_collidableBaseBehaviorFactory : CollidableBaseBehaviorFactory) extends AllBinaryGameLayer(param_name, param_layerInfo, param_viewPosition) with CollidableInterfaceCompositeInterface {
    import _root_.org.allbinary.game.layer.CollidableCompositeLayer.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var collidableInferface : CollidableBaseBehavior = CollidableNeverCollideBehaviorFactory.getInstance().createBehavior()

    //Constructor
    {
        val name : String = param_name
        val layerInfo : Rectangle = param_layerInfo
        val viewPosition : ViewPositionBase = param_viewPosition
        val collidableBaseBehaviorFactory : CollidableBaseBehaviorFactory = param_collidableBaseBehaviorFactory
        if (collidableBaseBehaviorFactory ne CollidableNeverCollideBehaviorFactory.getInstance()) {
            this.setCollidableInferface(collidableBaseBehaviorFactory.createBehavior())
        }
    }

    def getArtificialIntelligenceInterface() : ArtificialIntelligenceInterface = {
        ForcedLogUtil.log(this.commonStrings.NOT_IMPLEMENTED, this)
        return ArtificialIntelligence.getInstance()
    }

    override def getCollidableInferface() : CollidableBaseBehavior = {
        return this.collidableInferface
    }

    def setCollidableInferface(collidableInferface : CollidableBaseBehavior) : Unit = {
        this.collidableInferface = collidableInferface
    }

    override def implmentsCollidableInterface() : Boolean = {
        return true
    }

    override def toStringAppend(stringBuffer : StringMaker) : Unit = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        super.toStringAppend(stringBuffer)
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.getCollidableInferface().toString())
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        this.toStringAppend(stringBuffer)
        return stringBuffer.toString()
    }

}

object CollidableCompositeLayer {
    private var NULL_COLLIDABLE_COMPOSITE_LAYER : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : CollidableCompositeLayer = {
        if (CollidableCompositeLayer.NULL_COLLIDABLE_COMPOSITE_LAYER eq NullUtil.getInstance().NULL_OBJECT) {
            CollidableCompositeLayer.NULL_COLLIDABLE_COMPOSITE_LAYER = new CollidableCompositeLayer(StringUtil.getInstance().EMPTY_STRING, RectangleFactory.SINGLETON, ViewPositionBase.NULL_VIEW_POSITION, CollidableNeverCollideBehaviorFactory.getInstance())
        }
        return CollidableCompositeLayer.NULL_COLLIDABLE_COMPOSITE_LAYER.asInstanceOf[CollidableCompositeLayer]
    }

}


