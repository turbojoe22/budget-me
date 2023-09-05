import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "@/views/LandingPage.vue";
import LoginPage from "@/views/LoginPage.vue";
import RegisterPage from "@/views/RegisterPage.vue"
import HomePage from "@/views/HomePage.vue";
import TransactionsList from "@/views/TransactionsList.vue";
import ExpenseList from "@/views/ExpenseList.vue";
import CreateExpense from "@/views/CreateExpense.vue";
import BudgetPeriodList from "@/views/BudgetPeriodList.vue";
import CreateBudgetPeriod from "@/views/CreateBudgetPeriod.vue";
import AddReceipts from "@/views/AddReceipts.vue";
import ViewReceipts from "@/views/ViewReceipts.vue";



const routes = [
    {
        path: "/",
        name: "LandingPage",
        component: LandingPage,
    },
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,

    },
    {
        path: "/register",
        name: "RegisterPage",
        component: RegisterPage,
    },
    {
         path: "/home",
         name: "HomePage",
         component: HomePage,
    },
    {
        path: "/transactions",
        name: "TransactionsList",
        component: TransactionsList,
    },
    {
        path: "/expenses",
        name: "ExpenseList",
        component: ExpenseList,
    },
    {
        path: "/expenses/create",
        name: "CreateExpense",
        component: CreateExpense,
    },
    {
        path: "/budget-period-list",
        name: "BudgetPeriodList",
        component: BudgetPeriodList,
    },
    {
        path: "/create-budget-period",
        name: "CreateBudgetPeriod",
        component: CreateBudgetPeriod,
    },
    {
           path: "/receipt/add",
           name: "AddReceipts",
           component: AddReceipts,
    },
    {
           path: "/receipt/view",
           name: "ViewReceipts",
           component: ViewReceipts,
    },



];
    const router = createRouter({
        history: createWebHistory(process.env.BASE_URL),
        routes,
        linkActiveClass: "active-link",

    });
    export default router;