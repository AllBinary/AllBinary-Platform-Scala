/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

trait TransformInfoObjectConfigInterface extends DomDocumentMappingInterface {

    //Usually used for updating a sites templates
    def containsView(transformInfoInterface : TransformInfoInterface) : Boolean

    def getName() : String

    def getTransformsGroup(group : String) : BasicArrayList

    //InputStream createInputStream() throws Exception;
    def getTransforms() : BasicArrayList

    def getParentTransforms() : BasicArrayList

    def getGroupTransforms() : BasicArrayList

    def getOutputTypeName() : String

    def setOutputTypeName(value : String) : Unit

    def getInputOutputTypeName() : String

    def getInputOutputTypeFile() : String

    def getImportUriPath() : String

    //void setImportUriPath(String importUriPath);
    override def toString() : String

}


