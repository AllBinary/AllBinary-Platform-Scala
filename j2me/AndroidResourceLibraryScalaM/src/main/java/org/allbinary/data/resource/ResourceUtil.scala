/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource

import _root_.java.io.InputStream
import _root_.android.app.Activity
import _root_.android.content.Context
import _root_.android.content.res.Resources
import _root_.org.allbinary.debug.DebugFactory
import _root_.org.allbinary.debug.NoDebug
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.HashtableUtil

//Android
class ResourceUtil private() {
    import _root_.org.allbinary.data.resource.ResourceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private Activity activity;
    private var context : Object = NullUtil.getInstance().NULL_OBJECT

    private var resources : Object = NullUtil.getInstance().NULL_OBJECT

    private var hashMap : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    def setLoadingPaths(path : String, ext : String) : Unit = {
        this.logUtil.putF(CommonStrings.getInstance().NOT_IMPLEMENTED, this, "setLoadingPaths")
    }

    def getContext() : Context = {
        return this.context.asInstanceOf[Context]
    }

    /*     public Activity getActivity()     {         return activity;     }     */
    def setContextFromActivity(activity : Activity) : Unit = {
        //this.activity = activity;
        this.context = activity
    }

    def setContext(aContext : Context) : Unit = {
        this.context = aContext
    }

    def getResourceId(resource : String) : Integer = {
        val value : Integer = this.hashMap.get(resource).asInstanceOf[Integer]
        if (DebugFactory.getInstance() ne NoDebug.getInstance()) {
            PreLogUtil.put(new StringMaker().append(resource).append(CommonSeps.getInstance().COLON).append(value.toString()).toString(), this, "getResourceId")
        }
        return value
    }

    def addResource(resource : String, value : Integer) : Unit = {
        if (DebugFactory.getInstance() ne NoDebug.getInstance()) {
            PreLogUtil.put(new StringMaker().append(resource).append(CommonSeps.getInstance().COLON).append(value.toString()).toString(), this, "addResource")
            if (this.containsDuplicate(resource, value)) {
                ForcedLogUtil.log(new StringMaker().append("Found Duplicate Resource: ").append(resource).toString(), this)
            }
        }
        this.hashMap.put(resource, value)
    }

    private def containsDuplicate(resource : String, value : Integer) : Boolean = {
        var objectArray : Array[Object] = HashtableUtil.getInstance().getKeysAsArray(this.hashMap)

        {
            var index : Int = objectArray.length
            while ({ index -= 1; index } >= 0) {
                var integer : Integer = this.hashMap.get(objectArray(index).asInstanceOf[Object]).asInstanceOf[Integer]
                if (resource ne objectArray(index)) {
                    if (value != integer) {
                        if (value.intValue() == integer.intValue()) {
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    /*     private Resources getResources()     {         return this.resources;     }     */
    def setResources(resources : Resources) : Unit = {
        this.logUtil.putF(new StringMaker().append("Resource Loader: ").append(resources.getClass().getName()).toString(), this, "setResources")
        this.resources = resources
    }

    //final String RESOURCE = "Resource Found";
    def getResourceAsStream(resource : String) : InputStream = {
        // InputStream inputStream = assetManager.open(resourcePath);
        val integer : Integer = this.hashMap.get(resource).asInstanceOf[Integer]
        val id : Int = integer.intValue()
        val resources : Resources = (this.resources.asInstanceOf[Resources])
        val inputStream : InputStream = resources.openRawResource(id)
        if (inputStream != null) {
            //this.logUtil.putF(RESOURCE, this, METHOD_NAME);
            return inputStream
        }
        return inputStream
    }

}

object ResourceUtil {
    private val instance : ResourceUtil = new ResourceUtil()

    def getInstance() : ResourceUtil = {
        return ResourceUtil.instance
    }

}


