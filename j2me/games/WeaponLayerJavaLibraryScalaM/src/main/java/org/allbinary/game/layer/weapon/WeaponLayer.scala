/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.animation.IndexedAnimation
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.collision.CollidableBaseBehavior
import _root_.org.allbinary.game.combat.destroy.DestroyedLayerProcessor
import _root_.org.allbinary.game.combat.weapon.WeaponProperties
import _root_.org.allbinary.game.configuration.GameConfigurationUtil
import _root_.org.allbinary.game.identification.BasicGroupFactory
import _root_.org.allbinary.game.multiplayer.layer.MultiPlayerGameLayer
import _root_.org.allbinary.game.multiplayer.layer.RemoteInfo
import _root_.org.allbinary.game.score.NoScoreable
import _root_.org.allbinary.game.score.ScoreableInterface
import _root_.org.allbinary.game.tick.TickableInterface
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.physics.movement.Movement
import _root_.org.allbinary.view.ViewPosition
import _root_.org.allbinary.view.ViewPositionBase

class WeaponLayer(param_name : String, param_remoteInfo : RemoteInfo, param_multiPlayerType : Int, param_movement : Movement, param_animationInterface : Animation, param_destroyedAnimationInterface : Animation, param_rectangle : Rectangle, param_viewPosition : ViewPositionBase) extends MultiPlayerGameLayer(param_remoteInfo, BasicGroupFactory.getInstance().NONE_ARRAY, param_name, param_rectangle, param_viewPosition) with TickableInterface {
    import _root_.org.allbinary.game.layer.weapon.WeaponLayer.{*}

    // private static final int MIN = 200;
    private var animationInterface : Animation = NullAnimationFactory.getFactoryInstance().getInstance(0)

    var initAnimationInterface : Animation = null

    private var destroyedAnimationInterface : Animation = null

    private var sourceLayerInterface : AllBinaryLayer = AllBinaryLayer.NULL_ALLBINARY_LAYER

    // private int angle;
    var totalDamage : Int = 0

    private var initDamage : Int = 0

    private var destroyed : Boolean = true

    var scoreableInterface : ScoreableInterface = NoScoreable.getInstance()

    private var movement : Movement = null

    private var weaponProperties : WeaponProperties = WeaponProperties.NULL_WEAPON_PROPERTIES

    private var multiPlayerType : Int = 0

    private var collidableWeaponBehavior : CollidableWeaponBehavior = CollidableWeaponBehavior.getNullInstance()

    //    }
    //Constructor
    {
        val name : String = param_name
        val remoteInfo : RemoteInfo = param_remoteInfo
        val multiPlayerType : Int = param_multiPlayerType
        val movement : Movement = param_movement
        val animationInterface : Animation = param_animationInterface
        val destroyedAnimationInterface : Animation = param_destroyedAnimationInterface
        val rectangle : Rectangle = param_rectangle
        val viewPosition : ViewPositionBase = param_viewPosition
        // super(Group.NONE, rectangle, viewPosition, true);
        this.initAnimationInterface = animationInterface
        this.setAnimationInterface(animationInterface)
        this.destroyedAnimationInterface = destroyedAnimationInterface
        this.movement = movement
        this.multiPlayerType = multiPlayerType
    }

    override def setCollidableInferface(collidableInferface : CollidableBaseBehavior) : Unit = {
        super.setCollidableInferface(collidableInferface)
        this.collidableWeaponBehavior = this.getCollidableInferface().asInstanceOf[CollidableWeaponBehavior]
    }

    def initXYZ(x : Int, y : Int, z : Int) : Unit = {
        this.x = x
        this.y = y
        this.z = z
    }

