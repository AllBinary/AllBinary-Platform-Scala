/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info


class TransformInfoProperties(param_name : String, param_label : String, param_description : String, param_objectFileName : String, param_objectConfigFileName : String, param_templateFileName : String) {

    private var name : String = null

    private var label : String = null

    private var description : String = null

    private var objectFileName : String = null

    private var objectConfigFileName : String = null

    private var templateFileName : String = null

    //Constructor
    {
        val name : String = param_name
        val label : String = param_label
        val description : String = param_description
        val objectFileName : String = param_objectFileName
        val objectConfigFileName : String = param_objectConfigFileName
        val templateFileName : String = param_templateFileName
        this.name = name
        this.label = label
        this.description = description
        this.objectFileName = objectFileName
        this.templateFileName = templateFileName
        this.objectConfigFileName = objectConfigFileName
    }

    def setName(value : String) : Unit = {
        this.name = value
    }

    def setDescription(value : String) : Unit = {
        this.description = value
    }

    def setViewFile(value : String) : Unit = {
        this.objectFileName = value
    }

    def setTemplateFile(value : String) : Unit = {
        this.templateFileName = value
    }

    def setObjectConfigFile(value : String) : Unit = {
        this.objectConfigFileName = value
    }

    def getName() : String = {
        return this.name
    }

    def getLabel() : String = {
        return this.label
    }

    def getDescription() : String = {
        return this.description
    }

    def getViewFile() : String = {
        return this.objectFileName
    }

    def getTemplateFile() : String = {
        return this.templateFileName
    }

    def getObjectConfigFile() : String = {
        return this.objectConfigFileName
    }

}


