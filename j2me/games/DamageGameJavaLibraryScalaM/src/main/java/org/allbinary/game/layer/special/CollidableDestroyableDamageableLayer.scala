/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.special

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.collision.CollidableNeverCollideBehaviorFactory
import _root_.org.allbinary.game.combat.damage.DamageableInterface
import _root_.org.allbinary.game.combat.destroy.DestroyableInterface
import _root_.org.allbinary.game.combat.destroy.event.DestroyedEvent
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.input.event.GameKeyEvent
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.CollidableCompositeLayer
import _root_.org.allbinary.game.layer.pickup.PickedUpLayerInterfaceFactoryInterface
import _root_.org.allbinary.game.layer.pickup.PickupBehavior
import _root_.org.allbinary.game.layer.pickup.PickupCompositeInterface
import _root_.org.allbinary.game.part.PartInterface
import _root_.org.allbinary.game.part.PartInterfaceUtil
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.view.ViewPositionBase

/*  * The Game Layers/Objects requirements change a bunch from game to game.  * As such Game Layers/Objects are very complex in nature.  * As a result it is best to create a game specific composite game layer for a specific game.  * Although, I have 3 classes that break this rule because I have not thought of composites that fit yet.  * The 3 classes are MultiPlayerGameLayer -> CollidableDestroyableDamageableLayer -> CollidableCompositeLayer.  * In the future these 3 classes should probably go away and be pushed into game Layer/Object composites/properties.  * I will probably always have one magical game class for new features that don't fit into a composite yet regardless.  * For now just think of the 3 classes (MultiPlayerGameLayer -> CollidableDestroyableDamageableLayer -> CollidableCompositeLayer)  * as SpecialGameLayer or MagicalGameLayer.  */
class CollidableDestroyableDamageableLayer(param_groupInterface : Array[Group], param_name : String, param_layerInfo : Rectangle, param_viewPosition : ViewPositionBase) extends CollidableCompositeLayer(param_name, param_layerInfo, param_viewPosition, CollidableNeverCollideBehaviorFactory.getInstance()) with DestroyableInterface with DamageableInterface with PickupCompositeInterface with SpecialGameInputInterface {
    import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer.{*}

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var groupInterface : Array[Group] = null

    private var readyForExplosion : Boolean = false

    private var initWidth : Int = 0

    private var initHeight : Int = 0

    private var initX : Int = 0

    private var initY : Int = 0

    private var initZ : Int = 0

    var partInterfaceArrayP : Array[PartInterface] = PartInterfaceUtil.getZeroArray()

    private var pickupBehavior : PickupBehavior = null

    var allBinaryGameLayerManagerP : AllBinaryGameLayerManager = AllBinaryGameLayerManager.getNullInstance()

    var isDraggable : Boolean = false

    var isDragged : Boolean = false

