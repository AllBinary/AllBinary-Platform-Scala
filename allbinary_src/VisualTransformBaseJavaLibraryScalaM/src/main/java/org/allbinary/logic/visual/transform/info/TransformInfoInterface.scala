/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.w3c.dom.Document

trait TransformInfoInterface extends TableMappingInterface {

    def log() : String

    def `override`(hashMap : HashMap[Object, Object]) : Unit

    def getName() : String

    def setStoreName(value : String) : Unit

    def getStoreName() : String

    def getObjectFile() : String

    def getObject() : Object

    def getTemplateFilePath() : AbPath

    def getTemplateFile() : String

    def getTemplate() : String

    def getDataFilePath() : AbPath

    def getDataFile() : String

    def getDataDocument() : Document

    def setName(value : String) : Unit

    def setObjectFile(value : String) : Unit

    def setObject(anyType : Object) : Unit

    def setObjectConfigInterface(transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface) : Unit

    def getObjectConfigInterface() : TransformInfoObjectConfigInterface

    def setTemplateFile(value : String) : Unit

    def setTemplate(value : String) : Unit

    def setDataFile(value : String) : Unit

    def setData(value : String) : Unit

    //called so it will not use a special viewinfoobjectgenerator
    def setChild() : Unit

    def isChild() : Boolean

}


