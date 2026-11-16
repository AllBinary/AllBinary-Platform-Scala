/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.api30

import _root_.android.app.Activity
import _root_.android.view.Window
import _root_.androidx.core.view.WindowCompat
import _root_.androidx.core.view.WindowInsetsCompat
import _root_.androidx.core.view.WindowInsetsControllerCompat
import _root_.org.allbinary.android.api5.ActivityFractureUtilAPI5

class ActivityFractureUtilAPI30 extends ActivityFractureUtilAPI5 {
    import _root_.org.allbinary.android.api30.ActivityFractureUtilAPI30.{*}

    override def setFullScreen(activity : Activity) : Unit = {
        //API30 on up
        val window : Window = activity.getWindow()
        val windowInsetsController : WindowInsetsControllerCompat = WindowCompat.getInsetsController(window, window.getDecorView())
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
    }

}

object ActivityFractureUtilAPI30 {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance30 : ActivityFractureUtilAPI30 = new ActivityFractureUtilAPI30()

    def getInstance() : ActivityFractureUtilAPI30 = {
        return ActivityFractureUtilAPI30.instance30
    }

}


