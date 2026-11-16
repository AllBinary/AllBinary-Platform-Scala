/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.theme

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.store.theme.StoreThemeCategoryFactory
import _root_.org.allbinary.business.category.store.theme.StoreThemeCategoryInterface
import _root_.org.allbinary.data.tree.category.CategoryLoaderFactory
import _root_.org.allbinary.data.tree.category.CategoryLoaderInterface
import _root_.org.allbinary.data.tree.dom.DomData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.io.path.PathUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.CompositeTransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.includes.style.css.template.retail.CssStyleValidation
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ThemeValidation private () extends ThemeInterface with ValidationInterface with DomNodeInterface with CompositeTransformInfoInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var transformInfoInterface : TransformInfoInterface = null

    private var styleValidationInterface : ValidationInterface = null

    private var themeName : String = null

    private var themePreviewImageName : String = null

    private var webAppAbPath : AbPath = null

    private var categoryAbPath : AbPath = null

    private var fileAbPath : AbPath = null

    def this(transformInfoInterface : TransformInfoInterface, cssStyleValidation : CssStyleValidation, categoryThemePath : String) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        val pathData : AbPathData = AbPathData.getInstance()
        val pathUtil : PathUtil = PathUtil.getInstance()
        this.categoryAbPath = pathUtil.removeNameFromPath(categoryThemePath)
        this.themeName = pathData.getNameFromPath(categoryThemePath)
        this.styleValidationInterface = cssStyleValidation
        this.init()
    }

    def this(transformInfoInterface : TransformInfoInterface, hashMap : HashMap[Object, Object]) = {
        this()
        this.transformInfoInterface = transformInfoInterface
        var categoryThemeAbPath : AbPath = new AbPath(hashMap.get(ThemeData.getInstance().PATH).asInstanceOf[String], StringUtil.getInstance().EMPTY_STRING)
        val pathData : AbPathData = AbPathData.getInstance()
        val pathUtil : PathUtil = PathUtil.getInstance()
        this.categoryAbPath = pathUtil.removeNameFromPath(categoryThemeAbPath.toString())
        this.themeName = pathData.getNameFromPath(categoryThemeAbPath.toString())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("CategoryThemePath: ")
            stringBuffer.append(categoryThemeAbPath.toString())
            stringBuffer.append(" & CategoryPath: ")
            stringBuffer.append(this.categoryAbPath.toString())
            stringBuffer.append(" & ThemeName: ")
            stringBuffer.append(this.themeName)
            this.logUtil.putF("Http Request Constructor", this, stringBuffer.toString())
        }
        //Load the theme properties from the category file associated with the theme
        this.init()
    }

    def this(storeThemeCategoryInterface : StoreThemeCategoryInterface, node : Node) = {
        this()
        this.transformInfoInterface = storeThemeCategoryInterface.getTransformInfoInterface()
        this.categoryAbPath = storeThemeCategoryInterface.getPath()
        var themeNameNode : Node = DomSearchHelper.getNode(ThemeData.getInstance().NAME, node.getChildNodes())
        var valueNode : Node = DomSearchHelper.getNode(DomData.VALUE, themeNameNode.getChildNodes())
        this.themeName = DomNodeHelper.getTextNodeValue(valueNode)
        var previewImageNameNode : Node = DomSearchHelper.getNode(ThemeData.getInstance().PREVIEW_IMAGE_NAME, node.getChildNodes())
        var previewImageNameValueNode : Node = DomSearchHelper.getNode(DomData.VALUE, previewImageNameNode.getChildNodes())
        this.themePreviewImageName = DomNodeHelper.getTextNodeValue(previewImageNameValueNode)
        this.webAppAbPath = storeThemeCategoryInterface.getWebAppPath()
        this.init(storeThemeCategoryInterface)
    }

    /*          StoreThemeCategoryFactory storeThemeCategoryFactory =              new StoreThemeCategoryFactory(this.getTransformInfoInterface());           //String categoryName = CategoryUtil.getNameFromPath(this.categoryPath);          //this.categoryPath, categoryName          //load the css associated with the categoryPathPath          CategoryInterface rootStoreThemeCategoryInterface =              storeThemeCategoryFactory.getRootInstance(this.categoryPath);                             StoreThemeCategory storeThemeCategory = (StoreThemeCategory)             CategoryTreeFactory.getInstance(                storeThemeCategoryFactory).get(rootStoreThemeCategoryInterface);    */
    private def init() : Unit = {
        var categoryFactoryInterface : CategoryFactoryInterface = new StoreThemeCategoryFactory(this.getTransformInfoInterface())
        var categoryLoaderInterface : CategoryLoaderInterface = CategoryLoaderFactory.getInstance(categoryFactoryInterface)
        var rootStoreThemeCategoryInterface : StoreThemeCategoryInterface = categoryFactoryInterface.getRootInstance().asInstanceOf[StoreThemeCategoryInterface]
        this.init(rootStoreThemeCategoryInterface)
    }

    private def init(storeThemeCategoryInterface : StoreThemeCategoryInterface) : Unit = {
        this.fileAbPath = new AbPath(storeThemeCategoryInterface.getRootFilePath().toString() + this.categoryAbPath.toString(), StringUtil.getInstance().EMPTY_STRING)
        this.webAppAbPath = storeThemeCategoryInterface.getWebAppPath()
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.transformInfoInterface
    }

    def getName() : String = {
        return this.themeName
    }

    def getPreviewImageName() : String = {
        return this.themePreviewImageName
    }

    def getPreviewImagePath() : String = {
        return this.webAppAbPath.toString() + this.categoryAbPath.toString()
    }

    def getPath() : String = {
        return this.categoryAbPath.toString()
    }

    def getCssStyleValidation() : CssStyleValidation = {
        if (this.styleValidationInterface == null) {
            var cssStyleFileAbPath : AbPath = new AbPath(this.fileAbPath.toString(), (this.themeName + AbPathData.getInstance().EXTENSION_SEP) + CategoryData.getInstance().UNCRYPTED_EXTENSION)
            //Load the css style for this theme themes 
            var cryptFileReader : CryptFileReader = new CryptFileReader(CategoryData.getInstance().UNCRYPTED_EXTENSION, CategoryData.getInstance().ENCRYPTED_EXTENSION)
            var document : Document = DomDocumentHelper.create(cryptFileReader.get(cssStyleFileAbPath))
            this.styleValidationInterface = new CssStyleValidation(document)
        }
        return this.styleValidationInterface.asInstanceOf[CssStyleValidation]
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.IS_VALID)
            }
            if (!StringValidationUtil.getInstance().isValidRequired(this.categoryAbPath.toString(), AbSqlData.MINSTRING, AbSqlData.MAXSTRING)) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (!StringValidationUtil.getInstance().isValidRequired(this.themeName, AbSqlData.MINSTRING, AbSqlData.MAXSTRING)) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (!this.getCssStyleValidation().isValid().booleanValue()) {
                isValid = _root_.java.lang.Boolean.FALSE
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("End: " + isValid, this, this.commonStrings.IS_VALID)
            }
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Theme Validation Error")
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def getKey() : Object = {
        return this.getName().asInstanceOf[Object]
    }

    def toVector() : BasicArrayList = {
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(this.getName())
        vector.add(this.getPath())
        vector.add(this.getPreviewImageName())
        vector.add(this.getPreviewImagePath())
        return vector
    }

    def toHashMap() : HashMap[Object, Object] = {
        var themeData : ThemeData = ThemeData.getInstance()
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(themeData.NAME, this.getName())
        hashMap.put(themeData.PATH, this.getPath())
        hashMap.put(themeData.PREVIEW_IMAGE_NAME, this.getPreviewImageName())
        hashMap.put(themeData.PREVIEW_IMAGE_PATH, this.getPreviewImagePath())
        return hashMap
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNameValueNodes(document, ThemeData.getInstance().NAME, this.toHashMap())
        var domNodeInterface : DomNodeInterface = this.getCssStyleValidation().asInstanceOf[DomNodeInterface]
        node.appendChild(domNodeInterface.toXmlNode(document))
        return node
    }

}