    var isDropped : Boolean = false

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val name : String = param_name
        val layerInfo : Rectangle = param_layerInfo
        val viewPosition : ViewPositionBase = param_viewPosition
        this.initWidth = layerInfo.getWidth()
        this.initHeight = layerInfo.getHeight()
        this.groupInterface = groupInterface
        this.pickupBehavior = PickupBehavior.getNullInstance()
    }

    def initPosition() : Unit = {
        this.setPosition(this.initX, this.initY, this.initZ)
    }

    def initPositionXYZ(x : Int, y : Int, z : Int) : Unit = {
        this.initX = x
        this.initY = y
        this.initZ = z
    }

    //Should be overridden
    override def paint(graphics : Graphics) : Unit = {
        //this.logUtil.putF(this.commonStrings.NOT_IMPLEMENTED, this, canvasStrings.PAINT);
        super.paint(graphics)
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def getDamage(damageType : Int) : Int = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    override def isDestroyed() : Boolean = {
        throw new Exception(this.commonStrings.NOT_IMPLEMENTED)
    }

    /*     private void setDestroyed(boolean destroyed)      throws Exception     {         throw new Exception(this.commonStrings.NOT_IMPLEMENTED);     }     */
    override def getGroupInterface() : Array[Group] = {
        return this.groupInterface
    }

    def setGroupInterface(teamInterface : Array[Group]) : Unit = {
        this.groupInterface = teamInterface
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        this.allBinaryGameLayerManagerP = allBinaryGameLayerManager
        //this.logUtil.putF(new StringMaker().append(commonStrings.START).append(this.getName()).append(CommonSeps.getInstance().SPACE).append(allBinaryGameLayerManager).toString(), this, this.commonStrings.PROCESS);
        if (this.allBinaryGameLayerManagerP == null) {
            throw new RuntimeException()
        }
    }

    final def isReadyForExplosion() : Boolean = {
        return this.readyForExplosion
    }

    final def setReadyForExplosion(isReadyForExplosion : Boolean) : Unit = {
        this.readyForExplosion = isReadyForExplosion
    }

    def getInitWidth() : Int = {
        return this.initWidth
    }

    def getInitHeight() : Int = {
        return this.initHeight
    }

    def getInitX() : Int = {
        return this.initX
    }

    def getInitY() : Int = {
        return this.initY
    }

    override def up() : Unit = {
    }

    override def down() : Unit = {
    }

    override def right() : Unit = {
    }

    override def left() : Unit = {
    }

    override def strafeLeft() : Unit = {
    }

    override def strafeRight() : Unit = {
    }

    override def fire(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    override def special1(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    override def special2(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    override def special3(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    override def special4(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    override def special5(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent) : Unit = {
    }

    def upAnalog(yAnalogValue : Int) : Unit = {
    }

    def downAnalog(yAnalogValue : Int) : Unit = {
    }

    def rightAnalog(xAnalogValue : Int) : Unit = {
    }

    def leftAnalog(xAnalogValue : Int) : Unit = {
    }

    def rightTrigger(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent, xAnalogValue : Int) : Unit = {
    }

    def leftTrigger(layerManager : AllBinaryLayerManager, gameKeyEvent : GameKeyEvent, xAnalogValue : Int) : Unit = {
    }

    /*     //For optimized handler but currently not enables until I decide on depencies     public void onMovement(TrackingEvent trackingEvent)     {     }     */
    def onDestroyed(destroyedEvent : DestroyedEvent) : Unit = {
    }

    override def getPickupBehavior() : PickupBehavior = {
        return this.pickupBehavior
    }

    override def setPickupBehavior(pickupBehavior : PickupBehavior) : Unit = {
        this.pickupBehavior = pickupBehavior
    }

    def addPart(pickedUpLayerInterfaceFactoryInterface : PickedUpLayerInterfaceFactoryInterface) : Unit = {
    }

    def setPartInterfaceArray(partInterfaceArray : Array[PartInterface]) : Unit = {
        this.partInterfaceArrayP = partInterfaceArray
    }

    def getPartInterfaceArray() : Array[PartInterface] = {
        return this.partInterfaceArrayP
    }

    override def toStringAppend(stringBuffer : StringMaker) : Unit = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val positionStrings : PositionStrings = PositionStrings.getInstance()
        super.toStringAppend(stringBuffer)
        stringBuffer.append(commonSeps.NEW_LINE)
        val groupInterfaceArray : Array[Group] = this.getGroupInterface()
        val size : Int = groupInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                stringBuffer.append(groupInterfaceArray(index).toString())
                stringBuffer.append(commonSeps.COMMA)
                index += 1
            }
        }
        val pickupBehavior : PickupBehavior = this.getPickupBehavior()
        if (pickupBehavior != null) {
            stringBuffer.append(commonSeps.NEW_LINE)
            stringBuffer.append(pickupBehavior.toString())
        }
        /*         if (this.getPartInterfaceArray() != null)         {             stringBuffer.append(commonSeps.NEW_LINE);             int total = this.getPartInterfaceArray().length;             stringBuffer.append(total);             stringBuffer.append(commonSeps.SPACE);             stringBuffer.append(PARTS_LABEL);              for (int index = 0; index < total; index++)             {                 stringBuffer.append(this.getPartInterfaceArray()[index].toString());             }         }         */
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(CollidableDestroyableDamageableLayer.READYFOREXPLOSION)
        stringBuffer.appendboolean(this.readyForExplosion)
        stringBuffer.append(commonSeps.NEW_LINE)
        stringBuffer.append(this.commonStrings.INIT)
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(positionStrings.X_LABEL)
        stringBuffer.appendint(this.initX)
        stringBuffer.append(positionStrings.Y_LABEL)
        stringBuffer.appendint(this.initX)
        stringBuffer.append(positionStrings.Z_LABEL)
        stringBuffer.appendint(this.initZ)
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        this.toStringAppend(stringBuffer)
        return stringBuffer.toString()
    }

}

object CollidableDestroyableDamageableLayer {
    private var NULL_COLLIDABLE_DESTROYABLE_DAMAGE_LAYER : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : CollidableDestroyableDamageableLayer = {
        if (CollidableDestroyableDamageableLayer.NULL_COLLIDABLE_DESTROYABLE_DAMAGE_LAYER eq NullUtil.getInstance().NULL_OBJECT) {
            CollidableDestroyableDamageableLayer.NULL_COLLIDABLE_DESTROYABLE_DAMAGE_LAYER = new CollidableDestroyableDamageableLayer(BasicGroupFactory.getInstance().NONE_ARRAY, StringUtil.getInstance().EMPTY_STRING, RectangleFactory.SINGLETON, ViewPositionBase.NULL_VIEW_POSITION)
        }
        return CollidableDestroyableDamageableLayer.NULL_COLLIDABLE_DESTROYABLE_DAMAGE_LAYER.asInstanceOf[CollidableDestroyableDamageableLayer]
    }

    //private static final String PARTS_LABEL = "Parts: ";
    private val READYFOREXPLOSION : String = "ReadyForExplosion: "

}


