
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import UserManagementUserManager from "./components/listers/UserManagementUserCards"
import UserManagementUserDetail from "./components/listers/UserManagementUserDetail"

import ProductManagementProductManager from "./components/listers/ProductManagementProductCards"
import ProductManagementProductDetail from "./components/listers/ProductManagementProductDetail"

import OrderManagementOrderManager from "./components/listers/OrderManagementOrderCards"
import OrderManagementOrderDetail from "./components/listers/OrderManagementOrderDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/userManagements/users',
                name: 'UserManagementUserManager',
                component: UserManagementUserManager
            },
            {
                path: '/userManagements/users/:id',
                name: 'UserManagementUserDetail',
                component: UserManagementUserDetail
            },

            {
                path: '/productManagements/products',
                name: 'ProductManagementProductManager',
                component: ProductManagementProductManager
            },
            {
                path: '/productManagements/products/:id',
                name: 'ProductManagementProductDetail',
                component: ProductManagementProductDetail
            },

            {
                path: '/orderManagements/orders',
                name: 'OrderManagementOrderManager',
                component: OrderManagementOrderManager
            },
            {
                path: '/orderManagements/orders/:id',
                name: 'OrderManagementOrderDetail',
                component: OrderManagementOrderDetail
            },



    ]
})
