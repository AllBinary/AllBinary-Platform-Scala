/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig.generator

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.InputStream
import _root_.java.util.HashMap
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.InputOutputTypeData
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpStoreInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class StoreFileGenerator(param_transformInfoInterface : TransformInfoInterface) extends TransformInfoObjectConfigGenerator {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings_StoreFileGenerator : CommonStrings = CommonStrings.getInstance()

    private var output : String = null

    private var fileAbPath : AbPath = null

    private var file : AbFile = null

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var httpTransformInfoInterface : TransformInfoHttpInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpInterface]
        var weblisketSession : WeblisketSession = new WeblisketSession(httpTransformInfoInterface.getPropertiesHashMap(), httpTransformInfoInterface.getPageContext())
        //3. Use root view name as default output file name
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getWebappPath())
        stringBuffer.append(weblisketSession.getStoreName())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        var abPath : AbPath = new AbPath(stringBuffer.toString(), StringUtil.getInstance().EMPTY_STRING)
        //1. Use requested file name output
        var fileName : String = httpTransformInfoInterface.getPropertiesHashMap().get(InputOutputTypeData.getInstance().FILE).asInstanceOf[String]
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(fileName)) {
            //2. Use objectconfig specified output - no imp
            var transformInfoHttpStoreInterface : TransformInfoHttpStoreInterface = transformInfoInterface.asInstanceOf[TransformInfoHttpStoreInterface]
            //3. Use root view name as default output file name
            fileName = transformInfoInterface.getName().substring(transformInfoHttpStoreInterface.getStoreName().length() + 1)
            //& Replace TRANSFORM_COMPONENTS_PREVIEW TRANSFORM_COMPONENTS_SMALL_PREVIEW
            var outputMappingHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
            outputMappingHashMap.put(TransformInfosData.getInstance().PREVIEW, "Preview")
            outputMappingHashMap.put(TransformInfosData.getInstance().SMALL_PREVIEW, "SmallPreview")
            outputMappingHashMap.put(CommonSeps.getInstance().SPACE, StringUtil.getInstance().EMPTY_STRING)
            var replace : Replace = new Replace(outputMappingHashMap)
            fileName = replace.all(fileName)
        }
        if (stringValidationUtil.isEmpty(fileName)) {
            throw new Exception("TransformInfoObjectConfigGenerator FileName Not Specified")
        }
        //3. Use jsp as default output
        var tempOutput : String = httpTransformInfoInterface.getPropertiesHashMap().get(InputOutputTypeData.getInstance().NAME).asInstanceOf[String]
        if (stringValidationUtil.isEmpty(tempOutput)) {
            tempOutput = InputOutputTypeData.getInstance().DEFAULT
        }
        this.output = tempOutput
        if (stringValidationUtil.isEmpty(this.output)) {
            throw new Exception("TransformInfoObjectConfigGenerator Output=extension Not Specified")
        }
        stringBuffer = new StringMaker()
        stringBuffer.append(fileName)
        stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
        stringBuffer.append(this.output)
        abPath = new AbPath(abPath.toString(), stringBuffer.toString())
        this.fileAbPath = abPath
        this.file = AbFile.createAbFileFromAbPath(this.fileAbPath)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("File: " + this.fileAbPath.toString(), this, this.commonStrings_StoreFileGenerator.CONSTRUCTOR)
        }
    }

    override def process(input : String) : String = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Processing", this, this.commonStrings_StoreFileGenerator.PROCESS)
        }
        if (!this.file.exists()) {
            this.file.createNewFile()
        }
        if (this.file.exists()) {
            var inputStream : InputStream = new ByteArrayInputStream(input.getBytes())
            FileUtil.getInstance().write(inputStream, this.file)
        } else {
            throw new Exception("Could Not Create: " + this.fileAbPath.toString())
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("Processed", this, this.commonStrings_StoreFileGenerator.PROCESS)
        }
        return StringUtil.getInstance().EMPTY_STRING
    }

}


