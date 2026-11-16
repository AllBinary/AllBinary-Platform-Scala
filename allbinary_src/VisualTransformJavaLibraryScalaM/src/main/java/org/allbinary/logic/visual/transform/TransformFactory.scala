/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntity
import _root_.org.allbinary.data.tables.transform.info.TransformInfoEntityBuilder
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoObjectFactory
import _root_.org.allbinary.string.CommonStrings

class TransformFactory private() {
    import _root_.org.allbinary.logic.visual.transform.TransformFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    //another views info and do not use request info
    def getInstance(abeClientInformation : AbeClientInformationInterface, viewName : String, ownerTransformInfoInterface : TransformInfoInterface) : TransformInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Creating Transform: " + viewName, this, this.commonStrings.GET_INSTANCE)
            }
            var ownerTransformInfoHttpInterface : TransformInfoHttpInterface = ownerTransformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
            var transformInfoEntity : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
            var transformInfoInterface : TransformInfoInterface = transformInfoEntity.get(viewName, ownerTransformInfoHttpInterface.getPropertiesHashMap(), ownerTransformInfoHttpInterface.getPageContext())
            if (transformInfoInterface == null) {
                throw new Exception("No Such View In DB: " + viewName)
            }
            transformInfoInterface.setChild()
            val anyType : Object = TransformInfoObjectFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface)
            /*          if(!(object instanceof TransformInterface))          {             throw new Exception("View Object Not Instance Of TransformInterface but is: " + ClassUtil.viewAll(object,CommonSeps.getInstance().NEW_LINE));          }          else              */
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Created Transform: " + viewName, this, this.commonStrings.GET_INSTANCE)
            }
            return anyType.asInstanceOf[TransformInterface]
        } catch {
            case e : Exception => {
                //String error = "Failed To Get Instance: " + viewName + "->TransformFactory";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, this.commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    //create a root/parent instance from db and/or request
    def getInstance(abeClientInformation : AbeClientInformationInterface, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformInterface = {
        try {
            val transformInfoData : TransformInfoData = TransformInfoData.getInstance()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Creating Transform: " + propertiesHashMap.get(transformInfoData.NAME), this, this.commonStrings.GET_INSTANCE)
            }
            val transformInfoEntity : TransformInfoEntity = TransformInfoEntityBuilder.getInstance()
            var transformInfoInterface : TransformInfoInterface = transformInfoEntity.get(propertiesHashMap.get(transformInfoData.NAME).asInstanceOf[String], propertiesHashMap, pageContext)
            if (transformInfoInterface != null) {
                transformInfoInterface.`override`(propertiesHashMap)
            } else {
                transformInfoInterface = TransformInfoHttpFactory.getInstance(propertiesHashMap, pageContext).asInstanceOf[TransformInfoInterface]
            }
            val anyType : Object = TransformInfoObjectFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface)
            /*          if(!(object instanceof TransformInterface))           {             throw new Exception("View Object Not Instance Of TransformInterface but is: " +                 ClassUtil.viewAll(object,CommonSeps.getInstance().NEW_LINE));          }          else              */
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Created Transform: " + propertiesHashMap.get(transformInfoData.NAME), this, this.commonStrings.GET_INSTANCE)
            }
            return anyType.asInstanceOf[TransformInterface]
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failed To Get Instance: ")
                    stringBuffer.append(propertiesHashMap.get(TransformInfoData.getInstance().NAME).asInstanceOf[String])
                    stringBuffer.append("->TransformFactory")
                    this.logUtil.put(stringBuffer.toString(), this, this.commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    //create a root instance from a root TransformInfoInterface
    def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) : TransformInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Creating Transform: " + transformInfoInterface.getName(), this, "getInstance(TransformInfoInterface)")
            }
            val anyType : Object = TransformInfoObjectFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface)
            /*          if(!(object instanceof TransformInterface))           {             throw new Exception("View Object Not Instance Of TransformInterface but is: " + ClassUtil.viewAll(object,CommonSeps.getInstance().NEW_LINE));          }          else              */
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                this.logUtil.putF("Created Transform: " + transformInfoInterface.getName(), this, "getInstance(TransformInfoInterface)")
            }
            return anyType.asInstanceOf[TransformInterface]
        } catch {
            case e : Exception => {
                //String error = "Failed To Get Instance: " + transformInfoInterface.getName();
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(TransformInfoInterface)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TransformFactory {
    private val instance : TransformFactory = new TransformFactory()

    def getInstance() : TransformFactory = {
        return TransformFactory.instance
    }

}


