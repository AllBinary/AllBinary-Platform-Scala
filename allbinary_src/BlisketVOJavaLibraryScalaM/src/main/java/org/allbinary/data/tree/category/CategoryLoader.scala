/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.category

import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.properties.CategoryProperties
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileReader
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class CategoryLoader(param_categoryFactoryInterface : CategoryFactoryInterface) extends CategoryModifierTree(param_categoryFactoryInterface) with CategoryLoaderInterface {

    val logUtil_CategoryLoader : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val categoryFactoryInterface : CategoryFactoryInterface = param_categoryFactoryInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil_CategoryLoader.putF(this.commonStrings.START, this, "CategoryLoader(CategoryFactoryInterface categoryFactoryInterface)")
        }
    }

    //Creates new root category if possible
    def getDoc(categoryInterface : CategoryInterface) : Document = this.synchronized {
        try {
            if (categoryInterface.getProperties().getPath(categoryInterface.getHierarchy()) != null) {
                //this.logUtil.putF("Level: " + categoryInterface.getHierarchy().getLevel(), this, "getDoc");
                if (categoryInterface.getHierarchy().getLevel() == 1) {
                    var rootAbFile : AbFile = AbFile.createAbFileFromAbPath(categoryInterface.getRootFilePath())
                    if (!rootAbFile.isDirectory()) {
                        rootAbFile.mkdirs()
                        if (!rootAbFile.isDirectory()) {
                            throw new Exception("Could Not Create Directory")
                        }
                        this.save(categoryInterface)
                    }
                }
                var fileAbPath : AbPath = categoryInterface.getFilePath()
                var cryptFileReader : CryptFileReader = new CryptFileReader(CategoryData.getInstance().UNCRYPTED_EXTENSION, CategoryData.getInstance().ENCRYPTED_EXTENSION)
                var document : Document = DomDocumentHelper.create(cryptFileReader.get(fileAbPath))
                return document
            } else {
                throw new Exception("Null Category")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    try {
                        categoryInterface.log()
                    } catch {
                        case e2 : Exception => {
                            this.logUtil_CategoryLoader.put("Could Not Log Category", this, "getDoc", e)
                        }
                    }
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, "getDoc", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*     public synchronized CategoryInterface get(CategoryInterface categoryInterface)     {     try     {     Document document = this.getDoc(categoryInterface);      return this.get(document);     }     catch(Exception e)     {     if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))     {     this.logUtil.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e);     }     return null;     }     }      */
    def get(categoryInterface : CategoryInterface) : CategoryInterface = this.synchronized {
        try {
            var document : Document = this.getDoc(categoryInterface)
            var categoryNode : Node = DomSearchHelper.getNode(CategoryData.getInstance().NAME, document.getChildNodes())
            return this.addProperties(categoryInterface, categoryNode.getChildNodes())
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*     public synchronized CategoryInterface getUpToLevel(     CategoryInterface categoryInterface, int level)     {     try     {     if(level < 0) throw new Exception("Level Must Be A Positive Number");          Document document = this.getDoc(categoryInterface);          return this.get(document);     }     catch(Exception e)     {     if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))     {     this.logUtil.put(this.commonStrings.FAILURE, this, "getUpToLevel", e);     }     return null;     }     }          //This loads everything as a result could use up a bunch of memory     public synchronized CategoryInterface getAll(     CategoryInterface categoryInterface)     {     try     {     Document document = this.getDoc(categoryInterface);          //CategoryInterface categoryInterface =     // (CategoryInterface) categoryFactoryInterface.getInstance(     //  categoryPath + FileData.SEPARATOR + categoryName);          return this.get(document);     }     catch(Exception e)     {     if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))     {     this.logUtil.put(this.commonStrings.FAILURE, this, "getAll", e);     }     return null;     }     }      */
    def get(document : Document) : CategoryInterface = this.synchronized {
        try {
            var categoryNode : Node = DomSearchHelper.getNode(CategoryData.getInstance().NAME, document.getChildNodes())
            var loadedCategoryInterface : CategoryInterface = this.categoryFactoryInterface.getRootInstanceFromNode(categoryNode)
            return this.addProperties(loadedCategoryInterface, categoryNode.getChildNodes())
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*     public synchronized CategoryInterface get(Node categoryNode)     {     try     {     CategoryInterface loadedCategoryInterface =     this.categoryFactoryInterface.getRootInstance(categoryNode);      return this.addProperties(loadedCategoryInterface, categoryNode.getChildNodes());     }     catch(Exception e)     {     if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))     {     this.logUtil.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e);     }     return null;     }     }      */
    def getAll(categoryInterface : CategoryInterface) : CategoryInterface = this.synchronized {
        try {
            var document : Document = this.getDoc(categoryInterface)
            return this.getAll(document)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    private def getAll(document : Document) : CategoryInterface = this.synchronized {
        try {
            var categoryNode : Node = DomSearchHelper.getNode(CategoryData.getInstance().NAME, document.getChildNodes())
            var loadedCategoryInterface : CategoryInterface = this.categoryFactoryInterface.getRootInstanceFromNode(categoryNode)
            //return this.getAll(loadedCategoryInterface, categoryNode.getChildNodes());
            return this.addProperties(loadedCategoryInterface, categoryNode.getChildNodes())
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    private def getAll(parentCategoryInterface : CategoryInterface, categoryNodeList : NodeList) : CategoryInterface = this.synchronized {
        try {
            if (categoryNodeList != null) {

                {
                    var index : Int = 0
                    while (index < categoryNodeList.getLength()) {
                        var categoryNode : Node = categoryNodeList.item(index)
                        if ((categoryNode != null) && (categoryNode.getNodeName().compareTo(CategoryData.getInstance().NAME) == 0)) {
                            var categoryInterface : CategoryInterface = this.categoryFactoryInterface.getInstance(parentCategoryInterface.getHierarchy().getRoot(), parentCategoryInterface, categoryNode).asInstanceOf[CategoryInterface]
                            parentCategoryInterface.addChild(categoryInterface)
                        }
                        index += 1
                    }
                }
            }
            return parentCategoryInterface
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    //This could be in the category constructor
    private def addProperties(loadedCategoryInterface : CategoryInterface, categoryNodeList : NodeList) : CategoryInterface = this.synchronized {
        try {
            if (categoryNodeList != null) {

                {
                    var index : Int = 0
                    while (index < categoryNodeList.getLength()) {
                        var categoryNode : Node = categoryNodeList.item(index)
                        if ((categoryNode != null) && (categoryNode.getNodeName().compareTo(CategoryData.getInstance().NAME) == 0)) {
                            var categoryPropertiesInterface : CategoryPropertiesInterface = (new CategoryProperties(categoryNode)).asInstanceOf[CategoryPropertiesInterface]
                            loadedCategoryInterface.addChildProperty(categoryPropertiesInterface)
                        }
                        index += 1
                    }
                }
            }
            return loadedCategoryInterface
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryLoader.put(this.commonStrings.FAILURE, this, this.commonStrings.GET, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}


