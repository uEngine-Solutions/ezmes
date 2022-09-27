
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import WorkOrderManager from "./components/listers/WorkOrderCards"
import WorkOrderDetail from "./components/listers/WorkOrderDetail"

import ProductionManager from "./components/listers/ProductionCards"
import ProductionDetail from "./components/listers/ProductionDetail"

import EquipmentManager from "./components/listers/EquipmentCards"
import EquipmentDetail from "./components/listers/EquipmentDetail"
import WorkerManager from "./components/listers/WorkerCards"
import WorkerDetail from "./components/listers/WorkerDetail"
import MaterialsManager from "./components/listers/MaterialsCards"
import MaterialsDetail from "./components/listers/MaterialsDetail"


import DashboardView from "./components/DashboardView"
import DashboardViewDetail from "./components/DashboardViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/workOrders',
                name: 'WorkOrderManager',
                component: WorkOrderManager
            },
            {
                path: '/workOrders/:id',
                name: 'WorkOrderDetail',
                component: WorkOrderDetail
            },

            {
                path: '/productions',
                name: 'ProductionManager',
                component: ProductionManager
            },
            {
                path: '/productions/:id',
                name: 'ProductionDetail',
                component: ProductionDetail
            },

            {
                path: '/equipment',
                name: 'EquipmentManager',
                component: EquipmentManager
            },
            {
                path: '/equipment/:id',
                name: 'EquipmentDetail',
                component: EquipmentDetail
            },
            {
                path: '/workers',
                name: 'WorkerManager',
                component: WorkerManager
            },
            {
                path: '/workers/:id',
                name: 'WorkerDetail',
                component: WorkerDetail
            },
            {
                path: '/materials',
                name: 'MaterialsManager',
                component: MaterialsManager
            },
            {
                path: '/materials/:id',
                name: 'MaterialsDetail',
                component: MaterialsDetail
            },


            {
                path: '/dashboards',
                name: 'DashboardView',
                component: DashboardView
            },
            {
                path: '/dashboards/:id',
                name: 'DashboardViewDetail',
                component: DashboardViewDetail
            },


    ]
})