    def init(sourceLayerInterface : AllBinaryLayer, angle : Int, otherAngle : Int, weaponProperties : WeaponProperties, scoreable : ScoreableInterface) : Unit = {
        /*         if (weaponProperties.getDamage() < MIN)         {            throw new Exception("Initializing below minimum damage of: " + MIN);         }          if(weaponProperties.getDamage() > MAX)         {             throw new Exception("Initializing above max damage with: " + weaponProperties.getDamage());         }         */
        this.setWeaponPropertiesP(weaponProperties)
        this.setReadyForExplosion(false)
        this.setAnimationInterface(this.getInitAnimationInterfaceP())
        this.setOwnerLayerInterface(sourceLayerInterface)
        this.collidableWeaponBehavior.init(sourceLayerInterface)
        this.setGroupInterfaces()
        // this.angle = angle;
        if (scoreable != null) {
            this.scoreableInterface = scoreable
        }
        // basicVelocityProperties.getVelocityYBasicDecimalP().set(0);
        this.totalDamage = 0
        this.initDamage = weaponProperties.getDamage()
        this.setDestroyed(false)
        this.movement.init(weaponProperties.getSpeed(), angle, otherAngle)
    }

    // Subgroups are not taken if enemy is the base group.
    def setGroupInterfaces() : Unit = {
        val basicGroupFactory : BasicGroupFactory = BasicGroupFactory.getInstance()
        if (this.sourceLayerInterface.getGroupInterface()(0) eq basicGroupFactory.ENEMY) {
            this.setGroupInterface(basicGroupFactory.ENEMY_ARRAY)
        } else {
            this.setGroupInterface(this.sourceLayerInterface.getGroupInterface())
        }
    }

