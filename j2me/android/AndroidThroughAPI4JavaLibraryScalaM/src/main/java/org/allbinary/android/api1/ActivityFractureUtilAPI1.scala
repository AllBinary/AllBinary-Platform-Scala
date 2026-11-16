/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.api1

import _root_.org.allbinary.android.ActivityFractureUtil
import _root_.android.app.Activity
import _root_.android.view.WindowManager

class ActivityFractureUtilAPI1 extends ActivityFractureUtil {
    import _root_.org.allbinary.android.api1.ActivityFractureUtilAPI1.{*}

    //private final int MAX_API = 4;
    override def process(activity : Activity) : Unit = {
    }

    /*     public void process(Activity activity, boolean shouldAllowVirtualKeyboardFracture) throws Exception     {         if(GameInputMotionInfoAPI1.getInstance().MAX_API != this.MAX_API)         {             throw new Exception("GameInputMotion is Factured");         }                  int SDK_VERSION = AndroidInfoFactory.getInstance().getVersion();          if(!shouldAllowVirtualKeyboardFracture && SDK_VERSION > VirtualKeyboardAPI1.MAX_API)         {             throw new Exception("VirtualKeyboard is probably Factured");         }     }     */
    override def setFullScreen(activity : Activity) : Unit = {
        // FLAG_FULLSCREEN
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

}

object ActivityFractureUtilAPI1 {
    private val instance : ActivityFractureUtilAPI1 = new ActivityFractureUtilAPI1()

    def getInstance() : ActivityFractureUtilAPI1 = {
        return ActivityFractureUtilAPI1.instance
    }

}


