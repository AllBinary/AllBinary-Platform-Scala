/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.api5

import _root_.android.app.Activity
import _root_.org.allbinary.input.motion.button.TouchScreenTypeFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.android.api1.ActivityFractureUtilAPI1
import _root_.org.allbinary.input.motion.button.TouchScreenFactory

class ActivityFractureUtilAPI5 extends ActivityFractureUtilAPI1 {
    import _root_.org.allbinary.android.api5.ActivityFractureUtilAPI5.{*}

    //Since: API Level 7
    private val FEATURE_TOUCHSCREEN_MULTITOUCH : String = "android.hardware.touchscreen.multitouch"

    //Since: API Level 8
    private val FEATURE_TOUCHSCREEN : String = "android.hardware.touchscreen"

    //Since: API Level 8
    private val FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT : String = "android.hardware.touchscreen.multitouch.distinct"

    override def process(activity : Activity) : Unit = {
        val touchScreenFactory : TouchScreenFactory = TouchScreenFactory.getInstance()
        val touchScreenTypeFactory : TouchScreenTypeFactory = TouchScreenTypeFactory.getInstance()
        touchScreenFactory.setTouch(this.isTouch(activity))
        touchScreenFactory.setMultiTouch(this.isMultiTouch(activity))
        touchScreenFactory.setMultiTouchDistinct(this.isMultiTouchDistinct(activity))
        touchScreenTypeFactory.update(activity)
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        //this.logUtil.putF(touchScreenFactory.toString(), this, commonStrings.PROCESS);
        PreLogUtil.put(touchScreenFactory.toString(), this, commonStrings.PROCESS)
    }

    private def isTouch(activity : Activity) : Boolean = {
        return this.isFeature(activity, this.FEATURE_TOUCHSCREEN)
    }

    private def isMultiTouch(activity : Activity) : Boolean = {
        return this.isFeature(activity, this.FEATURE_TOUCHSCREEN_MULTITOUCH)
    }

    private def isMultiTouchDistinct(activity : Activity) : Boolean = {
        return this.isFeature(activity, this.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)
    }

    private def isFeature(activity : Activity, property : String) : Boolean = {
        return activity.getPackageManager().hasSystemFeature(property)
    }

}

object ActivityFractureUtilAPI5 {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance5 : ActivityFractureUtilAPI5 = new ActivityFractureUtilAPI5()

    def getInstance() : ActivityFractureUtilAPI5 = {
        return ActivityFractureUtilAPI5.instance5
    }

}


