/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.activity

import _root_.android.view.View

trait ViewCompositeInterface {

    def getRootView() : View

    def getView() : View

    //WindowManager getWindowManager();
    def runOnUiThread(action : Runnable) : Unit

}


