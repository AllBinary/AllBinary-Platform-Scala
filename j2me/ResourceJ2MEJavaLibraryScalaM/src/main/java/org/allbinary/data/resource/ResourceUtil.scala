/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource

import _root_.java.io.InputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

//J2ME
class ResourceUtil private() {
    import _root_.org.allbinary.data.resource.ResourceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def setLoadingPaths(path : String, ext : String) : Unit = {
        this.logUtil.putF(CommonStrings.getInstance().NOT_IMPLEMENTED, this, "setLoadingPaths")
    }

    //private final String GET_RESOURCE = "Getting Resource: ";
    def getResourceAsStream(resource : String) : InputStream = {
        var inputStream : InputStream = resource.getClass().getResourceAsStream(resource)
        if (inputStream == null) {
            inputStream = this.getResourceAsStreamAtStart(resource, 2)
            if (inputStream == null) {
                inputStream = this.getResourceAsStreamAtStart(resource, 1)
                if (inputStream == null) {
                    val stringMaker : StringMaker = new StringMaker()
                    val index : Int = resource.lastIndexOf('/')
                    var resourcePath : String = resource.substring(index + 1)
                    //                    this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                    inputStream = resource.getClass().getResourceAsStream(resourcePath)
                    if (inputStream == null) {
                        resourcePath = resource.substring(index)
                        //                        this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                        inputStream = resource.getClass().getResourceAsStream(resourcePath)
                        if (inputStream == null) {
                            val RES : String = "res"
                            resourcePath = stringMaker.append(RES).append(resource.substring(index)).toString()
                            //                            this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                            inputStream = resource.getClass().getResourceAsStream(resourcePath)
                            if (inputStream == null) {
                                stringMaker.delete(0, stringMaker.length())
                                resourcePath = stringMaker.append("/").append(RES).append(resource.substring(index)).toString()
                                //                                this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                inputStream = resource.getClass().getResourceAsStream(resourcePath)
                                val COLON : String = CommonSeps.getInstance().COLON
                                if (inputStream == null) {
                                    stringMaker.delete(0, stringMaker.length())
                                    resourcePath = stringMaker.append(RES).append(COLON).append(resource.substring(index)).toString()
                                    //                                    this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                    inputStream = resource.getClass().getResourceAsStream(resourcePath)
                                    if (inputStream == null) {
                                        stringMaker.delete(0, stringMaker.length())
                                        resourcePath = stringMaker.append(RES).append(COLON).append(resource.substring(index + 1)).toString()
                                        //                                        this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                        inputStream = resource.getClass().getResourceAsStream(resourcePath)
                                        if (inputStream == null) {
                                            val RESOURCE_STRING : String = "resource"
                                            stringMaker.delete(0, stringMaker.length())
                                            resourcePath = stringMaker.append(RESOURCE_STRING).append(COLON).append(resource.substring(index)).toString()
                                            //                                            this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                            inputStream = resource.getClass().getResourceAsStream(resourcePath)
                                            if (inputStream == null) {
                                                stringMaker.delete(0, stringMaker.length())
                                                resourcePath = stringMaker.append(RESOURCE_STRING).append(COLON).append(resource.substring(index + 1)).toString()
                                                //                                                this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                                inputStream = resource.getClass().getResourceAsStream(resourcePath)
                                                //String resourcePath = resource;
                                                if (inputStream == null) {
                                                    stringMaker.delete(0, stringMaker.length())
                                                    throw new Exception(stringMaker.append("Unable to obtain: ").append(resource).toString())
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return inputStream
    }

    private def getResourceAsStreamAtStart(resource : String, startIndex : Int) : InputStream = {
        val stringMaker : StringMaker = new StringMaker()
        var index : Int = resource.indexOf(CommonSeps.getInstance().COLON)
        val resourcePath : String = resource.substring(index + startIndex)
        //Try getting resource with normal resource access
        val inputStream : InputStream = resource.getClass().getResourceAsStream(resourcePath)
        if (inputStream != null) {
            //            this.logUtil.putF("Resource Found", this, METHOD_NAME);
            return inputStream
        }
        return inputStream
    }

    def addResource(resource : String, value : Integer) : Unit = {
    }

}

object ResourceUtil {
    private var instance : ResourceUtil = new ResourceUtil()

    def getInstance() : ResourceUtil = {
        return ResourceUtil.instance
    }

}


