/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.string


class CommonStateStrings {
    import _root_.org.allbinary.string.CommonStateStrings.{*}

    val CONTEXT : String = "Context: "

    val FINISH : String = "finish"

    val CREATE : String = "onCreate"

    val START : String = "onStart"

    val RESTART : String = "onRestart"

    val RESUME : String = "onResume"

    val PAUSE : String = "onPause"

    val STOP : String = "onStop"

    val DESTROY : String = "onDestroy"

    val BIND : String = "onBind"

    val ON_SAVE_INSTANCE_STATE : String = "onSaveInstanceState"

    val ON_START_COMMAND : String = "onStartCommand"

}

object CommonStateStrings {
    private val instance : CommonStateStrings = new CommonStateStrings()

    def getInstance() : CommonStateStrings = {
        return CommonStateStrings.instance
    }

}


