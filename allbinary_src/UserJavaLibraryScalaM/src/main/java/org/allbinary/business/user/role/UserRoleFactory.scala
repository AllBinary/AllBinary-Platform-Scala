/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.org.allbinary.business.user.modules.UserFactory
import _root_.org.allbinary.business.user.modules.admin.AdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.StoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.customer.CustomerStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.order.OrderStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.order.adjust.AdjustOrderStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.order.review.ReviewOrderStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.order.ship.ShipOrderStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.payment.PaymentStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.product.ProductStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.web.WebStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.web.view.editor.ViewEditorWebStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.web.wizard.WizardWebStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.admin.store.web.workflow.editor.WorkflowEditorWebStoreAdminUserFactory
import _root_.org.allbinary.business.user.modules.customer.subscriber.SubscriberUserFactory
import _root_.org.allbinary.business.user.modules.customer.wholesale.WholesaleUserFactory

/**  *  * @author user  */
class UserRoleFactory {
    import _root_.org.allbinary.business.user.role.UserRoleFactory.{*}

    private val basicUserRoleFactory : BasicUserRoleFactory = BasicUserRoleFactory.getInstance()

    val INSTALLER : UserRole = new UserRoleB(this.basicUserRoleFactory.INSTALLER, null)

    //new AdministratorUserFactory()
    val ADMINISTRATOR : UserRole = new UserRoleB(this.basicUserRoleFactory.ADMINISTRATOR, new AdminUserFactory())

    //Users
    val CUSTOMER : UserRole = new UserRoleB(this.basicUserRoleFactory.CUSTOMER, new UserFactory())

    val SUBSCRIBERCUSTOMER : UserRole = new UserRoleB(this.basicUserRoleFactory.SUBSCRIBERCUSTOMER, new SubscriberUserFactory())

    val WHOLESALECUSTOMER : UserRole = new UserRoleB(this.basicUserRoleFactory.WHOLESALECUSTOMER, new WholesaleUserFactory())

    //Store Admin
    val STOREMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.STOREMANAGER, new StoreAdminUserFactory())

    //Managers
    val PRODUCTMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.PRODUCTMANAGER, new ProductStoreAdminUserFactory())

    val CUSTOMERMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.CUSTOMERMANAGER, new CustomerStoreAdminUserFactory())

    val PAYMENTMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.PAYMENTMANAGER, new PaymentStoreAdminUserFactory())

    val ORDERMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.ORDERMANAGER, new OrderStoreAdminUserFactory())

    val WEBMANAGER : UserRole = new UserRoleB(this.basicUserRoleFactory.WEBMANAGER, new WebStoreAdminUserFactory())

    //Order Manager Assistants
    val REVIEWER : UserRole = new UserRoleB(this.basicUserRoleFactory.REVIEWER, new ReviewOrderStoreAdminUserFactory())

    val SHIPPING : UserRole = new UserRoleB(this.basicUserRoleFactory.SHIPPING, new ShipOrderStoreAdminUserFactory())

    val ADJUSTER : UserRole = new UserRoleB(this.basicUserRoleFactory.ADJUSTER, new AdjustOrderStoreAdminUserFactory())

    //Web Manager Assistants
    val WORKFLOWEDITOR : UserRole = new UserRoleB(this.basicUserRoleFactory.WORKFLOWEDITOR, new WorkflowEditorWebStoreAdminUserFactory())

    val WIZARD : UserRole = new UserRoleB(this.basicUserRoleFactory.WIZARD, new WizardWebStoreAdminUserFactory())

    //new UserRole (BasicUserRole, new WizardEditorWebStoreAdminUserFactory());
    val VIEWEDITOR : UserRole = new UserRoleB(this.basicUserRoleFactory.VIEWEDITOR, new ViewEditorWebStoreAdminUserFactory())

}

object UserRoleFactory {
    private val instance : UserRoleFactory = new UserRoleFactory()

    def getInstance() : UserRoleFactory = {
        return UserRoleFactory.instance
    }

}