    override def processTick(allBinaryLayerManager : AllBinaryLayerManager) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, gameStrings.PROCESS_TICK);
        if (this.isExhausted() && !this.isDestroyed()) {
            //PreLogUtil.put("Explosion - Processing", this, gameStrings.PROCESS_TICK);
            if (this.isReadyForExplosion()) {
                //PreLogUtil.put("Explosion - Ready Processing", this, gameStrings.PROCESS_TICK);
                var indexedAnimationInterface : IndexedAnimation = this.getAnimationInterface().asInstanceOf[IndexedAnimation]
                var currentFrame : Int = indexedAnimationInterface.getFrame()
                if (currentFrame < (indexedAnimationInterface.getAnimationSize() - 1)) {
                    // show next frame in explosion
                    indexedAnimationInterface.nextFrame()
                } else {
                    //PreLogUtil.put("Explosion - End", this, gameStrings.PROCESS_TICK);
                    this.setDestroyed(true)
                }
            } else {
                val collidableWeaponBehavior : CollidableWeaponBehavior = this.getCollidableInferface().asInstanceOf[CollidableWeaponBehavior]
                if (collidableWeaponBehavior.isCollided()) {
                    //PreLogUtil.put("Explosion - Begin", this, gameStrings.PROCESS_TICK);
                    this.setAnimationInterface(this.destroyedAnimationInterface)
                    this.getMovement().stop()
                    this.setReadyForExplosion(true)
                } else {
                    //PreLogUtil.put("Explosion - Begin and End", this, gameStrings.PROCESS_TICK);
                    this.setDestroyed(true)
                }
            }
        }
        this.movement.process(this)
        // decrease the beams power over a distance
        this.totalDamage += this.weaponProperties.getDissipation()
    }

    /*     private void slow()     {         Movement movement = this.getMovement();          BasicVelocityProperties velocityProperties =              ((VelocityInterfaceCompositeInterface) movement).getVelocityProperties();          BasicDecimal xBasicDecimal = velocityProperties.getVelocityXBasicDecimalP();         BasicDecimal yBasicDecimal = velocityProperties.getVelocityYBasicDecimalP();           //xBasicDecimal.multiply(4);         xBasicDecimal.divide(2);          //yBasicDecimal.multiply(4);         yBasicDecimal.divide(2);     }     */
    override def isDestroyed() : Boolean = {
        return this.destroyed
    }

    override def damage(damage : Int, damageType : Int) : Unit = {
        this.totalDamage += damage * damage
    }

    def givePoints(total : Int) : Unit = {
        this.scoreableInterface.addPoints(GameConfigurationUtil.getInstance().getCompetitionValue() * total)
    }

    // Is damage value gone
    def isExhausted() : Boolean = {
        // as such it went beyond the positive max
        if ((this.totalDamage > this.getInitDamage()) || (this.totalDamage < 0)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def getDamage(damageType : Int) : Int = {
        if (!this.isExhausted()) {
            var total : Int = this.getInitDamage() - this.totalDamage
            // + this.getInitDamage() + " totalDamage: " + totalDamage, this, // "damage");
            this.givePoints(total)
            return total
        }
        return 0
    }

    def setDestroyed(destroyed : Boolean) : Unit = {
        this.destroyed = destroyed
        if (this.isDestroyed()) {
            this.scoreableInterface = NoScoreable.getInstance()
            DestroyedLayerProcessor.getInstance().add(this)
        }
    }

    /*     private void setInitDamage(int initDamage)     {         this.initDamage = initDamage;     }     */
    def getInitDamage() : Int = {
        return this.initDamage
    }

    def setAnimationInterface(animationInterface : Animation) : Unit = {
        this.animationInterface = animationInterface
    }

    def getAnimationInterface() : Animation = {
        return this.animationInterface
    }

    def getInitAnimationInterfaceP() : Animation = {
        return this.initAnimationInterface
    }

    def setInitAnimationInterfaceP(initAnimationInterface : Animation) : Unit = {
        this.initAnimationInterface = initAnimationInterface
    }

    def getDestroyedAnimationInterface() : Animation = {
        return this.destroyedAnimationInterface
    }

    /**      * @return the sourceLayerInterface      */
    def getOwnerLayerInterface() : AllBinaryLayer = {
        return this.sourceLayerInterface
    }

    /**      * @param sourceLayerInterface      *            the sourceLayerInterface to set      */
    def setOwnerLayerInterface(sourceLayerInterface : AllBinaryLayer) : Unit = {
        this.sourceLayerInterface = sourceLayerInterface
    }

    override def paint(graphics : Graphics) : Unit = {
        // this.logUtil.putF(this.commonStrings.START, this, canvasStrings.PAINT);
        val viewPosition : ViewPositionBase = this.getViewPosition()
        //TWB - the offset does not make sense? is collision offset? 
        this.animationInterface.paintXY(graphics, viewPosition.getX() - this.getHalfWidth(), viewPosition.getY() - this.getHalfHeight())
    }

    override def paintThreed(graphics : Graphics) : Unit = {
        val viewPosition : ViewPositionBase = this.getViewPosition()
        this.animationInterface.paintThreedXYZ(graphics, viewPosition.getX() - this.getHalfWidth(), viewPosition.getY() - this.getHalfHeight(), viewPosition.getZ() - this.getHalfDepth())
    }

    /**      * @return the movement      */
    def getMovement() : Movement = {
        return this.movement
    }

    /**      * @param movement      *            the movement to set      */
    def setMovement(movement : Movement) : Unit = {
        this.movement = movement
    }

    override def getType() : Int = {
        return WeaponLayer.getStaticType()
    }

    override def getMultiPlayerType() : Int = {
        return this.multiPlayerType
    }

    def setWeaponPropertiesP(weaponProperties : WeaponProperties) : Unit = {
        this.weaponProperties = weaponProperties
    }

    def getWeaponPropertiesP() : WeaponProperties = {
        return this.weaponProperties
    }

    override def implmentsTickableInterface() : Boolean = {
        return true
    }

    override def set(gl : GL) : Unit = {
        //OpenGLSurfaceChangedInterface openGLSurfaceChangedInterface = ;        
        this.initAnimationInterface.set(gl)
    }

}

object WeaponLayer {
    def getStaticType() : Int = {
        return 0
    }

}


