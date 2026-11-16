/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android.activity


trait SimpleProgressActivityInterface {

    def runOnUiThread(action : Runnable) : Unit

    def onSetProgress(value : Int, text : String) : Unit

    def onDismissProgress(animationSequence : Array[Int]) : Unit

    def onShowProgress(indeterminate : Boolean, animationSequence : Array[Int]) : Unit

}


