import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "@/views/LoginPage.vue";
import TransactionsList from "@/views/TransactionsList.vue";
import ExpenseList from "@/views/ExpenseList.vue";
import Registration from "@/views/RegistrationPage.vue";
import HomePage from "@/views/HomePage.vue";

const routes = [
    {
        path: "/",
        name: "HomePage",
        component: HomePage,
    },
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,
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
        path: "/register",
        name: "Registration",
        component: Registration,
    }


];
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
    linkActiveClass: "active-link",

});
export default router;