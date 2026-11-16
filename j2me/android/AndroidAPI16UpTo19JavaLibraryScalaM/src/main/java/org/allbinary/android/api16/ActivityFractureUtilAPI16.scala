/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.api16

import _root_.android.app.Activity
import _root_.android.view.View
import _root_.org.allbinary.android.api5.ActivityFractureUtilAPI5

class ActivityFractureUtilAPI16 extends ActivityFractureUtilAPI5 {
    import _root_.org.allbinary.android.api16.ActivityFractureUtilAPI16.{*}

    override def setFullScreen(activity : Activity) : Unit = {
        val decorView : View = activity.getWindow().getDecorView()
        //        //API 11-30 setSystemUiVisibility
        val visibility : Int = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.setSystemUiVisibility(visibility)
    }

}

object ActivityFractureUtilAPI16 {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance16 : ActivityFractureUtilAPI16 = new ActivityFractureUtilAPI16()

    def getInstance() : ActivityFractureUtilAPI16 = {
        return ActivityFractureUtilAPI16.instance16
    }

}


