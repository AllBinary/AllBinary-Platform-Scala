/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.resource

import _root_.org.allbinary.animation.BasicAnimationInterfaceFactoryInterface
import _root_.org.allbinary.animation.NullAnimationFactory
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.RectangleFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class BaseResourceAnimationInterfaceFactoryInterfaceFactory(param_name : String, param_hashtable : ABHashtable[Object, Object], param_rectangleHashtable : ABHashtable[Object, Object], param_rectangleArrayHashtable : ABHashtable[Object, Object]) extends FeatureResourceAnimationInterfaceFactoryInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var hashtable : ABHashtable[Object, Object] = null

    private var rectangleHashtable : ABHashtable[Object, Object] = null

    private var rectangleArrayOfArraysHashtable : ABHashtable[Object, Object] = null

    private var name : String = null

    private var initialized : Boolean = false

    //Constructor
    {
        val name : String = param_name
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        val rectangleHashtable : ABHashtable[Object, Object] = param_rectangleHashtable
        val rectangleArrayHashtable : ABHashtable[Object, Object] = param_rectangleArrayHashtable
        this.hashtable = hashtable
        this.rectangleHashtable = rectangleHashtable
        this.rectangleArrayOfArraysHashtable = rectangleArrayHashtable
        this.name = name
    }

    def getName() : String = {
        return this.name
    }

    override def init(level : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(new StringMaker().append("Available List of Animations: ").append(this.hashtable.toString()).toString(), this, commonStrings.INIT)
        this.setInitialized(true)
    }

    def initImageCache(imageCache : ImageCache, level : Int) : Unit = {
    }

    def add(resource : String, animationInterfaceFactoryInterface : BasicAnimationInterfaceFactoryInterface) : Unit = {
        //PreLogUtil.put(resource, this, this.commonStrings.ADD);
        if (this.hashtable.containsKey(resource.asInstanceOf[Object])) {
            throw new Exception(new StringMaker().append("Resource Already Created: ").append(resource).toString())
        }
        this.hashtable.put(resource, animationInterfaceFactoryInterface)
    }

    override def getBasicAnimationInterfaceFactoryInstance(resource : String) : BasicAnimationInterfaceFactoryInterface = {
        val basicAnimationInterfaceFactoryInterfaceCanBeNull : Object = this.hashtable.get(resource)
        if (basicAnimationInterfaceFactoryInterfaceCanBeNull == null) {
            //this.logUtil.putF(new StringMaker().append("No Resource for: ").append(resource).toString(), this, "getBasicAnimationInterfaceFactoryInstance");
            return NullAnimationFactory.NULL_NOT_FOR_USE_ANIMATION_FACTORY
        }
        return basicAnimationInterfaceFactoryInterfaceCanBeNull.asInstanceOf[BasicAnimationInterfaceFactoryInterface]
    }

    override def getRectangle(resource : String) : Rectangle = {
        val rectangleCanBeNull : Object = this.rectangleHashtable.get(resource)
        if (rectangleCanBeNull == null) {
            return RectangleFactory.SINGLETON
        }
        return rectangleCanBeNull.asInstanceOf[Rectangle]
    }

    def addRectangle(resource : String, rectangle : Rectangle) : Unit = {
        this.rectangleHashtable.put(resource, rectangle)
    }

    override def getRectangleArrayOfArrays(resource : String) : Array[Array[Rectangle]] = {
        var valueCanBeNull : Object = this.rectangleArrayOfArraysHashtable.get(resource)
        if (valueCanBeNull != null) {
            val rectangleArrayOfArrays : Array[Array[Rectangle]] = valueCanBeNull.asInstanceOf[Array[Array[Rectangle]]]
            return rectangleArrayOfArrays
        } else {
            return RectangleFactory.ARRAY_OF_ARRAYS
        }
        throw new IllegalStateException()
    }

    def addRectangleArrayOfArrays(resource : String, rectangleArrayOfArrays : Array[Array[Rectangle]]) : Unit = {
        this.rectangleArrayOfArraysHashtable.put(resource, rectangleArrayOfArrays)
    }

    override def isFeature() : Boolean = {
        return false
    }

    override def isLoadingLevel(level : Int) : Boolean = {
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (level == resourceLoadingLevelFactory.LOAD_ALL.getLevel()) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        return new StringMaker().append(this.getClass().getName()).append(CommonSeps.getInstance().SEMICOLON).append(CommonSeps.getInstance().SPACE).append(this.name).toString()
    }

    override def getHashtable() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

    def getRectangleHashtable() : ABHashtable[Object, Object] = {
        return this.rectangleHashtable
    }

    def getRectangleArrayOfArraysHashtable() : ABHashtable[Object, Object] = {
        return this.rectangleArrayOfArraysHashtable
    }

    def setInitialized(initialized : Boolean) : Unit = {
        this.initialized = initialized
    }

    def isInitialized() : Boolean = {
        return this.initialized
    }

}


