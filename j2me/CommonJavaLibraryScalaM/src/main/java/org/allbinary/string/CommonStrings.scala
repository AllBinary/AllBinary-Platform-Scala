/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.string

import _root_.jsinterop.annotations.JsType
import _root_.jsinterop.annotations.JsMethod
import _root_.jsinterop.annotations.JsProperty

@JsType
class CommonStrings {
    import _root_.org.allbinary.string.CommonStrings.{*}

    @JsProperty
    val EMPTY : String = "Empty"

    @JsProperty
    val CREATE_IMAGE : String = "createImage"

    @JsProperty
    val PLEASE_WAIT : String = "Please Wait"

    @JsProperty
    val PLEASE_WAIT_FOR_SERVER : String = "Please Wait Getting Data From Server..."

    @JsProperty
    val PERIODS : String = "..."

    @JsProperty
    val LOADING : String = "Loading..."

    //CommonStrings.getInstance()
    @JsProperty
    val CONSTRUCTOR : String = "Constructor"

    @JsProperty
    val START : String = "Start"

    @JsProperty
    val END : String = "End"

    @JsProperty
    val EXCEPTION : String = "Exception"

    @JsProperty
    val EXCEPTION_LABEL : String = "Exception: "

    @JsProperty
    val CLEANUP : String = "cleanup"

    @JsProperty
    val INIT : String = "init"

    @JsProperty
    val CLOSE : String = "close"

    @JsProperty
    val UP : String = "up"

    @JsProperty
    val DOWN : String = "down"

    @JsProperty
    val LEFT : String = "left"

    @JsProperty
    val RIGHT : String = "right"

    @JsProperty
    val DIRECTION_NAME : Array[String] = Array[String](this.DOWN, this.LEFT, this.RIGHT, this.UP)

    @JsProperty
    val CREATE : String = "Create"

    @JsProperty
    val REMOVE : String = "Remove"

    @JsProperty
    val UPDATE : String = "Update"

    @JsProperty
    val DELETE : String = "Delete"

    @JsProperty
    val delete : String = "delete"

    @JsProperty
    val LOAD : String = "load"

    @JsProperty
    val SAVE : String = "save"

    @JsProperty
    val ADD : String = "Add"

    @JsProperty
    val DROP : String = "Drop"

    @JsProperty
    val INSERT : String = "Insert"

    @JsProperty
    val VISIT : String = "visit"

    @JsProperty
    val START_METHOD_NAME : String = this.START

    @JsProperty
    val END_METHOD_NAME : String = "end"

    @JsProperty
    val GET : String = "get"

    @JsProperty
    val PROCESS : String = "process"

    @JsProperty
    val GET_INSTANCE : String = "getInstance"

    @JsProperty
    val GET_LIST : String = "getList"

    @JsProperty
    val RUN : String = "run"

    @JsProperty
    val START_RUNNABLE : String = "Start Runnable"

    @JsProperty
    val RUNNING : String = "Running"

    @JsProperty
    val END_RUNNABLE : String = "End Runnable"

    @JsProperty
    val DISABLE : String = "disable"

    @JsProperty
    val ENABLE : String = "enable"

    @JsProperty
    val SUCCESS : String = "Command Success"

    @JsProperty
    val FAILURE : String = "Command Failed"

    @JsProperty
    val NOT_IMPLEMENTED : String = "Not Implemented"

    @JsProperty
    val UNKNOWN : String = "Unknown"

    @JsProperty
    val ON_EVENT : String = "onEvent"

    @JsProperty
    val IS_VALID : String = "isValid"

    @JsProperty
    val TOSTRING : String = "toString"

    @JsProperty
    val ADD_LISTENER : String = "addListener"

    @JsProperty
    val REMOVE_LISTENER : String = "removeListener"

    @JsProperty
    val SIZE : String = "size"

}

object CommonStrings {
    private val instance : CommonStrings = new CommonStrings()

    @JsMethod
    def getInstance() : CommonStrings = {
        return CommonStrings.instance
    }

}


