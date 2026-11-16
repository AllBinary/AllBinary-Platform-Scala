/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.org.allbinary.logic.communication.http.request.RequestMapInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.taghelpers.ValidationViewHelper
import _root_.tags.HelperTag
import _root_.views.admin.inventory.InventoryItemView
import _root_.views.admin.inventory.download.DownloadableInventoryItemView

class InventoryItemViewParentTagHelper {
    import _root_.admin.taghelpers.InventoryItemViewParentTagHelper.{*}

    def getInventoryItemView(inventoryTag : HelperTag) : InventoryItemView = {
        if (inventoryTag != null) {
            //File in request
            this.checkForValidationViewHelper(inventoryTag.getHelper())
            var validationViewHelper : ValidationViewHelper = inventoryTag.getHelper().asInstanceOf[ValidationViewHelper]
            var viewObject : TransformInterface = validationViewHelper.getViewObject()
            if (viewObject.getTypeId() != InventoryItemView.TYPE_ID) {
                var stringBuffer : StringMaker = new StringMaker()
                //stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append("Must have ")
                stringBuffer.append("InventoryItemView and not: ")
                stringBuffer.append(inventoryTag.getHelper().getClass().getName())
                throw new Exception(stringBuffer.toString())
            }
            return viewObject.asInstanceOf[InventoryItemView]
        } else {
            throw new Exception("Must have parent tag.")
        }
        throw new IllegalStateException()
    }

    def getDownloadableInventoryItemView(inventoryTag : HelperTag) : DownloadableInventoryItemView = {
        if (inventoryTag != null) {
            //File in request
            this.checkForValidationViewHelper(inventoryTag.getHelper())
            var validationViewHelper : ValidationViewHelper = inventoryTag.getHelper().asInstanceOf[ValidationViewHelper]
            var viewObject : TransformInterface = validationViewHelper.getViewObject()
            if (viewObject.getTypeId() != DownloadableInventoryItemView.TYPE_ID) {
                var stringBuffer : StringMaker = new StringMaker()
                //stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append("Must have ")
                stringBuffer.append("DownloadableInventoryItemView and not: ")
                stringBuffer.append(inventoryTag.getHelper().getClass().getName())
                throw new Exception(stringBuffer.toString())
            }
            return viewObject.asInstanceOf[DownloadableInventoryItemView]
        } else {
            throw new Exception("Must have parent tag.")
        }
        throw new IllegalStateException()
    }

    def getRequestMapInterface(inventoryTag : HelperTag) : RequestMapInterface = {
        if (inventoryTag != null) {
            //File in request
            this.checkForValidationViewHelper(inventoryTag.getHelper())
            var validationViewHelper : ValidationViewHelper = inventoryTag.getHelper().asInstanceOf[ValidationViewHelper]
            var viewObject : TransformInterface = validationViewHelper.getViewObject()
            if ((viewObject.getTypeId() != InventoryItemView.TYPE_ID) && (viewObject.getTypeId() != DownloadableInventoryItemView.TYPE_ID)) {
                var stringBuffer : StringMaker = new StringMaker()
                //stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append("Must have ")
                stringBuffer.append("specific TYPE_ID and not: ")
                stringBuffer.append(inventoryTag.getHelper().getClass().getName())
                throw new Exception(stringBuffer.toString())
            }
            return viewObject.asInstanceOf[RequestMapInterface]
        } else {
            throw new Exception("Must have parent tag.")
        }
        throw new IllegalStateException()
    }

    def checkForValidationViewHelper(helperObject : Object) : Unit = {
        if (!(helperObject.isInstanceOf[ValidationViewHelper])) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Must have ")
            stringBuffer.append("ValidationViewHelper")
            stringBuffer.append("and not: ")
            stringBuffer.append(helperObject.getClass().getName())
            throw new Exception(stringBuffer.toString())
        }
    }

}

object InventoryItemViewParentTagHelper {
    private val instance : InventoryItemViewParentTagHelper = new InventoryItemViewParentTagHelper()

    def getInstance() : InventoryItemViewParentTagHelper = {
        return InventoryItemViewParentTagHelper.instance
    }

}


