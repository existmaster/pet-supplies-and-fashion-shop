
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import UserManager from "./components/ui/UserGrid"

import ProductManager from "./components/ui/ProductGrid"

import OrderManager from "./components/ui/OrderGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/users',
                name: 'UserManager',
                component: UserManager
            },

            {
                path: '/products',
                name: 'ProductManager',
                component: ProductManager
            },

            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },



    ]
})
